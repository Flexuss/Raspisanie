package ru.kpfu.itis.dmitry_ivanov.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Dmitry on 03.05.2017.
 */

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "city_name")
    private String cityName;

    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    private Set<University> universities;

    public void setUniversities(Set<University> univercities) {
        this.universities = univercities;
    }

    public Set<University> getUniversities() {

        return universities;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }
}
