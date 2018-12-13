package academy.softserve.movieuniverse.dto;

import java.util.ArrayList;
import java.util.List;

import academy.softserve.movieuniverse.entity.Country;
import academy.softserve.movieuniverse.entity.Gallery;
import academy.softserve.movieuniverse.entity.Links;
import academy.softserve.movieuniverse.entity.StarProfession;

public class StarCreateDTO {
	private Long id;
    private String firstName;
    private String lastName;
    private Long birthday;
    private String biography;
    private Double growth;
    private List<Country> countries = new ArrayList<>();
    private String cityOfBirth;
    private List<StarProfession> professions = new ArrayList<StarProfession>();
    private List<Links> links = new ArrayList<Links>();
    private Gallery gallery;
    
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
	public Gallery getGallery() {
		return gallery;
	}
	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}
}
