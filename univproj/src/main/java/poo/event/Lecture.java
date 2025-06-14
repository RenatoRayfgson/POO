package poo.event;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Lecture extends Event {
    private String speaker;

    public Lecture(String title, LocalDate date, String local, int maxCapacity, String description, int type, String speaker, Integer id) {
        super(title, date, local, maxCapacity, description, type, id);
        this.speaker = speaker;
    }

    public Lecture() {
        // Default constructor
    }

    @Override
    public String getCertificateExtraInfo() {
        return "The lecture was presented by: " + speaker;
    }
    @Override
    public Lecture CollectData(Integer id, Scanner sc){        
        System.out.println("Enter the title of the Lecture:\n");
        String lectureName = sc.nextLine();
        System.out.println("Enter the date of the Lecture (dd/mm/yyyy):\n");
        String dateEvent = sc.nextLine();
        LocalDate lectureDate;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            lectureDate = LocalDate.parse(dateEvent, formatter);            
        } catch (DateTimeException e) {
            System.out.println("Invalid date format. Please use dd/mm/yyyy.");
            lectureDate = LocalDate.now();
        }
        System.out.println("Enter the location of the Course:\n");
        String lectureLocation = sc.nextLine();
        System.out.println("Enter the description of the Course:\n");
        String lectureDescription = sc.nextLine();
        System.out.println("Enter the maximum capacity of the Course:\n");
        int lectureCapacity = sc.nextInt(); 
        sc.nextLine();       
        System.out.println("Enter the Professor who will teach the course:\n");
        String lectureSpeaker = sc.nextLine();
        return new Lecture(lectureName, lectureDate, lectureLocation, lectureCapacity, lectureDescription, 3, lectureSpeaker, id);
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setPalestrante(String speaker) {
        this.speaker = speaker;
    }
    
}
