package ru.kpfu.itis.dmitry_ivanov.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Dmitry on 03.05.2017.
 */
@Entity
@Table(name = "universities")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "university_name")
    private String universityName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "university_city")
    private City city;

    @OneToMany(mappedBy = "university", fetch = FetchType.EAGER)
    private Set<Faculty> faculties;

    @OneToMany(mappedBy = "university", fetch = FetchType.EAGER)
    private Set<Professor> professors;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void setProfessors(Set<Professor> professors) {
        this.professors = professors;
    }

    public Long getId() {

        return id;
    }

    public String getUniversityName() {
        return universityName;
    }

    public City getCity() {
        return city;
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public Set<Professor> getProfessors() {
        return professors;
    }
}
