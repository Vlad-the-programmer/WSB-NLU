package university;

public class Poet extends ExperiencedLecturer {
    private String hatedAuthor;

    public String getHatedAuthor() {
        return hatedAuthor;
    }

    public void setHatedAuthor(String hatedAuthor) {
        this.hatedAuthor = hatedAuthor;
    }
    
    public GradedHomework gradeHomework(SolvedHomework hwToSolve) {
        if (hwToSolve.getSolution()
                .contains(this.getHatedAuthor())) {
            return new GradedHomework(hwToSolve,
                    0,
                    this);
        } else {
            return new GradedHomework(hwToSolve,
                    hwToSolve.getMaxPoints(),
                    this);
        }
    }
    
    public Poet(String hatedAuthor, int experienceYears, String firstName,
            String lastName, int employeeNumber) {
        super(experienceYears, firstName, lastName, employeeNumber);
        this.hatedAuthor = hatedAuthor;
    }
}
