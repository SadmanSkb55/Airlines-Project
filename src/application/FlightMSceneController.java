package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
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

public class FlightMSceneController extends ControllerAbs implements Initializable {
	ControllerAbs c1=new ControllerAbs();
	
	@FXML
	private ChoiceBox<String> flights;
	@FXML
	private ChoiceBox<String> times;
	@FXML
	private ChoiceBox<String> froms;
	@FXML
	private String[] fromss= {"Hazrat Shahjalal International Airport","Shah Amanat International Airport","Osmani International Airport"};
	@FXML
	private ChoiceBox<String> tos;
	@FXML
	private TextArea comment;
	@FXML
	private Label Done;
	@FXML
	private Button publish;
	@FXML
	private Button Update;
	
	private String[] array1=new String[100];
	private String[] array2=new String[100];
	private String[] array3=new String[100];
	private String flightR;
	private String timesR;
	private String tosR;
	private String fromsR;
	
	public FlightMSceneController() {
		flightR=" ";
		timesR=" ";
		tosR=" ";
		fromsR=" ";
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 try {
	            BufferedReader reader=new BufferedReader(new FileReader("Flights.txt"));
	            String line;
	            int i=0;
	            while ((line= reader.readLine())!=null) {
	                this.array1[i]=line;
	                i++;
	            }
	            reader.close();
	        } catch (FileNotFoundException e) {
	            throw new RuntimeException(e);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
		 try {
	            BufferedReader reader=new BufferedReader(new FileReader("Times.txt"));
	            String line;
	            int i=0;
	            while ((line= reader.readLine())!=null) {
	                this.array2[i]=line;
	                i++;
	            }
	            reader.close();
	        } catch (FileNotFoundException e) {
	            throw new RuntimeException(e);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
		 try {
	            BufferedReader reader=new BufferedReader(new FileReader("Destinations.txt"));
	            String line;
	            int i=0;
	            while ((line= reader.readLine())!=null) {
	                this.array3[i]=line;
	                i++;
	            }
	            reader.close();
	        } catch (FileNotFoundException e) {
	            throw new RuntimeException(e);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }	
		 flights.getItems().addAll(array1);
			flights.setOnAction(this::getflights);
			 times.getItems().addAll(array2);
				times.setOnAction(this::gettimes);
				 tos.getItems().addAll(array3);
					tos.setOnAction(this::gettos);
					froms.getItems().addAll(fromss);
					froms.setOnAction(this::getfroms);
		 
	}
	private void getflights(ActionEvent event) {
    	 flightR = flights.getValue();
	}
	private void gettimes(ActionEvent event) {
    	timesR = times.getValue();
	}
	private void gettos(ActionEvent event) {
    	tosR = tos.getValue();
	}
	private void getfroms(ActionEvent event) {
		fromsR=froms.getValue();
	}
	
public void update(ActionEvent event) {
	try {
        BufferedWriter writer=new BufferedWriter(new FileWriter("FStats.txt",true));
        writer.write(flightR+" "+timesR+" "+fromsR+" "+tosR);
        writer.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
	Done.setText("Updated");
}
public void publish(ActionEvent event) {
	try {
        BufferedWriter writer=new BufferedWriter(new FileWriter("FStats.txt",true));
        writer.write("\n"+comment.getText());
        writer.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
	Done.setText("Published");
}

}
