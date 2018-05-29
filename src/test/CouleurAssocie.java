package test;

import javafx.scene.paint.Color;

public class CouleurAssocie {

	private int bleu;
	private int vert;
	private int rouge;
	private int reste=255;
	
	public Color couleur;

	CouleurAssocie(Color c){
		reste=(int) (c.getBlue()*255);
		bleu=(int) (reste/0.59);
		reste=(int) (reste/(1-0.59));
		
		if (bleu>=255) {
			reste+=(bleu-255)*0.59;
		}
		
		rouge=(int) (reste/0.3);
		reste=(int) (reste/(1-0.3));
		
		if (rouge>=255) {
			reste+=(rouge-255)*0.3;
		}
		
		bleu=(int) (reste/0.11);
		reste=(int) (reste/(1-0.11));
		
		if (bleu>=255) {
			reste+=(bleu-255)*0.11;
		}
		
		couleur=new Color(rouge, vert, bleu, .99);
		
	}
}
