package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AESceneController implements CommonScene{
	@FXML
	private Stage stage;
	@FXML
	 private Scene scene;
	@FXML
	 private Parent root;
	@Override
	public void StatusAE(ActionEvent event)throws Exception{	
		 try {
	         FXMLLoader loader = new FXMLLoader(getClass().getResource("StatusComm.fxml"));
	         Parent root = loader.load();
	         Stage stage = new Stage();
	         stage.setTitle("NoticeBoard");
	         stage.setScene(new Scene(root));
	         stage.show();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	}
	
	public void FlightsAE(ActionEvent event)throws Exception{	
		 try {
	         FXMLLoader loader = new FXMLLoader(getClass().getResource("FlightsComm.fxml"));
	         Parent root = loader.load();
	         Stage stage = new Stage();
	         stage.setTitle("Flights");
	         stage.setScene(new Scene(root));
	         stage.show();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	}
	public void WeatherAE(ActionEvent event)throws Exception{	
		 try {
	         FXMLLoader loader = new FXMLLoader(getClass().getResource("WeatherComm.fxml"));
	         Parent root = loader.load();
	         Stage stage = new Stage();
	         stage.setTitle("Weather");
	         stage.setScene(new Scene(root));
	         stage.show();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	}
	@Override
	public void FlightstatAE(ActionEvent event)throws Exception{	
		 try {
	         FXMLLoader loader = new FXMLLoader(getClass().getResource("FlightStatComm.fxml"));
	         Parent root = loader.load();
	         Stage stage = new Stage();
	         stage.setTitle("Flight Status");
	         stage.setScene(new Scene(root));
	         stage.show();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	}
	@Override
	public void SReqAE(ActionEvent event)throws Exception{	
		 try {
	         FXMLLoader loader = new FXMLLoader(getClass().getResource("ServiceComm.fxml"));
	         Parent root = loader.load();
	         Stage stage = new Stage();
	         stage.setTitle("Service Request");
	         stage.setScene(new Scene(root));
	         stage.show();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	}
	@Override
	public void ComandRepAE(ActionEvent event)throws Exception{	
		 try {
	         FXMLLoader loader = new FXMLLoader(getClass().getResource("ComplaintsComm.fxml"));
	         Parent root = loader.load();
	         Stage stage = new Stage();
	         stage.setTitle("Complaints and Report");
	         stage.setScene(new Scene(root));
	         stage.show();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	}
	@Override
	public void NoticeM(ActionEvent event)throws Exception{	
		 try {
	         FXMLLoader loader = new FXMLLoader(getClass().getResource("NoticeComm.fxml"));
	         Parent root = loader.load();
	         Stage stage = new Stage();
	         stage.setTitle("Notice Board");
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
