package academy.softserve.movieuniverse.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comment extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private User commentator;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie commentedMovie;

    private String title;

    @Column(columnDefinition = "text")
    private String text;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();

    public User getCommentator() {
        return commentator;
    }

    public void setCommentator(User commentator) {
        this.commentator = commentator;
    }

    public Movie getCommentedMovie() {
        return commentedMovie;
    }

    public void setCommentedMovie(Movie commentedMovie) {
        this.commentedMovie = commentedMovie;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
