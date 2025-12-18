import java.util.*;
import jakarta.persistence.*;

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

public User (Long id,String fullName,String email,String password,String role="LEARNER",String preferredLearningStyle){
    this.id=id;
    this.fullName=fullName;
    this.email=email;
    this.password=password;
    this.role=role;
    this.preferredLearningStyle=preferredLearningStyle;
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

public String getemail(){
    return email;
}

public void setemail(String email){
    this.email=email;
}

public String getpassword(){
    return password;
}
public void setpassword(String password){
    this.password=password;

}

public String getrole(){
    return role;
}
public void setrole(String role){
    this.role=role;
}

public String getpreferredLearningStyle(){
    return preferredLearningStyle;
}
public void setpreferredLearningStyle(String preferredLearningStyle){
    this.preferredLearningStyle=preferredLearningStyle;
}

}