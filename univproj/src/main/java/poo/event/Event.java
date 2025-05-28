package poo.event;

import java.util.ArrayList;
import java.util.Date;

public abstract class Event {
    
    protected String title;    
    protected Date date;    
    protected String local;    
    protected int maxCapacity;    
    protected String description;
    protected Integer id;     
    protected ArrayList<Integer> participants;
    protected int type; // 1 - AcademicExhibition, 2 - Course, 3 - Lecture, 4 - Workshop
    
    public Event(String title, Date date, String local, int maxCapacity, String description, int type, Integer id) {
        this.title = title;
        this.date = date;
        this.local = local;
        this.maxCapacity = maxCapacity;
        this.description = description;        
        this.participants = new ArrayList<>();
        this.type = type;
        this.id = id;                
    }
    
    //Criar método abstrato que liste os eventos ou qualquer coisa do tipo
    //public abstract void listEventDetails(); //Isso pode retornar os dados gerais em eventos e depois cada evento pode sobrescrever esse método para retornar os dados específicos

    public Integer getId() {
        return id;
    }
}
