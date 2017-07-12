
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HW5 {

	public static void main(String[] args) {
		HW5.retrieve("Pickering Atoms");
		HW5.retrieve("abc123");
	}

	private static void retrieve(String fName) {
		AnnotationConfiguration config = new AnnotationConfiguration(); 
		config.addAnnotatedClass(Application.class); 
		config.addAnnotatedClass(User.class); 
		
		SessionFactory factory=config.configure().buildSessionFactory();   
		Session session = factory.getCurrentSession();   
		session.beginTransaction(); 

		String hql="from User where firstName = :name"; 
		Query query = session.createQuery(hql); 
		query.setString("name", fName); 
		Object o = query.uniqueResult(); 
		User user = (User)o; 
		if (user == null)	{
			System.out.println ("No matching user exist");
		} else	{
			System.out.println("First Name={"+user.getFirstName() +"} Age=" + user.getAge());
			List<Application> appList = user.getApps();
			if (appList == null || appList.size() == 0)	{
				System.out.println("No applications exist for the user");
			}	else{
				for (Application app : appList)	{
					System.out.println("App Name={"+app.getAppName()+"}");
				}
			}
		}
	}

}
