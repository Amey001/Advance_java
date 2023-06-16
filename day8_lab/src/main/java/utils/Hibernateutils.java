package utils;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Hibernateutils {
	private static SessionFactory factory; //singleton,immutable,inherently 
//	thrd safe object one/DB
//	job: session provider
	
	static {
		System.out.println(" in static init block ! ");
		factory=new Configuration() // empty config
			.configure() //reads props n mappings from hibernate.cfg.xml
			.buildSessionFactory(); //building SF
		
	}

	public static SessionFactory getFactory() {
		return factory;
	}

	public static void setFactory(SessionFactory factory) {
		Hibernateutils.factory = factory;
	}
	
	
	
	

}
