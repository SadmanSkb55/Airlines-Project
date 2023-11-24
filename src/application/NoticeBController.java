package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NoticeBController extends ControllerAbs  {
	ControllerAbs c1=new ControllerAbs();
@FXML
private TextArea noticetxts;
@FXML
private Button update;
@FXML
private Label done;

public void update(ActionEvent event) {
	try {
        BufferedWriter writer=new BufferedWriter(new FileWriter("Notices.txt",true));
        writer.write(noticetxts.getText());  
        writer.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
	done.setText("Updated");
}


}
