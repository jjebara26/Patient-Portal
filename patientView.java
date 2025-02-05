package portal.java;

import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class patientView {
	private static int id;
	public static void enterID() {
		Stage stage = new Stage();
		Label enter = new Label("Enter your patient ID:");
		Label error = new Label("Please type a valid ID");
		error.setVisible(false);
		TextField enterText = new TextField();
		Button enterButton = new Button("Submit");
		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(enter, enterText, enterButton);
		hbox.setAlignment(Pos.CENTER);
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(hbox, error);
		Scene scene = new Scene(vbox, 400, 200);
		vbox.setAlignment(Pos.CENTER);
		stage.setScene(scene);
		stage.show();
		enterButton.setOnAction(e -> {
			try {
				id = Integer.parseInt(enterText.getText());
			} catch (NumberFormatException e1) {
				error.setVisible(true);
				enterText.clear();
			}
			String directoryPath = "C:\\Users\\josep\\eclipse-workspace\\cse360hw4.java";
	        String fileName = id + "_PatientInfo.txt";

	        // Create a Path object for the file
	        Path filePath = Paths.get(directoryPath, fileName);

	        // Check if the file exists
	        boolean fileExists = Files.exists(filePath);

	        // Print the result
	        if (fileExists) {
	        	stage.close();
	            patientForm(id);
	        } else {
	        	error.setVisible(true);
				enterText.clear();
	        }
		});
	}
	public static void patientForm(int id) {
		// Specify the directory path and file name
        String directoryPath = "C:\\Users\\josep\\eclipse-workspace\\cse360hw4.java";
        String fileName = id + "CTResults.txt";

        // Create a Path object for the directory and file
        Path directory = Paths.get(directoryPath);
        Path file = directory.resolve(fileName);

        // Check if the file exists
        boolean fileExists = Files.exists(file);

        // Print the result
        if (fileExists) {
        	String filePath = "C:\\Users\\josep\\eclipse-workspace\\cse360hw4.java\\" + id + "CTResults.txt";

            // Create a list to store lines
    		List<String> lines = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                // Read each line of the file
                while ((line = reader.readLine()) != null) {
                    // Store each line in the list
                    lines.add(line);
                }
            } catch (IOException e) {
                
            }
            
            String tot = lines.get(1);
            String lm = lines.get(2);
            String lad = lines.get(3);
            String lcx = lines.get(4);
            String rca = lines.get(5);
            String pda = lines.get(6);

	        
	        String filePath1 = "C:\\Users\\josep\\eclipse-workspace\\cse360hw4.java\\" + id + "_PatientInfo.txt";

            // Create a list to store lines
    		List<String> lines1 = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath1))) {
                String line;
                // Read each line of the file
                while ((line = reader.readLine()) != null) {
                    // Store each line in the list
                    lines1.add(line);
                }
            } catch (IOException e) {
                
            }
            
            String fName = lines1.get(0);
            String lName = lines1.get(1);
            
    		Stage stage = new Stage();
    		Label top = new Label("Hello " + fName + " " + lName);
    		top.setFont(Font.font("Sans", 15));
    		Label total = new Label("The total Agatston CAC score");
    		total.setFont(Font.font("Sans", 15));
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
    		
    		Label totalText = new Label(tot);
    		totalText.setPrefWidth(250);
    		totalText.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
    		Label LMText = new Label(lm);
    		LMText.setPrefWidth(125);
    		LMText.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
    		Label LADText = new Label(lad);
    		LADText.setPrefWidth(125);
    		LADText.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
    		Label LCXText = new Label(lcx);
    		LCXText.setPrefWidth(125);
    		LCXText.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
    		Label RCAText = new Label(rca);
    		RCAText.setPrefWidth(125);
    		RCAText.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
    		Label PDAText = new Label(pda);
    		PDAText.setPrefWidth(125);
    		PDAText.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
    		
    		HBox totalHBox = new HBox(3);
    		totalHBox.getChildren().addAll(total, totalText);
    		totalHBox.setSpacing(80);
    		
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
    		
    		VBox main = new VBox(3);
    		main.getChildren().addAll(top, totalHBox, LMHbox, LADHbox, LCXHbox, RCAHbox, PDAHbox);
    		main.setSpacing(15);
    		main.setMargin(top, new Insets(0, 0, 0, 250));
    		
    		Scene scene = new Scene(main, 650, 300);
    		stage.setScene(scene);
    		stage.show();
        } else {
        	Stage stage = new Stage();
        	Label error = new Label("No data is available yet");
        	VBox vbox = new VBox();
        	vbox.getChildren().add(error);
        	vbox.setAlignment(Pos.CENTER);
        	Scene scene = new Scene(vbox, 300, 200);
        	stage.setScene(scene);
        	stage.show();
        }
        
	}
}
