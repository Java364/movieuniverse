package academy.softserve.movieuniverse.dto.userreview;

public interface UserReviewRequest {
    String getTitle();

    String getText();

    void setTitle(String title);

    void setText(String text);
}
