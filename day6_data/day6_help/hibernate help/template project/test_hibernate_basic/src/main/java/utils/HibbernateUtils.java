package utils;


import org.hibernate.*;
import org.hibernate.cfg.Configuration;



public class HibbernateUtils {
	private static SessionFactory factory;
	
	static {
		
		Configuration config=new Configuration();
		factory=config
				.configure()	
				.buildSessionFactory();
	}

	public static SessionFactory getFactory() {
		return factory;
	}

	
	
}
