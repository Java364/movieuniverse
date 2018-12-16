package academy.softserve.movieuniverse.dto.user;

import academy.softserve.movieuniverse.dto.MovieMarkDTO;
import academy.softserve.movieuniverse.dto.UserReviewDto;

import java.util.List;

public interface UserFullInfo {

    Long getId();

    void setId(Long id);

    String getEmail();

    void setEmail(String email);

    String getPassword();

    void setPassword(String password);

    String getConfirmPassword();

    void setConfirmPassword(String confirmPassword);

    String getLastName();

    void setLastName(String lastName);

    String getFirstName();

    void setFirstName(String firstName);

    Long getBirthday();

    void setBirthday(Long birthday);

    Long getEntryCreationDate();

    void setEntryCreationDate(Long entryCreationDate);

    Long getEntryLastUpdate();

    void setEntryLastUpdate(Long entryLastUpdate);

    Boolean getRemoved();

    void setRemoved(Boolean removed);

    List<UserReviewDto> getUserReviewDTOList();

    void setUserReviewDTOList(List<UserReviewDto> userReviewDTOList);

    List<MovieMarkDTO> getMovieMarkDTOList();

    void setMovieMarkDTOList(List<MovieMarkDTO> movieMarkDTOList);

}
