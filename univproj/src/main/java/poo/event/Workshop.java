package poo.event;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Workshop extends Event  {
    private String instructor;
    private String necessaryMaterials;

    public Workshop(String title, LocalDate date, String local, int maxCapacity, String description, int type, String instructor, Integer id, String necessaryMaterials) {
        super(title, date, local, maxCapacity, description, type, id);
        this.instructor = instructor;
    }

    public Workshop() {
        // Default constructor
    }
    
    public static Workshop CollectData(Integer id, Scanner sc){        
        System.out.println("Enter the title of the Workshop:\n");
        String workshopName = sc.nextLine();
        System.out.println("Enter the date of the Workshop (dd/mm/yyyy):\n");
        String date = sc.nextLine(); 
        LocalDate workshopDate;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            workshopDate = LocalDate.parse(date, formatter);            
        } catch (DateTimeException e) {
            System.out.println("Invalid date format. Please use dd/mm/yyyy.");
            workshopDate = LocalDate.now();
        }
        System.out.println("Enter the location of the Workshop:\n");
        String workshopLocation = sc.nextLine();
        System.out.println("Enter the description of the Workshop:\n");
        String workshopDescription = sc.nextLine();
        System.out.println("Enter the maximum capacity of the Workshop:\n");
        int workshopCapacity = sc.nextInt(); 
        sc.nextLine();       
        System.out.println("Enter the Professor who will teach the Workshop:\n");
        String workshopInstructor = sc.nextLine();
        System.out.println("Enter the necessary materials for the Workshop (separated by comma):\n");
        String workshopMaterials = sc.nextLine();
        return new Workshop(workshopName, workshopDate, workshopLocation, workshopCapacity, workshopDescription, 4, workshopInstructor, id, workshopMaterials);
    }

    public String getInstrutor() {
        return instructor;
    }

    public void setInstrutor(String instructor) {
        this.instructor = instructor;
    }

    public String getNecessaryMaterials() {
        return necessaryMaterials;
    }

    public void setNecessaryMaterials(String necessaryMaterials) {
        this.necessaryMaterials = necessaryMaterials;
    }

}