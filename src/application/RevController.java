package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RevController extends ControllerAbs  {
	ControllerAbs c1=new ControllerAbs();
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private TextField t1;

    private double sum;
    private double sum2;

    public RevController() {
        sum = 0.0;
        sum2 = 0.0;
    }
    public RevController(double sum, double sum2) {
        this.sum = sum;
        this.sum2 = sum2;
    }
    

    public void show1(ActionEvent event) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("TotalFare.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                this.sum += Double.parseDouble(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        l1.setText(String.valueOf(sum));
    }

    public void show2(ActionEvent event) {
        sum2 = sum - Double.parseDouble(t1.getText());
        l2.setText(String.valueOf(sum2));
    }
}
