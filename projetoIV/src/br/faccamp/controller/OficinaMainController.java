package br.faccamp.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;


public class OficinaMainController implements Initializable {
	@FXML
	private Button btClientes ;
	@FXML
	private Button btVeiculos ; 
	@FXML
	private Button btOs; 
	@FXML
	private Button btRelatorio ; 
	@FXML
	private Button btConfiguracao ; 
	// Menu > Cadastro 
	@FXML
	private Menu cadastro ; 
	@FXML
	private MenuItem cliente ; 
	@FXML
	private MenuItem funcionario ;
	@FXML
	private MenuItem produto;
	
	@FXML
	private MenuItem veiculos ; 
	
	// Menu Serviços 
	
	// Menu > Ajuda 
	
	// Menu > Sair 
	@FXML
	private Menu sair ; 
	@FXML
	private MenuItem sairSistema ; 

	@Override
	public void initialize(URL url, ResourceBundle bundle) {
		sairSistema.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
	}
}