package application.PRAKTIKUM6.Main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {
	@Override
    public void start(Stage primaryStage) {
        try {
           
        	Parent root = FXMLLoader.load(getClass().getResource("/application/PRAKTIKUM6/View/MahasiswaView.fxml"));
            
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Data Mahasiswa (MVC)");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
        launch(args);
	
    }
}
