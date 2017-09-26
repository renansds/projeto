package br.faccamp.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;

public class BarraProgressoController implements Initializable {
	@FXML
	private Label status;
	@FXML
	private ProgressBar barra;

	@FXML
	private ProgressIndicator indicador;

	@FXML
	private Button btnCarrega;

	@Override
	public void initialize(URL url, ResourceBundle bundle) {
		btnCarrega.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Implementar logica para conectar ao banco ! ");
			}
		});
		
		btnCarrega.setOnAction((ActionEvent acao) -> {
            //criando um classe anônima Service que cria uma Task que também é anônima
            //a classe Service serve para gerenciar threads em JavaFX 
            Service<Void> servico = new Service() {
                @Override
                protected Task createTask() {
                    return new Task() {
                        @Override
                        protected Void call() throws Exception {
                            //Task tem duas property interessantes para usar junto a um ProgressBar
                            //a messageProperty, que pode ser ligada a outra StringProperty
                            //para transmitir uma mensagem,
                            //e a progressProperty, que serve para mandar valores númericos a uma
                            //ProgressBar ou ProgressIndicator
                            Thread.sleep(300);
                            updateProgress(1, 10);
                            for (int i = 0; i <= 10; i++) {
                                updateProgress(i + 1, 10);
                                updateMessage(i * 10  + "%");
                                Thread.sleep(300);
                            }
                            
                            return null;
                        }
                    };
                }
            };
            //fazendo o bind (ligando) nas proprety
            status.textProperty().bind(servico.messageProperty());
            barra.progressProperty().bind(servico.progressProperty());
            //precisa inicializar o Service
            servico.restart();
        });

	}

}
