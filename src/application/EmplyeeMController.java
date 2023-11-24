package application;

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

public class EmplyeeMController extends ControllerAbs {
	ControllerAbs c1=new ControllerAbs();
	 @FXML
	   private Button Recuit;
	 @FXML
	   private Button Assign;
	 @FXML
	   private Button Abort;
	   @FXML
	   private Label Name;
	   @FXML
		private Stage stage;
		@FXML
		 private Scene scene;
		@FXML
		 private Parent root;
		
		public void previousScene(ActionEvent event)throws Exception{	
			root = FXMLLoader.load(getClass().getResource("AdminScene.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  stage.setScene(scene);
			  stage.show();	  
		}
		
		public void RecruitScene(ActionEvent event) throws Exception {
			 try {
		         FXMLLoader loader = new FXMLLoader(getClass().getResource("RecuitScene.fxml"));
		         Parent root = loader.load();
		         Stage stage = new Stage();
		         stage.setTitle("Recuitment");
		         stage.setScene(new Scene(root));
		         stage.show();
		     } catch (IOException e) {
		         e.printStackTrace();
		     }
		}
		public void AssignScene(ActionEvent event)throws Exception{	
			try {
		         FXMLLoader loader = new FXMLLoader(getClass().getResource("AssignScene.fxml"));
		         Parent root = loader.load();
		         Stage stage = new Stage();
		         stage.setTitle("Assign");
		         stage.setScene(new Scene(root));
		         stage.show();
		     } catch (IOException e) {
		         e.printStackTrace();
		     }  
		}
		public void AbortScene(ActionEvent event)throws Exception{	
			try {
		         FXMLLoader loader = new FXMLLoader(getClass().getResource("AbortScene.fxml"));
		         Parent root = loader.load();
		         Stage stage = new Stage();
		         stage.setTitle("Remove");
		         stage.setScene(new Scene(root));
		         stage.show();
		     } catch (IOException e) {
		         e.printStackTrace();
		     }
		}
		public void ReportReader(ActionEvent event)throws Exception{	
			try {
		         FXMLLoader loader = new FXMLLoader(getClass().getResource("ReportR.fxml"));
		         Parent root = loader.load();
		         Stage stage = new Stage();
		         stage.setTitle("Remove");
		         stage.setScene(new Scene(root));
		         stage.show();
		     } catch (IOException e) {
		         e.printStackTrace();
		     }
		}
		public void RequestReader(ActionEvent event)throws Exception{	
			try {
		         FXMLLoader loader = new FXMLLoader(getClass().getResource("RequestR.fxml"));
		         Parent root = loader.load();
		         Stage stage = new Stage();
		         stage.setTitle("Remove");
		         stage.setScene(new Scene(root));
		         stage.show();
		     } catch (IOException e) {
		         e.printStackTrace();
		     }
		}
		
}
