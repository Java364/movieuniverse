package academy.softserve.movieuniverse.dto.interfaces;

import academy.softserve.movieuniverse.dto.MovieDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

//@JsonDeserialize(as = MovieDTO.class)
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
