package src;

import src.structures.linkedList.LinkedList;

public class Student implements Comparable<Student> {
    private LinkedList data;
    private int id;

    //id index 0
    //gpa index 1
    //name index 2
    //surname index 3
    //dob index 4
    //department index 5
    //nationality index 6

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

    public double getDob(){
        return data.get(4, Double.class);
    }

    public void setDob(double gpa) {
        data.edit(4, gpa);
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


    public int compareGpa (){
        return 0;
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
