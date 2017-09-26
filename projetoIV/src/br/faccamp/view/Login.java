package br.faccamp.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent parent = FXMLLoader.
				load(getClass().getResource("login.fxml"));
				Scene scene = new Scene(parent);
				scene.getStylesheets();
				stage.setResizable(false);
				
				stage.setScene(scene);
				stage.setTitle("Tela de Login");
				stage.show();
				
	}

	public static void main(String[] args) {
		launch(args);
	}
}
