package poo.participant;

public class Student extends Participant  {
    private String matriculation;

    public Student(String name, String email, String cpf, int type, String matriculation){
    super(name, email, cpf, type);
    this.matriculation = matriculation;
    }

    public String getMatriculation() {
        return matriculation;
    }

    public void setMatriculation(String matriculation) {
        this.matriculation = matriculation;
    }
    
}
