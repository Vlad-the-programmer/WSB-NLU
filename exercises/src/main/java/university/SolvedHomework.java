package university;

public class SolvedHomework extends Homework {
//    private String title;
//    private String description;
//    private Lecturer author;
//    private int maxPoints;
    private String solution;
    private Student solutionAuthor;

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Student getSolutionAuthor() {
        return solutionAuthor;
    }

    public void setSolutionAuthor(Student solutionAuthor) {
        this.solutionAuthor = solutionAuthor;
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

    public SolvedHomework(String title, String description, Lecturer author,
            int maxPoints, String solution, Student solutionAuthor) {
//        this.title = title;
//        this.description = description;
//        this.author = author;
//        this.maxPoints = maxPoints;
//        this.title = title; // :(
        super(title, description, author, maxPoints); // :)
        this.solution = solution;
        this.solutionAuthor = solutionAuthor;
    }
    
    public SolvedHomework(Homework homework, String solution,
            Student solutionAuthor) {
        this(homework.getTitle(),
                homework.getDescription(),
                homework.getAuthor(),
                homework.getMaxPoints(),
                solution,
                solutionAuthor);
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nSolution:\n" + getSolution() +
                " (solved by " + getSolutionAuthor() + ")";
    }
}
