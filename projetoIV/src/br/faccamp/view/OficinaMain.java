package br.faccamp.view;

import br.faccamp.controller.CarregadorTela;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OficinaMain extends Application {

	private static Stage stage;

	public static Stage getStage() {
		return stage;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent parent = FXMLLoader.
				load(getClass().getResource(CarregadorTela.CAMINHO_BASE + "oficinaManager.fxml"));
				Scene scene = new Scene(parent);
				scene.getStylesheets();
				stage.setFullScreen(true);
				stage.setScene(scene);
				stage.setTitle("Oficina Mecânica");
				stage.show();
				
	}

	public static void main(String[] args) {
		launch(args);
	}
}
