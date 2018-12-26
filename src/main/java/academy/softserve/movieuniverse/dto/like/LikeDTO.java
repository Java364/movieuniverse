package academy.softserve.movieuniverse.dto.like;

import org.springframework.hateoas.ResourceSupport;

import academy.softserve.movieuniverse.entity.Like;

public class LikeDTO extends ResourceSupport implements LikeFullInfo{

 
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

	public Like.Mark getMark() {
		return mark;
	}

	public void setMark(Like.Mark mark) {
		this.mark = mark;
	}

}
