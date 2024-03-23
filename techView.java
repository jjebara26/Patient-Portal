package hw4.java;

import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.geometry.*;

public class techView {
	public static void techForm() {
		Stage stage = new Stage();
		Label patientID = new Label("Patient ID:");
		patientID.setFont(Font.font("Sans", 15));
		Label total = new Label("The total Agatston CAC score");
		total.setFont(Font.font("Sans", 15));
		Label vessel = new Label("Vessel level Agatston CAC score");
		vessel.setFont(Font.font("Sans", 15));
		Label LM = new Label("LM:");
		LM.setFont(Font.font("Sans", 15));
		Label LAD = new Label("LAD:");
		LAD.setFont(Font.font("Sans", 15));
		Label LCX = new Label("LCX:");
		LCX.setFont(Font.font("Sans", 15));
		Label RCA = new Label("RCA:");
		RCA.setFont(Font.font("Sans", 15));
		Label PDA = new Label("PDA:");
		PDA.setFont(Font.font("Sans", 15));
		
		Label errorMessage = new Label("One or more of the fields are unfilled OR the ID is not valid, file NOT saved");
		errorMessage.setVisible(false);
		
		TextField patientIDText = new TextField();
		patientIDText.setPrefWidth(250);
		TextField totalText = new TextField();
		totalText.setPrefWidth(250);
		TextField LMText = new TextField();
		TextField LADText = new TextField();
		TextField LCXText = new TextField();
		TextField RCAText = new TextField();
		TextField PDAText = new TextField();
		
		Button save = new Button("Save");
		save.setFont(Font.font("Sans", FontWeight.BOLD, 12));
		save.setStyle("-fx-background-color: cornflowerblue; -fx-border-width: 2px; -fx-background-radius: 0px; -fx-padding: 15px 30px");
		
		HBox LMHbox = new HBox(3);
		LMHbox.getChildren().addAll(LM, LMText);
		LMHbox.setSpacing(52);
		
		HBox LADHbox = new HBox(3);
		LADHbox.getChildren().addAll(LAD, LADText);
		LADHbox.setSpacing(45);
		
		HBox LCXHbox = new HBox(3);
		LCXHbox.getChildren().addAll(LCX, LCXText);
		LCXHbox.setSpacing(48);
		
		HBox RCAHbox = new HBox(3);
		RCAHbox.getChildren().addAll(RCA, RCAText);
		RCAHbox.setSpacing(45);
		
		HBox PDAHbox = new HBox(3);
		PDAHbox.getChildren().addAll(PDA, PDAText);
		PDAHbox.setSpacing(45);
		
		
		VBox left = new VBox(3);
		left.getChildren().addAll(patientID, total, vessel, LMHbox, LADHbox, LCXHbox, RCAHbox, PDAHbox);
		left.setAlignment(Pos.TOP_LEFT);
		left.setSpacing(15);
		
		VBox right = new VBox(3);
		right.getChildren().addAll(patientIDText, totalText, errorMessage, save);
		right.setAlignment(Pos.TOP_CENTER);
		right.setSpacing(5);
		right.setMargin(errorMessage, new Insets(100, 0, 0, 0));
		right.setMargin(save, new Insets(175, 0, 0, 0));
		
		HBox main = new HBox(3);
		main.getChildren().addAll(left, right);
		
		
		Scene scene = new Scene(main, 650, 400);
		stage.setScene(scene);
		stage.show();
		
		save.setOnAction(e -> {
			String directoryPath = "C:\\Users\\josep\\eclipse-workspace\\cse360hw4.java";
	        String fileName = patientIDText.getText() + "_PatientInfo.txt";

	        // Create a Path object for the file
	        Path filePath = Paths.get(directoryPath, fileName);

	        // Check if the file exists
	        boolean fileExists = Files.exists(filePath);
	        
			if(!fileExists || patientIDText.getText().isEmpty() || totalText.getText().isEmpty() || LMText.getText().isEmpty() || LADText.getText().isEmpty()|| LCXText.getText().isEmpty() || RCA.getText().isEmpty() || PDA.getText().isEmpty()) {
				errorMessage.setVisible(true);
			} else {
				String patientID1 = patientIDText.getText();
				Path path = Paths.get(patientID1 + "CTResults.txt");
				String fileContent = patientIDText.getText() + "\n" + totalText.getText() + "\n" + LMText.getText() + "\n" + LADText.getText() + "\n" + LCXText.getText() + "\n" + RCAText.getText() + "\n" + PDAText.getText();
				try {
					Files.write(path, fileContent.getBytes());
				} catch (IOException e1) {
					System.out.println("IOEXCEPTION");
				}
			
				patientIDText.clear();
				totalText.clear();
				LMText.clear();
				LADText.clear();
				LCXText.clear();
				RCAText.clear();
				PDAText.clear();
			}
		});
	}
}
