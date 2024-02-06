
package administration;

import java.util.List;
import university.Course;
import java.util.ArrayList;
import university.Homework;
import university.Lecture;
import university.Student;

public class Evaluation {
    private static List<Course> courses;
    private static List<Lecture> lectures;
    private static boolean[][] result;
    private static List<Homework> homeWorks;
   
    public static void setCourses(List<Course> courses) {
        Evaluation.courses = courses;
    }

    public static void setHomeWorks(List<Homework> homeWorks) {
        Evaluation.homeWorks = homeWorks;
    }

    public static List<Homework> getHomeWorks() {
        return homeWorks;
    }

    public static void setLectures(List<Lecture> lectures) {
        Evaluation.lectures = lectures;
    }

    public static List<Course> getCourses() {
        return courses;
    }

    public static List<Lecture> getLectures() {
        return lectures;
    }
    
    static{
        courses = new ArrayList<>();
        lectures = new ArrayList<>();
        homeWorks = new ArrayList<>();
    }
    
    public static void fillResult() {
        result = new boolean[HumanResources.getNumberOfStudents()][courses.size()];
        for(int studentIndex = 0; studentIndex < HumanResources.getNumberOfStudents(); studentIndex++) {
            for(int courseIndex = 0; courseIndex < courses.size(); courseIndex++) {
                int sumOfHours = 0;
                for(Lecture lecture: getLectures()) {
                    if(getCourses().get(courseIndex) == lecture.getCourse()) {
                        for(Student participants: lecture.getParticipants()) {
                            if(participants == HumanResources.getStudents()[studentIndex]) {
                                sumOfHours += lecture.getNumberofHours();
                            }
                        }
                    }
                }
                
                if(sumOfHours >= getCourses().get(courseIndex).getNumberOfHours()) {
                    result[studentIndex][courseIndex] = true;
                } else {
                    result[studentIndex][courseIndex] = false; 
                }
            }
        }
    }
    
    public static void printCorrectCourses() {
       List<Course> result = getCourses().stream().filter(course -> course.getNumberOfHours() % 3 == 0).toList();
       System.out.println(result);
       for(Course correctCourse: result) {
           System.out.println(correctCourse);
       }
       
    }
    
    public static void printLongCourses() {
       getCourses().stream().filter(course -> course.getNumberOfHours() > 50).forEach(course -> System.out.println(course)); 
    }
    
    public static void showResult() {
        for(int courseIndex = 0; courseIndex < courses.size(); courseIndex++) {
            System.out.println(getCourses().get(courseIndex));
            for(int studentIndex = 0; studentIndex < HumanResources.getNumberOfStudents(); studentIndex++) {
                System.out.println(HumanResources.getStudents()[studentIndex] + (result[studentIndex][courseIndex] ? " - Pass": " - Fail"));
            }
        }
    }

    public static void addCourse(String name, int numberOfHours, Student[] participants){
        Course item = new Course(name, numberOfHours, participants);
        getCourses().add(item);
       
    }
    public static void addLecture(Course item1, int item2, Student[] item3){
        getLectures().add(new Lecture(item1, item2, item3));
    }
   
    public static String getCoursesData(){
        String result = "";
        for(Course item: getCourses()){
            result += item + "\n";
                   
            
        }
        return result;
        
    }
    public static String getLecturesData(){
        String result = "";
        for(Lecture item: getLectures()){
            result += item + "\n";
        }
        return result;
        
    }
}
