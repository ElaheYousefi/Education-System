package ir.ac.qiau.iau.educational.repository;

import ir.ac.qiau.iau.educational.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {

   @Query(value="select distinct lect_id, fee, name, lect_type, unit from teacher_lecture,lecture" +
            " where lecture.lect_id= teacher_lecture.lecture_id" +
            " and teacher_lecture.lecture_id not in(select registration.lecture_id from registration where registration.std_id=?1)"
            //" and teacher_lecture.teacher_id not in(select registration.teach_id from registration where registration.std_id=?1)",
            , nativeQuery = true)
    List<Lecture> getAvailableLectureById(long studentId);

   @Query(value="select * from lecture inner join registration on lecture.lect_id= registration.lecture_id"+
                " where registration.std_id= ?1"
                , nativeQuery = true)
   List<Lecture> getGottenLecture(long studentId);

    @Query(value="select * from lecture inner join "+
            "teacher_lecture on lecture.lect_id= teacher_lecture.lecture_id "+
            "where lecture.lect_id= ?1"
            , nativeQuery = true)
    List<Lecture> getGroupsForLecture(long lectureId);
}
