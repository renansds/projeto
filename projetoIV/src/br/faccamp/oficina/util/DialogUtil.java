package br.faccamp.oficina.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class DialogUtil {

	public static void mensagemSair(String titulo, String mensagem) {
		Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
		ButtonType btnSim = new ButtonType("Sim");
		ButtonType btnNao = new ButtonType("Não");

		dialogoExe.setTitle(titulo);
		dialogoExe.setHeaderText(mensagem);
		dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
		dialogoExe.showAndWait().ifPresent(b -> {
			if (b == btnSim) {
				System.exit(0);
			}
		});
	}
}
