package ru.kpfu.itis.dmitry_ivanov.model;

import javax.persistence.*;

/**
 * Created by Dmitry on 04.05.2017.
 */

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professor")
    private Professor professor;

    @Column(name = "day")
    private int day;

    @Column(name = "time")
    private int time;

    @Column(name = "aud")
    private int aud;

    @Column(name = "theme")
    private String theme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getAud() {
        return aud;
    }

    public void setAud(int aud) {
        this.aud = aud;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
