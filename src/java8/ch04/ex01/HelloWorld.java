/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch04.ex01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloWorld extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		String initialText = "Hello, JavaFX!";
		Label label = new Label(initialText);
		label.setFont(new Font("Times New Roman", 100));
		TextField textField = new TextField(initialText);
		label.textProperty().bind(textField.textProperty());
		textField.textProperty().addListener(s -> primaryStage.sizeToScene());
		primaryStage.setScene(new Scene(new VBox(label, textField)));
		primaryStage.setTitle("Hello");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch();
	}
}
