package br.faccamp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.faccamp.oficina.util.DialogUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;

public class OficinaMainController implements Initializable {
	@FXML
	private ProgressBar progressBar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}

	public void onSair() {
		DialogUtil.mensagemSair("Sair do Sistema", "Tem certeza que deseja sair ?");
	}
	
}