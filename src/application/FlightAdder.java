package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FlightAdder implements Initializable,Airplanes {
	
	@FXML
	private TextField fname;
	@FXML
	private TextField cap;
	@FXML
	private TextField dateofissue;
	@FXML
	private ChoiceBox<String>Model;
	@FXML
	private ChoiceBox<String>Type;
	@FXML
	private Label label;
	
	private String name;
	private String capa;
	private String doI;
	private String typx;
	private String modx;
	private String[] mod= {"Boeing 737","Boeing 787","Boeing 777","Airbus A380"};
	private String [] typ= {"Single-Engine Land","Single-Engine Sea","Multi-Engine Land","Multi-Engine Sea"};
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Model.getItems().addAll(mod);
		Model.setOnAction(this::getmod);
		
		Type.getItems().addAll(typ);
		Type.setOnAction(this::gettyp);
		
	}
	 private void getmod(ActionEvent event) {
	    	modx = Model.getValue();
		}
	    private void gettyp(ActionEvent event) {
	    	typx= Type.getValue();
		}
	    @Override
	    public void adder(ActionEvent event) {
	    	try {
	            BufferedWriter writer=new BufferedWriter(new FileWriter("FlightDetail.txt",true));
	            writer.write(fname.getText()+"\n"+cap.getText()+"\n"+dateofissue+"\n"+modx+"\n"+typ);
	           
	            writer.close();
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    	try {
	            BufferedWriter writer=new BufferedWriter(new FileWriter("Flights.txt",true));
	            writer.write(fname.getText()+"\n");
	           
	            writer.close();
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    	label.setAccessibleHelp("Added");
	    }
		@Override
		public void adderscene(ActionEvent event) {
			
		}

}
