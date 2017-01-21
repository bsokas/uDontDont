package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;

//import org.json.JSONException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;



public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("uDoDo Entry Form");
		
		BorderPane root = new BorderPane();
		
		VBox structure = new VBox();
		VBox response = new VBox();
		HBox colorScale = new HBox();
		root.setLeft(structure);
		root.setRight(response);
		root.setBottom(colorScale);
		structure.setSpacing(5);
		response.setSpacing(5);
		
		root.setPadding(new Insets(10, 10, 10, 10));
		//root.setHgap(10);
		//root.setVgap(12);
		
		Text structureHeader = new Text();
		structureHeader.setText("Enter the assignment structure: ");
		//structureHeader.setFont(Font.font(null, FontWeight.BOLD, 36));
		
		//Layout options for number of questions
		Text structureHeading = new Text();
		structureHeading.setText("Assignment Parameters");
		structureHeading.setTextAlignment(TextAlignment.CENTER);
		
		Label t = new Label("Assignment Type: ");
		final ComboBox<String> typeOptions = new ComboBox<String>();
		typeOptions.getItems().addAll("Homework", "Assessment (Quiz, Test, etc.)", "Project");
		typeOptions.getSelectionModel().selectFirst();
		HBox type = new HBox();
		type.getChildren().addAll(t, typeOptions);
		
		Label mc = new Label("Multiple Choice:");
		TextField multChoice = new TextField ();
		HBox q1 = new HBox();
		q1.setSpacing(8);
		q1.getChildren().addAll(mc, multChoice);
		
		Label sa = new Label("Short Answer: ");
		TextField shortAnswer = new TextField();
		HBox q2 = new HBox();
		q2.getChildren().addAll(sa, shortAnswer);
		q2.setSpacing(8);
		
		Label fr = new Label("Free Response: ");
		TextField freeResponse = new TextField();
		HBox q3 = new HBox();
		q3.getChildren().addAll(fr, freeResponse);
		q3.setSpacing(8);
		
		Label o = new Label("Other: ");
		TextField other = new TextField();
		HBox q4 = new HBox();
		q4.getChildren().addAll(o, other);
		q4.setSpacing(8);
		
		Label re = new Label("Reused question: ");
		TextField reused = new TextField();
		HBox q5 = new HBox();
		q5.setSpacing(8);
		q5.getChildren().addAll(re, reused);

		Label srct = new Label("Questions from Textbooks: ");
		TextField sourceText = new TextField();
		HBox q6 = new HBox();
		q6.setSpacing(8);
		q6.getChildren().addAll(srct, sourceText);
		
		Label srcp = new Label("Questions from Personal Resources: ");
		TextField sourcePersonal = new TextField();
		HBox q7 = new HBox();
		q7.setSpacing(8);
		q7.getChildren().addAll(srcp, sourcePersonal);
		
		Label srco = new Label("Original Questions: ");
		TextField sourceOriginal = new TextField();
		HBox q8 = new HBox();
		q8.setSpacing(8);
		q8.getChildren().addAll(srco, sourceOriginal);

		Label d = new Label("Assignment Difficulty: ");
		final ComboBox<String> difficulty = new ComboBox<String>();
		difficulty.getItems().addAll("Easy", "Moderate", "Challenging", "Difficult", "Hellish");
		difficulty.getSelectionModel().selectFirst();
		HBox q9 = new HBox();
		q9.setSpacing(8);
		q9.getChildren().addAll(d, difficulty);
		
		Label st = new Label("Can the students keep the assignment?");
		final ComboBox<String> ownership = new ComboBox<String>();
		ownership.getItems().addAll("Yes", "No");
		ownership.getSelectionModel().selectFirst();
		HBox q10 = new HBox();
		q10.setSpacing(8);
		q10.getChildren().addAll(st, ownership);
		
		Label sol = new Label("Are solutions provided? ");
		final ComboBox<String> solutions = new ComboBox<String>();
		solutions.getItems().addAll("Yes", "No");
		solutions.getSelectionModel().selectFirst();
		HBox q11 = new HBox();
		q11.setSpacing(8);
		q11.getChildren().addAll(sol, solutions);
		
		ToggleGroup toggle = new ToggleGroup();
		RadioButton suspected = new RadioButton();
		suspected.setText("Suspected");
		RadioButton confirmed = new RadioButton();
		confirmed.setText("Confirmed");
		suspected.setToggleGroup(toggle);
		confirmed.setToggleGroup(toggle);
		
		Button submit = new Button();
		submit.setText("Submit");
		
		structure.getChildren().addAll(structureHeading, type, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, suspected, confirmed, submit);
		
		submit.setOnAction((click)->{
			int assignmentType = 0;
			if(typeOptions.getValue().equals("Homework")){assignmentType = 1;}
			else if(typeOptions.getValue().contains("Assessment")){assignmentType = 2;}
			else{assignmentType = 3;}
			
			int mcTotal = Integer.parseInt(multChoice.getText());
			int saTotal = Integer.parseInt(shortAnswer.getText());
			int frTotal = Integer.parseInt(freeResponse.getText());
			int otherTotal = Integer.parseInt(other.getText());
			int reuseTotal = Integer.parseInt(reused.getText());
			int sourceTextIndex = Integer.parseInt(sourceText.getText());
			int sourcePersonalIndex = Integer.parseInt(sourcePersonal.getText());
			int sourceOriginalIndex = Integer.parseInt(sourceOriginal.getText());
			
			int difficultyIndex = 0;
			if(difficulty.getValue().equals("Easy")){difficultyIndex = 1;} 
			else if(difficulty.getValue().equals("Moderate")){difficultyIndex = 2;}
			else if(difficulty.getValue().equals("Challenging")){difficultyIndex = 3;}
			else if(difficulty.getValue().equals("Difficult")){difficultyIndex = 4;}
			else{difficultyIndex = 5;}
			
			int ownershipIndex = ownership.getValue().equals("Yes") ? 1 : 0;
			int solutionsIndex = solutions.getValue().equals("Yes") ? 1 : 0;
			int cheatingType = confirmed.isSelected() ? 1 : 0;
			
			//Database db = new Database(assignmentType, mcTotal, saTotal, frTotal, otherTotal, reuseTotal, sourceTextIndex, sourcePersonalIndex,
					//sourceOriginalIndex, difficultyIndex, ownershipIndex, solutionsIndex, cheatingType);
			
			HueColorScaleExample colorRange = new HueColorScaleExample();
			
			System.out.println("This worked!");
			System.out.println(assignmentType);
			
			
		});
		
		Scene scene = new Scene(root, 300, 275);
		primaryStage.setScene(scene);
		
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
