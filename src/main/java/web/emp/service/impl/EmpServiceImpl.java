package web.emp.service.impl;



import java.util.List;

import web.emp.bean.EmpVO;
import web.emp.dao.EmpDAO;
import web.emp.dao.impl.EmpDAOImpl;
import web.emp.service.EmpService;

public class EmpServiceImpl implements EmpService {
	
	EmpDAO dao = new EmpDAOImpl();

	@Override
	public EmpVO selectByEmailAndPassword(EmpVO empVO) {
		
		EmpVO resultEmpVO = dao.selectByEmailAndPassword(empVO);

		return resultEmpVO;
	}
	
	

//	public EmpVO addEmp(byte[] empPictureId, String englishLastName, String englishFirstName, String jobLevels,
//			String gender, LocalDate empBirthday, String passportNo, String email, LocalDate startDate,
//			LocalDate resignationDate, String password, String empCellphoneNo, String empAddress, String status,
//			LocalDateTime lastModificationDate, LocalDateTime loginTime) {
//
//		EmpVO empVO = new EmpVO();
//
//		empVO.setEmpPictureId(empPictureId);
//		empVO.setEnglishLastName(englishLastName);
//		empVO.setEnglishFirstName(englishFirstName);
//		empVO.setJobLevels(jobLevels);
//		empVO.setGender(gender);
//		empVO.setEmpBirthday(empBirthday);
//		empVO.setPassportNo(passportNo);
//		empVO.setEmail(email);
//		empVO.setStartDate(startDate);
//		empVO.setResignationDate(resignationDate);
//		empVO.setPassword(password);
//		empVO.setEmpCellphoneNo(empCellphoneNo);
//		empVO.setEmpAddress(empAddress);
//		empVO.setStatus(status);
//		empVO.setLastModificationDate(lastModificationDate);
//		empVO.setLoginTime(loginTime);
//
//		dao.insert(empVO);
//
//		return empVO;
//	}

	

	public void deleteEmp(Integer empno) {
		EmpDAO dao = new EmpDAOImpl();
		dao.delete(empno);
	}

	public EmpVO getOneEmp(Integer empno) {
		EmpDAO dao = new EmpDAOImpl();
		return dao.findByPrimaryKey(empno);
	}

	public List<EmpVO> getAll() {
		EmpDAO dao = new EmpDAOImpl();
		return dao.getAll();
	}



	@Override
	public EmpVO addEmp(EmpVO empVO) {
	
		
		dao.insert(empVO);
		
		
		
		return empVO;
	}


}
