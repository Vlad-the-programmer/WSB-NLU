
package store;


public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private static int idCounter;
    
    // Constructors
    public Customer(String firstName, String lastName, String address, String email) {
        this.address = address;
        this.customerId = idCounter++;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", email=" + email + '}';
    }
    
    // Getters
    public String getAddress() {
        return address;
    }
    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }
    
    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }
    
    // Setters
    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
