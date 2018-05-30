package test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Test extends Application {
	
	public void start(Stage primaryStage) {
		Group root = new Group();
		Scene scene = new Scene(root, 300, 250);
		// 5 pixels space between child nodes
		VBox vbox = new VBox(5);
		// 1 pixel padding between child nodes only
		vbox.setPadding(new Insets(1));


		int nivGris=250;//chiffre a modifier pour cr�er de nouveaux gris

		Rectangle r1 = new Rectangle(100, 100);
		r1.setFill( new Color( nivGris/255. ,nivGris/255. , nivGris/255. , 1. ));
		Rectangle r2 = new Rectangle(100, 100);


		CouleurAssocie coul= new CouleurAssocie(nivGris);

		r2.setFill(coul.couleur);

		Text text = new Text( (int)(coul.couleur.getRed()*255)+ " " + (int)(coul.couleur.getGreen()*255) + " " + (int)(coul.couleur.getBlue()*255) );
		Text text2 = new Text( (int)(coul.couleur.getRed()*10)/10.0+ " " +  (int)(coul.couleur.getGreen()*10)/10.0 + " " +  (int)(coul.couleur.getBlue()*10)/10.0 );


		HBox.setMargin(r1, new Insets(2, 2, 2, 2));

		vbox.getChildren().addAll(r1, r2, text, text2);
		root.getChildren().add(vbox);


		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		
		launch(args);
	}
}
