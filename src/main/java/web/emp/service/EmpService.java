package web.emp.service;

import web.emp.bean.EmpVO;

public interface EmpService {

	EmpVO selectByEmailAndPassword(EmpVO empVO);

}
