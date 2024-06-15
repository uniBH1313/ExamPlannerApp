import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.SneakyThrows;


public class ExamPlannerApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ExamPlanner.fxml"));
        stage.setTitle("Vizsgatervező");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
