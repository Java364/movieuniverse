package academy.softserve.movieuniverse.entity;

import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Like extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private User commentator;

    @Column(name = "mark")
    @Enumerated(EnumType.STRING)
    private Mark mark;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getCommentator() {
        return commentator;
    }

    public void setCommentator(User commentator) {
        this.commentator = commentator;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public enum Mark {
        LIKE, DISLIKE
    }
}
