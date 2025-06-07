package poo.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import poo.event.AcademicExhibition;
import poo.event.Course;
import poo.event.Lecture;
import poo.event.Workshop;
import poo.service.EventManager;

public class Utilities {

    public static boolean isValidCPF(String cpf) {
        // Remove not numbers
        cpf = cpf.replaceAll("[^0-9]", "");               
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
        // Email validation
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(emailRegex);
    }

    public static boolean isValidTelephone(String telephone) {
        // Telephone validation (XX XXXXXXXXX)
        String telephoneRegex = "^\\d{2} \\d{9}$";
        return telephone != null && telephone.matches(telephoneRegex);
    }



    public static void initTestEvents() {
        EventManager eventManager = new EventManager();
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            AcademicExhibition ae = new AcademicExhibition(
                "ExpoTech", LocalDate.parse("10/06/2025", dtf), "Auditório 1", 100,
                "Exposição de projetos", 1, EventManager.getId(), "Stand A, Stand B"
            );
            eventManager.CreateEvent(ae);

            Course c = new Course(
                "Java Avançado", LocalDate.parse("15/06/2025", dtf), "Sala 201", 30,
                "Curso intensivo de Java", 2, "Prof. João", 20, EventManager.getId()
            );
            eventManager.CreateEvent(c);

            Lecture l = new Lecture(
                "Futuro da IA", LocalDate.parse("20/06/2025", dtf), "Teatro", 80,
                "Palestra sobre inteligência artificial", 3, "Dra. Maria", EventManager.getId()
            );
            eventManager.CreateEvent(l);

            Workshop w = new Workshop(
                "Robótica com Arduino", LocalDate.parse("25/06/2025", dtf), "Lab Maker", 25,
                "Workshop prático de robótica", 4, "Eng. Lucas", EventManager.getId(), "Notebook, Kit Arduino"
            );
            eventManager.CreateEvent(w);

            System.out.println("Eventos de teste criados com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao criar eventos de teste: " + e.getMessage());
        }
    }    
}