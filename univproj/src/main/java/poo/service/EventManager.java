package poo.service;

import java.util.ArrayList;
import java.util.List;

import poo.event.Event;

public class EventManager {
    @SuppressWarnings("FieldMayBeFinal")
    private static List<Event> event;
    private static Integer id=1;

    
    public EventManager(){
        event = new ArrayList<>();
    }
    
    public void CreateEvent(Event e) {        
        event.add(e);
        id++;
    }
    
    public static List<Event> display(){
        return event;
    }
    
    public static Integer getId() {
        return id;
    }
}
