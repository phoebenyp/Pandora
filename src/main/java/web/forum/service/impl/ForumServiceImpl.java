package web.forum.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import web.forum.bean.ForumVO;
import web.forum.dao.ForumDAO;
import web.forum.dao.impl.ForumDAOImpl;


public class ForumServiceImpl {

	private ForumDAO dao;
	
	public ForumServiceImpl() {
		
		dao = new ForumDAOImpl();
		
	}
	
	public ForumVO addForum(Integer postId, Integer memberId, String postTitle, String postContent, LocalDateTime postTime, Integer clicks, String status, byte[] postPic) {
		
		ForumVO forumVO = new ForumVO();
		
		forumVO.setPostId(postId);
		forumVO.setMemberId(memberId);
		forumVO.setPostTitle(postTitle);
		forumVO.setPostContent(postContent);
		forumVO.setPostTime(postTime);
		forumVO.setClicks(clicks);
		forumVO.setStatus(status);
		forumVO.setPostPic(postPic);
		dao.insert(forumVO);
		
		return forumVO;		
	}
	
	public ForumVO updateForum( Integer memberId, String postTitle, String postContent, LocalDateTime postTime, Integer clicks, String status, byte[] postPic,Integer postId) {
		
		ForumVO forumVO = new ForumVO();
		
		forumVO.setMemberId(memberId);
		forumVO.setPostTitle(postTitle);
		forumVO.setPostContent(postContent);
		forumVO.setPostTime(postTime);
		forumVO.setClicks(clicks);
		forumVO.setStatus(status);
		forumVO.setPostPic(postPic);
		forumVO.setPostId(postId);
		dao.update(forumVO);
		
		return forumVO;		
	}
	
	public void deleteForum(Integer postId) {
		dao.delete(postId);
	}
	
	public ForumVO getOneForum(Integer postId) {
		return dao.findByPrimaryKey(postId);		
	}
	
	public List<ForumVO> getAll(){
		return dao.getAll();		
	}	
}
