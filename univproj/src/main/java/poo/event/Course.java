package poo.event;

import java.util.Date;

public class Course extends Event {
    private int hours;
    private String professor;

    public Course(String title, Date date, String local, int maxCapacity, String description, int type, String professor, int hours, Integer id){
        super(title, date, local, maxCapacity, description, type, id);
        this.hours = hours;
        this.professor = professor;
    }    

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
