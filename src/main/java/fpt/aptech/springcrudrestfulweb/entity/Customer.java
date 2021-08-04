package fpt.aptech.springcrudrestfulweb.entity;



import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    public  long id;

    @Column(name="last_name")
    public String lastName;

    @Column(name="first_name")
    public String firstName;

    @Column(name="email")
    public String email;

    public Customer(){
        super();
    }
    public Customer(long id, String lastName, String firstName, String email) {
        super();
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
