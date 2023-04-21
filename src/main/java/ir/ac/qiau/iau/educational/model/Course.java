package ir.ac.qiau.iau.educational.model;

import javax.persistence.*;


@Entity
@Table
public class Course {

    @Id
    private int courseId;

//    @ManyToOne
//    @JoinColumn(name="depId")
//    private Department department;

    private String name;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

//    public Department getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Department department) {
//        this.department = department;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
