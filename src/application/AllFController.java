package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AllFController extends ControllerAbs {
	ControllerAbs c1=new ControllerAbs();

	@FXML
	private Button shower1;
	@FXML
	private Button shower2;
	@FXML
	private Label l1;
	@FXML
	private Label l2;
	
	public void show1(ActionEvent event) {
		try {
            BufferedReader reader=new BufferedReader(new FileReader("TotalFare.txt"));
            String line;
            while ((line= reader.readLine())!=null) {
                l1.setText(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}
	public void show2(ActionEvent event) {
		try {
            BufferedReader reader=new BufferedReader(new FileReader("TotalCancels.txt"));
            String line;
            while ((line= reader.readLine())!=null) {
                l2.setText(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}
	
}
