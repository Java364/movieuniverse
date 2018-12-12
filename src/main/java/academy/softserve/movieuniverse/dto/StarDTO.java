package academy.softserve.movieuniverse.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import academy.softserve.movieuniverse.entity.Country;
import academy.softserve.movieuniverse.entity.Gallery;
import academy.softserve.movieuniverse.entity.Links;
import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.entity.StarActivityInMovies;
import academy.softserve.movieuniverse.entity.StarProfession;

public class StarDTO {
	private Long id;
	private Boolean isRemoved;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String biography;
    private Double growth;
    private List<Country> countries = new ArrayList<>();
    private String cityOfBirth;
    private List<StarActivityInMovies> roles = new ArrayList<StarActivityInMovies>();
    private List<StarProfession> professions = new ArrayList<StarProfession>();
    private List<Links> links = new ArrayList<Links>();
    private List<Movie> movies = new ArrayList<Movie>();
    private Gallery gallery;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getIsRemoved() {
		return isRemoved;
	}
	public void setIsRemoved(Boolean isRemoved) {
		this.isRemoved = isRemoved;
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
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
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
	public List<Country> getCountries() {
		return countries;
	}
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	public String getCityOfBirth() {
		return cityOfBirth;
	}
	public void setCityOfBirth(String cityOfBirth) {
		this.cityOfBirth = cityOfBirth;
	}
	public List<StarActivityInMovies> getRoles() {
		return roles;
	}
	public void setRoles(List<StarActivityInMovies> roles) {
		this.roles = roles;
	}
	public List<StarProfession> getProfessions() {
		return professions;
	}
	public void setProfessions(List<StarProfession> professions) {
		this.professions = professions;
	}
	public List<Links> getLinks() {
		return links;
	}
	public void setLinks(List<Links> links) {
		this.links = links;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	public Gallery getGallery() {
		return gallery;
	}
	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}
}
