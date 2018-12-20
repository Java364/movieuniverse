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

    private String title;

    @Column(columnDefinition = "text")
    private String text;

    @OneToMany(mappedBy = "userReview", cascade = CascadeType.ALL)
    private List<UserReviewMark> userReviewMarks = new ArrayList<>();

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public Movie getReviewedMovie() {
        return reviewedMovie;
    }

    public void setReviewedMovie(Movie reviewedMovie) {
        this.reviewedMovie = reviewedMovie;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<UserReviewMark> getUserReviewMarks() {
        return userReviewMarks;
    }

    public void setUserReviewMarks(List<UserReviewMark> userReviewMarks) {
        this.userReviewMarks = userReviewMarks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
