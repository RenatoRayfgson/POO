package poo.participant;

import java.util.Scanner;

import static poo.utilities.Utilities.isValidCPF;
import static poo.utilities.Utilities.isValidEmail;

public class Guest extends Participant  {
    private String origin;

    public Guest(String name, String email, String cpf, int type, String origin, int modality, Integer id) {
        super(name, email, cpf, type, modality, id);
        this.origin = origin;
    }

    public static Guest collectDataPresential(Integer id, Scanner sc) {
        System.out.println("Enter the name of the guest:");
        String guestName = sc.nextLine();
        System.out.println("Enter the email of the guest:");
        String guestEmail = sc.nextLine();
        while(!isValidEmail(guestEmail)){
            System.out.println("Invalid email. Please enter a valid email:");
            guestEmail = sc.nextLine();
        }
        System.out.println("Enter the CPF of the guest:");
        String guestCpf = sc.nextLine();        
        while(!isValidCPF(guestCpf)){
            System.out.println("Invalid CPF. Please enter a valid CPF:");
            guestCpf = sc.nextLine();
        }        
        System.out.println("Enter the name of origin of the guest (Another university, enterprise, etc):");
        String guestOrigin = sc.nextLine();    
        return new Guest(guestName, guestEmail, guestCpf, 1, guestOrigin, 2, id);        
    } 

    public Guest() {
        // Default constructor
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
        
    public void collectData(Integer id, Scanner sc) {
        
    }
    
}
