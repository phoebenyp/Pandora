package web.sightseeing.dao.impl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SightseeingMarkDAOImpl {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Pandora");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private String GET_PIC = "SELECT Sightseeing_Mark_Picture FROM Pandora.Sightseeing_Mark WHERE Port_of_Call_No = ?;";

}
