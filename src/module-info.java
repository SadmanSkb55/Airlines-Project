module AirDemo {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.media;
	requires javafx.base;
	//this i add
	requires java.mail;
	requires itextpdf;
	requires activation;
	opens application to javafx.graphics, javafx.fxml;
}
