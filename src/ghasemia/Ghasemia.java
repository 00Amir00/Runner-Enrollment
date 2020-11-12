package ghasemia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Assignment 5
 *
 * Program : Developing a class that models a program for runners
 *
 * This class name is Ghasemia, and it contains the main method and start method
 *
 * @author Amirmahdi Ghasemi, 2020
 */
/**
 * The default constructor which extends Application class
 */
public class Ghasemia extends Application {

    @Override
    // The start method which takes a stage as its parameter, and it throws exception
    public void start(Stage stage) throws Exception {
        // The next line will show how the FXMLLoader will find the fxml file and will load the fxml file
        Parent root = FXMLLoader.load(getClass().getResource("FXMLRunProgram.fxml"));
        // The program will make a scene for our root variable
        Scene scene = new Scene(root);
        // The program will put the scene into the stage
        stage.setScene(scene);
        // The program will set title of the stage which is Registration
        stage.setTitle("Registration");
        // The last step which is showing the stage to the user
        stage.show();
    }

    /**
     * The main method, and the main method will launch the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }

}
