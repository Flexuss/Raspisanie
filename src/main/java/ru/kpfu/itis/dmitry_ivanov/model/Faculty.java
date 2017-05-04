package ru.kpfu.itis.dmitry_ivanov.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Dmitry on 03.05.2017.
 */

@Entity
@Table(name = "faculties")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "university_id")
    private University university;

    @Column(name = "faculty_name")
    private String name;

    @OneToMany(mappedBy = "faculty", fetch = FetchType.EAGER)
    private Set<Professor> professors;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfessors(Set<Professor> professors) {
        this.professors = professors;
    }

    public Long getId() {

        return id;
    }

    public University getUniversity() {
        return university;
    }

    public String getName() {
        return name;
    }

    public Set<Professor> getProfessors() {
        return professors;
    }
}
