package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class RequestReadercomm extends TextShow{
	@FXML
	private TextArea area;

	public void show(ActionEvent event) {
		try {
            FileReader fileReader = new FileReader("ServiceRequest.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            StringBuilder requests = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                requests.append(line).append("\n");
            }

            // Set the text in the TextArea
            area.setText(requests.toString());

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}
