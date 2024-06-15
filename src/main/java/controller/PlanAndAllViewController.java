package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import lombok.SneakyThrows;

import java.io.File;

public class PlanAndAllViewController {
    private Parent view;

    @SneakyThrows
    public PlanAndAllViewController() {
        File file=new File("src/main/resources/fxml/PlanAndAllView.fxml");
        Parent root = FXMLLoader.load(file.toURL());
        this.view = root;
    }

    public Parent getView () {
        return view;
    }
}
