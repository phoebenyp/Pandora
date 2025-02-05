package web.packages.dao;

import java.util.List;
import java.util.Map;

import web.packages.bean.PackagesVO;

public interface PackagesDAO {

	List<PackagesVO> getAll(Map<String, String[]> map);

	List<PackagesVO> getALLList();
	
	PackagesVO findByPrimaryKey(Integer packageId);
	
}
