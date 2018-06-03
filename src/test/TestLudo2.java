package test;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
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

public class TestLudo2 extends Application {

	Label label;
	Button bmoins;
	Button bplus;
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

	class ClicListenerIncDec implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {

			if (event.getTarget() == bplus && Integer.parseInt(label.getText()) < 10) {

				label.setText("" + (currentValue + 1));

				text = new Text("R:  " + 255 + "    G:  " + 255 + "    B:  " + 255);
				text.setFont(Font.font(null, FontWeight.SEMI_BOLD, 12.5));
				text.setFill(Color.BLACK);

				text2 = new Text("   " + 1.0 + "        " + 1.0 + "       " + 1.0);
				text2.setFont(Font.font(null, FontWeight.SEMI_BOLD, 12.5));
				text2.setFill(Color.BLACK);

				VBox vBox = new VBox(30);

				rgb = new Rectangle(140, 140, Color.WHITE);
				rgb.setStroke(Color.BLACK);
				rgb.setStrokeWidth(3);

				gris = new Rectangle(140, 140, Color.WHITE);
				gris.setStroke(Color.BLACK);
				gris.setStrokeWidth(3);

				colorPicker.setValue(Color.WHITE);
				colorPicker.setMaxWidth(143);

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
				colorPicker.setMaxWidth(143);

				if (gridPane.getChildren().size() == 1)

					label.setText("" + (currentValue));

				else {

					rgb = new Rectangle(140, 140, colorsRgb[currentValue - 2]);
					rgb.setStroke(Color.BLACK);
					rgb.setStrokeWidth(3);

					gris = new Rectangle(140, 140, new Color(colorsGrey[currentValue - 2] / 255.,
							colorsGrey[currentValue - 2] / 255., colorsGrey[currentValue - 2] / 255., 1.));
					gris.setStroke(Color.BLACK);
					gris.setStrokeWidth(3);

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

		label = new Label("0");
		label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		label.setStyle("-fx-background-color: lightblue;" + " -fx-alignment: center;" + " -fx-font: 30px Verdana;");
		bmoins = new Button("  -  ");
		bplus = new Button("  +  ");

		bplus.addEventHandler(ActionEvent.ACTION, new ClicListenerIncDec());
		bmoins.addEventHandler(ActionEvent.ACTION, new ClicListenerIncDec());

		Group root = new Group();
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(10, 10, 10, 10));
		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(bmoins, bplus);
		vbox.getChildren().addAll(label, hbox);
		vbox.setLayoutX(746);
		vbox.setLayoutY(10);
		gridPane.setHgap(16);
		gridPane.setLayoutY(140);
		gridPane.setLayoutX(12);

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
				text.setText("   R: " + red + "   G: " + green + "   B: " + blue);
				text2.setText("        " + (int) (color.getRed() * 10) / 10.0 + "    "
						+ (int) (color.getGreen() * 10) / 10.0 + "    " + (int) (color.getBlue() * 10) / 10.0);

				colorsRgb[currentValue - 1] = color;
				colorsGrey[currentValue - 1] = grey;
				texts[currentValue - 1] = text;
				texts2[currentValue - 1] = text2;

			}
		});

		root.getChildren().addAll(vbox, gridPane);

		Scene scene = new Scene(root, 1590, 620);
		scene.setFill(Color.rgb(204, 204, 204));
		stage.setResizable(false);
		stage.setScene(scene);

		stage.setTitle("INTERFACE DE VARIATION DE COULEUR");
		stage.show();

	}

	public static void main(String[] args) {

		Application.launch(TestLudo2.class, args);

	}
}
