package package1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EasyPrint2 extends Application {

	Label labelUtil = new Label("0");
	Label labelAlea = new Label("2");
	Button bmoinsUtil = new Button("  -  ");
	Button bplusUtil = new Button("  +  ");
	Button bmoinsAlea = new Button("  -  ");
	Button bplusAlea = new Button("  +  ");
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
	Text[] texts = new Text[10];
	Text[] texts2 = new Text[10];
	int[] colorsGrey = new int[10];
	int currentValue = 0;
	Rectangle rgb;
	Rectangle gris;
	int grey;
	Text text;
	Text text2;
	final HBox hboxChoix = new HBox(30);

	class ClicListener implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {

			if (event.getTarget() == bplusUtil || event.getTarget() == bmoinsUtil) {

				if (event.getTarget() == bplusUtil && Integer.parseInt(labelUtil.getText()) < 10) {

					labelUtil.setText("" + (currentValue + 1));

					text = new Text("  R: " + 255 + "  G: " + 255 + "  B: " + 255);
					text.setFont(Font.font(null, FontWeight.SEMI_BOLD, 12.5));
					text.setFill(Color.BLACK);

					text2 = new Text("     " + 1.0 + "     " + 1.0 + "     " + 1.0);
					text2.setFont(Font.font(null, FontWeight.SEMI_BOLD, 12.5));
					text2.setFill(Color.BLACK);

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

				if (event.getTarget() == bmoinsUtil) {

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
			} else {

				if (event.getTarget() == bplusAlea && Integer.parseInt(labelAlea.getText()) < 10) {

					labelAlea.setText("" + (Integer.parseInt(labelAlea.getText()) + 1));
					Alea();
				}

				if (event.getTarget() == bmoinsAlea && Integer.parseInt(labelAlea.getText()) > 2) {

					labelAlea.setText("" + (Integer.parseInt(labelAlea.getText()) - 1));
					Alea();
				}

				if (event.getTarget() == regenerer) {
					Alea();
				}
			}
		}
	}

	public void Alea() {

		root.getChildren().clear();
		root.getChildren().addAll(hboxChoix);

		labelAlea.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		labelAlea.setStyle("-fx-background-color: lightblue;" + " -fx-alignment: center;" + " -fx-font: 30px Verdana;");

		GridPane gridPane = new GridPane();
		gridPane.setHgap(12);
		gridPane.setLayoutY(180);
		gridPane.setLayoutX(8);

		vBoxAlea = new VBox(10);
		vBoxAlea.setPadding(new Insets(10, 10, 10, 10));
		hBoxAlea = new HBox(10);

		hBoxAlea.getChildren().addAll(bmoinsAlea, bplusAlea);
		vBoxAlea.getChildren().addAll(labelAlea, hBoxAlea, regenerer);
		vBoxAlea.setLayoutX(628);
		vBoxAlea.setLayoutY(18);

		VBox[] box = new VBox[10];
		ModuleCouleur[] mod = new ModuleCouleur[10];

		// 5 pixels space between child nodes
		int num = Integer.parseInt(labelAlea.getText());
		for (int i = 0; i < Integer.parseInt(labelAlea.getText()); i++) {
			box[i] = new VBox(30);
			mod[i] = new ModuleCouleur(((int) (235) / num) * (i + 1));
			box[i].getChildren().addAll(mod[i].r1, mod[i].r2, mod[i].text, mod[i].text2);
			gridPane.addColumn(i, box[i]);
		}

		root.getChildren().addAll(vBoxAlea, gridPane);
	}

	public void utilisateur() {

		root.getChildren().clear();
		root.getChildren().addAll(hboxChoix);
		
		labelUtil.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		labelUtil.setStyle("-fx-background-color: lightblue;" + " -fx-alignment: center;" + " -fx-font: 30px Verdana;");

		vBoxUtil = new VBox(10);
		vBoxUtil.setLayoutX(628);
		vBoxUtil.setLayoutY(18);
		vBoxUtil.setPadding(new Insets(10, 10, 10, 10));
		
		hBoxUtil = new HBox(10);
		hBoxUtil.getChildren().addAll(bmoinsUtil, bplusUtil);
		vBoxUtil.getChildren().addAll(labelUtil, hBoxUtil);
		
		gridPane.setHgap(12);
		gridPane.setLayoutY(154);
		gridPane.setLayoutX(8);

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
				text.setText("  R: " + red + "  G: " + green + "  B: " + blue);
				text2.setText("     " + (int) (color.getRed() * 10) / 10.0 + "     "
						+ (int) (color.getGreen() * 10) / 10.0 + "     " + (int) (color.getBlue() * 10) / 10.0);

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

		hboxChoix.setLayoutX(558);
		hboxChoix.setLayoutY(620);
		hboxChoix.getChildren().addAll(aleatoire, utilisateur);

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

		root.getChildren().addAll(hboxChoix);

		Scene scene = new Scene(root, 1340, 700);
		scene.setFill(Color.rgb(204, 204, 204));

		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("INTERFACE DE VARIATION DE COULEUR");
		stage.show();

	}

	public static void main(String[] args) {

		Application.launch(EasyPrint2.class, args);

	}
}
