package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginController extends Users {

	@FXML
	private Label myLabel;
	@FXML
	private Label myLabel2;
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	@FXML
	private Button myButton;
	
	private String checker1;
	private String checker2;
	@FXML
	private Stage stage;
	@FXML
	 private Scene scene;
	@FXML
	 private Parent root;
	
	
	public void checkUser(ActionEvent event) throws Exception{	
		try {
			checker1=username.getText();
			checker2=password.getText();
		if (checkAdmin(checker1, checker2)) {
			myLabel.setText("You are now signed up!");
			root = FXMLLoader.load(getClass().getResource("AdminScene.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  stage.setScene(scene);
			  stage.show();
			  }
		 if (checkAirplaneEmployee(checker1, checker2)) {
					myLabel.setText("You are now signed up!");
					root = FXMLLoader.load(getClass().getResource("AirEmployee.fxml"));
					  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					  scene = new Scene(root);
					  stage.setScene(scene);
					  stage.show();
			  }
			   if (checkTicketAgentX(checker1, checker2)) {
				  
					myLabel.setText("You are now signed up!");
					root = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));
					  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					  scene = new Scene(root);
					  stage.setScene(scene);
					  stage.show();
			  }
			     if (checkTerminalEmployeeX(checker1, checker2)) {
					myLabel.setText("You are now signed up!");
					root = FXMLLoader.load(getClass().getResource("TerminalEmployee.fxml"));
					  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					  scene = new Scene(root);
					  stage.setScene(scene);
					  stage.show();
			  }
         else if(username.getText().isEmpty() && password.getText().isEmpty()) {
            myLabel2.setText("Please enter your data.");
        }
		else {
			myLabel2.setText("Enter correct Username/Password");
			
		}
		}catch (Exception e) {
			myLabel2.setText("error");
			e.printStackTrace();
		}
	}
	 private static boolean checkAdmin(String enteredUsername, String enteredPassword) {
	        String filePath = "Administration.txt"; 

	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;

	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(":");
	                if (parts.length >= 2) {
	                String storedUsername = parts[0];
	                String storedPassword = parts[1];
//	                System.out.println("Entered Username: " + enteredUsername);
//	                System.out.println("Entered Password: " + enteredPassword);
//	                System.out.println("Stored Username: " + storedUsername);
//	                System.out.println("Stored Password: " + storedPassword);
	                if (enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword)) {
	                    return true;  
	                }
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return false; // Credentials do not match
	    }
	 private static boolean checkAirplaneEmployee(String enteredUsername, String enteredPassword) {
	        String filePath = "PlaneEmployee.txt"; 

	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;

	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(":");
	                if (parts.length >= 2) {
	                String storedUsername = parts[0];
	                String storedPassword = parts[1];
//	                System.out.println("Entered Username: " + enteredUsername);
//	                System.out.println("Entered Password: " + enteredPassword);
//	                System.out.println("Stored Username: " + storedUsername);
//	                System.out.println("Stored Password: " + storedPassword);
	                if (enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword)) {
	                    return true;  
	                }
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return false; // Credentials do not match
	    }
	 private static boolean checkTicketAgentX(String enteredUsername, String enteredPassword) {
	        String filePath = "TicketAgent.txt"; 

	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;

	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(":");
	                if (parts.length >= 2) {
	                String storedUsername = parts[0];
	                String storedPassword = parts[1];
//	                
//	                System.out.println("Entered Username: " + enteredUsername);
//	                System.out.println("Entered Password: " + enteredPassword);
//	                System.out.println("Stored Username: " + storedUsername);
//	                System.out.println("Stored Password: " + storedPassword);
	                
	                if (enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword)) {
	                	//System.out.println("Credentials match!");
	                    return true;  
	                }
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return false; // Credentials do not match
	    }
	 private static boolean checkTerminalEmployeeX(String enteredUsername, String enteredPassword) {
	        String filePath = "TerminalEmployee.txt"; 

	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;

	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(":");
	                if (parts.length >= 2) {
	                String storedUsername = parts[0];
	                String storedPassword = parts[1];
//	                System.out.println("Entered Username: " + enteredUsername);
//	                System.out.println("Entered Password: " + enteredPassword);
//	                System.out.println("Stored Username: " + storedUsername);
//	                System.out.println("Stored Password: " + storedPassword);
	                if (enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword)) {
	                    return true;  
	                }
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return false; // Credentials do not match
	    }
	 
	}

