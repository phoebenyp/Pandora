package web.cruiseline.dao;

import web.cruiseline.bean.PortsOfCallListVO;

public interface PortsOfCallListDAO {

	void insert(PortsOfCallListVO portsOfCallListVO);

	void update(PortsOfCallListVO portsOfCallListVO);

	void delete(Integer portsOfCallListNo);
	
	void deleteAll(Integer cruise_Lines_No);

}