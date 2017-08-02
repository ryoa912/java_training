/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch04.ex06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneApp extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane pane = new BorderPane();
		pane.setTop(new BorderPane(new Button("Top")));
		pane.setLeft(new Button("Left"));
		pane.setCenter(new Button("Center"));
		pane.setRight(new Button("Right"));
		pane.setBottom(new BorderPane(new Button("bottom")));
		primaryStage.setScene(new Scene(pane));
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch();
	}
}
