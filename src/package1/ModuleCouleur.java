package package1;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ModuleCouleur {
	
	Rectangle rectGris;//teinte de gris
	Rectangle rectCouleur;//couleur correspondante
	Text rgb255;//code rgb255 de la couleur
	Text rgbs;//code rgbs de la couleur
	
	
	ModuleCouleur(int nivGris){
		
		//rectangle de la teinte de gris fonies en parametre
		rectGris = new Rectangle(120, 120);
		rectGris.setFill( new Color( nivGris/255. ,nivGris/255. , nivGris/255. , 1. ));
		rectGris.setStroke(Color.BLACK);
		rectGris.setStrokeWidth(2);
		
		//une couleur correspondant au gris
		Color couleur= CouleurAssocie.Gris(nivGris);

		
		//rectangle d'une couleur correspondant au gris
		rectCouleur = new Rectangle(120, 120);
		rectCouleur.setFill(couleur);
		rectCouleur.setStroke(Color.BLACK);
		rectCouleur.setStrokeWidth(2);				
	
		//code RGB de la couleur correspondante
		rgb255 = new Text("RGB ("+(int)(couleur.getRed()*255)+ "," + (int)(couleur.getGreen()*255) + "," + (int)(couleur.getBlue()*255)+")" );
		rgb255.setFont(Font.font(null, FontWeight.SEMI_BOLD, 12.5));
		rgb255.setFill(Color.BLACK);
		
		
		//code RGBs de la couleur correspondante
		rgbs = new Text("    "+ (int)(couleur.getRed()*10)/10.0+ "   " +  (int)(couleur.getGreen()*10)/10.0 + "   " +  (int)(couleur.getBlue()*10)/10.0 );
		rgbs.setFont(Font.font(null, FontWeight.SEMI_BOLD, 12.5));  
		rgbs.setFill(Color.BLACK);


	}
}