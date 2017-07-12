import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity  
@Table(name = "application", schema = "ucirvine")
public class Application {

    @Id  
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
    @Column(name = "name")
	private String appName;  
    @Column(name = "description")
	private String desc = "test";  

	@ManyToOne  
	@JoinColumn(name="user_id")        
    private User user;  
	
	public User getUser() {
		return this.user;
	}  
	public void setUser(User user) {
		this.user = user;
	}  

	public long getId() {
		return id;
	}  
	public void setId(long id) {
		this.id = id;
	}  
	public String getAppName() {
		return this.appName;
	}  
	
	public void setAppName(String appName) {
		this.appName = appName;
	}
}