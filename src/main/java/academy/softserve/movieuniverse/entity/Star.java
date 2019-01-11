package academy.softserve.movieuniverse.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movie_stars")
public class Star extends Person {

    @Column(name = "star_biography")
    private String biography;

    @Column(name = "star_growth")
    private Double growth;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "stars_countries", joinColumns = @JoinColumn(name = "star_id"), inverseJoinColumns = @JoinColumn(name = "country_id"))
    private Set<Country> countries = new HashSet<>();

    @Column(name = "star_city")
    private String cityOfBirth;

    @OneToMany(mappedBy = "starProfession", cascade = CascadeType.ALL)
    private List<Crew> roles = new ArrayList<Crew>();

    @OneToMany(mappedBy = "star", cascade = CascadeType.ALL)
    private List<StarProfession> professions = new ArrayList<StarProfession>();

    @OneToMany(mappedBy = "star", cascade = CascadeType.ALL)
    private List<Links> links = new ArrayList<Links>();

    @OneToOne
    @JoinColumn(name = "gallery_id")
    private Gallery gallery;

    @OneToOne
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;

    public Star() {
    }

    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Crew> getRoles() {
        return roles;
    }

    public void setRoles(List<Crew> roles) {
        this.roles = roles;
    }

    public Double getGrowth() {
        return growth;
    }

    public void setGrowth(Double growth) {
        this.growth = growth;
    }

    public List<Links> getLinks() {
        return links;
    }

    public void setLinks(List<Links> links) {
        this.links = links;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public List<StarProfession> getProfessions() {
        return professions;
    }

    public void setProfessions(List<StarProfession> professions) {
        this.professions = professions;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }
}
