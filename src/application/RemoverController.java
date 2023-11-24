package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RemoverController extends EmployeeX implements Initializable {
	
	
	private static String name;
	protected static String dept;
	
	@FXML
	private ChoiceBox<String> Dept;
	@FXML
	private String[] DeptChoice= {"Administration","TicketingAgent","Airplane","Terminal"};
	private String DeptR;
	private String searchval;
	@FXML 
	private TextField searchbar;
	@FXML
	private Button Remove;
	@FXML
	private Button Search;
	@FXML
	private Label warning;
	@FXML
	private TextArea area;
	
	public RemoverController(String name, String department, String project){
		super(name, department);
		DeptR="";
		searchval="";
		}
	public RemoverController() {
		super(name,dept);
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Dept.getItems().addAll(DeptChoice);
		Dept.setOnAction(this::getDept);
	}
	 private void getDept(ActionEvent event) {
	    	DeptR= Dept.getValue();
		}
	 
	 
	 public void searcher(ActionEvent event)throws Exception{
		 if(DeptR.equalsIgnoreCase("Administration")) {
			searchval=searchbar.getText();
			boolean foundSearchTerm = false;
			try {
				 FileReader fileReader = new FileReader("PassengerInfo.txt");
		            BufferedReader reader = new BufferedReader(fileReader);
		         String line;
		         StringBuilder targetn = new StringBuilder();
		         
		         while ((line=reader.readLine())!=null) {
		        	 if (line.contains(searchval)) {
		                    foundSearchTerm = true;
		                    break; 
		                }
		        	 }
		         if (foundSearchTerm) {
		                for (int i = 1; i < 3; i++) {
		                    if ((line = reader.readLine()) != null) {
		                    	targetn.append(line).append("\n");
		                    } else {
		                        break; 
		                    }area.setText(targetn.toString());
		                }
		         }
		         else {
		        	 warning.setText("Seached Data Not Found");
		         }
			 }
			 catch (IOException e) {
		            throw new RuntimeException(e);
		        }
		 }
		 if(DeptR.equalsIgnoreCase("TicketingAgent")) {
				searchval=searchbar.getText();
				boolean foundSearchTerm = false;
				try {
					 FileReader fileReader = new FileReader("PassengerInfo.txt");
			            BufferedReader reader = new BufferedReader(fileReader);
			         String line;
			         StringBuilder targetn = new StringBuilder();
			         
			         while ((line=reader.readLine())!=null) {
			        	 if (line.contains(searchval)) {
			                    foundSearchTerm = true;
			                    break; 
			                }
			        	 }
			         if (foundSearchTerm) {
			                for (int i = 1; i < 3; i++) {
			                    if ((line = reader.readLine()) != null) {
			                    	targetn.append(line).append("\n");
			                    } else {
			                        break; 
			                    }area.setText(targetn.toString());
			                }
			         }
			         else {
			        	 warning.setText("Seached Data Not Found");
			         }
				 }
				 catch (IOException e) {
			            throw new RuntimeException(e);
			        }
			 }
		 if(DeptR.equalsIgnoreCase("Airplane")) {
				searchval=searchbar.getText();
				boolean foundSearchTerm = false;
				try {
					 FileReader fileReader = new FileReader("PassengerInfo.txt");
			            BufferedReader reader = new BufferedReader(fileReader);
			         String line;
			         StringBuilder targetn = new StringBuilder();
			         while ((line=reader.readLine())!=null) {
			        	 if (line.contains(searchval)) {
			                    foundSearchTerm = true;
			                    break; 
			                }
			        	 }
			         if (foundSearchTerm) {
			                for (int i = 1; i < 3; i++) {
			                    if ((line = reader.readLine()) != null) {
			                    	targetn.append(line).append("\n");
			                    } else {
			                        break; 
			                    }area.setText(targetn.toString());
			                }
			         }
			         else {
			        	 warning.setText("Seached Data Not Found");
			         }
				 }
				 catch (IOException e) {
			            throw new RuntimeException(e);
			        }
			 }
		 if(DeptR.equalsIgnoreCase("Terminal")) {
				searchval=searchbar.getText();
				boolean foundSearchTerm = false;
				try {
					 FileReader fileReader = new FileReader("PassengerInfo.txt");
			            BufferedReader reader = new BufferedReader(fileReader);
			         String line;
			         StringBuilder targetn = new StringBuilder();
			         while ((line=reader.readLine())!=null) {
			        	 if (line.contains(searchval)) {
			                    foundSearchTerm = true;
			                    break; 
			                }
			        	 }
			         if (foundSearchTerm) {
			                for (int i = 1; i < 6; i++) {
			                    if ((line = reader.readLine()) != null) {
			                    	targetn.append(line).append("\n");
			                    } else {
			                        break; 
			                    }area.setText(targetn.toString());
			                }
			         }
			         else {
			        	 warning.setText("Seached Data Not Found");
			         }
				 }
				 catch (IOException e) {
			            throw new RuntimeException(e);
			        }
			 }
	 }
	
	 
	 public void cancel(ActionEvent event)throws Exception {
		 if(DeptR.equalsIgnoreCase("Administration")) {
			searchval=searchbar.getText();
			boolean foundSearchTerm = false;
			StringBuilder updatedContent = new StringBuilder();

	        try (BufferedReader reader = new BufferedReader(new FileReader("Admininfo.txt"))) {
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
	                for (int i = 0; i < 6; i++) {
	                    reader.readLine();
	                }
	            }

	            while ((currentLine = reader.readLine()) != null) {
	                updatedContent.append(currentLine).append("\n");
	            }
	        }

	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Admininfo.txt"))) {
	            writer.write(updatedContent.toString());
	        }catch (IOException e) {
	            throw new RuntimeException(e);
	        }
		 }
		 if(DeptR.equalsIgnoreCase("TicketingAgent")) {
				searchval=searchbar.getText();
				boolean foundSearchTerm = false;
				StringBuilder updatedContent = new StringBuilder();

		        try (BufferedReader reader = new BufferedReader(new FileReader("TAinfo.txt"))) {
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
		                for (int i = 0; i < 6; i++) {
		                    reader.readLine();
		                }
		            }

		            while ((currentLine = reader.readLine()) != null) {
		                updatedContent.append(currentLine).append("\n");
		            }
		        }

		        try (BufferedWriter writer = new BufferedWriter(new FileWriter("TAinfo.txt"))) {
		            writer.write(updatedContent.toString());
		        }catch (IOException e) {
		            throw new RuntimeException(e);
		        }
			 }
		 if(DeptR.equalsIgnoreCase("Airplane")) {
				searchval=searchbar.getText();
				boolean foundSearchTerm = false;
				StringBuilder updatedContent = new StringBuilder();

		        try (BufferedReader reader = new BufferedReader(new FileReader("Airplaneinfo.txt"))) {
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
		                for (int i = 0; i < 6; i++) {
		                    reader.readLine();
		                }
		            }

		            while ((currentLine = reader.readLine()) != null) {
		                updatedContent.append(currentLine).append("\n");
		            }
		        }

		        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Airplaneinfo.txt"))) {
		            writer.write(updatedContent.toString());
		        }catch (IOException e) {
		            throw new RuntimeException(e);
		        }
			 }
		 if(DeptR.equalsIgnoreCase("Terminal")) {
				searchval=searchbar.getText();
				boolean foundSearchTerm = false;
				StringBuilder updatedContent = new StringBuilder();

		        try (BufferedReader reader = new BufferedReader(new FileReader("Terminfo.txt"))) {
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
		                for (int i = 0; i < 6; i++) {
		                    reader.readLine();
		                }
		            }

		            while ((currentLine = reader.readLine()) != null) {
		                updatedContent.append(currentLine).append("\n");
		            }
		        }

		        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Terminfo.txt"))) {
		            writer.write(updatedContent.toString());
		        }catch (IOException e) {
		            throw new RuntimeException(e);
		        }
			 }
	        
		}
	 @Override
	    public void displayInfo() {
	        super.displayInfo();  // Call the displayInfo method of the superclass
	    }
	
}
