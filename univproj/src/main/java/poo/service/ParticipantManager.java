package poo.service;

import java.util.List;
import java.util.Scanner;

import poo.event.Event;
import poo.participant.Participant;
import poo.participant.Student;

public class ParticipantManager {
    private static Integer id = 1;
    private static List<Participant> participants;

    
    private Event findEventById(int id) {
        for (Event e : EventManager.list()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
    
    public void addParticipantToEvent(int eventId, Participant participant) {
        Event event = findEventById(eventId);        
        if (event == null) {
            System.out.println("Event not found.");
            return;
        }         
        if (event.getParticipants().size() >= event.getMaxCapacity()) {
            System.out.println("Event is already full.");            
            return;
        }
        event.addParticipant(participant.getId());
        participants.add(participant);        
        System.out.println("Participant was added successfully to the event.");
    }
    
    public Student CreateStudentPresential(Scanner sc){
        return Student.collectDataPresential(id++, sc);        
    }
    
    public static List<Participant> getParticipants() {
        return participants;
    }
    /*public List<Participant> getParticipantsByEvent(int eventId) {
    // encontra o evento e filtra a lista de participantes pelo ID
    return p;
    }*/


    
}
