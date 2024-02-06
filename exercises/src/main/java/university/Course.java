package university;

public class Course {
    private String name;
    private int numberOfHours;
    private Student[] participants;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public Student[] getParticipants() {
        return participants;
    }

    public void setParticipants(Student[] participants) {
        this.participants = participants;
    }

    public Course(String name, int numberOfHours, Student[] participants) {
        this.name = name;
        this.numberOfHours = numberOfHours;
        this.participants =  participants;
    }
    public Course(String name, int numberOfHours)
    {
        this.name = name;
        this.numberOfHours = numberOfHours;
        this.participants = new Student[0];
    }
    
    @Override 
     public String toString() {
        return getName();
 }
}

