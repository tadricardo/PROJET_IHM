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
/*from  ww  w  .jav  a 2  s  .c  om*/
public class Test extends Application {
  @Override
  public void start(Stage primaryStage) {
    Group root = new Group();
    Scene scene = new Scene(root, 300, 250);
    // 5 pixels space between child nodes
    VBox vbox = new VBox(5);
    // 1 pixel padding between child nodes only
    vbox.setPadding(new Insets(1));
    

    
    
    Rectangle r1 = new Rectangle(100, 100);
    r1.setFill(Color.GRAY);
    Rectangle r2 = new Rectangle(100, 100);
 
    
    CouleurAssocie coul= new CouleurAssocie(Color.GRAY);
    
    r2.setFill(coul.couleur);

    Text text = new Text("255, 45, 79");
  
   

    HBox.setMargin(r1, new Insets(2, 2, 2, 2));

    vbox.getChildren().addAll(r1, r2, text);
    root.getChildren().add(vbox);

    

    primaryStage.setScene(scene);
    primaryStage.show();
  }
  public static void main(String[] args) {
    launch(args);
  }
}
