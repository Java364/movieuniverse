package academy.softserve.movieuniverse.dto.userreview;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = CommentDTO.class)
public interface CommentRequest {
    String getTitle();

    String getText();

    void setTitle(String title);

    void setText(String text);
}