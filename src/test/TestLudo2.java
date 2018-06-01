package test;

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

public class TestLudo2 extends Application {

	Label label;
	Button bmoins;
	Button bplus;
	GridPane gridPane = new GridPane();
	ColorPicker colorPicker = new ColorPicker();
	Rectangle rgb;
	Rectangle gris;
	int grey;
	Text text;
	Text text2;

	class ClicListenerIncDec implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {

			int currentValue = Integer.parseInt(label.getText());

			if (event.getTarget() == bplus && currentValue < 10) {

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
				
				colorPicker.setMaxWidth(143);
				
				vBox.getChildren().addAll(colorPicker, rgb, gris, text, text2);
				gridPane.addColumn(currentValue, vBox);

			}

			if (event.getTarget() == bmoins && currentValue > 0) {
				gridPane.getChildren().remove(gridPane.getChildren().size() - 1);
				label.setText("" + (currentValue - 1));

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
