package poo;

import java.util.Scanner;

import poo.event.AcademicExhibition;
import poo.event.Course;
import static poo.menu.Menus.EventsMenu;
import static poo.menu.Menus.menu;
import poo.service.EventManager;

//itextpdf
public class Main {    
    @SuppressWarnings("FieldMayBeFinal")
    private static Integer option = -1;              
    public static void main(String args[]){
        try (Scanner sc = new Scanner(System.in)) {
            while(option != 0){
                menu();
                try {
                    option = sc.nextInt();
                    switch(option){
                    case 1:{
                            EventsMenu();
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
                                    break;
                                }
                                case 4:{
                                    //Workshop
                                    break;
                                }
                                case 5:{
                                    //List Events
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
