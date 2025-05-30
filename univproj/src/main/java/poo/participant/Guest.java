package poo.participant;

import java.util.Scanner;

public class Guest extends Participant  {
    private String origin;

    public Guest(String name, String email, String cpf, int type, String origin, int modality, Integer id) {
        super(name, email, cpf, type, modality, id);
        this.origin = origin;
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
