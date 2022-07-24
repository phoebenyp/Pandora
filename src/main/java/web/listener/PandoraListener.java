package web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import web.util.EmpStatusUtil;

@WebListener
public class PandoraListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		sce.getServletContext().setAttribute("empStatusMap", EmpStatusUtil.STATUS_MAP);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
