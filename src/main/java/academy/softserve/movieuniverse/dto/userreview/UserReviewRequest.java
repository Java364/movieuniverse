package academy.softserve.movieuniverse.dto.userreview;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = UserReviewDTO.class)
public interface UserReviewRequest {
    String getTitle();

    String getText();

    void setTitle(String title);

    void setText(String text);
}
