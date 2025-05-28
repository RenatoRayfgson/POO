package poo.event;

import java.util.Date;

public class Lecture extends Event {
    private String speaker;

    public Lecture(String title, Date date, String local, int maxCapacity, String description, int type, String speaker, Integer id) {
        super(title, date, local, maxCapacity, description, type, id);
        this.speaker = speaker;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setPalestrante(String speaker) {
        this.speaker = speaker;
    }
    
}
