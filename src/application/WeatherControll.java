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

public class WeatherControll extends ControllerAbs  implements Initializable{
	ControllerAbs c1=new ControllerAbs();
	@FXML
	private TextField temp;
	@FXML
	private TextField hum;
	@FXML
	private TextField wind;
	@FXML
	private TextField precip;
	@FXML
	private Label done;
	@FXML
	private ChoiceBox<String> loc;
	@FXML
	private ChoiceBox<String> sts;
	
	private String locc;
	private String stss;
	
	public WeatherControll(){
		locc=" ";
		stss=" ";
	}
	
	private String[] arr1= {"Dhaka","Chittagong","Sylhet"};
	private String [] arr2= {"Sunny","Cloudy","Rainy","Stormy"};
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 loc.getItems().addAll(arr1);
			loc.setOnAction(this::getloc);
			 sts.getItems().addAll(arr2);
				sts.setOnAction(this::getstss);
		
	}
	private void getloc(ActionEvent event) {
	   	 this.locc= loc.getValue();
		}
		private void getstss(ActionEvent event) {
	   	this.stss = sts.getValue();
		}
public void updater(ActionEvent event) {
	 try {
         BufferedWriter writer=new BufferedWriter(new FileWriter("Weather.txt"));
         writer.write(temp.getText()+":"+hum.getText()+":"+wind.getText()+":"+precip.getText()+"L "+locc+" S "+stss);
//        
         writer.close();
     } catch (IOException e) {
         throw new RuntimeException(e);
     }
	 done.setText("Updated!!!");
}
}
