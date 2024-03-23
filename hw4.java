package hw4.java;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class hw4 extends Application {
	public static void main(String[] args) {
        launch(args);
    }
	
	public void start(Stage stage) {
		Label welcome = new Label("Welcome to Heart Health Imaging and Recording System");
		
		Button patientIntake1 = new Button("Patient Intake");
		patientIntake1.setFont(Font.font("Sans", FontWeight.BOLD, 12));
		patientIntake1.setStyle("-fx-background-color: cornflowerblue; -fx-border-width: 2px; -fx-background-radius: 0px; -fx-padding: 30px 60px");
		Button techView1 = new Button("CT Scan Tech View");
		techView1.setFont(Font.font("Sans", FontWeight.BOLD, 12));
		techView1.setStyle("-fx-background-color: cornflowerblue; -fx-border-width: 2px; -fx-background-radius: 0px; -fx-padding: 30px 46px");
		Button patientView1 = new Button("Patient View");
		patientView1.setFont(Font.font("Sans", FontWeight.BOLD, 12));
		patientView1.setStyle("-fx-background-color: cornflowerblue; -fx-border-width: 2px; -fx-background-radius: 0px; -fx-padding: 30px 64px");
		
		VBox vbox = new VBox(3);
		vbox.getChildren().addAll(welcome, patientIntake1, techView1, patientView1);
		vbox.setSpacing(30);
		vbox.setAlignment(Pos.TOP_CENTER);
		
		stage.setScene(new Scene(vbox, 500, 400));
		
		stage.show();
		
		patientIntake1.setOnAction(e -> {
			stage.close();
			patientIntake.intakeForm();
		});
		
		techView1.setOnAction(e -> {
			stage.close();
			techView.techForm();
		});
		
		patientView1.setOnAction(e -> {
			stage.close();
			patientView.enterID();
		});
	}
}
