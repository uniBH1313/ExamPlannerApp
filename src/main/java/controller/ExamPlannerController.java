package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import lombok.NoArgsConstructor;
import model.ExamPlanner;

@NoArgsConstructor
public class ExamPlannerController {
    @FXML
    BorderPane borderPane;

    @FXML
    private Button planViewButton;
    @FXML
    private Button allViewButton;
    @FXML
    private Button newViewButton;


    private ExamPlanner ep;

    @FXML
    public void initialize () {
        ep = new ExamPlanner();
        borderPane.setCenter(new Label("Itt lesz a terv..."));
    }



    public void switchToPlanView(ActionEvent actionEvent) {
        borderPane.setCenter(new PlanAndAllViewController().getView());
        //planViewButton.setBorder();
    }

    public void switchToAllView(ActionEvent actionEvent) {
        borderPane.setCenter(new Label("Itt lesznek a vizsg(l)ák..."));
    }

    public void switchToNewView(ActionEvent actionEvent) {
        borderPane.setCenter(new Label("Ittt lesz a hozzáadósos"));
    }


}
