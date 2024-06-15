import com.fasterxml.jackson.core.JsonProcessingException;
import javafx.application.Application;
import lombok.SneakyThrows;
import model.Exam;
import model.ExamPlanner;
import model.Subject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        Application.launch(ExamPlannerApplication.class, args);








        /*ExamPlanner ep=new ExamPlanner();
        //ep.addExam(1, "2024-09-05");
        //ep.addExam(2, "2024-06-25");
        //ep.addExam(3, "2024-06-17");
        //ep.addExam(2, "2024-07-10");
        System.out.println(ep.getSubjectsList());


        /*ArrayList<Exam> rev=(ArrayList)ep.getExamsList().clone();
        rev.removeLast();*/

        /*for (Exam e : ep.getExamsList()) {
            System.out.println(ep.matchingSubject(e.getSubjId()).getName()+"\t"+e.getDate());
        }
        /*System.out.println();
        System.out.println("=====================");
        System.out.println();
        for (Exam e : rev) {
            System.out.println(ep.matchingSubject(e.getSubjId()).getName()+"\t"+e.getDate());
        }*/




        /*ep.addSubject("Szoftverfejlesztés");
        ep.addSubject("Fordítóprogramok");
        ep.addSubject("Mestint");
        //System.out.println("============================= Tantárgyak hozzáadva");
        System.out.println(ep.getSubjectsList());*/

        /*ep.addSubject("It bizt");
        System.out.println("============================= Tantárgy hozzáadva [úrjaindítás]");
        System.out.println(ep.getSubjectsList());*/

        /*ep.addSubject("Gépi tanulás");
        System.out.println("============================= Tantárgy hozzáadva");
        System.out.println(ep.getSubjectsList());

        ep.addExam(1, "2024-05-25");
        System.out.println("============================= első vizsga hozzáadva");
        System.out.println(ep.getSubjectsList());
        for (Exam e : ep.getExamsList()) {
            System.out.println(ep.matchingSubject(e.getSubjId()).getName()+"\t"+e.getDate());
        }


        ep.addExam(1, "2024-06-10");
        System.out.println("============================= Máspdik vizsga hozzáadva [ÚI]");
        System.out.println(ep.getSubjectsList());
        for (Exam e : ep.getExamsList()) {
            System.out.println(ep.matchingSubject(e.getSubjId()).getName()+"\t"+e.getDate());
        }*/


        /*ep.addExam(4, "2024-09-05");
        System.out.println("============================= új vizsga hozzáadva");
        System.out.println(ep.getSubjectsList());
        for (Exam e : ep.getExamsList()) {
            System.out.println(ep.matchingSubject(e.getSubjId()).getName()+"\t"+e.getDate());
        }

        ep.addExam(3, "2024-06-17");
        System.out.println("============================= vizsga hozzáadva");
        System.out.println(ep.getSubjectsList());
        for (Exam e : ep.getExamsList()) {
            System.out.println(ep.matchingSubject(e.getSubjId()).getName()+"\t"+e.getDate());
        }

        ep.removeExam(ep.getExamsList().getLast());
        System.out.println("============================= vizsga törölve");
        System.out.println(ep.getSubjectsList());
        for (Exam e : ep.getExamsList()) {
            System.out.println(ep.matchingSubject(e.getSubjId()).getName()+"\t"+e.getDate());
        }

        ep.removeSubject(5);
        System.out.println("============================= tárgy törölve UI");
        System.out.println(ep.getSubjectsList());*/

        /*ep.removeExam(ep.getExamsList().get(1));
        System.out.println("============================= vizsga törölve régi akt");
        System.out.println(ep.getSubjectsList());
        for (Exam e : ep.getExamsList()) {
            System.out.println(ep.matchingSubject(e.getSubjId()).getName()+"\t"+e.getDate());
        }*/


        /*System.out.println(ep.getSubjectsList());
        for (Exam e : ep.getExamsList()) {
            System.out.println(ep.matchingSubject(e.getSubjId()).getName()+"\t"+e.getDate());
        }*/






    }
}
