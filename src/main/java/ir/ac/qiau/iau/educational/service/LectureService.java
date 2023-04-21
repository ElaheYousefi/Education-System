package ir.ac.qiau.iau.educational.service;

import ir.ac.qiau.iau.educational.repository.LectureRepository;
import ir.ac.qiau.iau.educational.model.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LectureService {

    LectureRepository lectureRepository;

    @Autowired
    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public List<Lecture> getLectures(){
        return lectureRepository.findAll();
    }

    public Lecture registerLecture(Lecture lecture){
        return lectureRepository.save(lecture);
    }

    public Lecture getLectureById(int id){
        return lectureRepository.getById(id);
    }

    public List<Lecture> getAvailableLecures(long studentId){//, long teacherId, long lectureId) {

        List<Lecture> lectures= lectureRepository.getAvailableLectureById(studentId);
        return lectures;
    }

    public List<Lecture> getGottenLectures(long studentId){

        return lectureRepository.getGottenLecture(studentId);
    }

    public List<Lecture> getGroupsForLecture(long lectureId){
        return lectureRepository.getGroupsForLecture(lectureId);
    }
}
