package academy.softserve.movieuniverse.dto.userreview;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = UserReviewDTO.class)
public interface UsersReviewMovieView {
    Long getUserReviewId();

    String getText();

    String getUserName();

    Long getCreationTime();

    Long getLastUpdated();

    void setUserReviewId(Long userReviewId);

    void setText(String text);

    void setUserName(String userName);

    void setCreationTime(Long creationTime);

    void setLastUpdated(Long lastUpdated);
}
