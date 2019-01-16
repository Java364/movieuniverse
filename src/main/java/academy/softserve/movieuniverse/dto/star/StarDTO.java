package academy.softserve.movieuniverse.dto.star;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StarDTO implements StarCreateInfo, StarSearchInfo, StarSearchShortInfo, CreditDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Long birthday;
    private String biography;
    private Double growth;
    private String cityOfBirth;
    private Boolean isRemoved;
    private String self;
    private String gallery;
    private String avatar;
    private String roles;
    private String links;
    private String countries;
    private String movies;
    private String professions;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Long getBirthday() {
        return birthday;
    }

    @Override
    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    @Override
    public String getBiography() {
        return biography;
    }

    @Override
    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Double getGrowth() {
        return growth;
    }

    public void setGrowth(Double growth) {
        this.growth = growth;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }

    public void setRemoved(Boolean removed) {
        isRemoved = removed;
    }

    @Override
    public String getSelf() {
        return self;
    }

    @Override
    public void setSelf(String self) {
        this.self = self;
    }

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    @Override
    public String getAvatar() {
        return avatar;
    }

    @Override
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }

    @Override
    public String getProfessions() {
        return professions;
    }

    @Override
    public void setProfessions(String professions) {
        this.professions = professions;
    }

    @Override
    public String toString() {
        return "StarDTO{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
                + ", birthday=" + birthday + ", biography='" + biography + '\'' + ", growth=" + growth
                + ", cityOfBirth='" + cityOfBirth + '\'' + ", isRemoved=" + isRemoved + ", self='" + self + '\''
                + ", gallery='" + gallery + '\'' + ", avatar='" + avatar + '\'' + ", roles='" + roles + '\''
                + ", links='" + links + '\'' + ", countries='" + countries + '\'' + ", movies='" + movies + '\''
                + ", professions='" + professions + '\'' + '}';
    }
}
