package university;

public class Mathematician extends ExperiencedLecturer {
    private int favouriteNumber;

    public int getFavouriteNumber() {
        return favouriteNumber;
    }

    public void setFavouriteNumber(int favouriteNumber) {
        this.favouriteNumber = favouriteNumber;
    }

    public GradedHomework gradeHomework(SolvedHomework hwToSolve) {
        if (hwToSolve.getSolution()
                .contains((String.valueOf(this.getFavouriteNumber())))) {
            return new GradedHomework(hwToSolve,
                    hwToSolve.getMaxPoints(),
                    this);
        } else {
            return new GradedHomework(hwToSolve, 0,this);
        }
    }
    
    public Mathematician(int favouriteNumber, int experienceYears,
            String firstName, String lastName, int employeeNumber) {
        super(experienceYears, firstName, lastName, employeeNumber);
        this.favouriteNumber = favouriteNumber;
    }
}
