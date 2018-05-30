package test;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
	VBox rectangle = new VBox(25);
	VBox monSlider = new VBox(10);
	VBox colonne = new VBox(10);
	HBox rgb = new HBox(25);
	FlowPane mesSliders = new FlowPane(10,10);

	// class interne permettant de gerer les EventHandler "clic souris"
	class ClicListenerIncDec implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {

			int currentValue = Integer.parseInt(label.getText());

			if (event.getTarget() == bplus && currentValue < 10) {

				label.setText("" + (currentValue + 1));
				
				int nivGris=200;
				Rectangle r1 = new Rectangle(100, 100);
				r1.setFill( new Color( nivGris/255. ,nivGris/255. , nivGris/255. , 1. ));
				Rectangle r2 = new Rectangle(100, 100);
				CouleurAssocie coul= new CouleurAssocie(nivGris);
				r2.setFill(coul.couleur);
				
				rectangle.getChildren().addAll(r1,r2);
				for (int i = 1; i <= 3; i++) {
					Label labelRgb = new Label("0");
					labelRgb.setStyle("-fx-background-color: lightblue;"+ " -fx-font: 30px Verdana;");
					labelRgb.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
					rgb.getChildren().add(labelRgb);
					
					Slider slider = new Slider(0,255,0);
					slider.setShowTickLabels(true);
					slider.setShowTickMarks(true);
					slider.setMajorTickUnit(50);
					slider.setMinorTickCount(5);
					slider.setBlockIncrement(10);
					monSlider.getChildren().add(slider);
				}
				
				colonne.getChildren().addAll(rectangle,monSlider,rgb);
				mesSliders.getChildren().addAll(colonne);
				
			}

			if (event.getTarget() == bmoins) {

				label.setText("" + currentValue );
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
		rectangle.setPadding(new Insets(0, 0, 25, 25));
		rgb.setPadding(new Insets(20, 20, 20, 20));
		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(bmoins, bplus);
		vbox.getChildren().addAll(label, hbox);
		mesSliders.setLayoutY(180);
		mesSliders.setLayoutX(10);
		root.getChildren().addAll(vbox,mesSliders);

		stage.setResizable(false);
		stage.setScene(new Scene(root, 800, 660));

		stage.setTitle("INTERFACE DE VARIATION");
		stage.show();
	}

	public static void main(String[] args) {

		Application.launch(TestLudo.class, args);

	}
}
