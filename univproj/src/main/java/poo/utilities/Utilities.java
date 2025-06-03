package poo.utilities;

import java.text.SimpleDateFormat;

import poo.event.AcademicExhibition;
import poo.event.Course;
import poo.event.Lecture;
import poo.event.Workshop;
import poo.service.EventManager;

public class Utilities {

    public static boolean isValidCPF(String cpf) {
        // Remove non-numeric characters
        cpf = cpf.replaceAll("[^0-9]", "");        
        // Check if the length is 11        
        return cpf.length() == 11;
    }

    public static boolean isOnlyDigits(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }        
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }    
        return true;
    }
    
    public static boolean isValidEmail(String email) {
        // Simple regex for basic email validation
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(emailRegex);
    }

    public static boolean isValidTelephone(String telephone) {
        // Simple regex for Brazilian telephone validation (XX XXXXXXXXX)
        String telephoneRegex = "^\\d{2} \\d{9}$";
        return telephone != null && telephone.matches(telephoneRegex);
    }

    @SuppressWarnings("UseSpecificCatch")
    public static void initTestEvents() {
        EventManager eventManager = new EventManager();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            AcademicExhibition ae = new AcademicExhibition(
                "ExpoTech", sdf.parse("10/06/2025"), "Auditório 1", 100,
                "Exposição de projetos", 1, EventManager.getId(), "Stand A, Stand B"
            );
            eventManager.CreateEvent(ae);

            Course c = new Course(
                "Java Avançado", sdf.parse("15/06/2025"), "Sala 201", 30,
                "Curso intensivo de Java", 2, "Prof. João", 20, EventManager.getId()
            );
            eventManager.CreateEvent(c);

            Lecture l = new Lecture(
                "Futuro da IA", sdf.parse("20/06/2025"), "Teatro", 80,
                "Palestra sobre inteligência artificial", 3, "Dra. Maria", EventManager.getId()
            );
            eventManager.CreateEvent(l);

            Workshop w = new Workshop(
                "Robótica com Arduino", sdf.parse("25/06/2025"), "Lab Maker", 25,
                "Workshop prático de robótica", 4, "Eng. Lucas", EventManager.getId(), "Notebook, Kit Arduino"
            );
            eventManager.CreateEvent(w);

            System.out.println("Eventos de teste criados com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao criar eventos de teste: " + e.getMessage());
        }
    }
}
