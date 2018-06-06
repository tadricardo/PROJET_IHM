package package1;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ModuleCouleur {
	
	Rectangle r1;
	Rectangle r2;
	Rectangle r3;
	Text text;
	Text text2;
	
	
	ModuleCouleur(int nivGris){
		r1 = new Rectangle(100, 100);
		r1.setFill( new Color( nivGris/255. ,nivGris/255. , nivGris/255. , 1. ));
		r2 = new Rectangle(100, 100);

		Color couleur= CouleurAssocie.Gris(nivGris);

		r2.setFill(couleur);

		text = new Text( "R:  "+(int)(couleur.getRed()*255)+ "    G:  " + (int)(couleur.getGreen()*255) + "    B:  " + (int)(couleur.getBlue()*255) );
		text.setFont(Font.font(null, FontWeight.SEMI_BOLD, 12.5));
		text.setFill(Color.BLACK);
		
		text2 = new Text("   "+ (int)(couleur.getRed()*10)/10.0+ "        " +  (int)(couleur.getGreen()*10)/10.0 + "       " +  (int)(couleur.getBlue()*10)/10.0 );
		text2.setFont(Font.font(null, FontWeight.SEMI_BOLD, 12.5));  
		text2.setFill(Color.BLACK);
		
		r3 = new Rectangle(100, 100);
		r3.setFill(couleur.grayscale());
		

		
	}

}
