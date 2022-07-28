package web.cruiseline.dao;

import java.util.List;

import web.cruiseline.bean.PortNameListVO;

public interface PortNameListDAO {

	List<PortNameListVO> getAll(Integer portsOfCallListNo);

	PortNameListVO selectOne(Integer portsOfCallListNo, Integer portOfCallSequence);

	PortNameListVO selectLast(Integer portsOfCallListNo);

	PortNameListVO selectLastSecond(Integer portsOfCallListNo);

	PortNameListVO selectFirst(Integer portsOfCallListNo);

}