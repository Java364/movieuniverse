package academy.softserve.movieuniverse.dto.userreview;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = UserReviewDTO.class)
public interface UsersReviewMovieView {
    Long getUserReviewId();

    void setUserReviewId(Long userReviewId);

    String getText();

    void setText(String text);

    String getUserName();

    void setUserName(String userName);

    Long getCreationTime();

    void setCreationTime(Long creationTime);

    Long getLastUpdated();

    void setLastUpdated(Long lastUpdated);
}
