package package1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application {

	public void start(Stage primaryStage) {
		GridPane root = new GridPane();
		Scene scene = new Scene(root, 1000, 250);
		// 5 pixels space between child nodes
		VBox vbox1 = new VBox(5);
		VBox vbox2 = new VBox(5);
		VBox vbox3 = new VBox(5);
		VBox vbox4 = new VBox(5);
		VBox vbox5 = new VBox(5);
		VBox vbox6 = new VBox(5);
		VBox vbox7 = new VBox(5);
		VBox vbox8 = new VBox(5);
		VBox vbox9 = new VBox(5);
		VBox vbox10 = new VBox(5);

		
		ModuleCouleur m1= null;
		ModuleCouleur m2 = null;
		ModuleCouleur m3 = null;
		ModuleCouleur m4= null;
		ModuleCouleur m5= null;
		ModuleCouleur m6= null;
		ModuleCouleur m7= null;
		ModuleCouleur m8= null;
		ModuleCouleur m9= null;
		ModuleCouleur m10= null;
		
		ModuleCouleur[] mod= {m1,m2,m3,m4,m5,m6,m7,m8,m9,m10};

		VBox[] box= {vbox1,vbox2,vbox3,vbox4,vbox5,vbox6,vbox7,vbox8,vbox9,vbox10};
		int num=10;
		for(int i=1 ; i<=num ; i++) {
			mod[i-1]=new ModuleCouleur( ( (int)(235)/num ) *i );
			box[i-1].getChildren().addAll(mod[i-1].r1, mod[i-1].r2, mod[i-1].text, mod[i-1].text2);
			root.addColumn(i-1, box[i-1]);

		}

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {

		launch(args);
	}
}