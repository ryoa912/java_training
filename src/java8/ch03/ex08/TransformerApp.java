/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch03.ex08;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TransformerApp extends Application {

	private static final String IMAGE_URL = "https://www.ibm.com/developerworks/community/blogs/ibmandgoogle/resource/BLOGS_UPLOADED_IMAGES/java-logo-2.png";

	public void start(Stage primaryStage) throws Exception {
		Image image = new Image(IMAGE_URL);
		Image image2 = transform(image, create(image, 10, Color.GRAY));
		primaryStage.setScene(new Scene(new HBox(new ImageView(image),new ImageView(image2))));
		primaryStage.show();
	}

	public static Image transform(Image in, ColorTransformer colorTransformer) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, colorTransformer.apply(x, y, in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}
	public static ColorTransformer create(Image image, int size, Color color) {
		return null;
	}

	public interface ColorTransformer {
		Color apply(int x, int y, Color colorAtXY);
	}

	public static void main(String[] args) {
		TransformerApp.launch();
	}
}
