package poo;

import java.util.Scanner;

import poo.event.AcademicExhibition;
import poo.event.Course;
import poo.event.Lecture;
import poo.event.Workshop;
import poo.menu.Menus;
import poo.service.EventManager;

//itextpdf
public class Main {    
    @SuppressWarnings("FieldMayBeFinal")
    private static Integer option = -1;              
    public static void main(String args[]){
        try (Scanner sc = new Scanner(System.in)) {
            while(option != 0){
                Menus.menu();
                try {
                    option = sc.nextInt();
                    switch(option){
                    case 1:{
                            Menus.EventsMenu();
                            int eventOption = sc.nextInt();
                            switch(eventOption){
                                case 1:{
                                    //Create Academic Exhibition                                    
                                    EventManager eventManager = new EventManager();
                                    Integer currentId = EventManager.getId();
                                    AcademicExhibition academicExhibition = AcademicExhibition.CollectData(currentId, sc);
                                    eventManager.CreateEvent(academicExhibition);
                                    System.out.println("Academic Exhibition was registered successfully!");
                                    break;
                                }
                                case 2:{
                                    //Create Course
                                    EventManager eventManager = new EventManager();
                                    Integer currentId = EventManager.getId();
                                    Course course = Course.CollectData(currentId, sc);
                                    eventManager.CreateEvent(course);
                                    System.out.println("Course was registered successfully!");
                                    break;
                                }
                                case 3:{
                                    //Create Lecture
                                    EventManager eventManager = new EventManager();
                                    Integer currentId = EventManager.getId();
                                    Lecture lecture = Lecture.CollectData(currentId, sc);
                                    eventManager.CreateEvent(lecture);
                                    System.out.println("Lecture was registered successfully!");
                                    break;
                                }
                                case 4:{
                                    //Workshop
                                    EventManager eventManager = new EventManager();
                                    Integer currentId = EventManager.getId();
                                    Workshop workshop = Workshop.CollectData(currentId, sc);
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
                        switch(modalityOption){
                            case 1:{

                                break;
                            }
                            case 2:{
                                Menus.SignPresentialParticipantMenu();
                                int participantOption = sc.nextInt();
                                switch(participantOption){
                                    case 1:{
                                        //Sign online guest to event
                                        System.out.println("Sign online guest to event");
                                        break;
                                    }
                                    case 2:{
                                        //Sign presential professor to event
                                        System.out.println("Sign online professor to event");
                                        break;
                                    }
                                    case 3:{
                                        //Sign presential student to event
                                        System.out.println("Sign online student to event");
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
                                break;
                            }
                            case 0:{
                                //Back to Main Menu
                                break;
                            }
                            default:
                                System.out.println("Invalid option, try again.");
                        }
                        //Sign participant to event
                        break;
                    }
                    case 3:{
                        //Generate Certify
                        break;
                    }
                    case 4:{
                        //Generate Report
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
