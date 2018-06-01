package test;

import javafx.geometry.Insets;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;


public class UnSlider {

private Slider red = new Slider(0,255,0);
private Slider green = new Slider(0,255,0);
private Slider blue = new Slider(0,255,0);
private VBox contenair = new VBox(10);
private VBox rectangle = new VBox(16);
private VBox donnees = new VBox(12);

private static int compteur = 1;
private static final int compteur2 = 10;

	
	public UnSlider() {
		
		red.setShowTickLabels(true);
		red.setShowTickMarks(true);
		red.setMajorTickUnit(50);
		red.setMinorTickCount(5);
		red.setBlockIncrement(10);
		
		green.setShowTickLabels(true);
		green.setShowTickMarks(true);
		green.setMajorTickUnit(50);
		green.setMinorTickCount(5);
		green.setBlockIncrement(10);
		
		blue.setShowTickLabels(true);
		blue.setShowTickMarks(true);
		blue.setMajorTickUnit(50);
		blue.setMinorTickCount(5);
		blue.setBlockIncrement(10);
		
		rectangle.setPadding(new Insets(0, 0, 16, 22));
		donnees.setPadding(new Insets(0, 0, 16, 13));
		ModuleCouleur mc = new ModuleCouleur( ( (int)(255)/compteur2 ) * compteur);
		this.rectangle.getChildren().addAll(mc.r1,mc.r2);
		this.donnees.getChildren().addAll(mc.text2,mc.text);
		this.contenair.getChildren().addAll(rectangle,donnees,red,green,blue);
		compteur++;
		
	}
	
	public VBox getVbox() {
		
		return this.contenair;
	}
	
	
}
