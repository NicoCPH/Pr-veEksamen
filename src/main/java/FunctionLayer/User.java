package FunctionLayer;
//----------------------------------Users constructors, that makes a specfic user--------------------------//
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
public class User {

        private int id; // just used to demo retrieval of autogen keys in UserMapper
        private String email;
        private String password; // Should be hashed and secured
        private String role;
        private String firstName;
        private String lastName;
        private double credit;

    public User(String email) {
        this.email = email;
    }

    public User(int id, double credit) {
        this.id = id;
        this.credit = credit;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, double credit) {
        this.email = email;
        this.credit = credit;
    }

    public User( String email, String password, String role ) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String email, String password, int credit) {
        this.email = email;
        this.password = password;
        this.credit = credit;
    }

    public User(String email, String password, String role, String firstName, String lastName ) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(int id, String email, String password, String role, String firstName, String lastName, double credit) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credit = credit;
    }

    public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public double getCredit() {
            return credit;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail( String email ) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword( String password ) {
            this.password = password;
        }

        public String getRole() {
            return role;
        }

        public void setRole( String role ) {
            this.role = role;
        }

        public int getId() {
            return id;
        }

        public void setId( int id ) {
            this.id = id;
        }

    }
