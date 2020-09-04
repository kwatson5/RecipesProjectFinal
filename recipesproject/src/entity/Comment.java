package entity;

public class Comment {
//Jess
	private int commentId;
	private String comment;

	public Comment(int commentId, String comment) {
		this.commentId = commentId;
		this.comment = comment;
	}

	public int getCommentId() {
		return commentId;
	}

	public String getComment() {
		return comment;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + "]";
	}

}
