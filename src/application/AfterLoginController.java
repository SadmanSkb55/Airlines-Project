package application;

import java.io.IOException;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.util.EventObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AfterLoginController extends ControllerAbs {
	ControllerAbs c1=new ControllerAbs();
	@FXML
	private Button Start;
	@FXML
	private Button logout;
	@FXML
	private Button previous;
	@FXML
	private Button notice;
	@FXML
	private Button reserve;
	@FXML
	private Button cancel;
	@FXML
	private AnchorPane scenePane;
	@FXML
	private Stage stage;
	@FXML
	 private Scene scene;
	@FXML
	 private Parent root;

	
	public void bufferScene(ActionEvent event) throws Exception {
		root = FXMLLoader.load(getClass().getResource("TicketScene.fxml"));
		//EventObject event = null;
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	public void previousScene(ActionEvent event)throws Exception{
		root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
		//EventObject event = null;
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
public void Logout(ActionEvent event) throws Exception{
	Stage stage = (Stage) scenePane.getScene().getWindow();
    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("LoginScene.fxml"))));
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You're about to logout!");
		alert.setContentText("Do you want to save before exiting?: ");
		
		if (scenePane != null) {
	        Stage stage1 = (Stage) scenePane.getScene().getWindow();
	        if (stage1 != null) {
	            stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("LoginScene.fxml"))));
	            stage1.show();
	        }
	    }
}
public void reservation(ActionEvent event) throws Exception {
	root = FXMLLoader.load(getClass().getResource("ReservationScene.fxml"));
	//EventObject event = null;
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
}
public void cancellation(ActionEvent event) throws Exception {
	root = FXMLLoader.load(getClass().getResource("CancellationScene.fxml"));
	//EventObject event = null;
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
}
public void noticeboard(ActionEvent event) throws Exception {
	 try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("NoticeScene.fxml"));
         Parent root = loader.load();
         Stage stage = new Stage();
         stage.setTitle("NoticeBoard and Depurtures");
         stage.setScene(new Scene(root));
         stage.show();
     } catch (IOException e) {
         e.printStackTrace();
     }
}



}
