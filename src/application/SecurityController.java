package application;

import java.io.BufferedWriter;
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
import javafx.scene.control.TextField;

public class SecurityController extends ControllerAbs  implements Initializable {
	ControllerAbs c1=new ControllerAbs();
	private SecurityForce securityForce;
	
	@FXML
	private ChoiceBox<String> field;
	@FXML
	private ChoiceBox<String> force;
	@FXML
	private ChoiceBox<String> Destination;
	@FXML
	private TextArea message;
	@FXML
	private Label done;
	@FXML
	private Label done2;
	@FXML
	private TextField name;
	@FXML
	private Button assign;
	@FXML
	private Button deploy;
	@FXML
	private Button sos;
	@FXML
	private Button callAm;
	@FXML
	private Button callFB;
	@FXML
	private String[] fields= {"Cheif of Security","Command Line Security","Front Line","Armed"};
	private String [] forces= {"CoS","CLS","FLS","AS","Military","AirForce","Police","S.W.A.T"};
	
	private String [] dest= {"Entrance","Terminal","Runways"};
	private String fieldF;
	private String forceF;
	private String destF;

	public SecurityController(){
		fieldF=" ";
		forceF=" ";
		destF=" ";
		done2 = new Label();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		 field.getItems().addAll(fields);
		 field.setOnAction(this::getfield);
		 force.getItems().addAll(forces);
		 force.setOnAction(this::getforce);
		 Destination.getItems().addAll(dest);
		 Destination.setOnAction(this::getdest);
	}
	private void getfield(ActionEvent event) {
   	 fieldF = field.getValue();
	}
	private void getforce(ActionEvent event) {
   	forceF = field.getValue();
	}
	private void getdest(ActionEvent event) {
   	destF = field.getValue();
	}
	public void assigner(ActionEvent event) {
		try {
            BufferedWriter writer=new BufferedWriter(new FileWriter("Security.txt"));
            writer.write("\n"+name.getText()+"/"+fieldF);
         
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
		done.setText("Assigned");
		
		
	}
	public void deployer(ActionEvent event) {
		try {
            BufferedWriter writer=new BufferedWriter(new FileWriter("SecurityDeploy.txt"));
            writer.write("\n"+fieldF+";"+destF+";"+fieldF+"//"+message.getText());
         
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
		done.setText("Deployed");
		done2.setText("Deploying security personnel to"+destF);
		
	}
	public void sos(ActionEvent event) {
		done.setText("Called");
	}
	public void callAb(ActionEvent event) {
		done.setText("Called");
	}
	public void CallFB(ActionEvent event) {
		done.setText("Called");
	}
	  public SecurityController(SecurityForce securityForce) {
	        this.securityForce = securityForce;
	    }

	    public void deploySecurity() {
	    	 if (this.securityForce != null) {
	             this.securityForce.performSecurityCheck();
	    	
	    	 }else {
	    		 done2.setText("Deploying security personnel");
	 	        securityForce.performSecurityCheck();
	    	 }
	    }

	    // Method Overloading: Added a new method with different parameters
	    public void deploySecurity(String location) {
	    	done2.setText("Deploying security personnel to " + location);
	        securityForce.performSecurityCheck(location);
	    }

}
