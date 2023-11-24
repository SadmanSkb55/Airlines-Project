package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AvailAirCon implements Airplanes {
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;
	@FXML
	private ImageView img1;
	@FXML
	private ImageView img2;
	@FXML
	private ImageView img3;
	@FXML
	private ImageView img4;
	@FXML
	private ImageView img5;
	@FXML
	private ImageView img6;
	@FXML
	private ImageView img7;
	@FXML
	private ImageView img8;
//	@FXML
//	private ImageView img12;
//	@FXML
//	private ImageView img32;
//	@FXML
//	private ImageView img42;
//	@FXML
//	private ImageView img52;
//	@FXML
//	private ImageView img62;
//	@FXML
//	private ImageView img72;
//	@FXML
//	private ImageView img82;

	@Override
	public void adderscene(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("FlightLoader.fxml"));
			Parent root = loader.load();
			Stage stage = new Stage();
			stage.setTitle("Add Flights");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void previousScene(ActionEvent event) throws Exception {
		root = FXMLLoader.load(getClass().getResource("AviationM.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	Image photo1 = new Image(getClass().getResourceAsStream("EA2pic-removebg-preview.png"));
	Image photo2 = new Image(getClass().getResourceAsStream("EtApic-removebg-preview.png"));
	Image photo3 = new Image(getClass().getResourceAsStream("DApic-removebg-preview.png"));
	Image photo4 = new Image(getClass().getResourceAsStream("CPpic-removebg-preview.png"));
	Image photo5 = new Image(getClass().getResourceAsStream("BApic-removebg-preview.png"));
	Image photo6 = new Image(getClass().getResourceAsStream("AApic-removebg-preview.png"));
	Image photo7 = new Image(getClass().getResourceAsStream("LApic-removebg-preview.png"));
	Image photo8 = new Image(getClass().getResourceAsStream("QAXpic-removebg-preview.png"));
	Image photo12 = new Image(getClass().getResourceAsStream("EMlogo.png"));
	Image photo22 = new Image(getClass().getResourceAsStream("ETlogo.png"));
	Image photo32 = new Image(getClass().getResourceAsStream("DAlogo.png"));
	Image photo42 = new Image(getClass().getResourceAsStream("CPlogo.png"));
	Image photo52 = new Image(getClass().getResourceAsStream("BAlogo.png"));
	Image photo62 = new Image(getClass().getResourceAsStream("AAlogo.png"));
	Image photo72 = new Image(getClass().getResourceAsStream("LAlogo.png"));
	Image photo82 = new Image(getClass().getResourceAsStream("QAlogo2.png"));

	public void photodisplay1() {
		img1.setImage(photo12);
	}

	public void photodisplay2() {
		img1.setImage(photo1);
	}

	public void photodisplay3() {
		img2.setImage(photo22);
	}

	public void photodisplay4() {
		img2.setImage(photo2);
	}

	public void photodisplay5() {
		img3.setImage(photo32);
	}

	public void photodisplay6() {
		img3.setImage(photo3);
	}

	public void photodisplay7() {
		img4.setImage(photo42);
	}

	public void photodisplay8() {
		img4.setImage(photo4);
	}

	public void photodisplay9() {
		img5.setImage(photo52);
	}

	public void photodisplay10() {
		img5.setImage(photo5);
	}

	public void photodisplay11() {
		img6.setImage(photo62);
	}

	public void photodisplay12() {
		img6.setImage(photo6);
	}

	public void photodisplay13() {
		img7.setImage(photo72);
	}

	public void photodisplay14() {
		img7.setImage(photo7);
	}

	public void photodisplay15() {
		img8.setImage(photo82);
	}

	public void photodisplay16() {
		img8.setImage(photo8);
	}

	@Override
	public void adder(ActionEvent event) {

	}

}
