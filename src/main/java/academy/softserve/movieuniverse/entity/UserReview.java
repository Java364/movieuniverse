package academy.softserve.movieuniverse.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_review")
public class UserReview extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private User reviewer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie reviewedMovie;

    @Column(columnDefinition = "text")
    private String text;

    @OneToMany(mappedBy = "userReview", cascade = CascadeType.ALL)
    private List<UserReviewMark> userReviewMarks = new ArrayList<>();

    public User getReviewer() {
        return reviewer;
    }

    public UserReview setReviewer(User reviewer) {
        this.reviewer = reviewer;
        return this;
    }

    public Movie getReviewedMovie() {
        return reviewedMovie;
    }

    public UserReview setReviewedMovie(Movie reviewedMovie) {
        this.reviewedMovie = reviewedMovie;
        return this;
    }

    public String getText() {
        return text;
    }

    public UserReview setText(String text) {
        this.text = text;
        return this;
    }

    public List<UserReviewMark> getUserReviewMarks() {
        return userReviewMarks;
    }

    public UserReview setUserReviewMarks(List<UserReviewMark> userReviewMarks) {
        this.userReviewMarks = userReviewMarks;
        return this;
    }
}
