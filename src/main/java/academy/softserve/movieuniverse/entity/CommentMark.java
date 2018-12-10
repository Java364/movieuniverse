package academy.softserve.movieuniverse.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment_mark")
public class CommentMark extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private UserReview userReview;

    @ManyToOne(fetch = FetchType.LAZY)
    private User reviewer;

    private boolean liked;

    public UserReview getUserReview() {
        return userReview;
    }

    public CommentMark setUserReview(UserReview userReview) {
        this.userReview = userReview;
        return this;
    }

    public User getReviewer() {
        return reviewer;
    }

    public CommentMark setReviewer(User reviewer) {
        this.reviewer = reviewer;
        return this;
    }

    public boolean isLiked() {
        return liked;
    }

    public CommentMark setLiked(boolean liked) {
        this.liked = liked;
        return this;
    }
}
