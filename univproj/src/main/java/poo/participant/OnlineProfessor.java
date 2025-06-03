package poo.participant;

import java.util.Scanner;

import static poo.utilities.Utilities.isOnlyDigits;
import static poo.utilities.Utilities.isValidCPF;
import static poo.utilities.Utilities.isValidEmail;
import static poo.utilities.Utilities.isValidTelephone;
 

public class OnlineProfessor extends Professor {
    @SuppressWarnings("FieldMayBeFinal")
    private String telephone;

    public OnlineProfessor(String name, String email, String cpf, int type, String matriculation, int modality, Integer id, String telephone){
        super(name, email, cpf, type, matriculation, modality, id);
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public static OnlineProfessor collectDataOnline(Integer id, Scanner sc) {
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
        String professorTelephone = sc.nextLine();        
        while(!isValidTelephone(professorTelephone)){
            System.out.println("Invalid telephone. Please enter a valid telephone (XX XXXXXXXXX format):");
            professorTelephone = sc.nextLine();
            sc.nextLine();
        }
        System.out.println("Enter the name of the Online professor:");
        String professorName = sc.nextLine();
        System.out.println("Enter the email of the Online professor:");
        String professorEmail = sc.nextLine();
        while(!isValidEmail(professorEmail)){
            System.out.println("Invalid email. Please enter a valid email:");
            professorEmail = sc.nextLine();
        }
        System.out.println("Enter the CPF of the Online professor:");
        String professorCpf = sc.nextLine();        
        while(!isValidCPF(professorCpf)){
            System.out.println("Invalid CPF. Please enter a valid CPF:");
            professorCpf = sc.nextLine();
        } 
        System.out.println("Enter the matriculation of the professor:");
        String professorMatriculation = sc.nextLine();
        while(!isOnlyDigits(professorMatriculation)){
            System.out.println("Invalid matriculation. Please enter a valid matriculation (only digits):");
            professorMatriculation = sc.nextLine();
        }       
        return new OnlineProfessor(professorName, professorEmail, professorCpf, 2, professorMatriculation, 1, id, professorTelephone);
    } 

}
