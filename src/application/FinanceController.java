package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FinanceController extends ControllerAbs {
	ControllerAbs c1=new ControllerAbs();
	@FXML
	private Button button1;
	@FXML
	private Button button2;
	@FXML
	private Button button3;
	@FXML
	private Stage stage;
	@FXML
	 private Scene scene;
	@FXML
	 private Parent root;
	
	public void Revenue(ActionEvent event)throws Exception{	
		 try {
	         FXMLLoader loader = new FXMLLoader(getClass().getResource("RevScene.fxml"));
	         Parent root = loader.load();
	         Stage stage = new Stage();
	         stage.setTitle("Revenue Calculator");
	         stage.setScene(new Scene(root));
	         stage.show();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	}
	public void AllFinance(ActionEvent event)throws Exception{	
		 try {
	         FXMLLoader loader = new FXMLLoader(getClass().getResource("AllFSCene.fxml"));
	         Parent root = loader.load();
	         Stage stage = new Stage();
	         stage.setTitle("All Financial Data");
	         stage.setScene(new Scene(root));
	         stage.show();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	}
	public void Total(ActionEvent event)throws Exception{	
		 try {
	         FXMLLoader loader = new FXMLLoader(getClass().getResource("TotalCalcScene.fxml"));
	         Parent root = loader.load();
	         Stage stage = new Stage();
	         stage.setTitle("Total Calculator");
	         stage.setScene(new Scene(root));
	         stage.show();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	}
	
	
}
