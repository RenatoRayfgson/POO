package poo;

import java.util.Scanner;

import poo.event.AcademicExhibition;
import poo.event.Course;
import poo.event.Lecture;
import poo.event.Workshop;
import poo.menu.Menus;
import poo.participant.Guest;
import poo.participant.OnlineGuest;
import poo.participant.OnlineProfessor;
import poo.participant.OnlineStudent;
import poo.participant.Professor;
import poo.participant.Student;
import poo.service.CertificateGenerator;
import poo.service.EventManager;
import static poo.service.EventManager.listEventsByCPF;
import poo.service.ParticipantManager;
import poo.utilities.PDFGenerator;
import poo.utilities.Utilities;



//itextpdf
public class Main {    
    @SuppressWarnings("FieldMayBeFinal")
    private static Integer option = -1;              
    public static void main(String args[]){
        try (Scanner sc = new Scanner(System.in)) {
            Utilities.initTestEvents(); // APENAS TESTE CRIANDO EVENTO, TEM QUE APAGAR DEPOIS!!!
            while(option != 0){
                Menus.menu();
                try {
                    option = sc.nextInt();
                    sc.nextLine();
                    switch(option){
                    case 1:{
                            Menus.EventsMenu();
                            int eventOption = sc.nextInt();
                            sc.nextLine();
                            //EVENT CREATION
                            switch(eventOption){
                                case 1:{
                                    //Create Academic Exhibition                                    
                                    EventManager eventManager = new EventManager();
                                    Integer currentId = EventManager.getId();
                                    AcademicExhibition academicExhibition = new AcademicExhibition().CollectData(currentId, sc);
                                    eventManager.CreateEvent(academicExhibition);
                                    System.out.println("Academic Exhibition was registered successfully!");
                                    break;
                                }
                                case 2:{
                                    //Create Course
                                    EventManager eventManager = new EventManager();
                                    Integer currentId = EventManager.getId();
                                    Course course = new Course().CollectData(currentId, sc);
                                    eventManager.CreateEvent(course);
                                    System.out.println("Course was registered successfully!");
                                    break;
                                }
                                case 3:{
                                    //Create Lecture
                                    EventManager eventManager = new EventManager();
                                    Integer currentId = EventManager.getId();
                                    Lecture lecture = new Lecture().CollectData(currentId, sc);
                                    eventManager.CreateEvent(lecture);
                                    System.out.println("Lecture was registered successfully!");
                                    break;
                                }
                                case 4:{
                                    //Workshop
                                    EventManager eventManager = new EventManager();
                                    Integer currentId = EventManager.getId();
                                    Workshop workshop = new Workshop().CollectData(currentId, sc);
                                    eventManager.CreateEvent(workshop);
                                    System.out.println("Workshop was registered successfully!");
                                    break;
                                }
                                case 5:{
                                    //List all events registered
                                    System.out.println("Listing all registered events:");
                                    EventManager.list();
                                    break;
                                }
                                case 0:
                                    //Back to Main Menu
                                    break;
                                default:
                                    System.out.println("Invalid option, try again.");
                            }
                        break;
                    }
                    case 2:{                        
                        Menus.SignParticipantMenu();
                        int modalityOption = sc.nextInt();
                        sc.nextLine();
                        switch(modalityOption){
                            case 1:{
                                Menus.SignOnlineParticipantMenu();
                                int participantOption = sc.nextInt();
                                switch(participantOption){
                                    //PARTICIPATION CREATION AND SIGNING
                                    case 1:{
                                        //Sign online guest to event
                                        ParticipantManager participantManager = new ParticipantManager();                                        
                                        OnlineGuest onlineGuest = participantManager.CreateGuestOnline(sc);                                        
                                        Integer eventId = EventManager.CollectId(sc);
                                        boolean sucess = participantManager.addParticipantToEvent(eventId, onlineGuest);
                                        if(sucess){
                                            System.out.println("Online guest was signed successfully to the event.");
                                        } else {
                                            System.out.println("Failed to sign online guest to the event.");
                                        }                                        
                                        break;
                                    }
                                    case 2:{
                                        //Sign online professor to event
                                        ParticipantManager participantManager = new ParticipantManager();                                        
                                        OnlineProfessor onlineProfessor = participantManager.CreateProfessorOnline(sc);                                        
                                        Integer eventId = EventManager.CollectId(sc);
                                        boolean sucess = participantManager.addParticipantToEvent(eventId, onlineProfessor);
                                        if(sucess){
                                            System.out.println("Online professor was signed successfully to the event.");
                                        } else {
                                            System.out.println("Failed to sign online professor to the event.");
                                        }                                        
                                        break;
                                    }
                                    case 3:{
                                        //Sign online student to event
                                        ParticipantManager participantManager = new ParticipantManager();                                        
                                        OnlineStudent onlineStudent = participantManager.CreateStudentOnline(sc);                                        
                                        Integer eventId = EventManager.CollectId(sc);
                                        boolean sucess = participantManager.addParticipantToEvent(eventId, onlineStudent);
                                        if(sucess){
                                            System.out.println("Online Student was signed successfully to the event.");
                                        } else {
                                            System.out.println("Failed to sign online student to the event.");
                                        }                                        
                                        break;
                                    }
                                    case 0:{
                                        //Back to Main Menu
                                        break;
                                    }
                                    default:
                                        System.out.println("Invalid option, try again.");
                                }
                                break;
                            }
                            case 2:{
                                Menus.SignPresentialParticipantMenu();
                                int participantOption = sc.nextInt();
                                sc.nextLine();
                                switch(participantOption){
                                    case 1:{
                                        //Sign presential guest to event
                                        ParticipantManager participantManager = new ParticipantManager();                                        
                                        Guest guest = participantManager.CreateGuestPresential(sc);                                        
                                        Integer eventId = EventManager.CollectId(sc);
                                        boolean sucess = participantManager.addParticipantToEvent(eventId, guest);
                                        if(sucess){
                                            System.out.println("Guest was signed successfully to the event.");
                                        } else {
                                            System.out.println("Failed to sign the guest to the event.");
                                        }                                        
                                        break;
                                    }
                                    case 2:{
                                        //Sign presential professor to event
                                        ParticipantManager participantManager = new ParticipantManager();                                        
                                        Professor professor = participantManager.CreateProfessorPresential(sc);                                        
                                        Integer eventId = EventManager.CollectId(sc);
                                        boolean sucess = participantManager.addParticipantToEvent(eventId, professor);
                                        if(sucess){
                                            System.out.println("Professor was signed successfully to the event.");
                                        } else {
                                            System.out.println("Failed to sign professor to the event.");
                                        }                                        
                                        break;
                                    }
                                    case 3:{
                                        //Sign presential student to event
                                        ParticipantManager participantManager = new ParticipantManager();                                        
                                        Student student = participantManager.CreateStudentPresential(sc);                                        
                                        Integer eventId = EventManager.CollectId(sc);
                                        boolean sucess = participantManager.addParticipantToEvent(eventId, student);
                                        if(sucess){
                                            System.out.println("Student was signed successfully to the event.");
                                        } else {
                                            System.out.println("Failed to sign student to the event.");
                                        }                                        
                                        break;
                                    }
                                    case 0:{
                                        //Back to Main Menu
                                        break;
                                    }
                                    default:
                                        System.out.println("Invalid option, try again.");
                                }
                                break;
                            }
                            case 3:{
                                //List participants in event
                                System.out.println("Enter the ID of the event you want to list participants: ");
                                int eventId = sc.nextInt();
                                EventManager.ListParticipantsByEvent(eventId);
                                break;
                            }
                            case 0:{
                                //Back to Main Menu
                                break;
                            }
                            default:
                                System.out.println("Invalid option, try again.");
                        }                        
                        break;
                    }
                    case 3:{
                        //Generate Certify
                        String cpf;
                        System.out.println("Enter the CPF of the participant to generate the certificate: ");
                        cpf = sc.nextLine();
                        while(!Utilities.isValidCPF(cpf)) {
                            System.out.println("Invalid CPF. Please enter a valid CPF: ");
                            cpf = sc.nextLine();
                        }
                        Menus.line();                        
                        listEventsByCPF(cpf);
                        Menus.line();
                        System.out.println("Enter the ID of the event to generate the certificate: ");
                        int eventId = sc.nextInt();
                        sc.nextLine();
                        boolean sucess = CertificateGenerator.generateCertificate(eventId, cpf);
                        Menus.line();
                        if(sucess){
                            System.out.println("Do you want to export the certificate as a PDF?\n[1] Yes\n[2] No");
                            int exportOption = sc.nextInt();
                            sc.nextLine();
                            if(exportOption == 1){
                                //Export to PDF
                                System.out.println("Generating PDF certificate...");
                                PDFGenerator.Generate(eventId, cpf);
                                System.out.println("PDF certificate generated successfully!");
                            } else {
                                System.out.println("Certificate generation completed without PDF export.");
                            }
                        }                      
                        break;                        
                    }
                    case 4:{
                        //Generate Report
                        Menus.SearchByTypeMenu();
                        int type = sc.nextInt();
                        sc.nextLine();
                        switch(type){
                            case 1:{
                                //Search by Academic Exhibitions
                                System.out.println("Listing all Academic Exhibitions:");
                                EventManager.SearchByType(1);
                                break;
                            }
                            case 2:{
                                //Search by Courses
                                System.out.println("Listing all Courses:");
                                EventManager.SearchByType(2);
                                break;
                            }
                            case 3:{
                                //Search by Lecture
                                System.out.println("Listing all Lectures:");
                                EventManager.SearchByType(3);
                                break;
                            }
                            case 4:{
                                //Search by Workshopes
                                System.out.println("Listing all Workshops:");
                                EventManager.SearchByType(4);
                                break;
                            }
                            case 5:{
                                //Search by date
                                System.out.println("Enter the date to search for events (dd/mm/yyyy): ");
                                String date = sc.nextLine();
                                EventManager.SearchByDate(date);
                                break;
                            }
                            default:{
                                System.out.println("Invalid option, try again.");
                            }
                        }
                        break;
                    }
                    case 0:
                        //EXIT
                        break;
                    default:
                        System.out.println("Invalid option, try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number.");
                sc.next(); // Clear the invalid input
                }
            }
        }
    }
}
