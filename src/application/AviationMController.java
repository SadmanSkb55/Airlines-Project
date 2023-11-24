package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AviationMController extends ControllerAbs {
	ControllerAbs c1=new ControllerAbs();
	@FXML
	private Stage stage;
	@FXML
	 private Scene scene;
	@FXML
	 private Parent root;
	@FXML
	private Button b1;
	@FXML
	private Button b2;
	@FXML
	private Button b3;
	@FXML
	private Button b4;
	@FXML
	private Button b5;
	
	public void avair(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("AvailScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();	 
	}
public void flights(ActionEvent event) {
	try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FlightLoader.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Add Flights");
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
	}
public void destin(ActionEvent event) {
	try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DestinationLoader.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Add Destinations");
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public void depts(ActionEvent event) {
	try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DeptLoader.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("NoticeBoard");
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public void previous(ActionEvent event) throws IOException {
	root = FXMLLoader.load(getClass().getResource("AdminScene.fxml"));
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();	
}
	

}
