package poo.participant;
import java.util.Scanner;

import static poo.utilities.Utilities.isValidCPF;

public class Student extends Participant  {
    private String matriculation;

    public Student(String name, String email, String cpf, int type, String matriculation){
    super(name, email, cpf, type);
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

    public static Student collectData(Integer id, Scanner sc) {
        System.out.println("Enter the name of the Student:");
        String studentName = sc.nextLine();
        System.out.println("Enter the email of the Student:");
        String studentEmail = sc.nextLine();
        System.out.println("Enter the CPF of the Student:");
        String studentCpf = sc.nextLine();        
        while(!isValidCPF(studentCpf)){
            System.out.println("Invalid CPF. Please enter a valid CPF:\n");
            studentCpf = sc.nextLine();
        }        
        System.out.println("Enter the matriculation of the Student:");
        String studentMatriculation = sc.nextLine();
        return new Student(studentName, studentEmail, studentCpf, 3, studentMatriculation);        
    }    
}
