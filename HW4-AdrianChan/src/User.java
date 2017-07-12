import java.util.List;
import java.util.Vector;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity  
@Table(name = "user", schema = "ucirvine")
public class User {  
      
    @Id  
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;  
      
    @Column(name = "firstName")
    private String firstName;  
    @Column(name = "age")
    private long age; 
    
    @OneToMany(mappedBy="user", targetEntity=Application.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)  
    private List<Application> apps; 
    
    public List<Application> getApps() {
    	return this.apps;
    }  
    
    public void setApp(List<Application> apps){
    	this.apps=apps;
    } 
    
    public User() {};  
      
    public User(int id, String firstName, int age) {  
        this.id = id;  
        this.firstName = firstName;  
        this.age = age;  
    }

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setAge(int age) {
		this.age = age;
	}  
	
	public String getFirstName()	{
		return this.firstName;
	}
  
}  