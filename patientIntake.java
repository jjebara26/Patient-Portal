package portal.java;

import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;
import java.util.Random;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class patientIntake {
	public static void intakeForm() {
		Stage stage = new Stage();
		Label top = new Label("Patient Intake Form");
		top.setFont(Font.font("Sans", 15));
		Label firstName = new Label("First Name:");
		firstName.setFont(Font.font("Sans", 15));
		Label lastName = new Label("Last Name:");
		lastName.setFont(Font.font("Sans", 15));
		Label email = new Label("Email:");
		email.setFont(Font.font("Sans", 15));
		Label phoneNumber = new Label("Phone Number:");
		phoneNumber.setFont(Font.font("Sans", 15));
		Label healthHistory = new Label("Health History:");
		healthHistory.setFont(Font.font("Sans", 15));
		Label insuranceID = new Label("Insurance ID:");
		insuranceID.setFont(Font.font("Sans", 15));
		
		TextField firstNameText = new TextField();
		TextField lastNameText = new TextField();
		TextField emailText = new TextField();
		TextField phoneNumberText = new TextField();
		TextField healthHistoryText = new TextField();
		TextField insuranceIDText = new TextField();
		
		Button save = new Button("Save");
		save.setFont(Font.font("Sans", FontWeight.BOLD, 12));
		save.setStyle("-fx-background-color: cornflowerblue; -fx-border-width: 2px; -fx-background-radius: 0px; -fx-padding: 15px 30px");
		
		HBox firstNameHbox = new HBox(3);
		firstNameHbox.getChildren().addAll(firstName, firstNameText);
		firstNameHbox.setSpacing(51);
		
		HBox lastNameHbox = new HBox(3);
		lastNameHbox.getChildren().addAll(lastName, lastNameText);
		lastNameHbox.setSpacing(52);
		
		HBox emailHbox = new HBox(3);
		emailHbox.getChildren().addAll(email, emailText);
		emailHbox.setSpacing(87);
		
		HBox phoneNumberHbox = new HBox(3);
		phoneNumberHbox.getChildren().addAll(phoneNumber, phoneNumberText);
		phoneNumberHbox.setSpacing(23);
		
		HBox healthHistoryHbox = new HBox(3);
		healthHistoryHbox.getChildren().addAll(healthHistory, healthHistoryText);
		healthHistoryHbox.setSpacing(29);
		
		HBox insuranceIDHbox = new HBox(3);
		insuranceIDHbox.getChildren().addAll(insuranceID, insuranceIDText);
		insuranceIDHbox.setSpacing(41);
		
		VBox middle = new VBox(3);
		middle.getChildren().addAll(firstNameHbox, lastNameHbox, emailHbox, phoneNumberHbox, healthHistoryHbox, insuranceIDHbox);
		middle.setAlignment(Pos.TOP_CENTER);
		middle.setSpacing(10);
		
		VBox main = new VBox(3);
		main.getChildren().addAll(top, middle, save);
		main.setAlignment(Pos.TOP_CENTER);
		main.setSpacing(10);
		
		
		Scene scene = new Scene(main, 550, 400);
		stage.setScene(scene);
		stage.show();
		
		save.setOnAction(e -> {
			Random rand = new Random();
			boolean fileExists;
			int randomInt;
			do {
				randomInt = rand.nextInt(90000) + 10000;
			
				String directoryPath = "C:\\Users\\josep\\eclipse-workspace\\cse360hw4.java";
				String fileName = randomInt + "_PatientInfo.txt";

				// Create a Path object for the file
				Path filePath = Paths.get(directoryPath, fileName);

				// Check if the file exists
				fileExists = Files.exists(filePath);

			} while(fileExists);
			
			Path path = Paths.get(randomInt + "_PatientInfo.txt");
			String fileContent = firstNameText.getText() + "\n" + lastNameText.getText() + "\n" + emailText.getText() + "\n" + phoneNumberText.getText() + "\n" + healthHistoryText.getText() + "\n" + insuranceIDText.getText();
			try {
				Files.write(path, fileContent.getBytes());
			} catch (IOException e1) {
				System.out.println("IOEXCEPTION");
			}
			
			firstNameText.clear();
			lastNameText.clear();
			emailText.clear();
			phoneNumberText.clear();
			healthHistoryText.clear();
			insuranceIDText.clear();
		});
	}
}
