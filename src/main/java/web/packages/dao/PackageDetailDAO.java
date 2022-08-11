package web.packages.dao;
import java.util.List;
import java.util.Map;

import web.packages.bean.PackageDetailVO;


public interface PackageDetailDAO {



	List<PackageDetailVO> findByPackageNo(Integer packageNo);

	
	

}
