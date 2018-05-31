package test;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class TestLudo extends Application {

	Label label;
	Button bmoins;
	Button bplus;
	GridPane gridPane = new GridPane();
	HBox mesSliders = new HBox(10);
	Text text;

	// class interne permettant de gerer les EventHandler "clic souris"
	class ClicListenerIncDec implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {

			int currentValue = Integer.parseInt(label.getText());

			if (event.getTarget() == bplus && currentValue < 10) {

				label.setText("" + (currentValue + 1));
				UnSlider us = new UnSlider();
				gridPane.addColumn(currentValue,us.getVbox());
			}

				

			if (event.getTarget() == bmoins) {

				label.setText("" + currentValue);
			}

		}

	}

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
		gridPane.setHgap(18);
		gridPane.setLayoutY(140);
		gridPane.setLayoutX(20);
		root.getChildren().addAll(vbox,gridPane);
		
		
		Scene scene = new Scene(root, 1590, 600);
		stage.setResizable(false);
		stage.setScene(scene);

		stage.setTitle("INTERFACE DE VARIATION");
		stage.show();

	}

	public static void main(String[] args) {

		Application.launch(TestLudo.class, args);

	}
}
