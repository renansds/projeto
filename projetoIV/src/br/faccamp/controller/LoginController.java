package br.faccamp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.faccamp.dao.DaoLogin;
import br.faccamp.view.Login;
import br.faccamp.view.OficinaMain;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController implements Initializable {

	@FXML
	private TextField txLogin;
	@FXML
	private PasswordField txSenha;
	@FXML
	private Button btEntrar, btSair;

	@Override
	public void initialize(URL url, ResourceBundle bundle) {

		btEntrar.setOnAction(new EventHandler<ActionEvent>() {
			int tentativa = 0;

			@Override
			public void handle(ActionEvent event) {
				DaoLogin db = new DaoLogin();
				boolean ok = db.loginUser(txLogin.getText(), txSenha.getText());
				if (ok) {
					try {
						new OficinaMain().start(new Stage());
						Stage stage = (Stage) btEntrar.getScene().getWindow();
						stage.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					Alert alert = new Alert(Alert.AlertType.WARNING);
					alert.setTitle("Aviso!");
					alert.setHeaderText("Usuário ou senha inválidos.");
					alert.show();
				}
			}
		});
		btSair.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
				ButtonType btnSim = new ButtonType("Sim");
				ButtonType btnNao = new ButtonType("Não");

				dialogoExe.setTitle("Sair do sistema");
				dialogoExe.setHeaderText("Tem certeza que deseja sair ?");
				dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
				dialogoExe.showAndWait().ifPresent(b -> {
					if (b == btnSim) {
						System.exit(0);
					}
				});
			}
		});
	}
}