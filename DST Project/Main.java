import java.io.IOException;
import java.util.Date;
import src.Student;
import src.structures.tree.Tree;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;



public class Main implements Serializable {
    public static Tree testTree = new Tree();
    public static void main(String[] args) throws IOException, ClassNotFoundException {
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

    public static void test1_addStudents() throws IOException, ClassNotFoundException{
        Random random = new Random();
        System.out.println("Running test1_addStudents");
        for (int i = 0; i < 25; i++) {
           testTree.add(new Student(i, random.nextDouble(4), "Student" + i, "Surname" + i, new Date(2000, 1, 1), "Computer Science", "American", "password"));
           System.out.println("Added student " + i + " to the tree");
        }
        System.out.println("Running test2");
        System.out.println(testTree.inOrder());
        testTree.toFile();
    }

    public static void test3_printStudentsFromDisk() throws IOException, ClassNotFoundException {
        System.out.println("Running test3_printStudentsFromDisk");
        System.out.println("Reading data from disk");
        System.out.println(testTree.inOrder());
    }

    public static void test4_removeStudent() throws IOException, ClassNotFoundException {
        System.out.println("Running test4_removeStudent");
        System.out.println("Type the id of the student you want to remove:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        testTree.remove(id);
        System.out.println("Student with id " + id + " removed");
        System.out.println(testTree.inOrder());
        testTree.toFile();
    }

    public static void test5_orderByGPA(){
        System.out.println("Running test5_orderByGPA");
    }

    public static void test6_10StudentsByGPA(){
        System.out.println("Running test6_10StudentsByGPA");
    }

    public static void testInterface() throws IOException, ClassNotFoundException{
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
                    System.out.println("Test 2 is automatic, it will print the tree in order after adding students to it.");
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
