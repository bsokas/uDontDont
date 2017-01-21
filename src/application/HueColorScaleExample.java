package application;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HueColorScaleExample extends Application{
	
	private double MIN = 100;
	private double MAX = 1000;
	
	private double GREEN_HUE = Color.GREEN.getHue();
	private double RED_HUE = Color.RED.getHue();
	
	@Override
	public void start(Stage primaryStage){
		
		Image colorScale = createColorScaleImage(600, 120, Orientation.HORIZONTAL);
		ImageView imageView = new ImageView(colorScale);
		StackPane root = new StackPane(imageView);
		Scene scene = new Scene(root, 700, 250);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private Color getColorForValue(double value){
		if(value < MIN || value > MAX){
			return Color.BLACK;
		}
		
		double hue = GREEN_HUE + (GREEN_HUE + RED_HUE) * (value - MIN) / (MAX - MIN) ;
		return Color.hsb(hue,  1.0,  1.0);
	}
	
	private Image createColorScaleImage(int width, int height, Orientation orientation){
		
		WritableImage image = new WritableImage(width, height);
		PixelWriter pixelWriter = image.getPixelWriter();
		
		if(orientation == Orientation.HORIZONTAL){
			for(int x = 0; x < width; x++){
				double value = MIN + (MAX - MIN) * x / width;
				Color color = getColorForValue(value);
				for(int y = 0; y < height; y++){
					pixelWriter.setColor(x, y, color);
				}
			}
		}
		
		else{
			for(int y = 0; y < height; y++){
				double value = MAX - (MAX - MIN) * y / height;
				Color color = getColorForValue(value);
				for(int x = 0; x < width; x++){
					pixelWriter.setColor(x, y, color);
				}
			}
		}
		return image;
	}
	
	public static void main(String[] args){
		launch(args);
	}
	
}
