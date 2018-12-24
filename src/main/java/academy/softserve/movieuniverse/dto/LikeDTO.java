package academy.softserve.movieuniverse.dto;

import academy.softserve.movieuniverse.entity.Like;

public class LikeDTO  {

    private Long id;
    private Like.Mark mark;
    private Long commentatorId;
    private Long commentId;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getCommentatorId() {
        return commentatorId;
    }

    public void setCommentatorId(Long commentatorId) {
        this.commentatorId = commentatorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Like.Mark getMark() {
		return mark;
	}

	public void setMark(Like.Mark mark) {
		this.mark = mark;
	}

}
