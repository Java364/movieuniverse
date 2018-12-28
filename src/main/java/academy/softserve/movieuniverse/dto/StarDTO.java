package academy.softserve.movieuniverse.dto;

import java.util.ArrayList;
import java.util.List;

import academy.softserve.movieuniverse.dto.country.CountryDTO;

public class StarDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Long birthday;
    private String biography;
    private Double growth;
    private String cityOfBirth;
    private Long galleryId;

    //private GalleryDTO galleryDto;
    private List<Long> rolesIds = new ArrayList<Long>();
    private List<Long> professionsIds = new ArrayList<Long>();
    private List<Long> linksIds = new ArrayList<Long>();
    private List<Long> countriesIds = new ArrayList<>();
    private List<Long> moviesIds = new ArrayList<Long>();
    private List<LinksDTO> links = new ArrayList<LinksDTO>();
    
    private List<StarProfessionDTO> professions = new ArrayList<StarProfessionDTO>();
    private List<CountryDTO> countries = new ArrayList<CountryDTO>();
    private List<StarActivityInMoviesDTO> activities = new ArrayList<StarActivityInMoviesDTO>();
    private Boolean isRemoved;
    
    private String self;
    private String gallery;
    private String roles;
    private String linksu;
    private String countriesu;
    private String moviesu;
    private String professionsu;
    
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

    public List<Long> getRolesIds() {
        return rolesIds;
    }

    public void setRolesIds(List<Long> rolesIds) {
        this.rolesIds = rolesIds;
    }

    public List<Long> getProfessionsIds() {
        return professionsIds;
    }

    public void setProfessionsIds(List<Long> professionsIds) {
        this.professionsIds = professionsIds;
    }

    public List<Long> getLinksIds() {
        return linksIds;
    }

    public void setLinksIds(List<Long> linksIds) {
        this.linksIds = linksIds;
    }

    public List<LinksDTO> getLinks() {
        return links;
    }

    public void setLinks(List<LinksDTO> links) {
        this.links = links;
    }

    public List<StarActivityInMoviesDTO> getActivities() {
        return activities;
    }

    public void setActivities(List<StarActivityInMoviesDTO> activities) {
        this.activities = activities;
    }

    public List<CountryDTO> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryDTO> countries) {
        this.countries = countries;
    }

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

    public List<Long> getMoviesIds() {
        return moviesIds;
    }

    public void setMoviesIds(List<Long> moviesIds) {
        this.moviesIds = moviesIds;
    }

    public Boolean getIsRemoved() {
        return isRemoved;
    }

    public void setIsRemoved(Boolean isRemoved) {
        this.isRemoved = isRemoved;
    }

    public List<StarProfessionDTO> getProfessions() {
        return professions;
    }

    public void setProfessions(List<StarProfessionDTO> professions) {
        this.professions = professions;
    }

    public Long getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(Long galleryId) {
        this.galleryId = galleryId;
    }

    public List<Long> getCountriesIds() {
        return countriesIds;
    }

    public void setCountriesIds(List<Long> countriesIds) {
        this.countriesIds = countriesIds;
    }
}
