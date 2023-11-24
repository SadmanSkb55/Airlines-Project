package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CancelController extends ControllerAbs {
	ControllerAbs c1=new ControllerAbs();

	@FXML
	private TextArea area;
	@FXML
	private Label warning;
	@FXML
	private Button search; 
	@FXML
	private Button previous; 
	@FXML
	private Button cancel; 
	@FXML
	private Stage stage;
	@FXML
	 private Scene scene;
	@FXML
	 private Parent root;
	@FXML
	private TextField searchbar;
	
	private String searchval;
	
	
	public void cancel(ActionEvent event)throws Exception {
		searchval=searchbar.getText();
		boolean foundSearchTerm = false;
		StringBuilder updatedContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader("PassengerInfo.txt"))) {
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                
                if (currentLine.contains(searchval)) {
                    foundSearchTerm = true;
                    break; 
                }
                	else {
                		warning.setText("Seached Data Not Found");
                }
                updatedContent.append(currentLine).append("\n");
                
            }

            if (foundSearchTerm) {
                for (int i = 0; i < 3; i++) {
                    reader.readLine();
                }
            }

            while ((currentLine = reader.readLine()) != null) {
                updatedContent.append(currentLine).append("\n");
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("PassengerInfo.txt"))) {
            writer.write(updatedContent.toString());
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        
	}
	public void searcher(ActionEvent event)throws Exception{
		searchval=searchbar.getText();
		boolean foundSearchTerm = false;
		 try {
			 FileReader fileReader = new FileReader("PassengerInfo.txt");
	            BufferedReader reader = new BufferedReader(fileReader);
	         String line;
	         StringBuilder passn = new StringBuilder();
	         while ((line=reader.readLine())!=null) {
	        	 if (line.contains(searchval)) {
	                    foundSearchTerm = true;
	                    break; 
	                }
	        	 }
	         if (foundSearchTerm) {
	                for (int i = 1; i < 3; i++) {
	                    if ((line = reader.readLine()) != null) {
	                    	passn.append(line).append("\n");
	                    } else {
	                        break; 
	                    }area.setText(passn.toString());
	                    
	                }
	                
	         }
	         else {
	        	 warning.setText("Seached Data Not Found");
	         }
		 }
		 catch (IOException e) {
	            throw new RuntimeException(e);
	        }
		 root = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  stage.setScene(scene);
			  stage.show();
	
	}
	public void previous(ActionEvent event)throws Exception{
		root = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
}
