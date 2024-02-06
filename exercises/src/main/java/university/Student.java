package university;

public class Student {
    private String firstName;
    private String lastName;
    private int albumNumber;
    private String formStudies;
    
    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public int getAlbumNumber() { return this.albumNumber; }
    public String getFormStudies() { return formStudies; }
    
    public void setFirstName(String newFirst) { this.firstName = newFirst; }
    public void setLastName(String newLast) { this.lastName = newLast; }
    public void setAlbumNumber(int albumNumber) { this.albumNumber = albumNumber; }
    public void setFormStudies(String formStudies) { this.formStudies = formStudies; }
    
    
    public SolvedHomework solveHomework(Homework hwToSolve, String solution) {
        return new SolvedHomework(hwToSolve, solution, this);
    }
    
    public Student(String firstName, String lastName, int albumNumber, String formStudies)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.albumNumber = albumNumber;
        this.formStudies = formStudies;
    }

    @Override
    public String toString() {
        return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", albumNumber=" + albumNumber + ", formStudies=" + formStudies + '}';
    }
}
