package test;

import javafx.scene.paint.Color;

public class CouleurAssocie {

	private double bleu=0;
	private double vert=0;
	private double rouge=0;
	private double reste;
	
	public Color couleur;

	CouleurAssocie(int a){
		reste=a/255.0;
			
		bleu=reste/0.11; //on rempli bleu	
		reste=0;
		if (bleu>=1.0) { //si bleu est trop plein ,on rempli vert	
			reste+=(bleu-1.0)*0.11;
			bleu=1.0;
			
			vert=reste/0.59;
			reste=0;
			if (vert>=1.0) { //si vert est trop plein ,on rempli rouge
				reste+=(vert-1.0)*0.59;
				vert=1.0;
			}
			
			rouge=reste/0.3;
			reste=0;
			if (rouge>=1.0) {
				reste+=(rouge-1.0)*0.3;
				rouge=1.0;
			}		
		}		
		couleur=new Color(rouge, vert, bleu, 1);		
	}
}
