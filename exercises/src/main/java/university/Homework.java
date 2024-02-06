package university;

public class Homework {
    private String title;
    private String description;
    private Lecturer author;
    private int maxPoints;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Lecturer getAuthor() {
        return author;
    }

    public void setAuthor(Lecturer author) {
        this.author = author;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }
    
    public Homework(String title, String description, Lecturer author,
            int maxPoints) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.maxPoints = maxPoints;
    }
    
    @Override
    public String toString() {
        return getTitle() + " (assigned by " + getAuthor() + "):\n" +
                getDescription() + "\nMaximum points: " + getMaxPoints();
    }
}
