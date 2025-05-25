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

    public Event(String title, Date date, String local, int maxCapacity, String description, int type, Integer id){
        this.title = title;
        this.date = date;
        this.local = local;
        this.maxCapacity = maxCapacity;
        this.description = description;        
        this.participants = new ArrayList<>();
        this.type = type;
        this.id = id;        
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Integer> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Integer> participants) {
        this.participants = participants;
    }
    
}
