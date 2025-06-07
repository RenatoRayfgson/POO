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

        Participant participant = ParticipantManager.findParticipantByCPF(cpf);
        
        if (participant == null) {
            System.out.println("Participant with CPF " + cpf + " not found in event " + event.getTitle() + ".");            
            return false;
        }

        if (!event.getParticipants().contains(participant.getId())) {
            System.out.println("The participant searched: " + participant.getName() + ", CPF: " + participant.getCpf() + " is not registered in " + event.getTitle() + ".");
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
