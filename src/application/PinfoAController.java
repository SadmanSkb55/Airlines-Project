package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PinfoAController extends TextShow{
	@FXML
	private TextField searchbar;
	private String searchval;
	@FXML
	private TextArea area;
	@FXML
	private Label warning;
	
	
	public void searcher(ActionEvent event)throws Exception{
		searchval=searchbar.getText();
		boolean foundSearchTerm = false;
		try {
            FileReader fileReader = new FileReader("Notices.txt");
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
	}
	public void showall(ActionEvent event) {
		try {
            FileReader fileReader = new FileReader("Notices.txt");
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            StringBuilder passn = new StringBuilder();
            while ((line= reader.readLine())!=null) {
            	passn.append(line).append("\n");
            }area.setText(passn.toString());
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}
	

}
