package poo.service;

import java.time.format.DateTimeFormatter;

import poo.event.Course;
import poo.event.Event;
import poo.menu.Menus;
import poo.participant.Participant;

public class CertificateGenerator {

    public static void generateCertificate(Integer eventId, String cpf) {        
        Event event = EventManager.findEventById(eventId);
        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        Participant participant = null;
        for(Integer participantId : event.getParticipants()){
            for(Participant p : ParticipantManager.getParticipants()){
                if(p.getId().equals(participantId) && p.getCpf().equals(cpf)){
                    participant = p;
                    break;
                }
            }
            if(participant != null) {
                break;
            }
        }
        if (participant == null) {
            System.out.println("Participant with CPF " + cpf + " not found in event " + event.getTitle() + ".");            
            return;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Menus.line();
        System.out.println("Certificate of Participation");
        Menus.line();
        System.out.println("This is a certificate of participation for:");
        System.out.println("Participant: " + participant.getName() + " (ID: " + participant.getId() + " CPF: " + participant.getCpf() + ") as a " + participant.getClass().getSimpleName());
        System.out.println("in the event: " + event.getTitle());
        System.out.println("That occured on: " + event.getDate().format(dtf) + " at " + event.getLocal());
        if(event instanceof Course){
            Course course = (Course) event;
            System.out.println("Course Duration: " + course.getHours() + " hours");
        }
        Menus.line();
        System.out.println("Thank you for your participation!");
        System.out.println("This certificate will also be sent to your email: " + participant.getEmail());
        
    }

}
