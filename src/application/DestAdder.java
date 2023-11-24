package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DestAdder extends ControllerAbs  {
	ControllerAbs c1=new ControllerAbs();
	@FXML
	private TextField dest;
	@FXML
	private Label label;
	
	public void adder(ActionEvent event) {
		try {
            BufferedWriter writer=new BufferedWriter(new FileWriter("Destinations.txt",true));
            writer.write("\n"+dest.getText());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
		label.setText("Added");
	}

}
