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

    public void Create(){
        
        id++;
    }
    public static List<Event> display(){
        return event;
    }
}
