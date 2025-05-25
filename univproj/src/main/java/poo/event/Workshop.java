package poo.event;

import java.util.ArrayList;
import java.util.Date;

public class Workshop extends Event  {
    private String instructor;
    private ArrayList<String> necessaryMaterials;

    public Workshop(String title, Date date, String local, int maxCapacity, String description, int type, String instructor, Integer id){
        super(title, date, local, maxCapacity, description, type, id);
        this.instructor = instructor;
    }

    public String getInstrutor() {
        return instructor;
    }

    public void setInstrutor(String instructor) {
        this.instructor = instructor;
    }

    public ArrayList<String> getNecessaryMaterials() {
        return necessaryMaterials;
    }

    public void setNecessaryMaterials(ArrayList<String> necessaryMaterials) {
        this.necessaryMaterials = necessaryMaterials;
    }
}