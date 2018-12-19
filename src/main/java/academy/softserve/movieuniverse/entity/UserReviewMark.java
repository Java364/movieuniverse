package academy.softserve.movieuniverse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

    @Column(name = "mark")
    @Enumerated(EnumType.STRING)
    private Mark mark;

    public UserReview getUserReview() {
        return userReview;
    }

    public void setUserReview(UserReview userReview) {
        this.userReview = userReview;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }
    
    public Mark getMark() {
		return mark;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}

	public enum Mark {
       LIKE,DISLIKE
    }
}
