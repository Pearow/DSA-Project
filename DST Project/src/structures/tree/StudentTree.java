package src.structures.tree;

import src.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class StudentTree extends Tree<Student> {
    public static StudentTree fromFile(String filename) throws IOException, ClassNotFoundException {
        Object tree = Tree.fromFile(filename);
        if (tree instanceof StudentTree)
            return (StudentTree) tree;
        else
        {
            System.out.println("File is not a StudentTree");
            return new StudentTree();
        }
    }

    public static void buildTree() throws IOException {
        {
            Student[] students = {
                    new Student(2200870, 3.3, "Kerem", "Serter", new Date(2000, 3, 21), "Software Engineering", "Turkish", "2200870"),
                    new Student(2200900, 3.4, "Salim", "Uçar", new Date(2003, 5, 26), "Software Engineering", "Turkish", "2200870"),
                    new Student(2200780, 3.0, "Azizcan", "Tam", new Date(2003, 0, 1), "Software Engineering", "Turkish", "2200780"),
                    new Student(4, 2.2, "Büşra", "Saygılı", new Date(2001, 2, 12), "Industrial Engineering", "Turkish", ""),
                    new Student(5, 2.6, "Hamit", "Hamdioğlu", new Date(2002, 11, 8), "Machine Engineering", "Turkish", "password"),
                    new Student(6, 2.6, "Sude", "Atak", new Date(2000, 6, 28), "Computer Engineering", "Turkish", "password"),
                    new Student(7, 0.7, "Klaus", "Schmidt", new Date(2002, 10, 11), "Biomedical Engineering", "German", "password"),
                    new Student(8, 3.2, "Emma", "Müller", new Date(2002, 4, 18), "Biomedical Engineering", "German", "password"),
                    new Student(9, 2.5, "Carl ", "Fischer", new Date(2004, 10, 9), "Computer Engineering", "German", "password"),
                    new Student(10, 2.8, "Abdulrezzak", "Awad", new Date(2000, 1, 26), "Electrical Engineering", "Palestinian", "password"),
                    new Student(11, 2.1, "Muhammed", "Saleh", new Date(2002, 8, 11), "Civil Engineering", "Palestinian", "password"),
                    new Student(12, 3.7, "Fatima", "Salama", new Date(2003, 7, 17), "Civil Engineering", "Palestinian", "password"),
                    new Student(13, 3.9, "Harvey", "Specter", new Date(2001, 11, 29), "Electrical Engineering", "English", "password"),
                    new Student(14, 3.2, "Elizabeth", "Brown", new Date(2004, 3, 14), "Industrial Engineering", "English", "password"),
                    new Student(15, 2.3, "Michael", "Scott", new Date(2002, 2, 30), "Electrical Engineering", "English", "password"),
                    new Student(16, 1.7, "Thomas", "Shelby", new Date(2001, 2, 24), "Computer Engineering", "English", "password"),
                    new Student(17, 4.0, "Tony", "Stark", new Date(2000, 6, 1), "Machine Engineering", "American", "password"),
                    new Student(18, 3.8, "Peter", "Parker", new Date(2004, 9, 23), "Machine Engineering", "American", "password"),
                    new Student(19, 1.5, "Tyrone", "Carver", new Date(2000, 4, 28), "Industrial Engineering", "American", "password"),
                    new Student(20, 2.0, "Lily", "Richards", new Date(2001, 8, 12), "Biomedical Engineering", "American", "password"),
                    new Student(21, 2.75, "Jack", "Sullivan", new Date(2003, 0, 19), "Machine Engineering", "Australian", "password"),
                    new Student(22, 2.3, "Nathan", "Drake", new Date(2003, 5, 20), "Civil Engineering", "Australian", "password"),
                    new Student(23, 3.3, "Matilda", "Mitchell", new Date(2004, 0, 17), "Biomedical Engineering", "Australian", "password"),
                    new Student(24, 3.1, "Saxton", "Hale", new Date(2004, 10, 10), "Software Engineering", "Australian", "password"),
                    new Student(25, 3.9, "Charles", "Oliviera", new Date(2002, 1, 13), "Civil Engineering", "Brazilian", "password"),
                    new Student(26, 2.7, "Isebela", "Santos", new Date(2001, 5, 8), "Software Engineering", "Brazilian", "password"),
                    new Student(27, 1.9, "Thiago", "Pereira", new Date(2003, 11, 10), "Electrical Engineering", "Brazilian", "password"),
                    new Student(28, 2.4, "Gabriela", "Silva", new Date(2000, 2, 22), "Electrical Engineering", "Brazilian", "password"),
                    new Student(29, 3.2, "Sofia", "Almeida", new Date(2000, 3, 8), "Industrial Engineering", "Portuguese", "password"),
                    new Student(30, 1.4, "Diogo", "Costa", new Date(2002, 11, 6), "Computer Engineering", "Portuguese", "password"),
                    new Student(31, 2.1, "Beatriz", "Fernandes", new Date(2003, 3, 15), "Biomedical Engineering", "Portuguese", "password"),
                    new Student(32, 4.0, "Ricardo", "Quaresma", new Date(2000, 8, 22), "Civil Engineering", "Portuguese", "password"),
                    new Student(33, 1.6, "Ali", "Hassan", new Date(2002, 6, 27), "Machine Engineering", "Lebanese", "password"),
                    new Student(34, 2.5, "Layla", "Farid", new Date(2004, 9, 31), "Biomedical Engineering", "Lebanese", "password"),
                    new Student(35, 2.2, "Rana", "Farhat", new Date(2004, 11, 7), "Industrial Engineering", "Lebanese", "password"),
                    new Student(36, 2.7, "Omar", "Nasser", new Date(2002, 0, 31), "Civil Engineering", "Lebanese", "password"),
                    new Student(37, 3.8, "Bahtiyar", "Zaynutdinov", new Date(2001, 3, 16), "Software Engineering", "Kazakhstani", "password"),
                    new Student(38, 4.0, "Shavkat", "Rakhmonov", new Date(2002, 7, 3), "Machine Engineering", "Kazakhstani", "password"),
                    new Student(39, 3.0, "Aisha", "Abayeva", new Date(2003, 2, 31), "Computer Engineering", "Kazakhstani", "password"),
                    new Student(40, 3.4, "Gulmira", "Temirkhanova", new Date(2001, 0, 1), "Industrial Engineering", "Kazakhstani", "password")
            };
            StudentTree tree = new StudentTree();
            for (Student student : students) {
                tree.add(student);
            }
            tree.toFile("database.dat");
        }
    }

    public Student find(int id) {
        Node node = this.findNode(id);
        if (node != null)
            return (Student) node.getData();
        return null;
    }

    public Student[] toArray() {
        ArrayList<Student> list = toArrayList();
        Student[] students = new Student[list.size()];
        list.toArray(students);
        return students;
    }

}
