package academy.softserve.movieuniverse.dto.star;

import java.util.List;

public class StarSearchRequest {
    private String keyword;
    private String name;
    private String movie;
    private List<String> professions;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public void setProfessions(List<String> professions) {
        this.professions = professions;
    }

    public List<String> getProfessions() {
        return professions;
    }
}
