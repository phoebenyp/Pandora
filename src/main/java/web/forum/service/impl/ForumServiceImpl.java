package web.forum.service.impl;

import java.util.List;

import web.forum.bean.ForumVO;
import web.forum.dao.ForumDAO;
import web.forum.dao.impl.ForumDAOImpl;


public class ForumServiceImpl {

	public List<ForumVO> getAll(){
		ForumDAO dao = new ForumDAOImpl();
		List<ForumVO> result = dao.getAll();
		return result;
		
	}
	
}
