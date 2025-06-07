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
        Participant p = ParticipantManager.findParticipantByCPF(cpf);
        Event e = EventManager.findEventById(eventId);

        if(p==null || e==null){
            System.out.println("Participant or Event not found.");
            return;
        }

        if (!e.getParticipants().contains(p.getId())) {
            System.out.println("The participant searched: " + p.getName() + ", CPF: " + p.getCpf() + " is not registered in " + e.getTitle() + ".");
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
