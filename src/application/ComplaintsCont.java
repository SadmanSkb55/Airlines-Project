package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ComplaintsCont extends  ControllerAbs {
	ControllerAbs c1=new ControllerAbs();
	@FXML
	private Label label;
	@FXML
	private TextArea area;
	
	public void ComplaintSender(ActionEvent event) {
		
		
	try (BufferedWriter writer = new BufferedWriter(new FileWriter("Complaints.txt"))) {
        writer.write(area.getText());  
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
	label.setText("Sent");
	}
}
