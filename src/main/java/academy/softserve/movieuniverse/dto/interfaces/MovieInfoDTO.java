package academy.softserve.movieuniverse.dto.interfaces;

//@JsonDeserialize(as = MovieDTO.class)
public interface MovieInfoDTO {
    public String getMovieName();

    public void setMovieName(String movieName);

    public String getDescription();

    public void setDescription(String description);

    public int getYear();

    public void setYear(int year);

    public Long getDuration();

    public void setDuration(Long duration);

    public String getAgeLimitation();

    public void setAgeLimitation(String ageLimitation);
}
