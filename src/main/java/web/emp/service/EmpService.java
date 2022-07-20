package web.emp.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import web.emp.bean.EmpVO;

public interface EmpService {

	
	EmpVO selectByEmailAndPassword(EmpVO empVO);

//    EmpVO addEmp(byte[] empPictureId, String englishLastName, String englishFirstName, String jobLevels,
//			String gender, LocalDate empBirthday, String passportNo, String email, LocalDate startDate,
//			LocalDate resignationDate, String password, String empCellphoneNo, String empAddress, String status,
//			LocalDateTime lastModificationDate, LocalDateTime loginTime);
	
	
	EmpVO addEmp(EmpVO empVO);
}

	