package usercard.cardQuery.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class User {

    @Id
    @GeneratedValue
    private Long Id;
    private String firstName;
    private String lastName;
    private Long mobileNumber;
    //private Date dob;
    private String address;
    private String designation;
    private String email;
    /*@Relationship(type = "HAS_A")
    private Set<Card> sharedWith;*/

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

   /* public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }*/

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

 /*   public Set<Card> getSharedWith() {
        return sharedWith;
    }

    public void setSharedWith(Set<Card> sharedWith) {
        this.sharedWith = sharedWith;
    }*/

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", address='" + address + '\'' +
                ", designation='" + designation + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
