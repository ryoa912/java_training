/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package namapro;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
