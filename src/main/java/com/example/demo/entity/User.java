public class StudentEntity{
    @Id
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String role;
    private String preferredLearningStyle;

    public StudentEntity (Long id,String fullName,String email,String password,String role,String preferredLearningStyle){
        this.id=id;
        this.fullName= fullName;
        this.email=email;
        this.password=password;
        this.role=role;
        this.preferredLearningStyle=preferredLearningStyle;
    }
}