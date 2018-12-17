package academy.softserve.movieuniverse.dto;

public class UserReviewMarkDTO {
	private Long id;
	private boolean liked;
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

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
