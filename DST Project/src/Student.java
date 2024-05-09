package src;

import src.structures.hasID;
import src.structures.linkedList.LinkedList;
import src.structures.Team;

import java.io.Serializable;
import java.util.Date;
import src.structures.linkedList.Node;

public class Student implements Serializable, Comparable<Student>, hasID {
    private LinkedList data;
    public final LinkedList teams = new LinkedList();

    //id index 0
    //gpa index 1  ex: == (+20), +-0.3 (+15), +-0.7 (+10), +-1.2 (+5), else (+0)
    //name index 2
    //surname index 3
    //dob index 4
    //department index 5  ex: Biomedical Engineering, Computer  Engineering, Civil Engineering, Industrial Engineering, Machine Engineering, Electrical Engineering, Software Engineering
    //nationality index 6 ex: American, Australian, Brazilian, English , German, Lebanese, Kazakhstani, Palestinian, Portuguese, Turkish
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

    public Team findTeam(int id){
        Node current = teams.getRoot();
        Team currentTeam;
        while (current != null){
            currentTeam = (Team) current.getData();
            if (currentTeam.teamId == id){
                return currentTeam;
            }
        }
        return null;
    }

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

    //department ex: Biomedical Engineering, Computer  Engineering, Civil Engineering, Industrial Engineering, Machine Engineering, Electrical Engineering, Software Engineering
    //nationality ex: American, Australian, Brazilian, English , German, Lebanese, Kazakhstani, Palestinian, Portuguese, Turkish
    //== (+20), +-0.3 (+15), +-0.7 (+10), +-1.2 (+5), else (+0)
    public int getCompatibility(Student o){
        int puan =0;

        if(getDepartment().contentEquals(o.getDepartment())){
                puan+=20;
        }
        else if (getDepartment().contentEquals("Biomedical Engineering") && (o.getDepartment().contentEquals("Computer Engineering") || o.getDepartment().contentEquals("Machine Engineering") || o.getDepartment().contentEquals("Electrical Engineering"))) {
                puan+=5;
        }
        else if (getDepartment().contentEquals("Computer Engineering") && (o.getDepartment().contentEquals("Electrical Engineering") || o.getDepartment().contentEquals("Software Engineering"))) {
                puan+=15;
        }
        else if(getDepartment().contentEquals("Computer Engineering") && o.getDepartment().contentEquals("Biomedical Engineering")){
                puan+=5;
        }
        else if (getDepartment().contentEquals("Civil Engineering") && (o.getDepartment().contentEquals("Industrial Engineering") || o.getDepartment().contentEquals("Machine Engineering"))) {
                puan+=10;
        }
        else if (getDepartment().contentEquals("Industrial Engineering") && (o.getDepartment().contentEquals("Civil Engineering") || o.getDepartment().contentEquals("Machine Engineering"))) {
            puan+=10;
        }
        else if (getDepartment().contentEquals("Industrial Engineering") && o.getDepartment().contentEquals("Software Engineering")){
            puan+=5;
        }
        else if (getDepartment().contentEquals("Machine Engineering") && ( o.getDepartment().contentEquals("Civil Engineering") || o.getDepartment().contentEquals("Industrial Engineering") || o.getDepartment().contentEquals("Electrical Engineering"))) {
            puan+=10;
        }
        else if(getDepartment().contentEquals("Machine Engineering") && o.getDepartment().contentEquals("Biomedical Engineering")){
            puan+=5;
        }
        else if (getDepartment().contentEquals("Electrical Engineering") && o.getDepartment().contentEquals("Computer Engineering")) {
            puan+=15;
        }
         else if(getDepartment().contentEquals("Electrical Engineering") && o.getDepartment().contentEquals("Machine Engineering")){
            puan+=10;
        }
         else if(getDepartment().contentEquals("Electrical Engineering") && o.getDepartment().contentEquals("Biomedical Engineering")){
            puan+=5;
        }
         else if (getDepartment().contentEquals("Software Engineering") && o.getDepartment().contentEquals("Computer Engineering")) {
            puan+=15;
        }
         else if (getDepartment().contentEquals("Software Engineering") && o.getDepartment().contentEquals("Industrial Engineering")) {
            puan+=5;
        }
        //
        if (getNationality().contentEquals(o.getNationality())){
            puan+=20;
        }
         else if (getNationality().contentEquals("American") && ((o.getNationality().contentEquals("Australian") || o.getNationality().contentEquals("English")))) {
            puan+=15;

        }
        else if (getNationality().contentEquals("English") && ((o.getNationality().contentEquals("Australian") || o.getNationality().contentEquals("American")))) {
            puan+=15;

        }
         else if (getNationality().contentEquals("Australian") && ((o.getNationality().contentEquals("English") || o.getNationality().contentEquals("American")))) {
            puan+=15;

        }
         else if (getNationality().contentEquals("Turkish") && ((o.getNationality().contentEquals("Kazakhstani")))) {
            puan+=15;

        }
         else if (getNationality().contentEquals("Turkish") && ((o.getNationality().contentEquals("Lebanese")||o.getNationality().contentEquals("German")||o.getNationality().contentEquals("Palestinian")))) {
            puan+=5;

        }
         else if (getNationality().contentEquals("Lebanese") && ((o.getNationality().contentEquals("Turkish")))) {
            puan+=5;

        }
        else if (getNationality().contentEquals("Lebanese") && ((o.getNationality().contentEquals("Palestinian")))) {
        puan+=15;
        }
        else if (getNationality().contentEquals("German") && ((o.getNationality().contentEquals("Turkish")))) {
        puan+=5;
        }
        else if (getNationality().contentEquals("German") && ((o.getNationality().contentEquals("English")))) {
        puan+=15;
        }
        else if (getNationality().contentEquals("Kazakhstani") && ((o.getNationality().contentEquals("Turkish")))) {
            puan+=15;
        }
       else  if (getNationality().contentEquals("Palestinian") && ((o.getNationality().contentEquals("Lebanese")))) {
            puan+=15;
        }
        else  if (getNationality().contentEquals("Palestinian") && ((o.getNationality().contentEquals("Turkısh")))) {
            puan+=5;
        }
        else if (getNationality().contentEquals("Brazilian") && ((o.getNationality().contentEquals("Portuguese")))) {
            puan+=15;

        }
        else if (getNationality().contentEquals("Brazilian") && ((o.getNationality().contentEquals("American")))) {
           puan+=5;}
        else if (getNationality().contentEquals("Portuguese") && ((o.getNationality().contentEquals("Brazilian")))) {
            puan+=15;
        }else if (getNationality().contentEquals("Portuguese") && ((o.getNationality().contentEquals("Turkish")))) {
            puan+=5;
        }
        //
        double difference = Math.abs(getGpa() - o.getGpa());
        if(getGpa() == o.getGpa()){
            puan+=20;
        }
        if(difference <= 0.3){
            puan+=15;
        }
        else if(difference <= 0.7){
            puan+=10;
        }
        else if(difference <= 1.2){
            puan+=5;
        }
        return puan;
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
