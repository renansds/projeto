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

	public static void mensagemAlerta(String titulo, String mensagem, String criticas) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		ButtonType btnOk = new ButtonType("ok");

		alert.setTitle(titulo);
		alert.setHeaderText(mensagem);
		if (criticas.length() > 0)
			alert.setContentText(criticas);
		alert.getButtonTypes().setAll(btnOk);
		alert.showAndWait().ifPresent(b -> {
			if (b == btnOk) {
				alert.close();
			}
		});

	}

	public static void mensagem(String titulo, String mensagem, String corpo) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);

		alert.setTitle(titulo);
		alert.setHeaderText(mensagem);
		alert.setContentText(corpo);
		alert.showAndWait();
	}
}
