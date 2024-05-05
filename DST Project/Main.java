import java.util.Date;
import src.Student;
import src.structures.Team;
import src.structures.linkedList.LinkedList;
import src.structures.linkedList.Node;
import java.io.Serializable;
import java.util.Scanner;



public class Main implements Serializable {
    public static void main(String[] args) {
        // Create a new student
//        Student student = new Student();
//        student.setId(1);
//        student.setName("John");
//        student.setSurname("Doe");
//        student.setGpa(3.5);
//        student.setDob(new Date(2000, 1, 1));
//        student.setDepartment("Computer Science");
//        student.setNationality("American");
//        student.setPassword("password");

        // Create a new team
//        Team team = new Team();
//        team.addStudent(student);

//        // Print the student's name
//        System.out.println("Student's name: " + student.getName());
//
//        // Print the student's surname
//        System.out.println("Student's surname: " + student.getSurname());
//
//        // Print the student's GPA
//        System.out.println("Student's GPA: " + student.getGpa());
//
//        // Print the student's date of birth
//        System.out.println("Student's date of birth: " + student.getDob());
//
//        // Print the student's department
//        System.out.println("Student's department: " + student.getDepartment());
//
//        // Print the student
        testInterface();
    }

    public static void test1_addStudents(){
        System.out.println("Running test1_addStudents");
        Student[] students = new Student[25];
        for (int i = 0; i < 25; i++) {
           students[i] = new Student(i, 3.5, "Student" + i, "Surname" + i, new Date(2000, 1, 1), "Computer Science", "American", "password");
           System.out.println(students[i].getId() + " added");
        }
    }

    public static void test2_printStudents(){
        System.out.println("Running test2_printStudents");
    }

    public static void test3_printStudentsFromDisk(){
        System.out.println("Running test3_printStudentsFromDisk");
    }

    public static void test4_removeStudent(){
        System.out.println("Running test4_removeStudent");
    }

    public static void test5_orderByGPA(){
        System.out.println("Running test5_orderByGPA");
    }

    public static void test6_10StudentsByGPA(){
        System.out.println("Running test6_10StudentsByGPA");
    }

    public static void testInterface(){
        System.out.println("Select test case or type 0 to exit:");
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        boolean trivial = true;
        while (trivial) {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Exiting");
                    trivial = false;
                    break;
                case 1:
                    test1_addStudents();
                    break;
                case 2:
                    test2_printStudents();
                    break;
                case 3:
                    test3_printStudentsFromDisk();
                    break;
                case 4:
                    test4_removeStudent();
                    break;
                case 5:
                    test5_orderByGPA();
                    break;
                case 6:
                    test6_10StudentsByGPA();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

}
