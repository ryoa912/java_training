/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch03.ex10;

import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UnaryOperatorChecker extends Application {
	private static final String IMAGE_URL = "https://www.ibm.com/developerworks/community/blogs/ibmandgoogle/resource/BLOGS_UPLOADED_IMAGES/java-logo-2.png";

	public void start(Stage primaryStage) throws Exception {
		Image image = new Image(IMAGE_URL);
		//UnaryOperator op = Color::brighter;
		//Image finalImage = transform(image, op.compose(Color::grayscale));
		primaryStage.setScene(new Scene(new HBox(new ImageView(image))));
		primaryStage.show();
}

	public static Image transform(Image in, UnaryOperator<Color> f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
}

	public static void main(String[] args) {
		UnaryOperatorChecker.launch();
	}
}