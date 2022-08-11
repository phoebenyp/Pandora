package web.packages.service;

import java.util.List;

import web.packages.bean.PackageDetailVO;

public interface PackageDetailService {
	
	 List<PackageDetailVO> getOnePackageDetail(Integer packageNo);

}
