package academy.softserve.movieuniverse.dto.userreview;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@Relation(value = "comment", collectionRelation = "comments")
public class CommentDTO extends ResourceSupport implements CommentRequest {
    private Long userReviewId;
    private String title;
    private String text;
    private String userName;
    private String movieName;
    private Long creationTime;
    private Long lastUpdate;

    public Long getCommentId() {
        return userReviewId;
    }

    public void setCommentId(Long userReviewId) {
        this.userReviewId = userReviewId;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Long creationTime) {
        this.creationTime = creationTime;
    }

    public Long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
