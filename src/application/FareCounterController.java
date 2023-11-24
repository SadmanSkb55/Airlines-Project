package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FareCounterController implements Initializable {
	
	
	
	@FXML
	private Button Proceed;
	@FXML
	private Button Previous;
	@FXML
	private Button Accept;
	@FXML
	private Button Calculate;
	@FXML
	private ChoiceBox<String> Payment;
	@FXML
	private String [] paymentMethod = {"Reservation","Visa Card","Master Card","American Express","Discover","Cheque"};
	@FXML
	private TextField Weight;
	@FXML
	private CheckBox secPass;
	@FXML
	private CheckBox payDone;
	@FXML
	private Stage stage;
	@FXML
	 private Scene scene;
	@FXML
	 private Parent root;
	@FXML
	private Label name;
	@FXML
	private Label nationality;
	@FXML
	private Label email;
	@FXML
	private Label phnum;
	@FXML
	private Label emerphnum;
	@FXML
	private Label dob;
	@FXML
	private Label pob;
	@FXML
	private Label gender;
	@FXML
	private Label pcn;
	@FXML
	private Label nos;
	@FXML
	private Label from;
	@FXML
	private Label to;
	@FXML
	private Label deptdate;
	@FXML
	private Label depttime;
	@FXML
	private Label flight;
	@FXML
	private Label seatclass;
	@FXML
	private Label welcome;
	@FXML
	private Label warning;
	@FXML
	private Label acceptance1;
	@FXML
	private Label acceptance2;
	@FXML
	private Label acceptance3;
	@FXML
	private Label Fareps;
	@FXML
	private Label TotalFarebs;
	@FXML
	private Label TAX;
	@FXML
	private Label FSTax;
	@FXML
	private Label TotalFare;
	@FXML
	private Label PassFC;
	
	private int minint;
	private int maxint;
	private String pmethod;
	private String nameR;
    private String nationalityR;
    private String emailR;
    private String phnnumberR;
    private String emerphnumR;
    private String dobR;
    private String pobR;
    private String genderR;
    private String pcnR;
    private int nosR;
    private String fromR;
    private String toR;
    private String depttimeR;
    private String deptdateR;
    private String flightR;
    private String seatclassR;
	
    
	
	public FareCounterController() {
		this.nameR="Not yet Assigned";
		this.nationalityR="Not yet Assigned";
		this.emailR="Not yet Assigned";
		this.phnnumberR="Not yet Assigned";
		this.emerphnumR="Not yet Assigned";
		//this.dob="Not yet Assigned";
		this.pobR="Not yet Assigned";
		this.genderR="Not yet Assigned";
		this.pcnR="Not yet Assigned";
		this.nosR=0;
		this.fromR="Not yet Assigned";
		this.toR="Not yet Assigned";
		this.depttimeR="Not yet Assigned";
		//this.deptdate="Not yet Assigned";
		this.flightR="Not yet Assigned"; 
		this.seatclassR="Not yet Assigned";
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Payment.getItems().addAll(paymentMethod);
		Payment.setOnAction(this::getPaymentMethod);
	}
	 private void getPaymentMethod(ActionEvent event) {
	    	pmethod = Payment.getValue();
		}
	 Random random = new Random();
	 CalculatorA calc=new CalculatorA();
public void initinput(ActionEvent event)throws Exception{
	 try {
         BufferedReader reader=new BufferedReader(new FileReader("TempInfo.txt"));
         String line;
         int linenum=0;
         while ((line=reader.readLine())!=null) {
         	linenum++;
         	if(linenum==1) {
             name.setText(line);
             nameR=line;
         	}
         	if(linenum==2) {
         		nationality.setText(line);
         		nationalityR=line;
         	}
         	if(linenum==3) {
         		email.setText(line);
         		emailR=line;
         	}
         	if(linenum==4) {
         		phnum.setText(line);
         		phnnumberR=line;
         	}
         	if(linenum==5) {
         		emerphnum.setText(line);
         		emerphnumR=line;
         	}
         	if(linenum==6) {
         		dob.setText(line);
         		dobR=line;
         	}
         	if(linenum==7) {
         		pob.setText(line);
         		pobR=line;
         	}
         	if(linenum==8) {
         		gender.setText(line);
         		genderR=line;
         	}
         	if(linenum==9) {
         		pcn.setText(line);
         		pcnR=line;
         	}
         	if(linenum==10) {
         		nos.setText(line);
         		nosR=Integer.parseInt(line);
         	}
         	if(linenum==11) {
         		from.setText(line);
         		fromR=line;
         	}
         	if(linenum==12) {
         		to.setText(line);
         		toR=line;
         	}
         	if(linenum==13) {
         		deptdate.setText(line);
         		deptdateR=line;
         	}
         	if(linenum==14) {
         		depttime.setText(line);
         		depttimeR=line;
         	}
         	if(linenum==15) {
         		flight.setText(line);
         		flightR=line;
         	}
         	if(linenum==16) {
         		seatclass.setText(line);
         		seatclassR=line;
         	}
         }
         reader.close();
     } catch (FileNotFoundException e) {
         throw new RuntimeException(e);
     } catch (IOException e) {
         throw new RuntimeException(e);
     }	 
}

public void setLuggage(ActionEvent event) throws Exception {
	 calc.initinput();
     calc.fareCalculate();
     calc.totalCalculate();
     calc.luggagecount();
	calc.setLuggageweight(Double.parseDouble(Weight.getText()));
}
public void generateNet(ActionEvent event) throws Exception{
	calc.initinput();
    calc.fareCalculate();
    calc.totalCalculate();
    calc.luggagecount();
	 TotalFarebs.setText(String.valueOf(calc.getTotalfarebs()));
		 TAX.setText(String.valueOf(calc.getTax()));
		FSTax.setText(String.valueOf(calc.getFstax()));
		TotalFare.setText(String.valueOf(calc.getTotal()));
		PassFC.setText(String.valueOf(calc.getPassfc()));
		Fareps.setText(String.valueOf(calc.getFareps()));
}

public void acceptPassenger(ActionEvent event) throws Exception{
	
	double randomInt = minint + (maxint - minint) * random.nextInt();
	
	if(pmethod.equalsIgnoreCase("Reservation")){
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter("Reservation.txt",true))) {
	            writer.write(emailR+randomInt);
	            writer.write("\n"+nameR+"\n"+nationalityR+"\n"+emailR+"\n"+phnnumberR+"\n"+emerphnumR+"\n"+dobR+"\n"+pobR+"\n"+genderR+"\n"+pcnR+"\n"+nosR+"\n"+fromR+"\n"+toR+"\n"+deptdateR+"\n"+depttimeR+"\n"+flightR+"\n"+seatclassR);            
	            writer.write("\n"+"--------------");
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
		 try {
	            BufferedWriter writer=new BufferedWriter(new FileWriter("TempReservationCodes.txt"));
	            writer.write(emailR+randomInt);
	            writer.close();
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
		 acceptance3.setText("Please Proceed for next Step,A reservation code will be provided");
	}
	else {
		if(secPass.isSelected() && payDone.isSelected()) {
			acceptance1.setText("Please proceed for Ticket");
		}
		else {
			acceptance2.setText("Please Confirm them");
		}
	}
}
public void proceedPassenger(ActionEvent event) throws IOException {
	
	if(pmethod!="Reservation") {
		welcome.setText("Please proceed");
		 try {
	            BufferedWriter writer=new BufferedWriter(new FileWriter("TempInfo.txt"));
	            writer.write(nameR+"\n"+nationalityR+"\n"+emailR+"\n"+phnnumberR+"\n"+emerphnumR+"\n"+dobR+"\n"+pobR+"\n"+genderR+"\n"+pcnR+"\n"+nosR+"\n"+fromR+"\n"+toR+"\n"+deptdateR+"\n"+depttimeR+"\n"+flightR+"\n"+seatclassR);            
	            writer.write("\n"+String.valueOf(calc.getTotal()));
	            writer.close();
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
		 try {
	            BufferedWriter writer=new BufferedWriter(new FileWriter("TotalFare.txt",true));
	            writer.write("\n"+String.valueOf(calc.getTotal()));
	            writer.close();
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
		
		 
	root = FXMLLoader.load(getClass().getResource("TerminalScene.fxml"));
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	}
	if(pmethod.equalsIgnoreCase("Reservation")){
		welcome.setText("Please proceed for code");
		root = FXMLLoader.load(getClass().getResource("ReserveCodeScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	else {
		warning.setText("Please Completete all the fields");
	}
}

public void previousScene(ActionEvent event)throws Exception{	
	 try {
         BufferedWriter writer=new BufferedWriter(new FileWriter("TempInfo.txt"));
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
}
