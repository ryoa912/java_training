/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch04.ex10;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebBrowserApp extends Application {
	private static final String HOME_URL = "https://github.com/";

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button backButton = new Button("戻る");
		backButton.setMinWidth(40);
		backButton.setDisable(true);
		TextField locationBar = new TextField(HOME_URL);
		locationBar.prefWidthProperty().bind(primaryStage.widthProperty());
		WebView webView = new WebView();
		WebEngine engine = webView.getEngine();
		engine.load(locationBar.getText());
		backButton.setOnAction(e -> {
			WebHistory history = engine.getHistory();
			int historyIndex = history.getCurrentIndex();
			ObservableList<WebHistory.Entry> entries = history.getEntries();
			if (historyIndex == 0) {
				backButton.setDisable(true);
			} else if (historyIndex > 0 && historyIndex < entries.size()) {
				history.go(-1);
				locationBar.setText(entries.get(historyIndex - 1).getUrl());
			}
		});
		locationBar.setOnAction(e -> {
			engine.load(locationBar.getText());
		});
		engine.getLoadWorker().stateProperty().addListener((o, oldValue, newValue) -> {
			if (newValue == Worker.State.SUCCEEDED) {
				locationBar.setText(engine.getLocation());
				backButton.setDisable(engine.getHistory().getCurrentIndex() == 0);
			}
		});
		HBox toolBar = new HBox(backButton, locationBar);
		VBox wrapper = new VBox(toolBar, webView);
		primaryStage.setScene(new Scene(wrapper));
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch();
	}
}
