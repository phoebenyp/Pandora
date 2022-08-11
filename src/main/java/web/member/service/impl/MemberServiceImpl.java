package web.member.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import web.emp.bean.EmpVO;
import web.member.bean.MemberVO;
import web.member.dao.MemberDAO;
import web.member.dao.impl.MemberDAOImpl;
import web.member.service.MemberService;

public class MemberServiceImpl implements MemberService{
	MemberDAO dao = new MemberDAOImpl();

	@Override
	public MemberVO selectByEmailAndPassword(MemberVO memberVO) {
		
		MemberVO resultMemberVO = dao.selectByEmailAndPassword(memberVO);

		return resultMemberVO;
	}
	
	public MemberVO getOneMember(Integer memberId) {

		return dao.findByPrimaryKey(memberId);
	}

	@Override
	public List<MemberVO> getAll() {

		return dao.getAll();
	}
	
	@Override
	public MemberVO addMember(MemberVO memberVO) {

		memberVO.setDiscountNo(1);
		memberVO.setAccumulatedConsumption(0);
		memberVO.setLastUpdateDate(LocalDateTime.now());
		memberVO.setRegistrationTime(LocalDateTime.now());
		
		
		dao.insert(memberVO);

		return memberVO;
	}
	
	@Override
	public MemberVO updateMember(MemberVO memberVO) {
		if (memberVO.getMemberPictureId() != null && memberVO.getMemberPictureId().length != 0) {
			dao.update(memberVO);
		} else {
			dao.updateWithOutPicture(memberVO);
		}
		
		return memberVO;
	}
	
	@Override
	public boolean isExistEmail(String memberEmail) {
		
		boolean result = dao.isExistEmail(memberEmail);
		
		return 	result;
	}
	
}
