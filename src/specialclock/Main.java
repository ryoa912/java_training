/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package specialclock;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import specialclock.components.Clock;
import specialclock.components.VoiceroidPlayer;

public class Main extends Application {
	@Override
    public void start(Stage primaryStage) throws IOException {
		primaryStage.setOnShown(e -> {
            State.setState(StateType.NORMAL);
            primaryStage.centerOnScreen();
        });
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("mascot.fxml")));
        scene.setFill(null);
        primaryStage.setScene(scene);
        primaryStage.show();
        //タイマタスクの生成
        TimerTask task = new TimerTask() {
			public void run() {
				if (Clock.justMinuteTime()) {
					try {
						VoiceroidPlayer.playTime();
					} catch (IOException | InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Timer timer = new Timer();
		timer.schedule(task, 1000L, 1000L);
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
