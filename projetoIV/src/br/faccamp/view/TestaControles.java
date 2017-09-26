package br.faccamp.view;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class TestaControles extends Application {
	private AnchorPane pane;
	private Button btnClick;
	private static Stage stage;

	public AnchorPane getPane() {
		return pane;
	}

	public void setPane(AnchorPane pane) {
		this.pane = pane;
	}

	public Button getBtnClick() {
		return btnClick;
	}

	public void setBtnClick(Button btnClick) {
		this.btnClick = btnClick;
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		TestaControles.stage = stage;
	}

	private void initTreeView() {
		TreeView<String> treeView = new TreeView<String>();
		TreeItem<String> item1 = new TreeItem<String>("Tópico 1");
		TreeItem<String> subitem1 = new TreeItem<String>("Tópico 1.1");
		TreeItem<String> subitem1_1 = new TreeItem<String>("Tópico 1.1.1");
		TreeItem<String> subitem1_2 = new TreeItem<String>("Tópico 1.1.2");
		TreeItem<String> subitem2 = new TreeItem<String>("Tópico 1.2");
		TreeItem<String> subitem3 = new TreeItem<String>("Tópico 1.3");
		TreeItem<String> subitem3_1 = new TreeItem<String>("Tópico 1.3.1");
		item1.getChildren().addAll(subitem1, subitem2, subitem3);
		subitem1.getChildren().addAll(subitem1_1, subitem1_2);
		subitem3.getChildren().add(subitem3_1);
		treeView.setRoot(item1);
		/* Indicar TreeView em um painel principal... */
		pane.getChildren().add(treeView);
	}

	private void initContextMenu() {
		final ListView<String> listView = new ListView<String>(
				FXCollections.observableArrayList("Primeiro item", "Segundo item", "Terceiro item"));
		ContextMenu contextMenu = new ContextMenu();
		MenuItem item1 = new MenuItem("Mostrar valor");
		item1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				JOptionPane.showMessageDialog(null, listView.getSelectionModel().getSelectedItem());
			}
		});

		MenuItem item2 = new MenuItem("Determinar valor nulo");
		item2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				listView.getItems().set(listView.getSelectionModel().getSelectedIndex(), "null");
			}
		});

		contextMenu.getItems().addAll(item1, item2);
		listView.setContextMenu(contextMenu);
		/* Indicar ListView em um painel principal... */
		pane.getChildren().add(listView);
	}

	private void initBarChart() {
		// utilizando grafico de barras
		BarChart<String, Number> chartLinguagens = new BarChart<String, Number>(new CategoryAxis(), new NumberAxis());
		// define o espaçamento entre as barras.
		chartLinguagens.setCategoryGap(30);
		// inserindo o title do grafico
		chartLinguagens.setTitle("Ranking de Linguagens de Programação Mar/2013");
		// seta nome e valor de cada linguagem apresentada no grafico
		XYChart.Data<String, Number> dataJava = new XYChart.Data<String, Number>("Java", 18.156);
		XYChart.Data<String, Number> dataC = new XYChart.Data<String, Number>("C", 17.141);
		XYChart.Data<String, Number> dataObjectiveC = new XYChart.Data<String, Number>("Objective-C", 10.230);
		XYChart.Data<String, Number> dataCPlus = new XYChart.Data<String, Number>("C++", 9.115);
		XYChart.Data<String, Number> dataCSharp = new XYChart.Data<String, Number>("C#", 6.597);
		XYChart.Series<String, Number> seriesData = new XYChart.Series<String, Number>();
		// rodapé ???
		seriesData.setName("Porcentagem (%)");

		seriesData.getData().addAll(dataJava, dataC, dataObjectiveC, dataCPlus, dataCSharp);

		chartLinguagens.getData().add(seriesData);
		/* Indicar o BarChart em um painel principal... */
		pane.getChildren().add(chartLinguagens);
	}

	public void initComponents() {
		pane = new AnchorPane();
		pane.setPrefSize(400, 500);
	}

	private void initLineChart() {
		LineChart<Number, Number> chartLinguagens = new LineChart<Number, Number>(new NumberAxis(2008, 2013, 5),
				new NumberAxis());
		chartLinguagens.setTitle("Ranking de Linguagens de Programação Mar/2013");
		XYChart.Series<Number, Number> serieJava = new XYChart.Series<Number, Number>();
		serieJava.setName("Java");
		serieJava.getData().addAll(new XYChart.Data<Number, Number>(2008, 1),
				new XYChart.Data<Number, Number>(2013, 1));
		XYChart.Series<Number, Number> serieC = new XYChart.Series<Number, Number>();
		serieC.setName("C");
		serieC.getData().addAll(new XYChart.Data<Number, Number>(2008, 2), new XYChart.Data<Number, Number>(2013, 2));
		XYChart.Series<Number, Number> serieObjectiveC = new XYChart.Series<Number, Number>();
		serieObjectiveC.setName("Objective-C");
		serieObjectiveC.getData().addAll(new XYChart.Data<Number, Number>(2008, 45),
				new XYChart.Data<Number, Number>(2013, 3));
		XYChart.Series<Number, Number> serieCPlus = new XYChart.Series<Number, Number>();
		serieCPlus.setName("C++");
		serieCPlus.getData().addAll(new XYChart.Data<Number, Number>(2008, 5),
				new XYChart.Data<Number, Number>(2013, 4));
		XYChart.Series<Number, Number> serieCSharp = new XYChart.Series<Number, Number>();
		serieCSharp.setName("C#");
		serieCSharp.getData().addAll(new XYChart.Data<Number, Number>(2008, 8),
				new XYChart.Data<Number, Number>(2013, 5));
		chartLinguagens.getData().addAll(serieJava, serieC, serieObjectiveC, serieCPlus, serieCSharp);
		pane.getChildren().add(chartLinguagens);
	}
	/**Aprender mais use o link abaixo 
	 * http://docs.oracle.com/javafx/2/charts/jfxpub-charts.htm
	 */
	private void initPieChart() {
		PieChart chartLinguagens = new PieChart();
		chartLinguagens.setTitle("Ranking de Linguagens de Programação Mar/2013");
		ObservableList<PieChart.Data> datas = FXCollections.observableArrayList(
				new PieChart.Data("Java", 18.156),
				new PieChart.Data("C", 17.141), 
				new PieChart.Data("Objective-C", 10.230),
				new PieChart.Data("C++", 9.115), 
				new PieChart.Data("C#", 6.597), 
				new PieChart.Data("Outros", 38.761));
		chartLinguagens.setData(datas);
		pane.getChildren().add(chartLinguagens);
	}

	private void initAudioPlayer() {
		Label lbTocando = new Label("Tocando música...");
		Media media =
		new Media(TelaComSwing.class.getResource("audio.mp3")
		.toExternalForm());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		/* Indicar Label em um painel principal... */
		}
	@Override
	public void start(Stage stage) throws Exception {

		initComponents();
		// initBarChart();
		// initLineChart();
		// initPieChart();
		initAudioPlayer();
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		// Remove a opção de maximizar a tela
		stage.setResizable(true);
		// Dá um título para a tela
		stage.setTitle("Login - GolFX");
		stage.show();
		// initLayout();
		TestaControles.stage = stage;

	}

	public static void main(String[] args) {
		launch(args);
	}

}
