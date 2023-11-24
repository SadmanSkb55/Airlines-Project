package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ReserveController extends ControllerAbs  {
	ControllerAbs c1=new ControllerAbs();
	@FXML
	private TextArea area;
	@FXML
	private Label warning;
	@FXML
	private Button proceed; 
	@FXML
	private Button search; 
	@FXML
	private Button previous; 
	@FXML
	private Button cancel; 
	@FXML
	private Stage stage;
	@FXML
	 private Scene scene;
	@FXML
	 private Parent root;
	@FXML
	private TextField searchbar;
	
	private String nameR;
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
    private String searchval;
    
    
    public ReserveController() {
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
	}
	
	
	public void searcher(ActionEvent event)throws Exception{
		searchval=searchbar.getText();
		boolean foundSearchTerm = false;
		try {
            FileReader fileReader = new FileReader("Notices.txt");
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            StringBuilder notif = new StringBuilder();
	         
	         while ((line=reader.readLine())!=null) {
	        	 if (line.contains(searchval)) {
	                    foundSearchTerm = true;
	                    break; 
	                }
	        	 }
	         if (foundSearchTerm) {
	                for (int i = 1; i < 18; i++) {
	                    if ((line = reader.readLine()) != null) {
	                    	 notif.append(line).append("\n");
	                    } else {
	                        break; // End of file reached
	                    }area.setText(notif.toString());

	                }
	         }
	         else {
	        	 warning.setText("Seached Data Not Found");
	         }
		 }
		 catch(Exception e) {
	        	 
	         }
	
	}
	public void proceed(ActionEvent event)throws Exception{
		try {
	         BufferedReader reader=new BufferedReader(new FileReader("Reservation.txt"));
	         String line;
	         int linenum=0;
	        
	         while ((line=reader.readLine())!=null) {
	         	linenum++;
	         	if(linenum==1) {
	           
	             nameR=line;
	         	}
	         	 if(searchval.equalsIgnoreCase(nameR)) {
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
	         }
	         }
	         reader.close();
	     } catch (FileNotFoundException e) {
	         throw new RuntimeException(e);
	     } catch (IOException e) {
	         throw new RuntimeException(e);
	     }	
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("TempInfo.txt"))) {
            writer.write(nameR+"\n"+nationalityR+"\n"+emailR+"\n"+phnnumberR+"\n"+emerphnumR+"\n"+dobR+"\n"+pobR+"\n"+genderR+"\n"+pcnR+"\n"+nosR+"\n"+fromR+"\n"+toR+"\n"+deptdateR+"\n"+depttimeR+"\n"+flightR+"\n"+seatclassR);            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
		root = FXMLLoader.load(getClass().getResource("FareCounterScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	public void cancel(ActionEvent event)throws Exception {
		searchval=searchbar.getText();
		boolean foundSearchTerm = false;
		StringBuilder updatedContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader("Reservation.txt"))) {
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                
                if (currentLine.contains(searchval)) {
                    foundSearchTerm = true;
                    break; 
                }
                	else {
                		warning.setText("Seached Data Not Found");
                }
                updatedContent.append(currentLine).append("\n");
                
            }

            if (foundSearchTerm) {
                for (int i = 0; i < 18; i++) {
                    reader.readLine();
                }
            }

            while ((currentLine = reader.readLine()) != null) {
                updatedContent.append(currentLine).append("\n");
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Reservation.txt"))) {
            writer.write(updatedContent.toString());
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        
	}
	public void previous(ActionEvent event)throws Exception{
		root = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
}
