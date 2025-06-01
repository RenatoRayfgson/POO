package poo.menu;
/*/>Cadastrar
>associar participantes a eventos
>gerar certificados
>Gerar relatorios*/
public class Menus{
    
    public static void line(){
        System.out.println("----------------------------------------\n");
    }

    public static void menu(){
        line();
        System.out.println("Take your option:\n[1] - Events\n[2] - Sign participant to event\n[3] - Generate Certify\n[0] - Generate Report\n[0] - EXIT");
        line();
    }

    public static void EventsMenu(){
        line();
        System.out.println("Take your option:\n[1] - Create Academic Exhibition\n[2] - Create Course\n[3] - Create Lecture\n[4] - Create Workshop\n[5] - List Events\n[0] - Back to Main Menu");
        line();
    }

    public static void SignParticipantMenu(){
        line();
        System.out.println("Take your option:\n[1] - Sign online participant to event\n[2] - Sign presential participant to event\n[3] - List participants in event\n[0] - Back to Main Menu");
        line();
    }
    public static void SignPresentialParticipantMenu(){
        line();
        System.out.println("Take your option:\n[1] - Sign presential guest to event\n[2] - Sign presential professor to event\n[3] - Sign presential guest event\n[0] - Back to Main Menu");
        line();
    }
    public static void SignOnlineParticipantMenu(){
        line();
        System.out.println("Take your option:\n[1] - Sign presential guest to event\n[2] - Sign presential professor to event\n[3] - Sign presential guest event\n[0] - Back to Main Menu");
        line();
    }

}
