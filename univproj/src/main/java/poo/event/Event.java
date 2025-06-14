package poo.event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Event {
    
    protected String title;    
    protected LocalDate date;    
    protected String local;    
    protected int maxCapacity;    
    protected String description;
    protected Integer id;     
    protected ArrayList<Integer> participants;
    protected int type; // 1 - AcademicExhibition, 2 - Course, 3 - Lecture, 4 - Workshop

    public Event(){
        //Default constructor
    }
    
    public Event(String title, LocalDate date, String local, int maxCapacity, String description, int type, Integer id) {
        this.title = title;
        this.date = date;
        this.local = local;
        this.maxCapacity = maxCapacity;
        this.description = description;        
        this.participants = new ArrayList<>();
        this.type = type;
        this.id = id;                
    }

    public void addParticipant(Integer participantId) {
        participants.add(participantId);
    }
        
    public abstract String getCertificateExtraInfo();

    public abstract Event CollectData(Integer id, Scanner sc);

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLocal() {
        return local;
    }

    public ArrayList<Integer> getParticipants() {
        return participants;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getType() {
        return type;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
