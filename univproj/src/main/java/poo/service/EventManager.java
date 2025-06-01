package poo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import poo.event.Event;
import poo.participant.Participant;

public class EventManager {
    @SuppressWarnings("FieldMayBeFinal")
    private static List<Event> event;
    private static Integer id=1;

    public void CreateEvent(Event e) {        
        event.add(e);
        id++;
    }
    
    public EventManager(){
        event = new ArrayList<>();
    }
    
    public static Integer CollectId(Scanner sc) {
        System.out.println("Enter the ID of the event you want to sign the participant in: ");
        Integer inputId = sc.nextInt();
        if (inputId < 1) {
            System.out.println("ID must be greater than 0.");
            return CollectId(sc);        
        }        
        return inputId;
    }
    
    public static List<Event> list(){
        for(Event e : event){ 
            System.out.println("Event ID: " + e.getId() + " Title: " + e.getTitle() + " Date: " + e.getDate() + " Local: " + e.getLocal());
        }
        return event;
    }

    public static void ListParticipantsByEvent(int eventID){
        
        Event eventSearched = null;
        
        for(Event e : EventManager.list()){
            if(e.getId() == eventID){
                eventSearched = e;
                break;
            }
        }
        
        if(eventSearched == null){
            System.out.println("Event not found.");
            return;
        }
        
        ArrayList<Integer> participants = eventSearched.getParticipants();
        
        if(participants.isEmpty()){
            System.out.println("No participants were registered for this event.");
            return;
        }
        System.out.println("Participants for event ID " + eventID + " - " + eventSearched.getTitle() + ":");

        for(Integer participantId : participants){
            for(Participant p : ParticipantManager.getParticipants()){
                if(p.getId().equals(participantId)){
                    String participantType = p.getClass().getSimpleName();
                    System.out.println("ID: " + p.getId() + ", Name: " + p.getName() + ", Type: " + participantType);
                    break;
                }
            }
        }
    }
    
    public static Integer getId() {
        return id;
    }
}
