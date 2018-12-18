package academy.softserve.movieuniverse.dto.userreview;

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
