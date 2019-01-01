package academy.softserve.movieuniverse.dto;

public class StarDTO {
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
    private String linksu;
    private String countriesu;
    private String moviesu;
    private String professionsu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getBiography() {
        return biography;
    }

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

    public Boolean getIsRemoved() {
        return isRemoved;
    }

    public void setIsRemoved(Boolean isRemoved) {
        this.isRemoved = isRemoved;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getLinksu() {
        return linksu;
    }

    public void setLinksu(String linksu) {
        this.linksu = linksu;
    }

    public String getCountriesu() {
        return countriesu;
    }

    public void setCountriesu(String countriesu) {
        this.countriesu = countriesu;
    }

    public String getMoviesu() {
        return moviesu;
    }

    public void setMoviesu(String moviesu) {
        this.moviesu = moviesu;
    }

    public String getProfessionsu() {
        return professionsu;
    }

    public void setProfessionsu(String professionsu) {
        this.professionsu = professionsu;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
