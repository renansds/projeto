package br.faccamp.view;

import br.faccamp.controller.CarregadorTela;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CadastroLogin extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Parent parent = FXMLLoader.
				load(getClass().getResource(CarregadorTela.CAMINHO_BASE + "cadastroLogin.fxml"));
				Scene scene = new Scene(parent);
				scene.getStylesheets();
				stage.setResizable(false);
				
				stage.setScene(scene);
				stage.setTitle("Cadastro de Usuário");
				stage.show();
				
	}

	public static void main(String[] args) {
		launch(args);
	}

}
