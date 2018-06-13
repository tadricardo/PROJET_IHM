package package1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class EasyPrint2 extends Application {

	Label labelUtil = new Label("0");
	Label labelAlea = new Label("2");
	Button bmoinsUtil = new Button("  -  ");
	Button bplusUtil = new Button("  +  ");
	Button bmoinsAlea = new Button("  -  ");
	Button bplusAlea = new Button("  +  ");
	Button exit = new Button("Exit");
	Button reset = new Button("Reset");
	Button reset1 = new Button("Reset");
	Button aleatoire = new Button("Mode Aleatoire");
	Button utilisateur = new Button("Mode Utilisateur");
	Button regenerer = new Button(" regenerate ");
	HBox hBoxUtil;
	VBox vBoxUtil;
	HBox hBoxAlea;
	VBox vBoxAlea;
	Group root = new Group();
	GridPane gridPane = new GridPane();
	ColorPicker colorPicker = new ColorPicker();
	Color[] colorsRgb = new Color[10];
	TextField[] texts = new TextField[10];
	TextField[] texts2 = new TextField[10];
	int[] colorsGrey = new int[10];
	int currentValue = 0;
	Rectangle rgb;
	Rectangle gris;
	int grey;
	TextField text;
	TextField text2;
	final HBox hboxChoix = new HBox(30);
	ModuleCouleur[] mod = new ModuleCouleur[10];
	CheckBox[] checkBox = new CheckBox[10];

	boolean dis = false;

	class ClicListener implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {

			// gere les evenements ajouter/enlever une couleur du mode utilisateur
			if (event.getTarget() == bplusUtil || event.getTarget() == bmoinsUtil) {

				// gere l'evenement ajout d'une couleur juqu'a 10 couleurs max
				if (event.getTarget() == bplusUtil && Integer.parseInt(labelUtil.getText()) < 10) {

					// creer un nouveau module couleur
					labelUtil.setText("" + (currentValue + 1));

					text = new TextField("RGB(" + 255 + "," + 255 + "," + 255 + ")");
					text.setFont(Font.font(null, FontWeight.SEMI_BOLD, 11));
					text.setMaxWidth(122);

					text2 = new TextField("0xffffffff");
					text2.setFont(Font.font(null, FontWeight.SEMI_BOLD, 11));
					text2.setMaxWidth(122);

					VBox vBox = new VBox(30);

					rgb = new Rectangle(120, 120, Color.WHITE);
					rgb.setStroke(Color.BLACK);
					rgb.setStrokeWidth(2);

					gris = new Rectangle(120, 120, Color.WHITE);
					gris.setStroke(Color.BLACK);
					gris.setStrokeWidth(2);

					colorPicker.setValue(Color.WHITE);
					colorPicker.setMaxWidth(122);

					colorsRgb[currentValue] = Color.WHITE;
					colorsGrey[currentValue] = 255;
					texts[currentValue] = text;
					texts2[currentValue] = text2;

					vBox.getChildren().addAll(colorPicker, rgb, gris, text, text2);

					gridPane.addColumn(currentValue, vBox);

					currentValue++;
				}
				
				
				// gere l'evenement suppression d'une couleur jusqu'a 0 couleur mini
				if (event.getTarget() == bmoinsUtil) {
					supprimerCouleurUtil();
				}
				
			} else {// gere les evenements ajouter/enlever une couleur du mode utilisateur

				// gere l'evenement ajout d'une couleur jusqu'a 10 couleurs max
				if (event.getTarget() == bplusAlea && Integer.parseInt(labelAlea.getText()) < 10) {

					labelAlea.setText("" + (Integer.parseInt(labelAlea.getText()) + 1));
					Alea();
				}

				// gere l'evenement suppression d'une couleurs jusqu'a 2 couleur mini
				if (event.getTarget() == bmoinsAlea && Integer.parseInt(labelAlea.getText()) > 2) {

					labelAlea.setText("" + (Integer.parseInt(labelAlea.getText()) - 1));
					Alea();
				}

				// permet de regenerer aleatoirement les couleurs
				if (event.getTarget() == regenerer) {

					regenerate();
				}
			}
		}
	}
	
	public void supprimerCouleurUtil() {
		VBox vbox2 = new VBox(30);
		colorPicker.setMaxWidth(122);

		if (gridPane.getChildren().size() == 1)

			labelUtil.setText("" + (currentValue));

		else {

			rgb = new Rectangle(120, 120, colorsRgb[currentValue - 2]);
			rgb.setStroke(Color.BLACK);
			rgb.setStrokeWidth(2);

			gris = new Rectangle(120, 120, new Color(colorsGrey[currentValue - 2] / 255.,
					colorsGrey[currentValue - 2] / 255., colorsGrey[currentValue - 2] / 255., 1.));
			gris.setStroke(Color.BLACK);
			gris.setStrokeWidth(2);

			colorPicker.setValue(colorsRgb[currentValue - 2]);
			gridPane.getChildren().remove(currentValue - 1);
			gridPane.getChildren().remove(currentValue - 2);

			vbox2.getChildren().addAll(colorPicker, rgb, gris, texts[currentValue - 2],
					texts2[currentValue - 2]);

			gridPane.addColumn(currentValue - 2, vbox2);

			labelUtil.setText("" + (currentValue - 1));

			currentValue--;
		}
	}

	// regenere les couleurs non validé
	public void regenerate() {
		root.getChildren().clear();
		root.getChildren().addAll(hboxChoix);

		labelAlea.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		labelAlea.setStyle("-fx-background-color: lightblue;" + " -fx-alignment: center;" + " -fx-font: 30px Verdana;");

		GridPane gridPane = new GridPane();
		gridPane.setHgap(34);
		gridPane.setLayoutY(235);
		gridPane.setLayoutX(26);

		vBoxAlea = new VBox(10);
		vBoxAlea.setPadding(new Insets(10, 10, 10, 10));
		hBoxAlea = new HBox(10);

		hBoxAlea.getChildren().addAll(bmoinsAlea, bplusAlea);
		vBoxAlea.getChildren().addAll(labelAlea, hBoxAlea, regenerer);
		vBoxAlea.setLayoutX(734);
		vBoxAlea.setLayoutY(18);

		VBox[] box2 = new VBox[10];

		// 5 pixels space between child nodes
		int num1 = Integer.parseInt(labelAlea.getText());
		for (int i = 0; i < Integer.parseInt(labelAlea.getText()); i++) {

			if (checkBox[i].isSelected()) {

				box2[i] = new VBox(30);
				box2[i].getChildren().addAll(checkBox[i], mod[i].r2, mod[i].r1, mod[i].text, mod[i].text2);
				gridPane.addColumn(i, box2[i]);

			} else {

				//checkBox[i] = new CheckBox("Valider");
				box2[i] = new VBox(30);
				mod[i] = new ModuleCouleur(((int) (235) / num1) * (i + 1));
				box2[i].getChildren().addAll(checkBox[i], mod[i].r2, mod[i].r1, mod[i].text, mod[i].text2);
				gridPane.addColumn(i, box2[i]);

			}
		}
		root.getChildren().addAll(vBoxAlea, reset, gridPane, exit);
	}


	public void disable() {


		dis = false;
		for(int i = 0; i < checkBox.length; i++) {
			if (checkBox[i].isSelected()) {

				bplusAlea.setDisable(true);
				bmoinsAlea.setDisable(true);
				
				dis = true;
			}
		}

		if(dis == false) {

			bplusAlea.setDisable(false);
			bmoinsAlea.setDisable(false);
			
		}

	}
	// creer toute les couleurs necessaire a l'affichage du mode aleatoire
	public void Alea() {

		root.getChildren().clear();
		root.getChildren().addAll(hboxChoix);

		labelAlea.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		labelAlea.setStyle("-fx-background-color: lightblue;" + " -fx-alignment: center;" + " -fx-font: 30px Verdana;");

		GridPane gridPane = new GridPane();
		gridPane.setHgap(34);
		gridPane.setLayoutY(235);
		gridPane.setLayoutX(26);

		vBoxAlea = new VBox(10);
		vBoxAlea.setPadding(new Insets(10, 10, 10, 10));
		hBoxAlea = new HBox(10);

		hBoxAlea.getChildren().addAll(bmoinsAlea, bplusAlea);
		vBoxAlea.getChildren().addAll(labelAlea, hBoxAlea, regenerer);
		vBoxAlea.setLayoutX(734);
		vBoxAlea.setLayoutY(18);

		VBox[] box = new VBox[10];

		aleatoire.setDisable(true);
		utilisateur.setDisable(false);
		
		// 5 pixels space between child nodes
		int num = Integer.parseInt(labelAlea.getText());
		for (int i = 0; i < Integer.parseInt(labelAlea.getText()); i++) {

			box[i] = new VBox(30);
			mod[i] = new ModuleCouleur(((int) (235) / num) * (i + 1));
			box[i].getChildren().addAll(checkBox[i], mod[i].r2, mod[i].r1, mod[i].text, mod[i].text2);
			gridPane.addColumn(i, box[i]);
		}

		root.getChildren().addAll(vBoxAlea, reset, gridPane, exit);
	}

	// creer toute les couleurs necessaire a l'affichage du mode utilisateur
	public void utilisateur() {
		System.out.println("ok");
		root.getChildren().clear();
		root.getChildren().addAll(reset1, hboxChoix, exit);

		labelUtil.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		labelUtil.setStyle("-fx-background-color: lightblue;" + " -fx-alignment: center;" + " -fx-font: 30px Verdana;");

		vBoxUtil = new VBox(10);
		vBoxUtil.setLayoutX(734);
		vBoxUtil.setLayoutY(18);
		vBoxUtil.setPadding(new Insets(10, 10, 10, 10));

		hBoxUtil = new HBox(10);
		hBoxUtil.getChildren().addAll(bmoinsUtil, bplusUtil);
		vBoxUtil.getChildren().addAll(labelUtil, hBoxUtil);

		gridPane.setHgap(34);
		gridPane.setLayoutY(220);
		gridPane.setLayoutX(26);
		
		aleatoire.setDisable(false);
		utilisateur.setDisable(true);
		colorPicker.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				Color color = colorPicker.getValue();

				int red = (int) (color.getRed() * 255);
				int green = (int) (color.getGreen() * 255);
				int blue = (int) (color.getBlue() * 255);

				grey = (int) ((color.getRed() * 255 * 0.2125) + (color.getGreen() * 255 * 0.7154)
						+ (color.getBlue() * 255 * 0.0721));
				rgb.setFill(color);

				gris.setFill(new Color(grey / 255., grey / 255., grey / 255., 1.));
				text.setText("RGB (" + red + "," + green + "," + blue + ")");
				text2.setText(""+color);

				colorsRgb[currentValue - 1] = color;
				colorsGrey[currentValue - 1] = grey;
				texts[currentValue - 1] = text;
				texts2[currentValue - 1] = text2;

			}
		});

		root.getChildren().addAll(vBoxUtil, gridPane);

	}

	@Override
	public void start(Stage stage) throws Exception {

		bplusUtil.addEventHandler(ActionEvent.ACTION, new ClicListener());
		bmoinsUtil.addEventHandler(ActionEvent.ACTION, new ClicListener());
		bplusAlea.addEventHandler(ActionEvent.ACTION, new ClicListener());
		bmoinsAlea.addEventHandler(ActionEvent.ACTION, new ClicListener());
		regenerer.addEventHandler(ActionEvent.ACTION, new ClicListener());

		hboxChoix.setLayoutX(650);
		hboxChoix.setLayoutY(760);
		hboxChoix.getChildren().addAll(aleatoire, utilisateur);

		exit.setLayoutX(1480);
		exit.setLayoutY(760);
		exit.setTextFill(Color.RED);
		exit.setFont(Font.font(14));

		reset.setLayoutX(20);
		reset.setLayoutY(760);
		reset.setTextFill(Color.RED);
		reset.setFont(Font.font(14));
		
		reset1.setLayoutX(20);
		reset1.setLayoutY(760);
		reset1.setTextFill(Color.RED);
		reset1.setFont(Font.font(14));

		for (int i = 0; i < 10; i++) {

			mod[i] = new ModuleCouleur(110);
		}

		aleatoire.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				Alea();

			}
		});

		utilisateur.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {


				utilisateur();

			}

		});

		for(int i = 0; i < checkBox.length;i++) {
			checkBox[i] = new CheckBox("Valider");

			checkBox[i].setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {

					disable();

				}
			});
		}

		exit.setOnAction(e -> System.exit(0));
		
		reset.setOnAction(e -> { 	
			labelAlea.setText("2");

			for(int i = 0; i < checkBox.length;i++) {
				checkBox[i] = new CheckBox("Valider");

				checkBox[i].setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {

						disable();

					}
				});
			}
			bmoinsAlea.setDisable(false);
			bplusAlea.setDisable(false);
			Alea();
		});
		
		reset1.setOnAction(e -> { 	
			for(int i = Integer.parseInt(labelUtil.getText()); i > 0; i--) {
				supprimerCouleurUtil();
			}
		});
		
		root.getChildren().addAll(hboxChoix, exit);

		Scene scene = new Scene(root);
		scene.setFill(Color.rgb(204, 204, 204));

		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("INTERFACE DE VARIATION DE COULEUR");

		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		stage.setX(bounds.getMinX());
		stage.setY(bounds.getMinY());
		stage.setWidth(bounds.getWidth());
		stage.setHeight(bounds.getHeight());

		stage.show();

	}

	public static void main(String[] args) {

		Application.launch(EasyPrint2.class, args);

	}
}
