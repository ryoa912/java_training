/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch03.ex06;

import java.util.function.BiFunction;

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

	@Override
	public void start(Stage primaryStage) throws Exception {
		Image image = new Image(IMAGE_URL);
		Image image2 = transform(image, (color, arg) -> arg ? color.invert() : color, true);
		primaryStage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2))));
		primaryStage.show();
	}

	public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y), arg));
			}
		}
		return out;
	}

	public interface ColorTransformer {

		Color apply(int x, int y, Color colorAtXY);
	}

	public static void main(String[] args) {
		TransformerApp.launch();
	}
}
