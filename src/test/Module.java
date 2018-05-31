package test;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Module {
	
	Rectangle r1;
	Rectangle r2;
	Rectangle r3;
	Text text;
	Text text2;
	
	Module(int nivGris){
		r1 = new Rectangle(100, 100);
		r1.setFill( new Color( nivGris/255. ,nivGris/255. , nivGris/255. , 1. ));
		r2 = new Rectangle(100, 100);

		CouleurAssocie coul= new CouleurAssocie(nivGris);

		r2.setFill(coul.couleur);

		text = new Text( (int)(coul.couleur.getRed()*255)+ " " + (int)(coul.couleur.getGreen()*255) + " " + (int)(coul.couleur.getBlue()*255) );
		text2 = new Text( (int)(coul.couleur.getRed()*10)/10.0+ " " +  (int)(coul.couleur.getGreen()*10)/10.0 + " " +  (int)(coul.couleur.getBlue()*10)/10.0 );

		r3 = new Rectangle(100, 100);
		r3.setFill(coul.couleur.grayscale());
		

		
	}

}
