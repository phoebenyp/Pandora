package web.packages.dao.impl;
import java.sql.Connection;
import javax.sql.DataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import web.packages.dao.PackagesDAO;

public class PackagesDAOImpl implements PackagesDAO{

	private static DataSource ds = null;
	
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Pandora");
			
		}catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String GET_ALL_STMT = "SELECT * FROM Packages order by Package_ID";
	private static final String GET_ONE_STMT = "SELECT * FROM Packages where Package_ID = ?";
}
