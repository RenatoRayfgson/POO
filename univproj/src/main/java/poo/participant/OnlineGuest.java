package poo.participant;

import java.util.Scanner;

import static poo.utilities.Utilities.isValidCPF;
import static poo.utilities.Utilities.isValidEmail;
import static poo.utilities.Utilities.isValidTelephone; 

public class OnlineGuest extends OnlineParticipant {
    @SuppressWarnings("FieldMayBeFinal")
    private String telephone;
    private String origin;

    public OnlineGuest(String name, String email, String cpf, int type, String origin, int modality, Integer id, String telephone) {
        super(name, email, cpf, type, modality, id);
        this.telephone = telephone;
        this.origin = origin;
    }

    public OnlineGuest() {
        // Default constructor
    }

    @Override
    public OnlineGuest collectDataOnline(Integer id, Scanner sc) {
        System.out.println("Do you agree to the following terms of online participation?\nKeep microphone muted\nDo not share or record the screen\nDo not share the link with others");
        System.out.println("[1] Yes\n[2] No");
        int choice = sc.nextInt();
        sc.nextLine();
        while(choice != 1){
            System.out.println("You must agree to the terms to participate online.\nDo you agree to the following terms of online participation?\nKeep microphone muted\nDo not share or record the screen\nDo not share the link with others");
            System.out.println("[1] Yes\n[2] No");
            choice = sc.nextInt();
            sc.nextLine();
        }
        System.out.println("Your telephone will be used to receive links and reminders about the event!\nEnter the telephone of the Online Guest (XX XXXXXXXXX format):");
        String guestTelephone = sc.nextLine();        
        while(!isValidTelephone(guestTelephone)){
            System.out.println("Invalid telephone. Please enter a valid telephone (XX XXXXXXXXX format):");
            guestTelephone = sc.nextLine();
            sc.nextLine();
        }
        System.out.println("Enter the name of the Online Guest:");
        String guestName = sc.nextLine();
        System.out.println("Enter the email of the Online Guest:");
        String guestEmail = sc.nextLine();
        while(!isValidEmail(guestEmail)){
            System.out.println("Invalid email. Please enter a valid email:");
            guestEmail = sc.nextLine();
        }
        System.out.println("Enter the CPF of the Online Guest:");
        String guestCpf = sc.nextLine();        
        while(!isValidCPF(guestCpf)){
            System.out.println("Invalid CPF. Please enter a valid CPF:");
            guestCpf = sc.nextLine();
        } 
        System.out.println("Enter the origin of the Guest (Another university, enterprise, etc):");
        String guestOrigin = sc.nextLine();    
        
        return new OnlineGuest(guestName, guestEmail, guestCpf, 1, guestOrigin, 2, id, guestTelephone);        
    }

    public String getTelephone() {
        return telephone;
    }

    public String getOrigin() {
        return origin;
    }
    
}
