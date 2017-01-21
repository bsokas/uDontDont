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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
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
		VBox parameters = new VBox();
		HBox results = new HBox();
		root.setLeft(structure);
		root.setRight(parameters);
		root.setBottom(results);
		structure.setSpacing(5);
		parameters.setSpacing(5);
		
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
		typeOptions.getItems().addAll("Homework", "Assessment (Quiz, Test, etc.", "Project");
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

		Label d = new Label("Assignmet Difficulty: ");
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
		
		structure.getChildren().addAll(structureHeading, type, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11);
		
		
		
		/*root.add(mc, 0, 0);
		root.add(multChoice, 1, 0);
		root.add(sa, 0, 1);
		root.add(shortAnswer, 1, 1);
		root.add(fr,  0, 2);
		root.add(freeResponse, 1, 2);
		root.add(o, 0, 3);
		root.add(other, 1, 3);*/
		
		
		//Assignment structure on the right
		
		
		
		Scene scene = new Scene(root, 300, 275);
		primaryStage.setScene(scene);
		
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
