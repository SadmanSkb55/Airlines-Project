package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class FileHandler extends ControllerAbs  {
	ControllerAbs c1=new ControllerAbs();
	@FXML
	private CheckBox box;
	@FXML
	private Button button;
	@FXML
	private Stage stage;
	@FXML
	 private Scene scene;
	@FXML
	 private Parent root;
	
	public void abort(ActionEvent event) throws IOException {
		if(box.isSelected()) {
		 try {
             BufferedWriter writer=new BufferedWriter(new FileWriter("TempInfo.txt"));
             writer.close();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
		 try {
             BufferedWriter writer=new BufferedWriter(new FileWriter("AirplaneInfo.txt"));
             writer.close();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
		 try {
             BufferedWriter writer=new BufferedWriter(new FileWriter("AllEmployee.txt"));
             writer.close();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
		 try {
             BufferedWriter writer=new BufferedWriter(new FileWriter("Destinations.txt"));
             writer.close();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
		 try {
             BufferedWriter writer=new BufferedWriter(new FileWriter("Flights.txt"));
             writer.close();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
		 try {
             BufferedWriter writer=new BufferedWriter(new FileWriter("Notices.txt"));
             writer.close();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
		 //...........
		 root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  stage.setScene(scene);
			  stage.show();	  
	}
	}
}
