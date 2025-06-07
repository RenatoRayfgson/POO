package poo.utilities;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import poo.event.Event;
import poo.participant.Participant;
import poo.service.EventManager;
import poo.service.ParticipantManager;

public class PDFGenerator {
    public static void Generate(Integer eventId, String cpf) {
        Event e = EventManager.findEventById(eventId);
        
        if(e==null){
            System.out.println("Event not found.");
            return;
        }
        Participant p = null;
        
        for(Integer participantId : e.getParticipants()){
            Participant participant = ParticipantManager.findParticipantById(participantId);
            if (participant != null && participant.getCpf().equals(cpf)) {
                p = participant;
                break;
            }
        }

        if (p==null) {
            System.out.println("No participant found with CPF: " + cpf);
            return;
        }

        Document document = new Document();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String fileName = "Certificate_" + p.getCpf() + ".pdf";
        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();
            document.add(new Paragraph("Certificate of Participation"));
            document.add(new Paragraph("This is a certificate of participation for:"));
            document.add(new Paragraph("Participant: " + p.getName() + " (ID: " + p.getId() + " CPF: " + p.getCpf() + ") as a " + p.getClass().getSimpleName()));
            document.add(new Paragraph("due the participation in the event: " + e.getTitle()));
            document.add(new Paragraph("That occurred on: " + e.getDate().format(dtf) + " at " + e.getLocal()));
            document.add(new Paragraph(e.getCertificateExtraInfo()));
            document.add(new Paragraph("Thanks for your participation!"));            
        } catch (FileNotFoundException | DocumentException e1) {
            System.err.println("Error creating PDF document: " + e1.getMessage());            
        } finally{
            document.close();
        }
    }    
}
