package poo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import poo.event.Event;
import poo.participant.Guest;
import poo.participant.OnlineGuest;
import poo.participant.OnlineProfessor;
import poo.participant.OnlineStudent;
import poo.participant.Participant;
import poo.participant.Professor;
import poo.participant.Student;

public class ParticipantManager {
    private static Integer id = 1;
    
    
    @SuppressWarnings("FieldMayBeFinal")
    private static List<Participant> participants = new ArrayList<>();
    
    
    private Event findEventById(int id) {
        for (Event e : EventManager.list()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
    
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
        event.addParticipant(participant.getId());
        participants.add(participant);        
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
        return OnlineStudent.collectDataOnline(id++, sc);      //Fix here!!
    }
    
    public OnlineProfessor CreateProfessorOnline(Scanner sc){
        return OnlineProfessor.collectDataOnline(id++, sc);    //Fix here!!
    }
    
    public OnlineGuest CreateGuestOnline(Scanner sc){
        return OnlineGuest.collectDataOnline(id++, sc);        //Fix here!!
    }
    
    /*public Guest CreateGuestPresential(Scanner sc){
        return Guest.collectDataPresential(id++, sc);        
    }*/
    
    public static List<Participant> getParticipants() {
        return participants;
    }
    
    public static Integer getId() {
        return id;
    }
    /*public List<Participant> getParticipantsByEvent(int eventId) {
    // encontra o evento e filtra a lista de participantes pelo ID
    return p;
    }*/


    
}
