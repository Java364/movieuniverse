package academy.softserve.movieuniverse.dto;

import academy.softserve.movieuniverse.entity.UserReviewMark;

public class UserReviewMarkDTO {

    private Long id;
    private UserReviewMark.Mark mark;
    private Long reviewerId;
    private Long userReviewId;

    public Long getUserReviewId() {
        return userReviewId;
    }

    public void setUserReviewId(Long userReviewId) {
        this.userReviewId = userReviewId;
    }

    public Long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public UserReviewMark.Mark getMark() {
		return mark;
	}

	public void setMark(UserReviewMark.Mark mark) {
		this.mark = mark;
	}

}
