package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CodeSceneController extends ControllerAbs {
	ControllerAbs c1=new ControllerAbs();
	@FXML
	private Stage stage;
	@FXML
	 private Scene scene;
	@FXML
	 private Parent root;
	@FXML
	private Label code;
	@FXML
	private Button proceed;
	@FXML
	private Button previous;
	@FXML
	private Button show;
	
	public void showCode(ActionEvent event)throws Exception{
		try {
	         BufferedReader reader=new BufferedReader(new FileReader("TempReservationCodes.txt"));
	         String line;
	        int count=0;
	         while ((line=reader.readLine())!=null) {
	        	 if(count==1) {
	        	 code.setText(line);
	        	 }
	        	 count++;
	         }
	         reader.close();
		}   
     catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }	 
	}
	
	public void proceedRun(ActionEvent event)throws Exception {
		 try {
	         BufferedWriter writer=new BufferedWriter(new FileWriter("TempReservationCodes.txt"));
	         writer.close();
	     } catch (IOException e) {
	         throw new RuntimeException(e);
	     }
		
		root = FXMLLoader.load(getClass().getResource("TicketScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		  
		  
		
	}
	

	public void previousScene(ActionEvent event)throws Exception{	
		 try {
	         BufferedWriter writer=new BufferedWriter(new FileWriter("TempReservationCodes.txt"));
	         writer.close();
	     } catch (IOException e) {
	         throw new RuntimeException(e);
	     }
		
		root = FXMLLoader.load(getClass().getResource("FareCounterScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		  
		  
	}
	
}
