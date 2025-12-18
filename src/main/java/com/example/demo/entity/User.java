import java.util.date;

@Entity
public class User{
    @Column unique =true;
    @Id

    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String role;
    private String preferredLearningStyle ;
    private Date created 
}