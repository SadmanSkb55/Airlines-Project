package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.animation.TranslateTransition;

//import javax.naming.NameAlreadyBoundException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TicketSceneController extends ControllerAbs  implements Initializable{
	ControllerAbs c1=new ControllerAbs();
	@FXML
	private TextField Name;
	@FXML
	private TextField Nationality;
	@FXML
	private TextField Email;
	@FXML
	private TextField Phonenumber;
	@FXML
	private TextField EmerPhoneNum;
	@FXML
	private DatePicker DOB;//Date of Birth
	@FXML
	private TextField POB;//Place of Birth
	@FXML
    private ChoiceBox<String> ChoiceGen;
	@FXML
	private String [] Gender = {"Male","Female","Other"};
	@FXML
	private TextField PCN;//Passport Card Number
	@FXML
	private Slider NOS;//Number of Seats
	@FXML
	private ChoiceBox<String> ChoiceFrom;
	@FXML
	private String [] From = {"Hazrat Shahjalal International Airport","Shah Amanat International Airport","Osmani International Airport"};
	@FXML
	private ChoiceBox<String> ChoiceTo;
	@FXML
	private String [] To = {"USA","CANADA","GERMANY","NETHERLANDS","NORWAY","BELGIUM","RUSSIA","CHINA","JAPAN","AUSTRALIA","SINGAPORE","MALAYSIA","INDIA","UAE","KSA","CONGO","AFRICA","BRASIL","ARGENTINA"};
	@FXML
	private DatePicker DeptDate;//Depurture date
	@FXML
	private ChoiceBox<String> ChoiceDeptTime;//Depurture Time
	@FXML
	private String [] DeptTime = {"10:00","11:00","1:00","3:30","5:00","7:00","7:40"};
	@FXML
	private Button Assign;
	@FXML
	private Button Previous;
	@FXML
	private Stage stage;
	@FXML
	 private Scene scene;
	@FXML
	 private Parent root;
	@FXML
    private ChoiceBox<String> ChoiceFlight;
	@FXML
	private String[] Flight = {"Qatar Airways","Emirates","Etihad Airlines","British Airways","American Airlines","Lufthansa","Cathay Pacific","Delta Airlines"};
	@FXML
	private ChoiceBox<String> ChoiceClass;
	@FXML
	private String[] SeatClass= {"Economy","Premium Economy","Buisness","First Class"};
	@FXML
	private Label warningMsg;
	@FXML
	private Label WelcomeMsg;
//	@FXML
//	private Label DOBshow;
//	@FXML 
//	private Label DeptDateShow; 
	@FXML
	private Label NOSshow; 
	@FXML
	private CheckBox Mode;
	@FXML
	private ImageView Background;
	
	private String name;
    private String nationality;
    private String email;
    private String phnnumber;
    private String emerphnum;
    private LocalDate dob;
    private String pob;
    private String gender;
    private String pcn;
    private int nos;
    private String from;
    private String to;
    private String depttime;
    private LocalDate deptdate;
    private String flight;
    private String seatclass;
	
    public TicketSceneController() {
		this.name="Not yet Assigned";
		this.nationality="Not yet Assigned";
		this.email="Not yet Assigned";
		this.phnnumber="Not yet Assigned";
		this.emerphnum="Not yet Assigned";
		//this.dob="Not yet Assigned";
		this.pob="Not yet Assigned";
		this.gender="Not yet Assigned";
		this.pcn="Not yet Assigned";
		this.nos=0;
		this.from="Not yet Assigned";
		this.to="Not yet Assigned";
		this.depttime="Not yet Assigned";
		//this.deptdate="Not yet Assigned";
		this.flight="Not yet Assigned"; 
		this.seatclass="Not yet Assigned";
	}
    //Area of choicebox2
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ChoiceGen.getItems().addAll(Gender);
		ChoiceGen.setOnAction(this::getGenderX);
		
		ChoiceFrom.getItems().addAll(From);
		ChoiceFrom.setOnAction(this::getFromX);
		
		ChoiceTo.getItems().addAll(To);
		ChoiceTo.setOnAction(this::getToX);
		
		ChoiceDeptTime.getItems().addAll(DeptTime);
		ChoiceDeptTime.setOnAction(this::getDepttimeX);
		
		ChoiceFlight.getItems().addAll(Flight);
		ChoiceFlight.setOnAction(this::getFlightX);
		
		ChoiceClass.getItems().addAll(SeatClass);
		ChoiceClass.setOnAction(this::getClassX);
		
		nos = (int) NOS.getValue();
		NOS.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldNumber, Number newNumber) {	
				nos = (int) NOS.getValue();
				nos = (int) NOS.getValue();
				NOSshow.setText(Integer.toString(nos));
			}			
		});	
	}
    private void getGenderX(ActionEvent event) {
    	gender = ChoiceGen.getValue();
	}
    private void getFromX(ActionEvent event) {
    	from = ChoiceFrom.getValue();
	}
    private void getToX(ActionEvent event) {
    	to= ChoiceTo.getValue();
	}
    private void getDepttimeX(ActionEvent event) {
    	depttime = ChoiceDeptTime.getValue();
	}
    private void getFlightX(ActionEvent event) {
    	flight = ChoiceFlight.getValue();
	}
    private void getClassX(ActionEvent event) {
    	seatclass=ChoiceClass.getValue();
	} 
    public void getDobX(ActionEvent event) { 
    	  LocalDate dob = DOB.getValue();
    	  String myFormattedDate= dob.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
   	 }
    
    public void getDeptDateX(ActionEvent event) { 
    	  LocalDate deptdate = DeptDate.getValue();
    	  String myFormattedDate= deptdate.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
    	 } 
    
//Mode Changer
Image PortScenery = new Image(getClass().getResourceAsStream("Air1.jpg"));
Image DarkScenery = new Image(getClass().getResourceAsStream("DarkMode.jpg"));

public void DarkMode(ActionEvent event) {
	
	if(Mode.isSelected()) {
		Background.setImage(DarkScenery);
		Name.setStyle("-fx-background-color: #F99417;-fx-background-radius:10;-fx-text-fill:#000000;-fx-font-size:16px;");
		Nationality.setStyle("-fx-background-color: #F99417;-fx-background-radius:10;-fx-text-fill:#000000;-fx-font-size:16px;");
		Email.setStyle("-fx-background-color: #F99417;-fx-background-radius:10;-fx-text-fill:#000000;-fx-font-size:16px;");
		Phonenumber.setStyle("-fx-background-color: #F99417;-fx-background-radius:10;-fx-text-fill:#000000;-fx-font-size:16px;");
		EmerPhoneNum.setStyle("-fx-background-color: #F99417;-fx-background-radius:10;-fx-text-fill:#000000;-fx-font-size:16px;");
		DOB.setStyle("-fx-background-color: #F99417;-fx-background-radius:10;-fx-text-fill:#000000;-fx-font-size:16px;");
		POB.setStyle("-fx-background-color: #F99417;-fx-background-radius:10;-fx-text-fill:#000000;-fx-font-size:16px;");
		ChoiceGen.setStyle("-fx-background-color: #F99417;-fx-background-radius:10;-fx-text-fill:#000000;-fx-font-size:16px;");
		PCN.setStyle("-fx-background-color: #F99417;-fx-background-radius:10;-fx-text-fill:#000000;-fx-font-size:16px;");
		ChoiceFrom.setStyle("-fx-background-color:#F99417;-fx-background-radius:10;-fx-text-fill:#ffffff;-fx-font-size:16px;");
		ChoiceTo.setStyle("-fx-background-color:#F99417;-fx-background-radius:10;-fx-text-fill:#ffffff;-fx-font-size:16px;");
		ChoiceDeptTime.setStyle("-fx-background-color:#F99417;-fx-background-radius:10;-fx-text-fill:#ffffff;-fx-font-size:16px;");
		ChoiceFlight.setStyle("-fx-background-color:#F99417;-fx-background-radius:10;-fx-text-fill:#ffffff;-fx-font-size:16px;");
		ChoiceTo.setStyle("-fx-background-color:#F99417;-fx-background-radius:10;-fx-text-fill:#ffffff;-fx-font-size:16px;");
		ChoiceFrom.setStyle("-fx-background-color:#F99417;-fx-background-radius:10;-fx-text-fill:#ffffff;-fx-font-size:16px;");
		ChoiceClass.setStyle("-fx-background-color:#F99417;-fx-background-radius:10;-fx-text-fill:#ffffff;-fx-font-size:16px;");
		DeptDate.setStyle("-fx-background-color:#F99417;-fx-background-radius:10;-fx-text-fill:#ffffff;-fx-font-size:16px;");
		NOS.setStyle("-fx-background-color:#F99417;-fx-background-radius:10;-fx-text-fill:#ffffff;-fx-font-size:16px;");
		Mode.setStyle("-fx-background-color:#F99417;-fx-background-radius:10;-fx-text-fill:#ffffff;-fx-font-size:16px;");
	    Assign.setStyle("-fx-background-color:#F99417;-fx-background-radius:10;");
		Previous.setStyle("-fx-background-color:#F99417;-fx-background-radius:10;");
		WelcomeMsg.setStyle("-fx-text-fill:#F99417;-fx-font-size:27px;-fx-font-weight:Bold");
	}
	else {
		Background.setImage(PortScenery);
		Name.setStyle("-fx-background-color:#000000;-fx-background-radius:10;-fx-text-fill:#ffffff;-fx-font-size:16px;");
        Nationality.setStyle("-fx-background-color:#000000 ;-fx-background-radius:10;-fx-text-fill:#ffffff;-fx-font-size:16px;");
		Email.setStyle("-fx-background-color: #000000;-fx-background-radius:10;-fx-text-fill:#ffffff;-fx-font-size:16px;");
		Phonenumber.setStyle("-fx-background-color: #000000;-fx-background-radius:10;-fx-text-fill:#ffffff;-fx-font-size:16px;");
		EmerPhoneNum.setStyle("-fx-background-color: #000000;-fx-background-radius:10;-fx-text-fill:#ffffff;-fx-font-size:16px;");
		DOB.setStyle("-fx-background-color: #000000;-fx-background-radius:10;-fx-text-fill:#ffffff;-fx-font-size:16px;");
		POB.setStyle("-fx-background-color: #000000;-fx-background-radius:10;-fx-text-fill:#ffffff;-fx-font-size:16px;");
		ChoiceGen.setStyle("-fx-background-color: #000000;-fx-background-radius:10;-fx-text-fill:#ffffff;-fx-font-size:16px;");
		PCN.setStyle("-fx-background-color: #000000;-fx-background-radius:10;-fx-text-fill:#ffffff;-fx-font-size:16px;");
		ChoiceFrom.setStyle("-fx-background-color:#000000;-fx-background-radius:10;-fx-text-fill:#000000;-fx-font-size:16px;");
		ChoiceTo.setStyle("-fx-background-color:#000000;-fx-background-radius:10;-fx-text-fill:#000000;-fx-font-size:16px;");
		ChoiceDeptTime.setStyle("-fx-background-color:#000000;-fx-background-radius:10;-fx-text-fill:#000000;-fx-font-size:16px;");
		ChoiceFrom.setStyle("-fx-background-color:#000000;-fx-background-radius:10;-fx-text-fill:#000000;-fx-font-size:16px;");
		ChoiceTo.setStyle("-fx-background-color:#000000;-fx-background-radius:10;-fx-text-fill:#000000;-fx-font-size:16px;");
		ChoiceFlight.setStyle("-fx-background-color:#000000;-fx-background-radius:10;-fx-text-fill:#000000;-fx-font-size:16px;");
		ChoiceClass.setStyle("-fx-background-color:#000000;-fx-background-radius:10;-fx-text-fill:#000000;-fx-font-size:16px;");
		DeptDate.setStyle("-fx-background-color:#000000;-fx-background-radius:10;-fx-text-fill:#000000;-fx-font-size:16px;");
		NOS.setStyle("-fx-background-color:#000000;-fx-background-radius:10;-fx-text-fill:#000000;-fx-font-size:16px;");
		Mode.setStyle("-fx-background-color:#6528F7;-fx-background-radius:10;-fx-text-fill:#000000;-fx-font-size:16px;");;
		Assign.setStyle("-fx-background-color:#6528F7;-fx-background-radius:10;");
		Previous.setStyle("-fx-background-color:#6528F7;-fx-background-radius:10;");
		WelcomeMsg.setStyle("-fx-text-fill:#6528F7;-fx-font-size:27px;-fx-font-weight:Bold");
	}
}
//Real works
	public void assignPassenger(ActionEvent event)throws Exception {
 		if(Name.getText().isEmpty() && Nationality.getText().isEmpty() && Email.getText().isEmpty()&& Phonenumber.getText().isEmpty() && EmerPhoneNum.getText().isEmpty() && DOB.getValue().isEqual(null) && POB.getText().isEmpty() && ChoiceGen.getValue().isEmpty() && PCN.getText().isEmpty() && NOS.getValue()==0 && ChoiceFrom.getValue().isEmpty() && ChoiceTo.getValue().isEmpty() && DeptDate.getValue().isEqual(null) && ChoiceDeptTime.getValue().isEmpty() && ChoiceFlight.getValue().isEmpty()){
 			try {
 				Alert alert = new Alert(AlertType.CONFIRMATION);
 				alert.setTitle("Blank Fields");
 				alert.setHeaderText("Please Fill up all the missed/blank information");
 				// alert.setContentText("");

 				if (alert.showAndWait().get() == ButtonType.OK) {

 					Stage stage2 = new Stage();
 					// System.out.println("You successfully logged out");
 					stage2.close();
 				}
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
 		}
 		else if (isValidPhoneNumber(Phonenumber.getText())==false) {
 			try {
 				Alert alert = new Alert(AlertType.CONFIRMATION);
 				alert.setTitle("Invalid");
 				alert.setHeaderText("Invalid Phone Number!!!,Re-Enter Phone Number Please");
 				// alert.setContentText("");

 				if (alert.showAndWait().get() == ButtonType.OK) {

 					Stage stage2 = new Stage();
 					// System.out.println("You successfully logged out");
 					stage2.close();
 				}
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
         } 
 		else if (isValidPhoneNumber(EmerPhoneNum.getText())==false) {
 			try {
 				Alert alert = new Alert(AlertType.CONFIRMATION);
 				alert.setTitle("Invalid");
 				alert.setHeaderText("Invalid Emergency Phone Number!!!,Re-Enter Emergency Phone Number Please");
 				// alert.setContentText("");

 				if (alert.showAndWait().get() == ButtonType.OK) {

 					Stage stage2 = new Stage();
 					// System.out.println("You successfully logged out");
 					stage2.close();
 				}
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
        } 
 		else if (isValidEmail(Email.getText())==false) {
 			try {
 				Alert alert = new Alert(AlertType.CONFIRMATION);
 				alert.setTitle("Invalid");
 				alert.setHeaderText("Invalid E-Mail Adresss!!!,Re-Enter Email Adress Please");
 				// alert.setContentText("");

 				if (alert.showAndWait().get() == ButtonType.OK) {

 					Stage stage2 = new Stage();
 					// System.out.println("You successfully logged out");
 					stage2.close();
 				}
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
         
 		//
 		}
		else {
		name=Name.getText();
		nationality=Nationality.getText();
		email=Email.getText();
		phnnumber=Phonenumber.getText();
		emerphnum=EmerPhoneNum.getText();
		dob=DOB.getValue();
		pob=POB.getText();
		gender=ChoiceGen.getValue();
		pcn=PCN.getText();
		nos=(int) NOS.getValue();
		from=ChoiceFrom.getValue();
		to=ChoiceTo.getValue();
		deptdate=DeptDate.getValue();
		depttime=ChoiceDeptTime.getValue();
		flight=ChoiceFlight.getValue();
		seatclass=ChoiceClass.getValue();
		
		//
//		 System.out.println(name);
//		 System.out.println(dob);
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("TempInfo.txt"));
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("TempMail.txt"));
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		
		
		 try {
	            BufferedWriter writer=new BufferedWriter(new FileWriter("TempMail.txt"));
	            writer.write(email);
	            writer.close();
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
		 try {
	            BufferedWriter writer=new BufferedWriter(new FileWriter("TempInfo.txt"));
	            writer.write(name+"\n"+nationality+"\n"+email+"\n"+phnnumber+"\n"+emerphnum+"\n"+dob+"\n"+pob+"\n"+gender+"\n"+pcn+"\n"+nos+"\n"+from+"\n"+to+"\n"+deptdate+"\n"+depttime+"\n"+flight+"\n"+seatclass);            
	            writer.write("\n");
	            writer.close();
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
		
		//next scene 
		root = FXMLLoader.load(getClass().getResource("FareCounterScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		  
		}
	
	}
	public void previousScene(ActionEvent event)throws Exception{
		root = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhnumber() {
		return phnnumber;
	}

	public void setPhnumber(String phnumber) {
		this.phnnumber = phnumber;
	}

	public String getEmerphnum() {
		return emerphnum;
	}

	public void setEmerphnum(String emerphnum) {
		this.emerphnum = emerphnum;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPob() {
		return pob;
	}

	public void setPob(String pob) {
		this.pob = pob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPcn() {
		return pcn;
	}

	public void setPcn(String pcn) {
		this.pcn = pcn;
	}

	public int getNos() {
		return nos;
	}

	public void setNos(int nos) {
		this.nos = nos;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDepttime() {
		return depttime;
	}

	public void setDepttime(String depttime) {
		this.depttime = depttime;
	}

	public LocalDate getDeptdate() {
		return deptdate;
	}

	public void setDeptdate(LocalDate deptdate) {
		this.deptdate = deptdate;
	}

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}
	public String getSeatClass(){
		return seatclass;
	}
	public void setSeatClass(String seatclass) {
		this.seatclass=seatclass;
	}
	public static boolean isValidEmail(String email) {
        // Define the regular expression for a valid email address
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        
        // Create a Pattern object
        Pattern pattern = Pattern.compile(emailRegex);
        
        // Create matcher object
        Matcher matcher = pattern.matcher(email);
        
        // Return whether the email matches the pattern
        return matcher.matches();
    }
	public static boolean isValidPhoneNumber(String phoneNumber) {
        // Define the regular expression for a valid phone number
        // This example assumes a simple format: digits with optional dashes
        String phoneRegex = "^[0-9-]+$";
        
        // Create a Pattern object
        Pattern pattern = Pattern.compile(phoneRegex);
        
        // Create matcher object
        Matcher matcher = pattern.matcher(phoneNumber);
        
        // Return whether the phone number matches the pattern
        return matcher.matches();
    }

	
}
