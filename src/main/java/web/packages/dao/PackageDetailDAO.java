package web.packages.dao;
import java.util.List;

import web.packages.bean.PackageDetailVO;


public interface PackageDetailDAO {



	List<PackageDetailVO> findByPackageNo(Integer packageNo);

}
