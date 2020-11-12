package ghasemia;

import ghasemia.model.Registration;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import prog24178.assigns.models.Events;

/*
 *
 * FXML Controller class
 *
 * Program : Developing a class that models a program for runners
 *
 * This class name is RunProgramController,
 * and it contains the controllers of
 * the program.
 *
 * @author Amirmahdi Ghasemi, 2020
 */
public class RunProgramController implements Initializable {

    /*
     * This is the ListView that was entered from FXMLRunProgram,
     * and it is
     * private, it will be used by referring to it by its name.
     */
    @FXML
    private ListView<Events> lstEvents;
    /*
     * This is the TextArea that was entered from FXMLRunProgram, and it is
     * private, it will be used by referring to it by its name.
     */
    @FXML
    private TextArea txtEventInfo;
    /*
     * This is the TextField that was entered from FXMLRunProgram, and it is
     * private, it will be used by referring to it by its name.
     */
    @FXML
    private TextField txtName;
    /*
     * This is the CheckBox that was entered from FXMLRunProgram, and it is
     * private, it will be used by referring to it by its name.
     */
    @FXML
    private CheckBox chkPaid;
    /*
     * These are the Buttons that were entered from FXMLRunProgram,
     * and they are
     * private, it will be used by referring to them by their name.
     */
    @FXML
    private Button btnRegister, btnExit;
    /*
     * This is the Label that was entered from FXMLRunProgram, and it is
     * private, it will be used by referring to it by its name.
     */
    @FXML
    private Label lblMessages;
    // This is registration object from Registration class, and it is private 
    private Registration registrations = new Registration();
    // This is PrintWriter class with null value, and its name is fileOut
    private PrintWriter fileOut = null;
    // This int variable with value of one, and its name is id
    private int id = 1;

    /*
     * This method takes one parameter which is event,
     * and it will close the
     * window and program whenever the user press the exit button.
     * After
     * checking that the fileOut is null or not.
     *
     * @param event
     */
    @FXML
    private void exit(ActionEvent event) {
        // Conditon for making sure about the file is not null
        if (fileOut != null) {
            fileOut.close();
        }
        // The program will convert whole window to the stage
        Stage stage = (Stage) btnExit.getScene().getWindow();
        // Then it close the stage
        stage.close();
    }

    /*
     * This method takes one parameter which is event, 
     * and it will print the
     * fields to the file.
     *
     * @param event
     */
    @FXML
    private void register(ActionEvent event) {
        // The id will set to the RegId in the registration classs
        registrations.setRegId(id++);
        // The fileOut will print the toSequentialFile
        fileOut.print(registrations.toSequentialFile());
        // The txtName filed will be cleared
        txtName.clear();
        // The chkPaid check box will be unchecked
        chkPaid.setSelected(false);
        // The message will be printed
        lblMessages.setText("Registration Saved.");
    }

    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // try-catch block for PrintWriter
        try {
            // The path is being passed to fileOut, and the value is true.
            // The vlaue will not be rewrite because of true value
            fileOut = new PrintWriter(new BufferedWriter(
                    new FileWriter("data/registration.txt", true)));
            // catch and exception
        } catch (Exception e) {
            // Any problem in the configuring of the path 
            //will cause to the below lines
            lblMessages.setText("Error connecting to registration file.");
            e.printStackTrace();
        }

        // Observable list that will store the event list
        ObservableList<Events> obsEvent
                = FXCollections.observableArrayList(Events.values());
        // Set items will set the events
        lstEvents.setItems(obsEvent);
        // Getting the SelectionModel for the following statements
        MultipleSelectionModel<Events> msm = lstEvents.getSelectionModel();
        // Selecting the first item
        msm.select(0);
        // Creating the display property
        StringProperty display = new SimpleStringProperty();

        // The paidProperty has been bind to the check box
        registrations.paidProperty().bind(chkPaid.selectedProperty());
        //the nameProperty has been bind to the txtName filed
        registrations.nameProperty().bind(txtName.textProperty());
        // The anonymous event for the list view
        msm.selectedItemProperty().addListener(new InvalidationListener() {
            @Override
            // Invalidated method that takes an observable list
            public void invalidated(Observable obs) {
                // For making sure that user has selected the item from the list
                if (msm.getSelectedIndex() >= 0) {
                    // Storing the selected item in the event object of registration class
                    registrations.event = msm.getSelectedItem();
                    // Setting the text from registration toString into the txtEventInfo
                    txtEventInfo.setText(registrations.toString());
                    // Clearing the message label
                    lblMessages.setText("");
                    // Binding the display with the value of the txtEventInfo
                    display.bind(txtEventInfo.textProperty());
                }

            }
        });
        // Bonus option: clear the message when 
        //the user types any character in the same field.
        //txtName.setOnKeyPressed(new EventHandler<KeyEvent>() {
        //@Override
        // Handle method for key event
        //public void handle(KeyEvent event) {
        // Clearing the message label
        //lblMessages.setText("");
        // }
        //});

    }

}
