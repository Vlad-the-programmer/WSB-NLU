package university;

public class Lecturer {
    private String firstName;
    private String lastName;
    private int employeeNumber;
    private boolean isemployementContract;
    private float salaryRate;
    
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
    public int getEmployeeNumber() {
        return employeeNumber;
    }
    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public boolean isIsemployementContract() {
        return isemployementContract;
    }

    public void setIsemployementContract(boolean isemployementContract) {
        this.isemployementContract = isemployementContract;
    }

    public float getSalaryRate() {
        return salaryRate;
    }

    public void setSalaryRate(float salaryRate) {
        this.salaryRate = salaryRate;
    }
    
 
    public Lecturer(String firstName, String lastName, int employeeNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
    }

    @Override
    public String toString() {
        return "Lecturer{" + "firstName=" + firstName + ", lastName=" + lastName + ", employeeNumber=" + employeeNumber + ", isemployementContract=" + isemployementContract + '}';
    }
}
