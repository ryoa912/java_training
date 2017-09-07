/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package specialclock;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import javafx.util.Duration;

public class Frame {
	private static Map<String, Image> image;
    private int time;
    private String imageName;

    static {
        image = new HashMap<>();
    }

    Frame(int time, String imageName) {
        this.time = time;
        this.imageName = imageName;
        image.putIfAbsent(imageName, new Image(imageName));
    }

    Duration getDuration() {
        return Duration.millis(time);
    }

    Image getImage() {
        return image.get(imageName);
    }
}
