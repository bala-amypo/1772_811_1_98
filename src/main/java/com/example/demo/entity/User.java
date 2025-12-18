import java.util.date;

@Entity
public class User{
    
    @Id
    @GeneratedValue
    private Long id;
    private String fullName;
    @Column(unique=true)
    private String email;
    private String password;
    private String role;
    private String preferredLearningStyle ;
    private LocalDate createdAt;

public User (Long id,String fullName,String email,String password,String role,String preferredLearningStyle){
    this.id=id;
}

public User(){

}

public Long getId(){
    return id;
}
public void setId(Long id){
    this.id=id;
}

public String getfullName(){
    return fullName;
}
public void setfullName(String fullName){
    this.fullName=fullName;
}

public String getemail
