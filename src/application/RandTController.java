package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class RandTController extends ControllerAbs implements Initializable{
	
	ControllerAbs c1=new ControllerAbs();

	@FXML
	private ChoiceBox<String> port;
	@FXML
	private ChoiceBox<String> flight;
	@FXML
	private ChoiceBox<String> to;
	@FXML
	private ChoiceBox<String> runwayc;
	@FXML
	private ChoiceBox<String> status;
	@FXML
	private ChoiceBox<String> condition;
	@FXML
	private ChoiceBox<String> arrival;
	@FXML
	private ChoiceBox<String> depurture;
	@FXML
	private ChoiceBox<String> terminal;
	@FXML
	private ChoiceBox<String> status2;
	@FXML
	private TextArea t1;
	 @FXML
		private Stage stage;
		@FXML
		 private Scene scene;
		@FXML
		 private Parent root;
	
	private String [] ports= {"Hazrat Shahjalal International Airport","Shah Amanat International Airport","Osmani International Airport"};
	private String [] runcodes= {"Runway1","Runway2","Runway3","RunwayV","RunwayD","RunwayI","RunwayF"};
	private String [] staus1= {"Occupied","Not Occupied"};
	private String [] condi= {"Under Maintanace","On Rest"};
	private String [] arrivals= {"10;00","11:00","1:00","3:40"};
	private String [] termi= {"Terminal-1", "Terminal-2","Terminal-3","Domestic terminal","Terminal D(D)", "International Terminal(I)", "Terminal IN(IN)", "Terminal 1(T1)","Domestic Terminal","International Terminal"};
	private String [] status2s= {"Zoned","Out of Task"};
	private String[] array1=new String[100];
	private String[] array2=new String[100];
	private String[] array3=new String[100];
	
	private String portss;
	private String flightss;
	private String toss;
	private String rcss;
	private String s1s;
	private String conds;
	private String arrs;
	private String depts;
	private String termss;
	private String s2s;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 try {
	            BufferedReader reader=new BufferedReader(new FileReader("Flights.txt"));
	            String line;
	            int i=0;
	            while ((line= reader.readLine())!=null) {
	                this.array1[i]=line;
	                i++;
	            }
	            reader.close();
	        } catch (FileNotFoundException e) {
	            throw new RuntimeException(e);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
		 try {
	            BufferedReader reader=new BufferedReader(new FileReader("Times.txt"));
	            String line;
	            int i=0;
	            while ((line= reader.readLine())!=null) {
	                this.array2[i]=line;
	                i++;
	            }
	            reader.close();
	        } catch (FileNotFoundException e) {
	            throw new RuntimeException(e);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
		 try {
	            BufferedReader reader=new BufferedReader(new FileReader("Destinations.txt"));
	            String line;
	            int i=0;
	            while ((line= reader.readLine())!=null) {
	                this.array3[i]=line;
	                i++;
	            }
	            reader.close();
	        } catch (FileNotFoundException e) {
	            throw new RuntimeException(e);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }	
		 port.getItems().addAll(ports);
			port.setOnAction(this::getports);
			 runwayc.getItems().addAll(runcodes);
				runwayc.setOnAction(this::getrunways);
				 status.getItems().addAll(staus1);
					status.setOnAction(this::getstatus);
					condition.getItems().addAll(condi);
					condition.setOnAction(this::getcondi);
					arrival.getItems().addAll(arrivals);
					arrival.setOnAction(this::getarrival);
					terminal.getItems().addAll(termi);
					terminal.setOnAction(this::gettermi);
					status2.getItems().addAll(status2s);
					status2.setOnAction(this::getstatus2);
					flight.getItems().addAll(array1);
					flight.setOnAction(this::getflights);
					to.getItems().addAll(array3);
					to.setOnAction(this::gettos);
					depurture.getItems().addAll(array2);
					depurture.setOnAction(this::gettimes);
		 
	}
	private void getflights(ActionEvent event) {
   	 flightss = flight.getValue();
	}
	private void gettimes(ActionEvent event) {
   	depts = depurture.getValue();
	}
	private void gettos(ActionEvent event) {
   	toss = to.getValue();
	}
	private void getports(ActionEvent event) {
   	 portss = port.getValue();
	}
	private void getrunways(ActionEvent event) {
   	rcss = runwayc.getValue();
	}
	private void getstatus(ActionEvent event) {
   	s1s = status.getValue();
	}
	private void getcondi(ActionEvent event) {
		portss=port.getValue();
	}
	private void getarrival(ActionEvent event) {
   	 arrs = arrival.getValue();
	}
	private void gettermi(ActionEvent event) {
   	termss = terminal.getValue();
	}
	private void getstatus2(ActionEvent event) {
   	s2s = status2.getValue();
	}
	
	
	public void assign(ActionEvent event) {
		try {
            BufferedWriter writer=new BufferedWriter(new FileWriter("RandTs.txt"));
            writer.write(flightss+"/"+depts+"/"+toss+"/"+portss+"/"+rcss+"/"+s1s+portss+"/"+arrs+"/"+termss+"/"+"s2s"+"\n"+t1.getText());
          
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
		try {
	         FXMLLoader loader = new FXMLLoader(getClass().getResource("Confirmation.fxml"));
	         Parent root = loader.load();
	         Stage stage = new Stage();
	         stage.setTitle("Confirmation");
	         stage.setScene(new Scene(root));
	         stage.show();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	}
	public void previousScene(ActionEvent event)throws Exception{	
		root = FXMLLoader.load(getClass().getResource("AdminScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();	  
	}
	
}
