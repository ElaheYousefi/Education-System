package ir.ac.qiau.iau.educational.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Polling {

    @EmbeddedId
    private PollingKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name="std_code")
    private Student student;


    @ManyToOne
    @MapsId("lectureId")
    @JoinColumn(name="lectureId")
    private Lecture lecture;

    @ManyToOne
    @MapsId("teacherId")
    @JoinColumn(name="teach_id")
    private Teacher teacher;


    private int teachingQuality;
    private int behaviour;
    private Date date;

    public PollingKey getId() {
        return id;
    }

    public void setId(PollingKey id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getTeachingQuality() {
        return teachingQuality;
    }

    public void setTeachingQuality(int teachingQuality) {
        this.teachingQuality = teachingQuality;
    }

    public int getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(int behaviour) {
        this.behaviour = behaviour;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
