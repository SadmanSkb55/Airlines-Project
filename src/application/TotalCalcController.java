package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TotalCalcController extends ControllerAbs  {
	ControllerAbs c1=new ControllerAbs();
	@FXML
	private Button b1;
	@FXML
	private Button b2;
	@FXML
	private Button b3;
	@FXML
	private Button b4;
	@FXML
	private Label l1;
	@FXML
	private Label l2;
	@FXML
	private Label l3;
	@FXML
	private TextField t1;
	
	private double sum;
	private  double sum2;
	private  double sum3;
	public TotalCalcController(){
		sum=0.0;
		sum2=0.0;
		sum3=0.0;
	}
	public TotalCalcController(double sum,double sum2, double sum3){
		this.sum=sum;
		this.sum2=sum2;
		this.sum3=sum3;
	}
	
	public void show1(ActionEvent event) {
		try {
            BufferedReader reader = new BufferedReader(new FileReader("TotalFare.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
            	if (!line.trim().isEmpty()) {
                this.sum += Double.parseDouble(line);
            	}
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        l1.setText(String.valueOf(sum));
        //System.out.println("show1: Sum value: " + sum);
	}
	public void show2(ActionEvent event) {
		try {
            BufferedReader reader = new BufferedReader(new FileReader("TotalCancels.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
            	if (!line.trim().isEmpty()) {
                this.sum3 += Double.parseDouble(line);
            	}
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        l2.setText(String.valueOf(sum3));
       // System.out.println("show2: Sum3 value: " + sum3);
	}
	public void show3(ActionEvent event) {
		sum2 = sum - Double.parseDouble(t1.getText()) - sum2;
        l3.setText(String.valueOf(sum2));
        //System.out.println("show3: Sum2 value: " + sum2);
	}
	
}
