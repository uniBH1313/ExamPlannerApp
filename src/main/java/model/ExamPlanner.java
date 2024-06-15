package model;

import java.io.File;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;



@Getter @Setter
public class ExamPlanner {
    private static ExamPlanner instance;

    public static ExamPlanner getInstance() {
        if (instance == null) {
            instance =new ExamPlanner();
        }
        return instance;
    }

    private ObjectMapper om = new ObjectMapper()
            .configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true)
            .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
            .registerModule(new JavaTimeModule());

    private final File subjectsFile=new File("src/main/resources/json/subjects.json");
    private final File examsFile=new File("src/main/resources/json/exams.json");
    private final File planFile=new File("src/main/resources/json/plan.json");
    private ArrayList<Subject> subjectsList = new ArrayList<>();
    private ArrayList<Exam> examsList = new ArrayList<>();
    private ArrayList<Exam> planList = new ArrayList<>();

    @SneakyThrows
    public ExamPlanner() {
            if(subjectsFile.length() != 0)
                subjectsList = om.readValue(subjectsFile, new TypeReference<ArrayList<Subject>>(){});
            if(examsFile.length() != 0)
                examsList = om.readValue(examsFile, new TypeReference<ArrayList<Exam>>(){});
            if(planFile.length() != 0)
                planList = om.readValue(subjectsFile, new TypeReference<ArrayList<Exam>>(){});
            ArrayList<Exam> toRemove = new ArrayList<>();
            for (Exam e : examsList)
                if(e.getDate().isBefore(LocalDate.now()))
                    toRemove.add(e);
            removeMoreExams(toRemove);
    }



    public Subject matchingSubject (int id) {
        Subject match = new Subject();
        for (Subject subject : subjectsList) {
            if (subject.getId() == id) {
                match = subject;
                break;
            }
        }
        return match;
    }
    @SneakyThrows
    public void addSubject (String name) {
        int nextId=(subjectsList.isEmpty() ? 1 : subjectsList.getLast().getId()+1);
        Subject newSubj=new Subject(nextId, name);
        subjectsList.add(newSubj);
        om.writeValue(subjectsFile, subjectsList);
    }

    @SneakyThrows
    public void removeSubject (int id) {
        subjectsList.remove(matchingSubject(id));
        om.writeValue(subjectsFile, subjectsList);
    }

    @SneakyThrows
    public void addExam (int subjId, String dateString) {
        //dateString=yearStr+"-"+monthStr+"-"+dayStr;
        Exam e = new Exam(subjId, dateString);
        examsList.add(e);
        om.writeValue(examsFile, examsList);
        matchingSubject(subjId).setNumOfExams(matchingSubject(subjId).getNumOfExams()+1);
        om.writeValue(subjectsFile, subjectsList);
        //makePlan
    }

    @SneakyThrows
    public void removeExam (Exam e) {
        matchingSubject(e.getSubjId()).setNumOfExams(matchingSubject(e.getSubjId()).getNumOfExams()-1);
        if(matchingSubject(e.getSubjId()).getNumOfExams() == 0) {
            removeSubject(e.getSubjId());
        }
        examsList.remove(e);
        om.writeValue(examsFile, examsList);
        //makePlan
    }

    @SneakyThrows
    public void removeMoreExams (ArrayList<Exam> toRemove) {
        for (Exam e : toRemove) {
            matchingSubject(e.getSubjId()).setNumOfExams(matchingSubject(e.getSubjId()).getNumOfExams()-1);
            if(matchingSubject(e.getSubjId()).getNumOfExams() == 0) {
                subjectsList.remove(matchingSubject(e.getSubjId()));
            }
            examsList.remove(e);
        }
        om.writeValue(examsFile, examsList);
        om.writeValue(subjectsFile, subjectsList);
        //makePlan
    }


    /*public void makePlan () {
        ArrayList<Exam> toPlan = new ArrayList<>();
        for (Exam e : examsList) {
            if (matchingSubject(e.getSubjId()).getNumOfExams() == 1) {
                toPlan.add(e);
                matchingSubject(e.getSubjId()).setInPlan(true);
            }
        }

        for (int i=0; i<examsList.size(); i++) {
            if (!matchingSubject(examsList.get(i).getSubjId()).getIsInPlan()) {
                int before=Period.between(examsList.get(i-1).getDate(), examsList.getFirst().getDate())
            }
        }
    }*/

}
