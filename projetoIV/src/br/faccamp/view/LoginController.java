package br.faccamp.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Implementar logica para conectar ao banco ! ");
			}
		});
		btSair.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Implementar aviso de confirmação para sair ! ");
				System.exit(0);
			}
		});
	}

}
