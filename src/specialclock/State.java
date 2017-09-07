/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package specialclock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.stage.Window;

public class State {
	private static ImageView target;
    private static StateType current;
    private Timeline time;
    private double width, height;

    public static void setTarget(ImageView target) {
        State.target = target;
    }

    public static void setState(StateType type) {
        if (type == current) return;
        Optional.ofNullable(current).map(StateType::getState).ifPresent(s -> s.time.stop());
        current = type;
        current.getState().setTarget();
    }

    // 呼び出す度に状態を変えたい時用
    public static void setState(StateType type, StateType... alt) {
        if (type == current) setState(alt[0]);
        else setState(IntStream.range(0, alt.length - 1).filter(i -> alt[i] == current)
                .mapToObj(i -> alt[i + 1]).findFirst().orElse(type));
    }

    State(int rate, Frame... frames) {
        width = frames[0].getImage().getWidth();
        height = frames[0].getImage().getHeight();
        List<KeyFrame> keys = Arrays.stream(frames)
                .map(frame -> new KeyFrame(frame.getDuration(), e -> nextFrame(frame)))
                .collect(Collectors.toList());
        time = new Timeline(rate);
        time.setCycleCount(Timeline.INDEFINITE); // ループさせる
        time.getKeyFrames().addAll(keys);
    }

    private void setTarget() {
        time.play();
        // 一応書いてるけどあまり気にしなくてもいいかもしれない
        Window window = target.getScene().getWindow();
        window.setWidth(width);
        window.setHeight(height);
    }

    private void nextFrame(Frame frame) {
        if (target.getImage() != frame.getImage()) target.setImage(frame.getImage());
    }

}
