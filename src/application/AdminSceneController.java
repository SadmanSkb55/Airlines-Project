package application;

import java.io.BufferedWriter;
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

public class AdminSceneController extends ControllerAbs{
	ControllerAbs c1=new ControllerAbs();
   @FXML
   private Button Employee;
   @FXML
   private Button Notice;
   @FXML
   private Button Flight;
   @FXML
   private Button Security;
   @FXML
   private Button Aviation;
   @FXML
   private Button Finance;
   @FXML
   private Button RandT;
   @FXML
   private Button Passenger;
   @FXML
   private Button Weather;
   @FXML
   private Button FileM;
   @FXML
   private Label Name;
   @FXML
	private Stage stage;
	@FXML
	 private Scene scene;
	@FXML
	 private Parent root;
	
	
	public void Employeem(ActionEvent event)throws Exception{	
		root = FXMLLoader.load(getClass().getResource("EmployeeMScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();	  
	}
	public void NoticeM(ActionEvent event)throws Exception{	
		 try {
	         FXMLLoader loader = new FXMLLoader(getClass().getResource("NoticeMScene.fxml"));
	         Parent root = loader.load();
	         Stage stage = new Stage();
	         stage.setTitle("NoticeBoard");
	         stage.setScene(new Scene(root));
	         stage.show();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	}
	public void FlightM(ActionEvent event)throws Exception{	
		 try {
	         FXMLLoader loader = new FXMLLoader(getClass().getResource("FlightMScene.fxml"));
	         Parent root = loader.load();
	         Stage stage = new Stage();
	         stage.setTitle("FlightStats");
	         stage.setScene(new Scene(root));
	         stage.show();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }  
	}
	public void SecurityM(ActionEvent event)throws Exception{	
		try {
	         FXMLLoader loader = new FXMLLoader(getClass().getResource("SecurityM.fxml"));
	         Parent root = loader.load();
	         Stage stage = new Stage();
	         stage.setTitle("Security");
	         stage.setScene(new Scene(root));
	         stage.show();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }  	  
	}
	public void AviationM(ActionEvent event)throws Exception{	
		root = FXMLLoader.load(getClass().getResource("AviationM.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();	  
	}
	public void FinanceM(ActionEvent event)throws Exception{	
		try {
	         FXMLLoader loader = new FXMLLoader(getClass().getResource("FinanceMScene.fxml"));
	         Parent root = loader.load();
	         Stage stage = new Stage();
	         stage.setTitle("Finance");
	         stage.setScene(new Scene(root));
	         stage.show();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }  
	}
	public void RandTM(ActionEvent event)throws Exception{	
		root = FXMLLoader.load(getClass().getResource("RandTScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();	  
	}
	public void PassengerM(ActionEvent event)throws Exception{	
		try {
	         FXMLLoader loader = new FXMLLoader(getClass().getResource("PassInfoScene.fxml"));
	         Parent root = loader.load();
	         Stage stage = new Stage();
	         stage.setTitle("Passengers Info");
	         stage.setScene(new Scene(root));
	         stage.show();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }  
	}
   
	public void WeatherM(ActionEvent event)throws Exception{
		
		try {
	         FXMLLoader loader = new FXMLLoader(getClass().getResource("WeatherMScene.fxml"));
	         Parent root = loader.load();
	         Stage stage = new Stage();
	         stage.setTitle("Weather Forecast");
	         stage.setScene(new Scene(root));
	         stage.show();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }  
			  
	}
	public void FileM(ActionEvent event)throws Exception{	
		
		try {
	         FXMLLoader loader = new FXMLLoader(getClass().getResource("FileMScene.fxml"));
	         Parent root = loader.load();
	         Stage stage = new Stage();
	         stage.setTitle("File Handler");
	         stage.setScene(new Scene(root));
	         stage.show();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }    
	}
   public void previousScene(ActionEvent event)throws Exception{	
		root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();	  
	}
	}

   
	
	
	
	
	
	
	
	
	

