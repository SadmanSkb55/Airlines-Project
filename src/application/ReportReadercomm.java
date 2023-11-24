package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ReportReadercomm extends TextShow{
	@FXML
	private TextArea area;

	public void show(ActionEvent event) {
		try {
            FileReader fileReader = new FileReader("Complaints.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            StringBuilder reports = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                reports.append(line).append("\n");
            }

            // Set the text in the TextArea
            area.setText(reports.toString());

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}
