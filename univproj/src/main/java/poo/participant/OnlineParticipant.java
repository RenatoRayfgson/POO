package poo.participant;

import java.util.Scanner;

public abstract class OnlineParticipant extends Participant {
    
    protected boolean checkIn = false;

    public OnlineParticipant(String name, String email, String cpf, int type, int modality, Integer id){
        super(name, email,cpf, type, modality, id);
    } 

    public OnlineParticipant() {
        // Default constructor
    }
    
    public abstract OnlineParticipant collectDataOnline(Integer id, Scanner sc);

    public boolean CheckIn() {
        return this.checkIn = true;
    }
    
}
