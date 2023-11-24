package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AssignController extends EmployeeX implements Initializable {

    @FXML
    private TextField Searchbar;
    @FXML
    private ChoiceBox<String> FieldD;
    private String[] FieldsAd = {"Administrator", "Vice Administrator", "Assistant Administrator","Ticketing Agent", "Assistant Ticketing Agent","Pilot", "Co-Pilot", "Air Hostess","Immigration Officer", "Assistant Immigration Officer", "Passport Officer", "External Affairs"};
//    private String[] FieldsTA = {"Ticketing Agent", "Assistant Ticketing Agent"};
//    private String[] FieldsAE = {"Pilot", "Co-Pilot", "Air Hostess"};
//    private String[] FieldsTE = {"Immigration Officer", "Assistant Immigration Officer", "Passport Officer", "External Affairs"};
    @FXML
    private Button Search;
    @FXML
    private Button Assign;
    @FXML
    private Label Warning;
    @FXML
    private TextArea DeptC;
    private String searchval;
    private static String dept;
    private String field;
    private static String name;
    private String[] container = new String[20];
    private String project;
   
    public AssignController(String name, String dept, String project) {
    	super(name, dept);
        searchval = "";
        dept = "";
        name = "";
        field = "";
    }
 public AssignController() {
	 super(name,dept);
    }

    public void searcher(ActionEvent event) throws Exception {
        this.searchval = Searchbar.getText();
        boolean foundSearchTerm = false;
        try (BufferedReader reader = new BufferedReader(new FileReader("AllEmployee.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(searchval)) {
                    foundSearchTerm = true;
                    break;
                }
            }
            if (!foundSearchTerm) {
                Warning.setText("Searched Data Not Found");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (foundSearchTerm) {
            try (BufferedReader reader = new BufferedReader(new FileReader("AllEmployee.txt"))) {
                String line;
                for (int i = 1; i < 6; i++) {
                    if (i == 2 && (line = reader.readLine()) != null) {
                        DeptC.setText(line);
                        this.dept = line;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Set up the container based on the department
//        if (dept.equalsIgnoreCase("Administration")) {
//            container = FieldsAd;
//        } else if (dept.equalsIgnoreCase("TicketingAgent")) {
//            container = FieldsTA;
//        } else if (dept.equalsIgnoreCase("Airplane")) {
//            container = FieldsAE;
//        } else if (dept.equalsIgnoreCase("Terminal")) {
//            container = FieldsTE;
       // }
        FieldD.getItems().addAll(FieldsAd);
        FieldD.setOnAction(this::getContainer);
    }

    private void getContainer(ActionEvent event) {
        field = FieldD.getValue();
        if (field != null) {
            field = FieldD.getValue();
        }
    }

    public void Assigner(ActionEvent event) throws Exception {
        // Check if name and field are not empty
        if (!name.isEmpty() && !field.isEmpty()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("AllEmployee.txt", true))) {
                writer.write(name + ":" + field + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            Warning.setText("Name and Field cannot be empty");
        }
    }
    @Override
    public void displayInfo() {
        super.displayInfo();  // Call the displayInfo method of the superclass
        Warning.setText("Project: " + project);
    }
}
