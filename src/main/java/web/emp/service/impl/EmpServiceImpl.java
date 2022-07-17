package web.emp.service.impl;

import web.emp.bean.EmpVO;
import web.emp.dao.EmpDAO;
import web.emp.dao.impl.EmpDAOImpl;
import web.emp.service.EmpService;

public class EmpServiceImpl implements EmpService {

	@Override
	public EmpVO selectByEmailAndPassword(EmpVO empVO) {
		EmpDAO dao = new EmpDAOImpl();
		EmpVO resultEmpVO= dao.selectByEmailAndPassword(empVO);
		
		return resultEmpVO;
	}

	
}
