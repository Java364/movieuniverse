package academy.softserve.movieuniverse.dto.userreview;

public interface UserReviewUserView {
    Long getUserReviewId();

    String getText();

    String getMovieName();

    Long getCreationTime();

    Long getLastUpdated();

    void setUserReviewId(Long userReviewId);

    void setText(String text);

    void setMovieName(String movieName);

    void setCreationTime(Long creationTime);

    void setLastUpdated(Long lastUpdated);
}
