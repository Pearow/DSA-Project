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
        data.add("Computer Engineering");
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
            current = current.getNext();
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
        else  if (getNationality().contentEquals("Palestinian") && ((o.getNationality().contentEquals("Turkish")))) {
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
        else if(difference <= 0.3){
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

    public static void main(String[] args) {

        Student John = new Student();
        Student Jane = new Student(2, 3.0, "Jane", "Doe", new Date(2000, 1, 1), "Computer Engineering", "American", "password");

//        System.out.println(John.getId());
//        System.out.println(John.getGpa());
//        System.out.println(John.getName());
//        System.out.println(John.getSurname());
//        System.out.println(John.getDob());
//        System.out.println(John.getDepartment());
//        System.out.println(John.getNationality());
//        System.out.println(John.getPassword());
//
//        System.out.println(Jane.getId());
//        System.out.println(Jane.getGpa());
//        System.out.println(Jane.getName());
//        System.out.println(Jane.getSurname());
//        System.out.println(Jane.getDob());
//        System.out.println(Jane.getDepartment());
//        System.out.println(Jane.getNationality());
//        System.out.println(Jane.getPassword());
//
//        Jane.setId(3);
//
//        System.out.println(Jane.getId());

        //Test yapilcak ogrenciler burada olusturulacak
        Student Kerem = new Student(3, 3.4, "Kerem", "Serter", new Date(2000, 1, 1), "Software Engineering", "Turkish", "password");
        Student Salim = new Student(3, 3.6, "Salim", "Ucar", new Date(2000, 1, 1), "Software Engineering", "Turkish", "password");
        Student Aziz = new Student(3, 3.0, "Azizcan", "Tam", new Date(2000, 1, 1), "Software Engineering", "Turkish", "password");
        Student Hans = new Student(3, 2.2, "Hans", "Flammenwerfer", new Date(2000, 1, 1), "Machine Engineering", "German", "password");
        Student Cristiano = new Student(3, 0.7, "Cristiano Ronaldo", "Doe", new Date(2000, 1, 1), "Biomedical Engineering", "Portuguese", "password");
        Student Abdulrezzak = new Student(3, 2.8, "Abdulrezzak", "Palestinian", new Date(2000, 1, 1), "Civil Engineering", "Palestinian", "password");
        Student Charles = new Student(3, 3.3, "Charles", "King", new Date(2000, 1, 1), "Electrical Engineering", "English", "password");
        Student Sniper = new Student(3, 4.0, "Sniper", "TF2", new Date(2000, 1, 1), "Industrial Engineering", "Australian", "password");
        Student Fatima = new Student(3, 3.7, "Fatima", "Lebanese", new Date(2000, 1, 1), "Civil Engineering", "American", "password");
        Student Seriz = new Student(3, 1.7, "Seriz", "Kazakhstani", new Date(2000, 1, 1), "Electrical Engineering", "Kazakhstani", "password");
        Student Pele = new Student(3, 2.6, "Pele", "King", new Date(2000, 1, 1), "Machine Engineering", "Brazilian", "password");


        System.out.println(Pele.getCompatibility(John));
        System.out.println(Pele.getCompatibility(Jane));
        System.out.println(Pele.getCompatibility(Kerem));
        System.out.println(Pele.getCompatibility(Salim));
        System.out.println(Pele.getCompatibility(Aziz));
        System.out.println(Pele.getCompatibility(Hans));
        System.out.println(Pele.getCompatibility(Cristiano));
        System.out.println(Pele.getCompatibility(Abdulrezzak));
        System.out.println(Pele.getCompatibility(Charles));
        System.out.println(Pele.getCompatibility(Sniper));
        System.out.println(Pele.getCompatibility(Fatima));
        System.out.println(Pele.getCompatibility(Seriz));
        System.out.println(Pele.getCompatibility(Pele));

        //compatibility tests completed
    }
}
