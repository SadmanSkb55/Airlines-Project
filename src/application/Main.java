package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
			//Group root=new Group();
			Scene scene = new Scene(root,1500,750);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Image icon=new Image(getClass().getResourceAsStream("AirLig.jpg"));
			primaryStage.getIcons().add(icon);

			primaryStage.setResizable(false);
			primaryStage.setTitle("Winterfell Airlines");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setOnCloseRequest(event -> {
				event.consume();
				logout(primaryStage);	
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	} 
public void logout(Stage primaryStage){	
		try {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You're about to logout!");
		alert.setContentText("Do you want to save before exiting?");
		
		if (alert.showAndWait().get() == ButtonType.OK){
			
			//System.out.println("You successfully logged out");
			primaryStage.close();
		} 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ControllerAbs c1=new ControllerAbs();
		EmployeeX e=new EmployeeX("","");
		LoginController l=new LoginController();
		RecuitController r=new RecuitController();
		TicketPrintController tp=new TicketPrintController();
		AESceneController s=new AESceneController();
		AvailAirCon av=new AvailAirCon(); 
		FareCounterController fc=new FareCounterController();
		
		
		launch(args);
	}
}
