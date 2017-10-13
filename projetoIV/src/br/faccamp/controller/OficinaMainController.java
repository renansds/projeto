package br.faccamp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.faccamp.oficina.util.DialogUtil;
import br.faccamp.view.CadastroLogin;
import br.faccamp.view.OficinaMain;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

public class OficinaMainController implements Initializable {
	@FXML
	private ProgressBar progressBar;
	@FXML
	private Button btnFuncionario;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}

	public void onSair() {
		DialogUtil.mensagemSair("Sair do Sistema", true);
	}
	@FXML
	public void onNovoFunc() throws Exception {
		new CadastroLogin().start(new Stage());
		}
	
}