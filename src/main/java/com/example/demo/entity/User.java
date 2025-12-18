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

public User (Long id,String fullName,String email,String password,String role,String )
}