package ir.ac.qiau.iau.educational.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property = "stdCode")
public class Student {

    @Id
    @Column(name="std_code", precision=10)
    private long stdCode;

    @NotEmpty(message = "User's name cannot be empty.")
    @Column(length = 20, nullable = false)
    private String name;

    @NotEmpty(message = "family cannot be empty.")
    @Column(length = 20, nullable = false)
    private String family;

    @NotNull(message = "cardId cannot be empty.")
    @Column(length = 8, nullable = false)
    private int cardId;

    @NotNull(message = "melliCode cannot be empty.")
    @Column(length = 10, unique = true)
    private long melliCode;

    @NotEmpty(message = "course cannot be empty.")
    @Column(length = 15, nullable = false)
    private String course;

    @NotEmpty(message = "department cannot be empty.")
    @Column(length = 20, nullable = false)
    private String department;

    @Column(length = 17)
    private Double cash;

    @OneToMany(mappedBy = "student")
    private List<Polling> polling;

    @OneToMany(mappedBy = "student")
    private List<Registration> registration;

    public long getStdCode() {
        return stdCode;
    }

    public void setStdCode(long stdCode) {
        this.stdCode = stdCode;
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

    public List<Polling> getPolling() {
        return polling;
    }

    public void setPolling(List<Polling> polling) {
        this.polling = polling;
    }

    public List<Registration> getRegistration() {
        return registration;
    }

    public void setRegistration(List<Registration> registration) {
        this.registration = registration;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }
}
