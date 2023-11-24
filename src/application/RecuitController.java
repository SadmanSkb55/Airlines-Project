package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RecuitController implements Initializable{
@FXML
private TextField Name;
@FXML
private TextField NID;
@FXML
private TextField Email;
@FXML
private TextField PhNum;
@FXML
private TextField Pass;
@FXML
private ChoiceBox<String> Dept;
@FXML
private String[] DeptChoice= {"Administration","TicketingAgent","Airplane","Terminal"};
@FXML
private PasswordField Repass;
@FXML
private Button recuit;
@FXML
private Button previous;
@FXML
private Label warning;
@FXML
	private Stage stage;
	@FXML
	 private Scene scene;
	@FXML
	 private Parent root;

private String name;
private String nid;
private String email;
private String phnumR;
private String DeptR;
private String passR;
private String repassR;

public RecuitController() {
	name="//";
	nid="//";
	email="//";
	phnumR="//";
	DeptR="//";
	passR="//";
	repassR="//";			
}
Department Admin = new Department("Admin");
Department Ticket = new Department("Ticket");
Department Airplane = new Department("Airplane");
Department Terminal = new Department("Terminal");



@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	Dept.getItems().addAll(DeptChoice);
	Dept.setOnAction(this::getDept);
}
 private void getDept(ActionEvent event) {
    	DeptR= Dept.getValue();
	}
public void recruuiter(ActionEvent event)throws Exception {
	
	if(Name.getText().isEmpty() && NID.getText().isEmpty()&& Email.getText().isEmpty() && PhNum.getText().isEmpty() && Dept.getValue().isEmpty() && Pass.getText().isEmpty() && Repass.getText().isEmpty()) {
		warning.setText("Please Enter All The Data");
	}
	else {
	this.name=Name.getText();
	this.nid=NID.getText();
	this.email=Email.getText();
	this.phnumR=PhNum.getText();
	this.DeptR=Dept.getValue();
	this.passR=Pass.getText();
	this.repassR=Repass.getText();
	if (Objects.equals(passR, repassR)) {
		warning.setText("Done!!!!!");
		try {
	        BufferedWriter writer=new BufferedWriter(new FileWriter("AllEmlpoyee.txt",true));
	        writer.write(name+"\n"+DeptR);
	        writer.close();
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
	if(DeptR.equalsIgnoreCase("Administration")) {
		Employee employee = new Employee(name, Admin);
	try {
        BufferedWriter writer=new BufferedWriter(new FileWriter("Admininfo.txt",true));
        writer.write("\n"+name+"\n"+nid+"\n"+email+"\n"+phnumR+"\n"+DeptR);
        writer.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
	try {
        BufferedWriter writer=new BufferedWriter(new FileWriter("Administration.txt",true));
        writer.write(name+":"+passR+"\n");
        writer.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }	
	}
	
	if(DeptR.equalsIgnoreCase("TicketingAgent")) {
		Employee employee = new Employee(name, Ticket);
		try {
	        BufferedWriter writer=new BufferedWriter(new FileWriter("TAinfo.txt",true));
	        writer.write("\n"+name+"\n"+nid+"\n"+email+"\n"+phnumR+"\n"+DeptR);
	        writer.close();
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
		try {
	        BufferedWriter writer=new BufferedWriter(new FileWriter("TicketAgent.txt",true));
	        writer.write(name+":"+passR+"\n");
	        writer.close();
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
		}
	
	if(DeptR.equalsIgnoreCase("Airplane")) {
		Employee employee = new Employee(name, Airplane);
		try {
	        BufferedWriter writer=new BufferedWriter(new FileWriter("Airplaneinfo.txt",true));
	        writer.write("\n"+name+"\n"+nid+"\n"+email+"\n"+phnumR+"\n"+DeptR);
	        writer.close();
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }	
		try {
	        BufferedWriter writer=new BufferedWriter(new FileWriter("PlaneEmployee.txt",true));
	        writer.write(name+":"+passR+"\n");
	        writer.close();
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
		}
	
	if(DeptR.equalsIgnoreCase("Terminal")) {
		Employee employee = new Employee(name, Terminal);
		try {
	        BufferedWriter writer=new BufferedWriter(new FileWriter("Terminfo.txt",true));
	        writer.write("\n"+name+"\n"+nid+"\n"+email+"\n"+phnumR+"\n"+DeptR);
	        writer.close();
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
		try {
	        BufferedWriter writer=new BufferedWriter(new FileWriter("TerminalEmployee.txt",true));
	        writer.write("\n"+name+":"+passR);
	        writer.close();
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
		}
	}else {
		warning.setText("Password didn't match");
	}
	}		
}
public void recruitandassign(ActionEvent event)throws Exception{
	if(Name.getText().isEmpty() && NID.getText().isEmpty()&& Email.getText().isEmpty() && PhNum.getText().isEmpty() && Dept.getValue().isEmpty() && Pass.getText().isEmpty() && Repass.getText().isEmpty()) {
		warning.setText("Please Enter All The Data");
	}
	else {
	this.name=Name.getText();
	this.nid=NID.getText();
	this.email=Email.getText();
	this.phnumR=PhNum.getText();
	this.DeptR=Dept.getValue();
	this.passR=Pass.getText();
	this.repassR=Repass.getText();
	if (Objects.equals(passR, repassR)) {
		try {
	        BufferedWriter writer=new BufferedWriter(new FileWriter("AllEmlpoyee.txt",true));
	        writer.write("\n"+name+"\n"+nid+"\n"+email+"\n"+phnumR+"\n"+DeptR);
	        writer.close();
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
		
	if(DeptR.equalsIgnoreCase("Administration")) {
	try {
        BufferedWriter writer=new BufferedWriter(new FileWriter("Admininfo.txt",true));
        writer.write("\n"+name+"\n"+nid+"\n"+email+"\n"+phnumR+"\n"+DeptR);
        writer.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
	try {
        BufferedWriter writer=new BufferedWriter(new FileWriter("Administration.txt",true));
        writer.write(name+":"+passR+"\n");
        writer.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }	
	}
	
	if(DeptR.equalsIgnoreCase("TicketingAgent")) {
		try {
	        BufferedWriter writer=new BufferedWriter(new FileWriter("TAinfo.txt",true));
	        writer.write("\n"+name+"\n"+nid+"\n"+email+"\n"+phnumR+"\n"+DeptR);
	        writer.close();
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
		try {
	        BufferedWriter writer=new BufferedWriter(new FileWriter("TicketAgent.txt",true));
	        writer.write(name+":"+passR+"\n");
	        writer.close();
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
		}
	
	if(DeptR.equalsIgnoreCase("Airplane")) {
		try {
	        BufferedWriter writer=new BufferedWriter(new FileWriter("Airplaneinfo.txt",true));
	        writer.write("\n"+name+"\n"+nid+"\n"+email+"\n"+phnumR+"\n"+DeptR);
	        writer.close();
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }	
		try {
	        BufferedWriter writer=new BufferedWriter(new FileWriter("PlaneEmployee.txt",true));
	        writer.write(name+":"+passR+"\n");
	        writer.close();
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
		}
	
	if(DeptR.equalsIgnoreCase("Terminal")) {
		try {
	        BufferedWriter writer=new BufferedWriter(new FileWriter("Terminfo.txt",true));
	        writer.write("\n"+name+"\n"+nid+"\n"+email+"\n"+phnumR+"\n"+DeptR);
	        writer.close();
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
		try {
	        BufferedWriter writer=new BufferedWriter(new FileWriter("TerminalEmployee.txt",true));
	        writer.write(name+":"+passR+"\n");
	        writer.close();
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
		try {
	        BufferedWriter writer=new BufferedWriter(new FileWriter("AllEmlpoyee.txt",true));
	        writer.write(name+"\n"+DeptR);
	        writer.close();
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
		root = FXMLLoader.load(getClass().getResource("AssignScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();	  
		  
		}
	}else {
		warning.setText("Password didn't match");
	}
	}		
}
	
	
	
	
}
