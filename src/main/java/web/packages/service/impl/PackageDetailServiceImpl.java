package web.packages.service.impl;
import java.util.List;

import web.packages.bean.PackageDetailVO;
import web.packages.dao.PackageDetailDAO;
import web.packages.dao.impl.PackageDetailDAOImpl;
import web.packages.service.PackageDetailService;
public class PackageDetailServiceImpl implements PackageDetailService {
	
	
	private PackageDetailDAO dao;

	public PackageDetailServiceImpl() {
		dao = new PackageDetailDAOImpl();
	}
	public List<PackageDetailVO> getOnePackageDetail(Integer packageNo) {
		return dao.findByPackageNo(packageNo);
	}



}
