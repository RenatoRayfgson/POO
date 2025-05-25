package poo.event;

import java.util.ArrayList;
import java.util.Date;

public class AcademicExhibition extends Event  {
    private ArrayList<String> stands;
    private ArrayList<String> professor;
    
    public AcademicExhibition(String title, Date date, String local, int maxCapacity, String description, int type, Integer id){
        super(title, date, local, maxCapacity, description, type, id);
        this.stands = new ArrayList<>();
        this.professor = new ArrayList<>();
    }

    public ArrayList<String> getStands() {
        return stands;
    }

    public void setStands(ArrayList<String> stands) {
        this.stands = stands;
    }

    public ArrayList<String> getProfessor() {
        return professor;
    }

    public void setProfessor(ArrayList<String> professor) {
        this.professor = professor;
    }
}
