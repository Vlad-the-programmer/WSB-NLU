package administration;

import university.*;

public class HumanResources {

    public static final int MAX_PEOPLE;
    
    private static int numberOfStudents;
    private static int numberOfLecturers;
    private static Lecturer[] lecturers;
    private static Student[] students;
    private static double[] grades;
    
    public static int getNumberOfStudents() {
        return numberOfStudents;
    }

    public static void setNumberOfStudents(int numberOfStudents) {
        HumanResources.numberOfStudents = numberOfStudents;
    }

    public static int getNumberOfLecturers() {
        return numberOfLecturers;
    }

    public static void setNumberOfLecturers(int numberOfLecturers) {
        HumanResources.numberOfLecturers = numberOfLecturers;
    }

    public static Lecturer[] getLecturers() {
        return lecturers;
    }

    public static void setLecturers(Lecturer[] lecturers) {
        HumanResources.lecturers = lecturers;
    }

    public static Student[] getStudents() {
        return students;
    }

    public static void setStudents(Student[] students) {
        HumanResources.students = students;
    }

    public static double[] getGrades() {
        return grades;
    }

    public static void setGrades(double[] grades) {
        HumanResources.grades = grades;
    }
    
    static {
        MAX_PEOPLE = 100;
        numberOfStudents = 0;
        numberOfLecturers = 0;
        lecturers = new Lecturer[MAX_PEOPLE];
        students = new Student[MAX_PEOPLE];
        grades = new double[]{2, 3, 3.5, 4, 4.5, 5, 5.5};
    }
    
    public static void addPerson(String firstName, String lastName, int idNumber, String formStudies, boolean isLecturer)
    {
        if (isLecturer) {
            lecturers[numberOfLecturers++] = new Lecturer(firstName, lastName, idNumber);
        }
        else {
            students[numberOfStudents++] = new Student(firstName, lastName, idNumber, formStudies);
        }
    }
}
