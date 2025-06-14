package poo.service;

import java.time.format.DateTimeFormatter;

import poo.event.Event;
import poo.menu.Menus;
import poo.participant.Participant;

public class CertificateGenerator {

    public static boolean generateCertificate(Integer eventId, String cpf) {        
        Event event = EventManager.findEventById(eventId);
        if (event == null) {
            System.out.println("Event not found.");
            return false;
        }

        Participant participant = null;

        for(Integer participantId : event.getParticipants()) {
            Participant p = ParticipantManager.findParticipantById(participantId);
            if (p != null && p.getCpf().equals(cpf)) {
                participant = p;
                break;
            }
        }

        if(participant == null) {
            System.out.println("Participant with CPF " + cpf + " not found in the event.");
            return false;
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Menus.line();
        System.out.println("Certificate of Participation");
        Menus.line();
        System.out.println("This is a certificate of participation for:");
        System.out.println("Participant: " + participant.getName() + " (ID: " + participant.getId() + " CPF: " + participant.getCpf() + ") as a " + participant.getClass().getSimpleName());
        System.out.println("due the participation in the event: " + event.getTitle());
        System.out.println("That occured on: " + event.getDate().format(dtf) + " at " + event.getLocal());
        System.out.println(event.getCertificateExtraInfo());
        Menus.line();
        System.out.println("Thank you for your participation!");
        System.out.println("This certificate will also be sent to your email: " + participant.getEmail());
        return true;
    }

}
