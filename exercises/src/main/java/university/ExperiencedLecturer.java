package university;

public abstract class ExperiencedLecturer extends Lecturer {
    private int experienceYears;

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }
    
    public Homework createHomework(String title, String description,
            int maxPoints) {
        return new Homework(title, description, this, maxPoints);
    }
    
    public abstract GradedHomework gradeHomework(SolvedHomework hwToGrade);
    
    public ExperiencedLecturer(int experienceYears, String firstName,
            String lastName, int employeeNumber) {
        super(firstName, lastName, employeeNumber);
        this.experienceYears = experienceYears;
    }
}
