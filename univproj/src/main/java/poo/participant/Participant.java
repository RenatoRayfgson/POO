package poo.participant;

public abstract class Participant {
    protected String name;
    protected String email;
    protected String cpf;
    protected Integer id;
    protected int type; //1 - Guest, 2 - Professor, 3 - Student
    protected int modality; //1 - Online, 2 - Presential (I still have to introduce this in constructors and supers)

    public Participant(String name, String email, String cpf, int type, int modality, Integer id){
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.type = type;
        this.modality = modality;
        this.id = id;
    } 

    public Participant() {
        // Default constructor
    }   
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    
}

