/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch03.ex11;

import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TransformApp extends Application {

	private static final String IMAGE_URL = "https://www.ibm.com/developerworks/community/blogs/ibmandgoogle/resource/BLOGS_UPLOADED_IMAGES/java-logo-2.png";

	public void start(Stage primaryStage) throws Exception {
		Image image = new Image(IMAGE_URL);
		Image brightenedImage = transform(image, Color::brighter);
		Image composedImage = transform(image, compose(
				createColorTransformer(Color::brighter),
				(x, y, c) -> x < 10 || x > image.getWidth() - 10
				|| y < 10 || y > image.getHeight() - 10 ? Color.GRAY : c));
		primaryStage.setScene(new Scene(new HBox(
				new ImageView(image),
				new ImageView(brightenedImage),
				new ImageView(composedImage)
		)));
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

	public static Image transform(Image in, ColorTransformer f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(x, y, in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
}

	public static ColorTransformer compose(ColorTransformer f1, ColorTransformer f2) {
		return (x, y, c) -> f2.apply(x, y, f1.apply(x, y, c));
}

	public static ColorTransformer createColorTransformer(UnaryOperator<Color> f) {
		return (x, y, c) -> f.apply(c); // unused: x, y
}

	public interface ColorTransformer {

		Color apply(int x, int y, Color colorAtXY);
}

	public static void main(String[] args) {
		TransformApp.launch();
}

}
