package web.packages.dao;

import java.util.List;
import java.util.Map;

import web.cruiseline.bean.PortsOfCallListVO;

public interface PortsOfCallListDAO2 {

	List<PortsOfCallListVO> getByCruiseLineNo(Integer cruiseLineNo);

	Map<Integer,String>  getPortMap();

}
