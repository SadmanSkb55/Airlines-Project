package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DeptControllerX extends ControllerAbs{
	ControllerAbs c1=new ControllerAbs();
	@FXML
	private TextField t;
	@FXML
	private TextField t24;
	@FXML
	private TextField gl;
	@FXML
	private Label label; 
	
	public void adder(ActionEvent event) {
		try {
            BufferedWriter writer=new BufferedWriter(new FileWriter("TimeKeeeper.txt",true));
            writer.write("\n"+t.getText()+"\n"+t24.getText()+"\n"+gl);
            
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	
	try {
        BufferedWriter writer=new BufferedWriter(new FileWriter("Times.txt",true));
        writer.write("\n"+t.getText()+"\n");
        
        writer.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
	label.setText("Added");
}

}
