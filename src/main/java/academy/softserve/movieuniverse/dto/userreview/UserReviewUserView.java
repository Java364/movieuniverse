package academy.softserve.movieuniverse.dto.userreview;

public interface UserReviewUserView {
    Long getUserReviewId();

    void setUserReviewId(Long userReviewId);

    String getText();

    void setText(String text);

    String getMovieName();

    void setMovieName(String movieName);

    Long getCreationTime();

    void setCreationTime(Long creationTime);

    Long getLastUpdated();

    void setLastUpdated(Long lastUpdated);
}
