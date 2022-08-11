package web.forum.bean;

import java.time.LocalDateTime;
import java.util.Arrays;

public class ForumVO implements java.io.Serializable {

	private Integer postId;
	private Integer memberId;
	private String postTitle;
	private String postContent;
	private LocalDateTime postTime;
	private Integer clicks;
	private String status;
	private byte[] postPic;

	

	@Override
	public String toString() {
		return "ForumVO [postId=" + postId + ", memberId=" + memberId + ", postTitle=" + postTitle + ", postContent="
				+ postContent + ", postTime=" + postTime + ", clicks=" + clicks + ", status=" + status + ", postPic="
				+ Arrays.toString(postPic) + "]";
	}

	public ForumVO() {

	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public LocalDateTime getPostTime() {
		return postTime;
	}

	public void setPostTime(LocalDateTime postTime) {
		this.postTime = postTime;
	}

	public Integer getClicks() {
		return clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public byte[] getPostPic() {
		return postPic;
	}

	public void setPostPic(byte[] postPic) {
		this.postPic = postPic;
	}

	public ForumVO(Integer postId, Integer memberId, String postTitle, String postContent, LocalDateTime postTime,
			Integer clicks, String status ,byte[] postPic) {
		super();
		this.postId = postId;
		this.memberId = memberId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postTime = postTime;
		this.clicks = clicks;
		this.status = status;
		this.postPic = postPic;
	}

}
