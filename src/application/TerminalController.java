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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TerminalController extends ControllerAbs implements Initializable{
	ControllerAbs c1=new ControllerAbs();
	@FXML
	private Label warning;
	@FXML
	private Stage stage;
	@FXML
	 private Scene scene;
	@FXML
	 private Parent root;
	@FXML
	private Label code;
	@FXML
	private Button proceed;
	@FXML
	private Button previous;
	@FXML
	private ChoiceBox<String> terminal;
	@FXML
	private String [] terminals= {"Terminal-1", "Terminal-2","Terminal-3","Domestic terminal","Terminal D(D)", "International Terminal(I)", "Terminal IN(IN)", "Terminal 1(T1)","Domestic Terminal","International Terminal"};
	@FXML
	private ChoiceBox<String> gate;
	@FXML
	private String []gates= {"A","B","C","VIP","Gate-1","Domestic","Gate A"};
	
	private String nameR;
//	private String nosR;
    private String nationalityR;
    private String emailR;
    private String phnnumberR;
    private String emerphnumR;
    private String dobR;
    private String pobR;
    private String genderR;
    private String pcnR;
    private int nosR;
    private String fromR;
    private String toR;
    private String depttimeR;
    private String deptdateR;
    private String flightR;
    private String seatclassR;
    private String fareR;
	
	String terminalinit;
	String gateinit;
	
	public TerminalController(String gateinit, String terminalinit) {
		this.gateinit=gateinit;
		this.terminalinit=terminalinit;
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		terminal.getItems().addAll(terminals);
		terminal.setOnAction(this::getTerminals);
		
		gate.getItems().addAll(gates);
		gate.setOnAction(this::getGates);
	}
	 private void getTerminals(ActionEvent event) {
	     terminalinit = terminal.getValue();
		}
	 private void getGates(ActionEvent event) {
	    	 gateinit = gate.getValue();
		}
	 
	 public TerminalController () {
			this.nameR="Not yet Assigned";
			this.nationalityR="Not yet Assigned";
			this.emailR="Not yet Assigned";
			this.phnnumberR="Not yet Assigned";
			this.emerphnumR="Not yet Assigned";
			//this.dob="Not yet Assigned";
			this.pobR="Not yet Assigned";
			this.genderR="Not yet Assigned";
			this.pcnR="Not yet Assigned";
			this.nosR=0;
			this.fromR="Not yet Assigned";
			this.toR="Not yet Assigned";
			this.depttimeR="Not yet Assigned";
			//this.deptdate="Not yet Assigned";
			this.flightR="Not yet Assigned"; 
			this.seatclassR="Not yet Assigned";
			this.fareR="null";
		}
	 
	 public void proceed(ActionEvent event)throws Exception {
		 if(gateinit.isEmpty()&& terminalinit.isEmpty()) {
			 warning.setText("Please enter them");
		 }
		 else{
			 try {
		         BufferedReader reader=new BufferedReader(new FileReader("TempInfo.txt"));
		         String line;
		         int linenum=0;
		         while ((line=reader.readLine())!=null) {
		         	linenum++;
		         	if(linenum==1) {
		             
		             nameR=line;
		         	}
		         	if(linenum==2) {
		         		
		         		nationalityR=line;
		         	}
		         	if(linenum==3) {
		         		
		         		emailR=line;
		         	}
		         	if(linenum==4) {
		         		
		         		phnnumberR=line;
		         	}
		         	if(linenum==5) {
		         		
		         		emerphnumR=line;
		         	}
		         	if(linenum==6) {
		         		
		         		dobR=line;
		         	}
		         	if(linenum==7) {
		         		
		         		pobR=line;
		         	}
		         	if(linenum==8) {
		         		
		         		genderR=line;
		         	}
		         	if(linenum==9) {
		         		
		         		pcnR=line;
		         	}
		         	if(linenum==10) {
		         		
		         		nosR=Integer.parseInt(line);
		         	}
		         	if(linenum==11) {
		         		
		         		fromR=line;
		         	}
		         	if(linenum==12) {
		         		
		         		toR=line;
		         	}
		         	if(linenum==13) {
		         		
		         		deptdateR=line;
		         	}
		         	if(linenum==14) {
		         		
		         		depttimeR=line;
		         	}
		         	if(linenum==15) {
		         		
		         		flightR=line;
		         	}
		         	if(linenum==16) {
		         		
		         		seatclassR=line;
		         	}
		         	if(linenum==17) {
		         		fareR=line;
		         	}
		         }
		         reader.close();
		     } catch (FileNotFoundException e) {
		         throw new RuntimeException(e);
		     } catch (IOException e) {
		         throw new RuntimeException(e);
		     }	 
			 
			 
			 try {
		            BufferedWriter writer=new BufferedWriter(new FileWriter("TempInfo.txt"));
		            writer.write(nameR+"\n"+nationalityR+"\n"+emailR+"\n"+phnnumberR+"\n"+emerphnumR+"\n"+dobR+"\n"+pobR+"\n"+genderR+"\n"+pcnR+"\n"+nosR+"\n"+fromR+"\n"+toR+"\n"+deptdateR+"\n"+depttimeR+"\n"+flightR+"\n"+seatclassR+"\n"+fareR);            
		            writer.write("\n"+terminalinit);
		            writer.write("\n"+gateinit);
		            writer.close();
		        } catch (IOException e) {
		            throw new RuntimeException(e);
		        }
			 
			 root = FXMLLoader.load(getClass().getResource("TicketPrintScene.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				  scene = new Scene(root);
				  stage.setScene(scene);
				  stage.show();
		 }
	 }
	 
	 
	public void previousScene(ActionEvent event)throws Exception{	
		
		root = FXMLLoader.load(getClass().getResource("FareCounterScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		  
		  
	}

}
