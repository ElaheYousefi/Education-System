package ir.ac.qiau.iau.educational.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Lecture {

    @Id
    @Column(name="lectId", precision = 10)
    private int lectId;

    @Column(length = 20, nullable = false)
    private String name;

    @Column( precision = 1, nullable = false)
    private int unit;

    @Column(length = 10, nullable = false)
    private String lectType;

    @Column(length = 10, nullable = false)
    private float fee;

    @ManyToMany(mappedBy = "lectures")
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "lecture")
    private List<Polling> pollings;

    @OneToMany(mappedBy = "lecture")
    private List<Registration> registrations;

    public int getLectId() {
        return lectId;
    }

    public void setLectId(int lectId) {
        this.lectId = lectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getLectType() {
        return lectType;
    }

    public void setLectType(String lectType) {
        this.lectType = lectType;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
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
