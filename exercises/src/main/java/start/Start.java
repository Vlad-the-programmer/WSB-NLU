package start;
import university.*;
import administration.*;
import administration.Evaluation;

public class Start {
    public static void main(String[] args)
    {
//        SolvedHomework solvie = new SolvedHomework("Some good homework",
//                "This is really well-written homework",
//            null, 10, "solution here", null);
//        
//        Homework justHW = new Homework("Assignment #1", 
//                "Some useful description", 
//                new Lecturer("John", "Doe", 1),
//                10);
//        
//        Poet edgar = new Poet("Tennessee Williams", 30,
//                "Edgar A.", "Poe", 2);
//        Mathematician pythagoras = new Mathematician(3,
//                60, "Pythagoras", "Idk", 3);
//        
//        GradedHomework newGradedHW = new GradedHomework("Solving for pi",
//                "Figure out the value of pi",
//            pythagoras, 4, "no solution yet",
//                null, -1, pythagoras);
//        
//        GradedHomework poemGradedHW = new GradedHomework("Write a poem",
//                "Get creative",
//            edgar, 4, "no solution yet",
//                null, -1, edgar);
//        
//        System.out.println("Displaying pure Homework data:");
//        System.out.println(justHW);
//        
//        System.out.println("\nDisplaying SolvedHomework data:");
//        System.out.println(solvie);
        
//        ExperiencedLecturer oldTimer = pythagoras;
//        ExperiencedLecturer goodFellow = edgar;
//        
//        oldTimer.gradeHomework(solvie);
        
//        Student newStudent = new Student("John", "Doe", 0);
//        System.out.println(newStudent.getFirstName() + " " + newStudent.getLastName());
//        HumanResources.addPerson("Jane", "Doe", 0, true);
//        HumanResources.addPerson("XYZ", "ABC", 1, true);
//        
//        HumanResources.addPerson("Student1", "Surname1", 0, false);
//        HumanResources.addPerson("Student2", "Surname2", 1, false);
//        
//        HumanResources.addPerson("Student3", "Surname3", 2, false);
//        HumanResources.addPerson("Student4", "Surname4", 3, false);
//        System.out.println("Lecturers:");
//        for (int i=0; i<HumanResources.getNumberOfLecturers(); i++) {
//            System.out.println(HumanResources.getLecturers()[i].toString());
//        }
//        for (Lecturer curLecturer: HumanResources.getLecturers()) {
//            if (curLecturer == null)
//                continue;
//            System.out.println(curLecturer.toString());
//          
//        }
//        Course item = new Course("Java", 10);
//        Evaluation.getCourses().add(item);
//        
//        Course item2 = new Course("C++", 10);
//        Evaluation.getCourses().add(item2);
//        
//        System.out.println("Courses");
//      
//        System.out.println(Evaluation.getCoursesData());
//        
//        item = new Course("Java", 10);
//        Evaluation.getCourses().remove(item); 
//        System.out.println("deleted");
//        System.out.println(Evaluation.getCoursesData());
//        
//        Evaluation.fillResult();
//        Evaluation.showResult();
        
        Poet edgar = new Poet("Tennessee Williams", 30,
               "Edgar A.", "Poe", 2);
        Mathematician pythagoras = new Mathematician(3,
                60, "Pythagoras", "Idk", 3);
        
        HumanResources.addPerson("Jane", "Doe", 0, false);
        HumanResources.getLecturers()[HumanResources.getNumberOfLecturers()] = edgar;
        HumanResources.setNumberOfLecturers(HumanResources.getNumberOfLecturers() + 1);
        
        HumanResources.getLecturers()[HumanResources.getNumberOfLecturers()] = pythagoras;
        HumanResources.setNumberOfLecturers(HumanResources.getNumberOfLecturers() + 1);
        
        
        Homework hm1 = pythagoras.createHomework("Hm1", "First 1", 10);
        Evaluation.getHomeWorks().add(hm1);
        SolvedHomework solvedHW1 = HumanResources.getStudents()[0].solveHomework(Evaluation.getHomeWorks().get(0), "Solution1");
        Evaluation.getHomeWorks().add(solvedHW1);
        
        
        Evaluation.getHomeWorks().add(edgar.gradeHomework(solvedHW1));
        
        Evaluation.getHomeWorks().add(pythagoras.gradeHomework(solvedHW1));
        
        Evaluation.getHomeWorks().forEach(hm -> System.out.println(hm));
        
    }
}
