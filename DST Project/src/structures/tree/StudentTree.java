package src.structures.tree;

import src.Student;

import java.util.Arrays;
import java.util.Collections;

public class StudentTree extends Tree<Student> {
    public Student find(int id){
        Node node = this.findNode(id);
        if(node != null)
            return (Student) node.getData();
        return null;
    }

    public Student[] toArray(){
        Student[] students = new Student[0];
        toArrayList().toArray(students);
        return students;
    }


    public Student[] sortByGpa(){
        Student[] students = toArray();
        Arrays.sort(students, Collections.reverseOrder());
        return students;
    }

    public Student[] sortByGpa(int n){
        Student[] students = sortByGpa();
        return Arrays.copyOfRange(students, 0, n);
    }
}
