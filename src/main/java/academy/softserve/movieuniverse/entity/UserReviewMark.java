package academy.softserve.movieuniverse.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_review_mark")
public class UserReviewMark extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private UserReview userReview;

    @ManyToOne(fetch = FetchType.LAZY)
    private User reviewer;

    private boolean liked;

    public UserReview getUserReview() {
        return userReview;
    }

    public UserReviewMark setUserReview(UserReview userReview) {
        this.userReview = userReview;
        return this;
    }

    public User getReviewer() {
        return reviewer;
    }

    public UserReviewMark setReviewer(User reviewer) {
        this.reviewer = reviewer;
        return this;
    }

    public boolean isLiked() {
        return liked;
    }

    public UserReviewMark setLiked(boolean liked) {
        this.liked = liked;
        return this;
    }
}
