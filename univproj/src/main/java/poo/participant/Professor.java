package poo.participant;

import java.util.Scanner;

public class Professor extends Participant {
    private String matriculation;

    public Professor(String name, String email, String cpf, int type, String matriculation){
        super(name, email, cpf, type);
        this.matriculation = matriculation;
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

    public void collectData(Integer id, Scanner sc) {
        
    }
}
