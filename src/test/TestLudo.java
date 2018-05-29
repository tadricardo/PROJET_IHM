package test;

import java.awt.event.MouseWheelEvent;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestLudo extends Application {

	Label label;
	Button bmoins;
	Button bplus;

	// class interne permettant de gerer les EventHandler "clic souris"
	class ClicListenerIncDec implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {

			int currentValue = Integer.parseInt(label.getText());

			if (event.getTarget() == bplus && currentValue < 10)

				label.setText("" + (currentValue + 1));

			if (event.getTarget() == bmoins && currentValue > 0)

				label.setText("" + (currentValue - 1));

		}

	}

	@Override
	public void start(Stage stage) throws Exception {

		label = new Label("10");
		label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		label.setStyle("-fx-background-color: lightblue;" + " -fx-alignment: center;" + " -fx-font: 30px Verdana;");
		bmoins = new Button("  -  ");
		bplus = new Button("  +  ");

		bplus.addEventHandler(ActionEvent.ACTION, new ClicListenerIncDec());
		bmoins.addEventHandler(ActionEvent.ACTION, new ClicListenerIncDec());

		Group root = new Group();
		
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(10, 10, 10, 10));
		vbox.setAlignment(Pos.TOP_RIGHT);
		
		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(bmoins, bplus);
		vbox.getChildren().addAll(label, hbox);
		hbox.setAlignment(Pos.TOP_RIGHT);
		root.getChildren().addAll(vbox);

		stage.setResizable(true);
		stage.setScene(new Scene(root, 600, 550));

		stage.setTitle("INTERFACE DE VARIATION");
		stage.show();
	}

	public static void main(String[] args) {

		Application.launch(TestLudo.class, args);

	}
}
