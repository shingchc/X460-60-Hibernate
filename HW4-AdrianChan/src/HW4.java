import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HW4 {

	public static void main(String[] args) {
		HW4.create();
		HW4.retrieve();
	}

	public static void create()	{
		AnnotationConfiguration config = new AnnotationConfiguration(); 
		config.addAnnotatedClass(Application.class); 
		config.addAnnotatedClass(User.class); 
		
		SessionFactory factory=config.configure().buildSessionFactory();   
		Session session = factory.getCurrentSession();   
		session.beginTransaction(); 
		
		User user = new User(); 
		user.setFirstName("Pickering Atoms"); 
		user.setAge(20); 
		List<Application> appList = new Vector();
		user.setApp(appList);
		session.save(user); 

		Application app1 = new Application(); 
		Application app2 = new Application();
		
		app1.setAppName("Lefty"); 
		app1.setUser(user); 
		
		user.getApps().add(app1);
		
		session.save(app1); 

		app2.setAppName("Blinky"); 
		app2.setUser(user); 

		user.getApps().add(app2);

		session.save(app2);

		session.merge(user); 

		session.getTransaction().commit();		
	}
	
	public static void retrieve() {   
		AnnotationConfiguration config = new AnnotationConfiguration();   
		config.addAnnotatedClass(User.class);   
		SessionFactory factory= config.configure().buildSessionFactory();   
		Session session = factory.getCurrentSession();   
		session.beginTransaction();   
		Query queryResult = session.createQuery("from User");   
		List allUsers;   
		allUsers = queryResult.list();   
		System.out.println("Retrieve users...");
		for (int i = 0; i < allUsers.size(); i++) {    
			User user = (User) allUsers.get(i);
			System.out.println("user name: "+user.getFirstName());
			for (Application app : user.getApps()){
				System.out.println("application: "+ app.getAppName());
			}
		}   
		session.getTransaction().commit(); 
	}  
}
