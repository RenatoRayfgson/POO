package poo.participant;

import java.util.Scanner;

import static poo.utilities.Utilities.isOnlyDigits;
import static poo.utilities.Utilities.isValidCPF;
import static poo.utilities.Utilities.isValidEmail;


public class Professor extends Participant {
    private String matriculation;

    public Professor(String name, String email, String cpf, int type, String matriculation, int modality, Integer id) {
        super(name, email, cpf, type, modality, id);
        this.matriculation = matriculation;
    }

    public static Professor collectDataPresential(Integer id, Scanner sc) {
    System.out.println("Enter the name of the Professor:");
    String professorName = sc.nextLine();
    System.out.println("Enter the email of the Professor:");
    String professorEmail = sc.nextLine();
    while(!isValidEmail(professorEmail)){
        System.out.println("Invalid email. Please enter a valid email:\n");
        professorEmail = sc.nextLine();
    }
    System.out.println("Enter the CPF of the Professor:");
    String professorCpf = sc.nextLine();        
    while(!isValidCPF(professorCpf)){
        System.out.println("Invalid CPF. Please enter a valid CPF:\n");
        professorCpf = sc.nextLine();
    }        
    System.out.println("Enter the matriculation of the Professor:");
    String professorMatriculation = sc.nextLine();
    while(!isOnlyDigits(professorMatriculation)){
        System.out.println("Invalid matriculation. Please enter a valid matriculation (only digits):\n");
        professorMatriculation = sc.nextLine();
    }
    return new Professor(professorName, professorEmail, professorCpf, 2, professorMatriculation, 2, id);
    }        

    public Professor() {
        // Default constructor
    } 
    
    public String getMatriculation() {
        return matriculation;
    }

    public void setMatriculation(String matriculation) {
        this.matriculation = matriculation;
    }
    
}
