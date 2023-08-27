package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student{
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade){
        this.name=name;
        this.rollNumber= rollNumber;
        this.grade=grade;
    }
    //getters and setters
    public String getName(){
        return name;
    }
    public int getRollNumber(){
        return rollNumber;
    }
    public String getGrade(){
        return grade;
    }

    @Override
    public String toString(){
        return "Name: " + name +"rollNumber: " + rollNumber + "grade: " + grade;
    }
}
class StudentManagementSystem{
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }
    public Student searchStudent(int rollNumber){
        for (Student student : students){
            if(student.getRollNumber() == rollNumber){
                return student;
            }
        }
        return null;
    }
    public List<Student> getAllStudents(){
        return students;
    }
}

public class Task3 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        while(true){
            System.out.println("1. Add a new student");
            System.out.println("2. Remove student from existing student");
            System.out.println("3. Search a student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    // get input and add student
                    System.out.println("Enter student's name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter roll number: ");
                    int rollNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = sc.nextLine();
                    Student newStudent = new Student(name, rollNumber, grade);
                    sms.addStudent(newStudent);
                }
                case 2 -> {
                    // get input and remove a student
                    System.out.print("Enter roll number to remove: ");
                    int removeRollNumber = sc.nextInt();
                    sms.removeStudent(removeRollNumber);
                }
                case 3 -> {
                    // get input and search student
                    System.out.println("Enter roll number to search: ");
                    int searchRollNumber = sc.nextInt();
                    Student foundStudent = sms.searchStudent(searchRollNumber);
                    if (foundStudent != null) {
                        System.out.println("Student found: + foundStudent");
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case 4 -> {
                    // Display all student
                    List<Student> allStudents = sms.getAllStudents();
                    for (Student student : allStudents) {
                        System.out.println(student);
                    }
                }
                case 5 -> {
                    System.out.println("Exiting the application...");
                    System.exit(0);
                }
                default -> System.out.println("invalid choice. please try again.");
            }
        }
    }
}
