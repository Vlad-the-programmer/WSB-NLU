package university;

public class GradedHomework extends SolvedHomework {
//    private String title;
//    private String description;
//    private Lecturer author;
//    private int maxPoints;
//    private String solution;
//    private Student solutionAuthor;
    private int grade;
    private ExperiencedLecturer gradeAuthor;

//    public String getSolution() {
//        return solution;
//    }
//
//    public void setSolution(String solution) {
//        this.solution = solution;
//    }
//
//    public Student getSolutionAuthor() {
//        return solutionAuthor;
//    }
//
//    public void setSolutionAuthor(Student solutionAuthor) {
//        this.solutionAuthor = solutionAuthor;
//    }

    @Override
    public String toString() {
        return "GradedHomework{" + "grade=" + grade + ", gradeAuthor=" + gradeAuthor + '}';
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public ExperiencedLecturer getGradeAuthor() {
        return gradeAuthor;
    }

    public void setGradeAuthor(ExperiencedLecturer gradeAuthor) {
        this.gradeAuthor = gradeAuthor;
    }
    

//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Lecturer getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(Lecturer author) {
//        this.author = author;
//    }
//
//    public int getMaxPoints() {
//        return maxPoints;
//    }
//
//    public void setMaxPoints(int maxPoints) {
//        this.maxPoints = maxPoints;
//    }

    public GradedHomework(String title, String description, Lecturer author,
            int maxPoints, String solution, Student solutionAuthor, int grade,
            ExperiencedLecturer gradeAuthor) {
//        this.title = title;
//        this.description = description;
//        this.author = author;
//        this.maxPoints = maxPoints;
//        this.solution = solution;
//        this.solutionAuthor = solutionAuthor;
        super(title, description, author, maxPoints, solution, solutionAuthor);
        this.grade = grade;
        this.gradeAuthor = gradeAuthor;
    }
    
    public GradedHomework(SolvedHomework tempHw, int grade, ExperiencedLecturer gradeAuthor) {
        super(tempHw, tempHw.getSolution(),
                tempHw.getSolutionAuthor());
        this.grade = grade;
        this.gradeAuthor = gradeAuthor;
    }
}
