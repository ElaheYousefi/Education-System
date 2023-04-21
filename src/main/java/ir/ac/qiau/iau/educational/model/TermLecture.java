package ir.ac.qiau.iau.educational.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="termlecture")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TermLecture {

    @Id
    @Column(precision=10)
    private long termLectId;

    @Column(precision = 4)
    private int term;

//    @OneToMany(mappedBy = "termLecture")
//    private List<Teacher> teachers;
//
//    @OneToMany(mappedBy = "termLecture")
//    private List<Lecture> lectures;

    public long getTermLectId() {
        return termLectId;
    }

    public void setTermLectId(long termLectId) {
        this.termLectId = termLectId;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

//    public List<Teacher> getTeachers() {
//        return teachers;
//    }
//
//    public void setTeachers(List<Teacher> teachers) {
//        this.teachers = teachers;
//    }
//
//    public List<Lecture> getLectures() {
//        return lectures;
//    }
//
//    public void setLectures(List<Lecture> lectures) {
//        this.lectures = lectures;
//    }
}
