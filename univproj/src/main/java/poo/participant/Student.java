package poo.participant;
import java.util.Scanner;

import static poo.utilities.Utilities.isOnlyDigits;
import static poo.utilities.Utilities.isValidCPF;
import static poo.utilities.Utilities.isValidEmail;

public class Student extends PresentialParticipant  {
    
    private String matriculation;

    public Student(String name, String email, String cpf, int type, String matriculation, int modality, Integer id){
    super(name, email, cpf, type, modality, id);
    this.matriculation = matriculation;
    }

    public Student() {
        // Default constructor
    }

    public String getMatriculation() {
        return matriculation;
    }

    public void setMatriculation(String matriculation) {
        this.matriculation = matriculation;
    }

    @Override
    public Student collectDataPresential(Integer id, Scanner sc) {
        System.out.println("Enter the name of the Student:");
        String studentName = sc.nextLine();
        System.out.println("Enter the email of the Student:");
        String studentEmail = sc.nextLine();
        while(!isValidEmail(studentEmail)){
            System.out.println("Invalid email. Please enter a valid email:");
            studentEmail = sc.nextLine();
        }
        System.out.println("Enter the CPF of the Student:");
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
        return new Student(studentName, studentEmail, studentCpf, 3, studentMatriculation, 2, id);        
    }  
  
}
