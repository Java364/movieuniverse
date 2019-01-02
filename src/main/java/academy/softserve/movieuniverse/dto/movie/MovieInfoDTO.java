package academy.softserve.movieuniverse.dto.movie;

//@JsonDeserialize(as = MovieDTO.class)
public interface MovieInfoDTO {
    String getMovieName();

    void setMovieName(String movieName);

    String getDescription();

    void setDescription(String description);

    int getYear();

    void setYear(int year);

    Long getDuration();

    void setDuration(Long duration);

    String getAgeLimitation();

    void setAgeLimitation(String ageLimitation);
}
