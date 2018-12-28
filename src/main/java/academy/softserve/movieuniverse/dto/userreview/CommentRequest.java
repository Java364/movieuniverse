package academy.softserve.movieuniverse.dto.userreview;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = CommentDTO.class)
public interface CommentRequest {
    String getTitle();

    void setTitle(String title);

    String getText();

    void setText(String text);
}
