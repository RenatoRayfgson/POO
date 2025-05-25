package poo.participant;

public class Guest extends Participant  {
    private String origin;

    public Guest(String name, String email, String cpf, int type, String origin){
        super(name, email, cpf, type);
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
}
