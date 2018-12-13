package academy.softserve.movieuniverse.dto;

import academy.softserve.movieuniverse.entity.*;

import java.util.ArrayList;
import java.util.List;

public class MovieDTO {
    private String movieName;
    private int year;
    private String description;
    private int duration;
    private MediaContent mediaContent;
    private int ageLimitation;
    private List<Genre> genres = new ArrayList<>();
    private List<Country> countries = new ArrayList<>();
    private List<StarActivityInMovies> roles = new ArrayList<StarActivityInMovies>();
    private List<Star> stars = new ArrayList<Star>();
    private List<UserReview> userReviews = new ArrayList<>();
    private List<MovieMark> movieMarks = new ArrayList<>();
}
