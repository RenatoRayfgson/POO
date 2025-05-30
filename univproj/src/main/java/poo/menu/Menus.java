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
        System.out.println("Take your option:\n[1] - Create Academic Exhibition\n[2] - Create Course\n[3] - Create Lecture\n[4] - Workshop\n[5] - List Events\n [0] - Back to Main Menu");
        line();
    }

    public static void SignParticipantMenu(){
        line();
        System.out.println("Take your option:\n[1] - Sign online participant to event\n [2] - Sign presential participant to event\n [3] - List participants in event\n[0] - Back to Main Menu");
        line();
    }

}
