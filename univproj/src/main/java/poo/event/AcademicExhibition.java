package poo.event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AcademicExhibition extends Event  {
    private String stands;    
    
    public AcademicExhibition(String title, Date date, String local, int maxCapacity, String description, int type, Integer id, String stands) {
        super(title, date, local, maxCapacity, description, type, id);
        this.stands = stands;
        
    }
    
    public AcademicExhibition() {
        // Default constructor
    }
        
    public static AcademicExhibition CollectData(Integer id, Scanner sc){        
        System.out.println("Enter the name of the Academic Exhibition:\n");
        String exhibitionName = sc.nextLine();
        System.out.println("Enter the date of the Academic Exhibition (dd/mm/yyyy):\n");
        String date = sc.nextLine(); 
        Date exhibitionDate;
        try {
            exhibitionDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/mm/yyyy.");
            exhibitionDate = new Date();
        }
        System.out.println("Enter the location of the Academic Exhibition:\n");
        String exhibitionLocation = sc.nextLine();
        System.out.println("Enter the description of the Academic Exhibition:\n");
        String exhibitionDescription = sc.nextLine();
        System.out.println("Enter the maximum capacity of the Academic Exhibition:\n");
        int exhibitionCapacity = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the stands of the Academic Exhibition (comma separated):\n");
        String exhibitionStands = sc.nextLine();
        return new AcademicExhibition(exhibitionName, exhibitionDate, exhibitionLocation, exhibitionCapacity, exhibitionDescription, 1, id, exhibitionStands);
    }
    
    public String getStands() {
        return stands;
    }

    public void setStands(String stands) {
        this.stands = stands;
    }

}
