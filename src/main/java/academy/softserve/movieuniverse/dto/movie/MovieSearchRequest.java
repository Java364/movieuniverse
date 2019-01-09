package academy.softserve.movieuniverse.dto.movie;

import org.springframework.data.domain.Sort;

import java.util.List;

public class MovieSearchRequest {
    private String keyword;
    private String name;
    private Integer yearFrom;
    private Integer yearTo;
    private List<String> genres;
    private Integer page = 1;
    private Integer size = 20;
    private SortingFields sort = SortingFields.ID;
    private Sort.Direction direction = Sort.Direction.ASC;

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

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

    public Integer getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(Integer yearFrom) {
        this.yearFrom = yearFrom;
    }

    public Integer getYearTo() {
        return yearTo;
    }

    public void setYearTo(Integer yearTo) {
        this.yearTo = yearTo;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public SortingFields getSort() {
        return sort;
    }

    public void setSort(SortingFields sort) {
        this.sort = sort;
    }

    public Sort.Direction getDirection() {
        return direction;
    }

    public void setDirection(Sort.Direction direction) {
        this.direction = direction;
    }
}
