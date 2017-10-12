package br.faccamp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.faccamp.dao.DaoLogin;
import br.faccamp.oficina.util.DialogUtil;
import br.faccamp.oficina.util.MascarasFX;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

public class CadastroLoginController implements Initializable {
	@FXML
	private Button btnSalvar;
	@FXML
	private Button btnAlterar;
	@FXML
	private Button btnExcluir;
	@FXML
	private Button btnCancelar;
	@FXML
	private TextField fieldNome;
	@FXML
	private TextField fieldCpf;
	@FXML
	private TextField fieldLogin;
	@FXML
	private PasswordField fieldSenha;

	@Override
	public void initialize(URL url, ResourceBundle bundle) {

		MascarasFX.mascaraCPF(fieldCpf);
		addTextLimiter(fieldLogin, 30);
		addTextLimiter(fieldSenha, 40);
		addTextLimiter(fieldNome, 40);

		fieldNome.setTooltip(new Tooltip("Digite seu nome completo."));
		fieldCpf.setTooltip(new Tooltip("Digite seu cpf, aceito somente numeros."));
		fieldLogin.setTooltip(new Tooltip("Digite um login no máximo 30 caracteres."));
		fieldSenha.setTooltip(new Tooltip("Digite uma senha de acesso."));
	}

	public void onSalvar() {
		System.out.println("Botao salvar clicado");
		if (!validaTela()) {
			DialogUtil.mensagemAlerta("Cadastro de Funcionários",
					"Por favor revise os campos digitados e tente novamente ", criticas.toString());
		} else {
			DialogUtil.mensagem("Cadastro de Funcionários", "Aguarde, salvando funcionário ", "Conectando ao Banco...");
			if (new DaoLogin().loginSalvar(fieldNome.getText(), fieldCpf.getText(), fieldLogin.getText(),
					fieldSenha.getText()))
				DialogUtil.mensagem("Cadastro de Funcionários", "Salvo", "");
		}
	}

	private StringBuilder criticas = null;

	private boolean validaTela() {
		boolean ok = false;
		criticas = new StringBuilder();

		if (!(fieldNome.getText().trim().length() > 0))
			criticas.append(" Nome ;");
		if (!(fieldCpf.getText().trim().length() > 9))
			criticas.append(" CPF ;");

		if (!(fieldLogin.getText().trim().length() > 0))
			criticas.append(" Login ; ");
		if (!(fieldSenha.getText().trim().length() > 0))
			criticas.append(" Senha ");
		if (criticas.length() > 1)
			return false;
		return true;
	}

	public void onAlterar() {

	}

	public void onDelete() {

	}

	public void onCancelar() {
	}

	public static void addTextLimiter(final TextField tf, final int maxLength) {
		tf.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (tf.getText().length() > maxLength) {
					String s = tf.getText().substring(0, maxLength);
					tf.setText(s);
				}
			}
		});
	}
}
