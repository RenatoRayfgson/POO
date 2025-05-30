package poo.event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Course extends Event {
    @SuppressWarnings("FieldMayBeFinal")
    private int hours;
    @SuppressWarnings("FieldMayBeFinal")
    private String professor;

    public Course(){
        
    }
    public Course(String title, Date date, String local, int maxCapacity, String description, int type, String professor, int hours, Integer id){
        super(title, date, local, maxCapacity, description, type, id);
        this.hours = hours;
        this.professor = professor;
    }
    
    public static Course CollectData(Integer id, Scanner sc){        
        sc.nextLine();
        System.out.println("Enter the name of the Course:\n");
        String courseName = sc.next();
        System.out.println("Enter the date of the Course (dd/mm/yyyy):\n");
        String date = sc.next(); 
        Date courseDate;
        try {
            courseDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/mm/yyyy.");
            courseDate = new Date();        
        }
        System.out.println("Enter the location of the Course:\n");
        String courseLocation = sc.next();
        System.out.println("Enter the description of the Course:\n");
        String courseDescription = sc.next();
        System.out.println("Enter the maximum capacity of the Course:\n");
        int courseCapacity = sc.nextInt();
        System.out.println("Enter the stands of the hours the course will least:\n");
        int courseHours = sc.nextInt();
        System.out.println("Enter the Professor who will teach the course:\n");
        String courseProfessor = sc.next();
        return new Course(courseName, courseDate, courseLocation, courseCapacity, courseDescription, 2, courseProfessor, courseHours, id);
    }
        
    public int getHours() {
        return hours;
    }

    public String getProfessor() {
        return professor;
    }    
}
