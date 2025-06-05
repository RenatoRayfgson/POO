package poo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import poo.event.Event;
import poo.participant.Guest;
import poo.participant.OnlineGuest;
import poo.participant.OnlineProfessor;
import poo.participant.OnlineStudent;
import poo.participant.Participant;
import poo.participant.Professor;
import poo.participant.Student;
import static poo.service.EventManager.findEventById;

public class ParticipantManager {
    private static Integer id = 1;
    
    
    @SuppressWarnings("FieldMayBeFinal")
    private static Map<Integer, Participant> participants = new HashMap<>();  
            
    public boolean addParticipantToEvent(int eventId, Participant participant) {
        Event event = findEventById(eventId);        
        if (event == null) {
            System.out.println("Event not found.");
            return false;
        }         
        if (event.getParticipants().size() >= event.getMaxCapacity()) {
            System.out.println("Event is full.");            
            return false;
        }

        if(event.getType() == 2 && !(participant instanceof OnlineStudent || participant instanceof Student)){
            System.out.println("Only students can be registered for a course.");
            return false;
        }

            // Verifica duplicidade por CPF
        for (Integer verifyId : event.getParticipants()) {
            Participant p = participants.get(verifyId);
            if (p != null && p.getCpf().equals(participant.getCpf())) {
                System.out.println("Participant with this CPF already registered in the event.");
                return false;
            }
        }
        event.addParticipant(participant.getId());
        participants.put(participant.getId(), participant);        
        System.out.println("Participant was added successfully to the event.");
        return true;
    }
    
    public Student CreateStudentPresential(Scanner sc){
        return Student.collectDataPresential(id++, sc);        
    }
    
    public Professor CreateProfessorPresential(Scanner sc){
        return Professor.collectDataPresential(id++, sc);        
    }
    
    public Guest CreateGuestPresential(Scanner sc){
        return Guest.collectDataPresential(id++, sc);        
    }

    public OnlineStudent CreateStudentOnline(Scanner sc){
        return OnlineStudent.collectDataOnline(id++, sc);      
    }
    
    public OnlineProfessor CreateProfessorOnline(Scanner sc){
        return OnlineProfessor.collectDataOnline(id++, sc);    
    }
    
    public OnlineGuest CreateGuestOnline(Scanner sc){
        return OnlineGuest.collectDataOnline(id++, sc);        
    }    
    
    public static Collection<Participant> getParticipants() {
        return participants.values();
    }
    
    public static Integer getId() {
        return id;
    }
    /*public List<Participant> getParticipantsByEvent(int eventId) {
    // encontra o evento e filtra a lista de participantes pelo ID
    return p;
    }*/


    
}
