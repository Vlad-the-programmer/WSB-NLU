package university;

public class Lecture {    
    private Course course;
    private int numberofHours;
    private Student[] participants;

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
    public int getNumberofHours() { return numberofHours; }
    public void setNumberofHours(int numberofHours) { this.numberofHours = numberofHours; }
    public Student[] getParticipants() { return participants; }
    public void setParticipants(Student[] participants) { this.participants = participants; }

    public Lecture(Course course, int numberofHours, Student[] participants) {
        this.course = course;
        this.numberofHours = numberofHours;
        this.participants = participants;
    }

    public Lecture(Course course, int numberofHours) {
        this.course = course;
        this.numberofHours = numberofHours;
        this.participants = new Student[0];
    }
}
