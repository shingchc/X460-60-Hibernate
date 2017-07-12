
import java.util.List;

import junit.framework.Assert;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HW6 {

	public static void main(String[] args) {
		try	{
		HW6.testUpdate("Koey", 38);
		} catch (Exception e)	{
			e.printStackTrace();
			System.out.println("update faile..");
		}

		try	{
			HW6.testSave("Joey", 28);
		} catch (Exception e)	{
			e.printStackTrace();
			System.out.println("save failed..");
		}
		System.out.println("example ends..");
}
	
	private static void testUpdate(String fName, int age)	{

		System.out.println("testUpdate called");
		
		AnnotationConfiguration config = new AnnotationConfiguration();   
		config.addAnnotatedClass(User.class);   
		SessionFactory factory= config.configure().buildSessionFactory();   
		Session hibernateSession = factory.getCurrentSession();
			
		try {  
			
			hibernateSession.beginTransaction();  
			User u = new User(); 
			u.setFirstName(fName);  
			u.setAge(age);
			hibernateSession.update(u);
			hibernateSession.getTransaction().commit(); 

		} catch (HibernateException e) { 
			e.printStackTrace();  
			hibernateSession.getTransaction().rollback();  
			hibernateSession.close();	
			throw e;
		}
	}

	private static void testSave(String fName, int age) {
		System.out.println("retrievePass called");
		
		AnnotationConfiguration config = new AnnotationConfiguration();   
		config.addAnnotatedClass(User.class);   
		SessionFactory factory= config.configure().buildSessionFactory();   
		Session hibernateSession = factory.getCurrentSession();
			
		try {  
			
			hibernateSession.beginTransaction();  
			User u = new User();  
			u.setFirstName(fName);  
			u.setAge(age); 
			hibernateSession.saveOrUpdate(u);
			hibernateSession.getTransaction().commit(); 
			
		} catch (HibernateException e) { 
			e.printStackTrace();  
			hibernateSession.getTransaction().rollback();  
			hibernateSession.close();  
		} 	
	}
}
