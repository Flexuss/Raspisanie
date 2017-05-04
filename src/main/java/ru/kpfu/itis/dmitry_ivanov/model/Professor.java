package ru.kpfu.itis.dmitry_ivanov.model;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by Dmitry on 03.05.2017.
 */

@Entity
@Table(name = "professors")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "university_id")
    private University university;

    @Column(name = "fio")
    private String fio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department")
    private Faculty faculty;

    @Column(name = "theme")
    private String theme;

    @Column(name = "experience")
    private int experience;

    @Column(name = "age")
    private int age;

    @Column(name = "regalia")
    private String regalia;

    @OneToMany(mappedBy = "professor", fetch = FetchType.EAGER)
    private Set<Schedule> schedules;

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRegalia(String regalia) {
        this.regalia = regalia;
    }

    public Long getId() {

        return id;
    }

    public University getUniversity() {
        return university;
    }

    public String getFio() {
        return fio;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public String getTheme() {
        return theme;
    }

    public int getExperience() {
        return experience;
    }

    public int getAge() {
        return age;
    }

    public String getRegalia() {
        return regalia;
    }
}
