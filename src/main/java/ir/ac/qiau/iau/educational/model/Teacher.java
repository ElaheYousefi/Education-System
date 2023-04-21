package ir.ac.qiau.iau.educational.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teacher {

    @Id
    @Column(name="teach_id", precision=10)
    private long teachId;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String family;

    @Column(length = 8, nullable = false)
    private int cardId;

    @Column(length = 10, nullable = false)
    private long melliCode;

    @Column(length = 20, nullable = false)
    private String course;

    @Column(length = 20, nullable = false)
    private String department;

    @Column(length = 10, nullable = false)
    private String grade;

    @ManyToMany
    @JoinTable(name="teacher_lecture", joinColumns= @JoinColumn(name="teacher_id"), inverseJoinColumns = @JoinColumn(name="lecture_id"))
    private List<Lecture> lectures;

    @OneToMany(mappedBy = "teacher")
    private List<Polling> pollings;

    @OneToMany(mappedBy = "teacher")
    private List<Registration> registrations;

    public long getTeachId() {
        return teachId;
    }

    public void setTeachId(long teachId) {
        this.teachId = teachId;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public long getMelliCode() {
        return melliCode;
    }

    public void setMelliCode(long melliCode) {
        this.melliCode = melliCode;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<Polling> getPollings() {
        return pollings;
    }

    public void setPollings(List<Polling> pollings) {
        this.pollings = pollings;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }
}
