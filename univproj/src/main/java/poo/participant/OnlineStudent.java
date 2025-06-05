package poo.participant;

import java.util.Scanner;

import static poo.utilities.Utilities.isOnlyDigits;
import static poo.utilities.Utilities.isValidCPF;
import static poo.utilities.Utilities.isValidEmail;
import static poo.utilities.Utilities.isValidTelephone;

public class OnlineStudent extends OnlineParticipant {

    @SuppressWarnings("FieldMayBeFinal")
    private String telephone;
    @SuppressWarnings("FieldMayBeFinal")
    private String matriculation;    

    
    public OnlineStudent() {
        // Default constructor
    }
    
    public OnlineStudent(String name, String email, String cpf, int type, String matriculation, int modality, Integer id, String telephone){
        super(name, email, cpf, type, modality, id);
        this.telephone = telephone;
        this.matriculation = matriculation;
    }
    
    @Override
    public OnlineStudent collectDataOnline(Integer id, Scanner sc) {
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
        System.out.println("Your telephone will be used to receive links and reminders about the event!\nEnter the telephone of the Online Student (XX XXXXXXXXX format):");
        String studentTelephone = sc.nextLine();        
        while(!isValidTelephone(studentTelephone)){
            System.out.println("Invalid telephone. Please enter a valid telephone (XX XXXXXXXXX format):");
            studentTelephone = sc.nextLine();            
        }
        System.out.println("Enter the name of the Online Student:");
        String studentName = sc.nextLine();
        System.out.println("Enter the email of the Online Student:");
        String studentEmail = sc.nextLine();
        while(!isValidEmail(studentEmail)){
            System.out.println("Invalid email. Please enter a valid email:");
            studentEmail = sc.nextLine();
        }
        System.out.println("Enter the CPF of the Online Student:");
        String studentCpf = sc.nextLine();        
        while(!isValidCPF(studentCpf)){
            System.out.println("Invalid CPF. Please enter a valid CPF:");
            studentCpf = sc.nextLine();
        } 
        System.out.println("Enter the matriculation of the Student:");
        String studentMatriculation = sc.nextLine();
        while(!isOnlyDigits(studentMatriculation)){
            System.out.println("Invalid matriculation. Please enter a valid matriculation (only digits):");
            studentMatriculation = sc.nextLine();
        }       
        return new OnlineStudent(studentName, studentEmail, studentCpf, 3, studentMatriculation, 1, id, studentTelephone);
    }        
    
    public String getMatriculation() {
        return matriculation;
    }

    public String getTelephone() {
        return telephone;
    }
}
