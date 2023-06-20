package web_app_listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.HibernateUtils;

/**
 * Application Lifecycle Listener implementation class SFManager
 *
 */
@WebListener
public class SFManager implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public SFManager() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	//Wc only once at shuutting down time cleaning the conection pool
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("in ctx destroyed");
		HibernateUtils.getFactory().close();
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	//wc only once at time of inititalization
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("in ctx init");
		// create singleton SF
		HibernateUtils.getFactory();// triggers cls loading --
		//static init block -- builds SF
	}

}
