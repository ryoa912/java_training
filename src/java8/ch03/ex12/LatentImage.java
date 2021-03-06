/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch03.ex12;

import java.util.LinkedList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LatentImage {
	private Image in;
	private List<UnaryOperator<Color>> pendingOperations;

	public LatentImage(Image in) {
		this.in = in;
		pendingOperations = new LinkedList<>();
	}

	LatentImage transfofrm(UnaryOperator<Color> f) {
		pendingOperations.add(f);
		return this;
	}

	public final Image toImage() {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Color c = in.getPixelReader().getColor(x, y);
				for (UnaryOperator<Color> f : pendingOperations) {
					c = f.apply(c);
				}
				out.getPixelWriter().setColor(x, y, c);
			}
		}
		return out;
	}

	public static void main(String[] args) {
		LatentImage latentImage = new LatentImage(new WritableImage(100, 100));
		Image i = latentImage.toImage();
	}
}
