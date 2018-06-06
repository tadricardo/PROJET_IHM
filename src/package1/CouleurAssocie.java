package package1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javafx.scene.paint.Color;

public class CouleurAssocie {

	static Color Gris(int nivGris){

		double pointBleu=0.0;
		double maxPointBleu=17.85;//255*0.07
		double pointVert=0.0;
		double maxPointVert=181.05;//255*0.71
		double pointRouge=0.0;
		double maxPointRouge=53.55;//255*0.21

		double reste=nivGris;//max 255, erreur si nivGris>255. 

		boolean vert=false;
		boolean bleu=false;
		boolean rouge=false;

		Double min=0.0;

		ThreadLocalRandom random = ThreadLocalRandom.current();
		
		//liste permettant de, une fois melang�e, traiter le couleurs dans un ordre aleatoire
		List<Integer> lstIndexes = new ArrayList<Integer>();
		lstIndexes.add(1);
		lstIndexes.add(2);
		lstIndexes.add(3);
		
		Collections.shuffle(lstIndexes);

		for(Integer index : lstIndexes) {
			switch(index) {
			
			//remplis chaque couleur avec un nombre aleatoire de point de couleur prennant en compte la quantit� de points restante, 
			//,si d'autres couleurs ont deja ete remplies et la quantit� max de la couleur trait�e
			
			case 1://bleu
				
				if(!vert&&!rouge)min=reste-maxPointVert-maxPointRouge;
				if(vert&&rouge)min=reste;
				if(vert&&!rouge) min=reste-maxPointRouge;
				if(!vert&&rouge) min=reste-maxPointVert;

				pointBleu=random.nextDouble( Math.max( 0.0 , min ) ,  Math.min( maxPointBleu , reste )+1E-13 );
				reste-=pointBleu;
				bleu=true;

				break;
				
			case 2://vert				
				
				if(!bleu&&!rouge)min=reste-maxPointBleu-maxPointRouge;
				if(bleu&&rouge)min=reste;
				if(bleu&&!rouge) min=reste-maxPointRouge;
				if(!bleu&&rouge) min=reste-maxPointBleu;

				pointVert=random.nextDouble( Math.max( 0.0 , min ) , Math.min( maxPointVert , reste )+1E-13 );
				reste-=pointVert;
				vert=true;
				break;
				
			case 3://rouge
				
				if(!vert&&!bleu)min=reste-maxPointVert-maxPointBleu;
				if(vert&&bleu)min=reste;
				if(vert&&!bleu) min=reste-maxPointBleu;
				if(!vert&&bleu) min=reste-maxPointVert;

				pointRouge=random.nextDouble( Math.max( 0.0 , min ) , Math.min( maxPointRouge , reste )+1E-13 );
				reste-=pointRouge;
				rouge=true;
				break;
			}
		}
		
		//cree une couleur a partir des points de couleurs calcules ramenees dans un interval 0.0-1.0
		return new Color( pointRouge/maxPointRouge , pointVert/maxPointVert , pointBleu/maxPointBleu , 1.0);	
	}
}
