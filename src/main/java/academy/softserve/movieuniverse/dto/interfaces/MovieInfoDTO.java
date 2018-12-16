package academy.softserve.movieuniverse.dto.interfaces;

public interface MovieInfoDTO {
    public String getMovieName();
    public String getDescription();
    public int getYear();
    public Long getDuration();
    public String getAgeLimitation();

    public void setMovieName(String movieName);
    public void setDescription(String description);
    public void setYear(int year);
    public void setDuration(Long duration);
    public void setAgeLimitation(String ageLimitation);
}
