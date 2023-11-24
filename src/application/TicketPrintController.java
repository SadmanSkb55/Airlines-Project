package application;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class TicketPrintController extends TextShow {
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;
	@FXML
	private Button proceed;
	@FXML
	private Button print;
	@FXML
	private Button previous;
	@FXML
	private Label name;
	@FXML
	private Label namep;
	@FXML
	private Label classseat;
	@FXML
	private Label from;
	@FXML
	private Label fromp;
	@FXML
	private Label to;
	@FXML
	private Label top;
	@FXML
	private Label date;
	@FXML
	private Label datep;
	@FXML
	private Label gate;
	@FXML
	private Label gatep;
	@FXML
	private Label flight;
	@FXML
	private Label flightp;
	@FXML
	private Label time;
	@FXML
	private Label timep;
	@FXML
	private Label seats;
	@FXML
	private Label seatsp;

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
	private String fareR;
	private String terminalR;
	private String gateR;

	Session newSession = null;
	MimeMessage mimeMessage;

	public TicketPrintController() {
		this.nameR = "Not yet Assigned";
		this.nationalityR = "Not yet Assigned";
		this.emailR = "Not yet Assigned";
		this.phnnumberR = "Not yet Assigned";
		this.emerphnumR = "Not yet Assigned";
		// this.dob="Not yet Assigned";
		this.pobR = "Not yet Assigned";
		this.genderR = "Not yet Assigned";
		this.pcnR = "Not yet Assigned";
		this.nosR = 0;
		this.fromR = "Not yet Assigned";
		this.toR = "Not yet Assigned";
		this.depttimeR = "Not yet Assigned";
		// this.deptdate="Not yet Assigned";
		this.flightR = "Not yet Assigned";
		this.seatclassR = "Not yet Assigned";
		this.fareR = "null";
		this.terminalR = "null";
		this.gateR = "null";
	}

	public void print(ActionEvent event) throws Exception {
		StringBuilder body = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("TempInfo.txt"));
			String line;
			int linenum = 0;
			while ((line = reader.readLine()) != null) {
				body.append(line).append("\n");
				linenum++;
				if (linenum == 1) {

					this.nameR = line;
				}
				if (linenum == 2) {

					this.nationalityR = line;
				}
				if (linenum == 3) {

					this.emailR = line;
				}
				if (linenum == 4) {

					this.phnnumberR = line;
				}
				if (linenum == 5) {

					this.emerphnumR = line;
				}
				if (linenum == 6) {

					this.dobR = line;
				}
				if (linenum == 7) {

					this.pobR = line;
				}
				if (linenum == 8) {

					this.genderR = line;
				}
				if (linenum == 9) {

					this.pcnR = line;
				}
				if (linenum == 10) {

					this.nosR = Integer.parseInt(line);
				}
				if (linenum == 11) {

					this.fromR = line;
				}
				if (linenum == 12) {

					this.toR = line;
				}
				if (linenum == 13) {

					this.deptdateR = line;
				}
				if (linenum == 14) {

					this.depttimeR = line;
				}
				if (linenum == 15) {

					this.flightR = line;
				}
				if (linenum == 16) {

					this.seatclassR = line;
				}
				if (linenum == 17) {
					this.fareR = line;
				}
				if (linenum == 18) {
					this.terminalR = line;
				}
				if (linenum == 19) {
					this.gateR = line;
				}
			}
			body.toString();
			reader.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("PassengerInfo.txt", true));
			writer.write(nameR + phnnumberR + "\n" + nameR + "\n" + nationalityR + "\n" + emailR + "\n" + phnnumberR
					+ "\n" + emerphnumR + "\n" + dobR + "\n" + pobR + "\n" + genderR + "\n" + pcnR + "\n" + nosR + "\n"
					+ fromR + "\n" + toR + "\n" + deptdateR + "\n" + depttimeR + "\n" + flightR + "\n" + seatclassR
					+ "\n" + fareR + "\n" + terminalR + "\n" + gateR);
			writer.write("\n-/-/-/-/-/-/-/-/-/-/-/-");
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		name.setText(nameR);
		namep.setText(nameR);
		classseat.setText(seatclassR);
		from.setText(fromR);
		to.setAccessibleHelp(toR);
		date.setText(deptdateR);
		gate.setText(gateR);
		flight.setText(flightR);
		time.setText(depttimeR);
		seats.setText(String.valueOf(nosR));
		fromp.setText(fromR);
		top.setAccessibleHelp(toR);
		datep.setText(deptdateR);
		gatep.setText(gateR);
		flightp.setText(flightR);
		timep.setText(depttimeR);
		seatsp.setText(String.valueOf(nosR));

		

		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF File", "*.pfd"));
		fc.setTitle("Save to PDF");
		fc.setInitialFileName("Ticket.pdf");
		Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

		File file = fc.showSaveDialog(stg);
		if (file != null) {
			String str = file.getAbsolutePath();
			FileOutputStream fos = new FileOutputStream(str);
			Document document = new Document();

			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(str));
			document.open();
			document.add(new Paragraph(body.toString()));
			document.close();
			writer.close();

			try {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Ticket");
				alert.setHeaderText("Ticket Saved Succesfully!!!");
				// alert.setContentText("");

				if (alert.showAndWait().get() == ButtonType.OK) {

					Stage stage2 = new Stage();
					// System.out.println("You successfully logged out");
					stage2.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			fos.flush();

		}
		
		
		
		
		TicketPrintController mail = new TicketPrintController();
		mail.setupServerProperties();
		mail.draftEmail();
		mail.sendEmail();

	}

	public void previous(ActionEvent event) throws Exception {

		root = FXMLLoader.load(getClass().getResource("TerminalScene.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	public void continuescene(ActionEvent event) throws Exception {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("TempInfo.txt"));
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("TempMail.txt"));
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		root = FXMLLoader.load(getClass().getResource("TicketScene.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	////////////
	private void setupServerProperties() {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		newSession = Session.getDefaultInstance(properties, null);
		String appPassword = "your_generated_app_password";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.user", "breadman1914@gmail.com");
		props.put("mail.smtp.password", "hjkr gbru pxtk sguv");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("breadman1914@gmail.com", "hjkr gbru pxtk sguv");
			}
		});
		try {
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", "breadman1914@gmail.com", appPassword);
			transport.close();
			// System.out.println("Connection successful.");
		} catch (Exception e) {
			e.printStackTrace();
			// System.err.println("Connection failed. Check the error stack trace for
			// details.");
		}
	}

	private MimeMessage draftEmail() throws AddressException, MessagingException, IOException {
		StringBuilder body = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("TempInfo.txt"));
			String line;

			int linenum = 0;
			while ((line = reader.readLine()) != null) {
				body.append(line).append("\n");
				linenum++;
				if (linenum == 1) {

					this.nameR = line;
				}
				if (linenum == 2) {

					this.nationalityR = line;
				}
				if (linenum == 3) {

					this.emailR = line;
				}
				if (linenum == 4) {

					this.phnnumberR = line;
				}
				if (linenum == 5) {

					this.emerphnumR = line;
				}
				if (linenum == 6) {

					this.dobR = line;
				}
				if (linenum == 7) {

					this.pobR = line;
				}
				if (linenum == 8) {

					this.genderR = line;
				}
				if (linenum == 9) {

					this.pcnR = line;
				}
				if (linenum == 10) {

					this.nosR = Integer.parseInt(line);
				}
				if (linenum == 11) {

					this.fromR = line;
				}
				if (linenum == 12) {

					this.toR = line;
				}
				if (linenum == 13) {

					this.deptdateR = line;
				}
				if (linenum == 14) {

					this.depttimeR = line;
				}
				if (linenum == 15) {

					this.flightR = line;
				}
				if (linenum == 16) {

					this.seatclassR = line;
				}
				if (linenum == 17) {
					this.fareR = line;
				}
				if (linenum == 18) {
					this.terminalR = line;
				}
				if (linenum == 19) {
					this.gateR = line;
				}
			}
			body.toString();
			reader.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		// String emailRecipients = emailR;

		if (emailR != null && !emailR.trim().isEmpty()) {
			try (BufferedReader reader = new BufferedReader(new FileReader("TempMail.txt"))) {
				String line;

				while ((line = reader.readLine()) != null) {
					if (line != null && !line.trim().isEmpty()) {
						emailR = line;
					}
				}
			}
		}
		String sanitizedEmail = emailR.trim(); // Removes leading and trailing whitespaces
		/// InternetAddress emailRecipients = new InternetAddress(sanitizedEmail);
		String emailSubject = "Greetings from Winterfell " + nameR;
		String emailBody = "Thanks for having patince,Your Ticket is Confirmed and Your Ticket Information are [Please Print out the PDF if needs or show this Email to Imigration]:            "
				+ body.toString();
		

		mimeMessage = new MimeMessage(newSession);
		// for (int i = 0; i < emailRecipients.length; i++) {
		mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(sanitizedEmail));
		// }

		mimeMessage.setSubject(emailSubject);

		MimeBodyPart bodyPart = new MimeBodyPart();
		bodyPart.setContent(emailBody, "text/html");
		MimeBodyPart pdfBodyPart = new MimeBodyPart();
		FileDataSource source = new FileDataSource("C:\\Users\\sadma\\OneDrive\\Documents\\Java\\AirDemo\\Ticket.pdf"); // Replace with the actual path to your PDF file
		//File file = new File("C:\\Users\\sadma\\OneDrive\\Documents\\Java\\AirDemo\\Ticket.pdf");
//		if (!file.exists()) {
//		    System.out.println("File not found: " + file.getAbsolutePath());
//		    // Add further handling or return from the method
//		}else
//			 System.out.println("Foundd");
//		System.out.println("Email Body: " + emailBody); // Check if the email body is correct
//		System.out.println("Attachment File: " + source.getFile());
		bodyPart.setContent(emailBody, "text/plain");
		pdfBodyPart.setDataHandler(new DataHandler(source));
		pdfBodyPart.setFileName("Ticket.pdf");
		pdfBodyPart.setHeader("Content-Type", "application/pdf");
		MimeMultipart multipart = new MimeMultipart();
		multipart.addBodyPart(bodyPart);
		multipart.addBodyPart(pdfBodyPart);
		mimeMessage.setContent(multipart);
		mimeMessage.setContent(multipart);
		mimeMessage.setContent(multipart, "multipart/mixed");
		return mimeMessage;

	}

	private void sendEmail() throws NoSuchProviderException, MessagingException {
		String fromUser = "breadman1914@gmail.com";
		String fromUserPassword = "hjkr gbru pxtk sguv";
		String emailHost = "smtp.gmail.com";
		Transport transport = newSession.getTransport("smtp");
		transport.connect(emailHost, fromUser, fromUserPassword);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		transport.close();
		// System.out.println("Email successfully sent");
		try {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Email");
			alert.setHeaderText("Email sent to: " + nameR);
			// alert.setContentText("");

			if (alert.showAndWait().get() == ButtonType.OK) {

				Stage stage2 = new Stage();
				// System.out.println("You successfully logged out");
				stage2.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	////

}
