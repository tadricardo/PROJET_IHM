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

	Label label;
	Button bmoins = new Button("  -  ");
	Button bplus = new Button("  +  ");
	Button aleatoire = new Button("Mode Aleatoire");
	Button utilisateur = new Button("Mode Utilisateur");
	HBox hBox;
	VBox vBox;
	Stage monStage;
	Scene scene;
	Scene sceneUtilisateur;
	Scene sceneAleatoire;
	int choix = 2;
	Group root = new Group();
	GridPane gridPane = new GridPane();
	ColorPicker colorPicker = new ColorPicker();
	Color[] colorsRgb = new Color[10];
	Text[] texts = new Text[10];
	int[] colorsGrey = new int[10];
	Text[] texts2 = new Text[10];
	int currentValue = 0;
	Rectangle rgb;
	Rectangle gris;
	int grey;
	Text text;
	Text text2;

	class ClicListener implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {

			if (event.getTarget() == bplus && Integer.parseInt(label.getText()) < 10) {

				label.setText("" + (currentValue + 1));

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

			if (event.getTarget() == bmoins) {

				VBox vbox2 = new VBox(30);
				colorPicker.setMaxWidth(122);

				if (gridPane.getChildren().size() == 1)

					label.setText("" + (currentValue));

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

					label.setText("" + (currentValue - 1));

					currentValue--;
				}
			}

		}
	}

	@Override
	public void start(Stage stage) throws Exception {

		bplus.addEventHandler(ActionEvent.ACTION, new ClicListener());
		bmoins.addEventHandler(ActionEvent.ACTION, new ClicListener());
		aleatoire.addEventHandler(ActionEvent.ACTION, new ClicListener());
		utilisateur.addEventHandler(ActionEvent.ACTION, new ClicListener());

		HBox hboxChoix = new HBox(30);
		hboxChoix.setLayoutX(570);
		hboxChoix.setLayoutY(620);
		hboxChoix.getChildren().addAll(aleatoire, utilisateur);

		if (choix == 1) {

			choix = 0;
			GridPane gridPane = new GridPane();
			gridPane.setHgap(14);
			gridPane.setLayoutY(154);
			gridPane.setLayoutX(14);
			
			VBox[] box = new VBox[10];
			ModuleCouleur[] mod = new ModuleCouleur[10];
			
			// 5 pixels space between child nodes
			int num = 10;
			for(int i = 0; i < 10; i++) {
				
				box[i] = new VBox(30);
				mod[i] = new ModuleCouleur(((int) (235) / num) * (i+1));
				box[i].getChildren().addAll(mod[i].r1, mod[i].r2, mod[i].text, mod[i].text2);
				gridPane.addColumn(i, box[i]);
				
			}

			root.getChildren().addAll(gridPane, hboxChoix);
			sceneAleatoire = new Scene(root, 1380, 700);
			sceneAleatoire.setFill(Color.rgb(204, 204, 204));
			stage.setScene(sceneAleatoire);

		} else if (choix == 2) {

			choix = 0;
			label = new Label("0");
			label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			label.setStyle("-fx-background-color: lightblue;" + " -fx-alignment: center;" + " -fx-font: 30px Verdana;");

			vBox = new VBox(10);
			vBox.setPadding(new Insets(10, 10, 10, 10));
			hBox = new HBox(10);

			hBox.getChildren().addAll(bmoins, bplus);
			vBox.getChildren().addAll(label, hBox);
			vBox.setLayoutX(642);
			vBox.setLayoutY(18);
			gridPane.setHgap(14);
			gridPane.setLayoutY(154);
			gridPane.setLayoutX(14);

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

			root.getChildren().addAll(vBox, gridPane, hboxChoix);
			sceneUtilisateur = new Scene(root, 1380, 700);
			sceneUtilisateur.setFill(Color.rgb(204, 204, 204));
			stage.setScene(sceneUtilisateur);

		} else {

			root.getChildren().addAll(hboxChoix);
			scene = new Scene(root, 1450, 700);
			scene.setFill(Color.rgb(204, 204, 204));
			stage.setResizable(false);
			stage.setScene(scene);
		}

		stage.setTitle("INTERFACE DE VARIATION DE COULEUR");
		stage.show();

	}

	public static void main(String[] args) {

		Application.launch(EasyPrint2.class, args);

	}
}
