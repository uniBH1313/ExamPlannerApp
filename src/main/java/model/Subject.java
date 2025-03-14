package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Subject {
    private int id;
    private String name;
    private int type;           //1 - jelenléti, 2 - beadandó
    private int difficulty;     //1 - könnyű, 2 - mehéz
    private int numOfExams;
    private boolean isInPlan;


    public Subject(int id, String name) {
        this.id=id;
        this.name = name;
        this.numOfExams = 0;
        this.isInPlan=false;
    }


    public boolean getIsInPlan() {
        return isInPlan;
    }

    @Override
    public String toString() {
        return id+" "+name+" ("+numOfExams+"db)";
    }
}
