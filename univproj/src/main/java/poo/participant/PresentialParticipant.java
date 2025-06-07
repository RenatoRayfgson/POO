package poo.participant;

import java.util.Scanner;

public abstract class PresentialParticipant extends Participant {

    protected boolean checkIn = false;

    public PresentialParticipant(String name, String email, String cpf, int type, int modality, Integer id) {
        super(name, email, cpf, type, modality, id);
    }

    public PresentialParticipant() {
        // Default constructor
    }

    public abstract PresentialParticipant collectDataPresential(Integer id, Scanner sc);    

    public boolean CheckIn() {
        return this.checkIn = true;
    }
}
