package src;

import src.structures.hasID;
import src.structures.linkedList.LinkedList;
import src.structures.Team;

import java.io.Serializable;
import java.util.Date;
import src.structures.linkedList.Node;
import static java.util.Objects.compare;

public class Student implements Serializable, Comparable<Student>, hasID {
    private LinkedList data;
    final LinkedList team = new LinkedList();

    //id index 0
    //gpa index 1
    //name index 2
    //surname index 3
    //dob index 4
    //department index 5
    //nationality index 6
    //password index 7

    public Student() {
        data = new LinkedList();
        data.add(1);
        data.add(3.5);
        data.add("John");
        data.add("Doe");
        data.add(new Date(2000, 1, 1));
        data.add("Computer Science");
        data.add("American");
        data.add("password");
    }

    public Student(int id, double gpa, String name, String surname, Date dob, String department, String nationality, String password) {
        data = new LinkedList();
        data.add(id);
        data.add(gpa);
        data.add(name);
        data.add(surname);
        data.add(dob);
        data.add(department);
        data.add(nationality);
        data.add(password);
    }

    public int getId() {
        return data.get(0, Integer.class);
    }

    public void setId(int id) {
        data.edit(0, id);
    }

    public double getGpa(){
        return data.get(1, Double.class);
    }

    public void setGpa(double gpa) {
        data.edit(1, gpa);
    }

    public String getName(){
        return data.get(2, String.class);
    }

    public void setName(String name) {
        data.edit(2, name);
    }

    public String getSurname(){
        return data.get(3, String.class);
    }

    public void setSurname(String Surname) {
        data.edit(3, Surname);
    }

    public Date getDob(){
        return data.get(4, Date.class);
    }

    public void setDob(Date dob) {
        data.edit(4, dob);
    }

    public String getDepartment(){
        return data.get(5, String.class);
    }

    public void setDepartment(String Department) {
        data.edit(5, Department);
    }

    public String getNationality(){
        return data.get(6, String.class);
    }

    public void setNationality(String Nationality) {
        data.edit(6, Nationality);
    }

    public String getPassword(){
        return data.get(7, String.class);
    }

    public void setPassword(String password) {
        data.edit(7, password);
    }

    @Override
    public int compareTo(Student student) {
        return Double.compare(getGpa(),student.getGpa());
    }

//    public Team findTeam(int id){
//        Node current = team.getRoot();
//        Team currentTeam;
//        while (current != null){
//            currentTeam = (Team) current.getData();
//            if (currentTeam.teamId == id){
//                return currentTeam;
//            }
//        }
//        return null;
//    }

    @Override
    public String toString(){
        return "ID: " + getId() + "\n" +
                "GPA: " + getGpa() + "\n" +
                "Name: " + getName() + "\n" +
                "Surname: " + getSurname() + "\n" +
                "Date of Birth: " + getDob() + "\n" +
                "Department: " + getDepartment() + "\n" +
                "Nationality: " + getNationality() + "\n" +
                "Password: " + getPassword() + "\n";
    }

    //get methodunun duzelmesini bekle
    public static void main(String[] args) {

        Student student1 = new Student();
        Student student2 = new Student(2, 3.0, "Jane", "Doe", new Date(2000, 1, 1), "Computer Science", "American", "password");

        System.out.println(student1.getId());
        System.out.println(student1.getGpa());
        System.out.println(student1.getName());
        System.out.println(student1.getSurname());
        System.out.println(student1.getDob());
        System.out.println(student1.getDepartment());
        System.out.println(student1.getNationality());
        System.out.println(student1.getPassword());

        System.out.println(student2.getId());
        System.out.println(student2.getGpa());
        System.out.println(student2.getName());
        System.out.println(student2.getSurname());
        System.out.println(student2.getDob());
        System.out.println(student2.getDepartment());
        System.out.println(student2.getNationality());
        System.out.println(student2.getPassword());

        student2.setId(3);

        System.out.println(student2.getId());

    }
}
