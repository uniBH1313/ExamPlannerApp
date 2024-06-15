package model;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class Exam implements Comparable<Exam> {
    private int subjId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    @JsonIgnore
    private Exam examBefore;
    @JsonIgnore
    private Exam examAfter;


    public Exam(int subjId, String dateString) {
        this.subjId = subjId;
        setDate(dateString);
    }

    public void setDate(String dateString) {
        this.date = LocalDate.parse(dateString);
    }


    @Override
    public int compareTo(Exam o) {
        return this.date.compareTo(o.getDate());
    }
}
