package ir.ac.qiau.iau.educational.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Registration {

    @EmbeddedId
    private PollingKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name="stdId")
    private Student student;


    @ManyToOne
    @MapsId("lectureId")
    @JoinColumn(name="lectureId")
    private Lecture lecture;

    @ManyToOne
    @MapsId("teacherId")
    @JoinColumn(name="teachId")
    private Teacher teacher;

    private Date date;
    @Transient
    private boolean selected= false;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
