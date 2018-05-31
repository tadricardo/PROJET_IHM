package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javafx.scene.paint.Color;

public class CouleurAssocie {

	private double bleu=0;
	private double vert=0;
	private double rouge=0;
	private double reste;

	public Color couleur;

	CouleurAssocie(int a){

		reste=a/255.0;
		ThreadLocalRandom random = ThreadLocalRandom.current();

		List<Integer> lstIndexes = new ArrayList<Integer>();
		lstIndexes.add(1);
		lstIndexes.add(2);
		lstIndexes.add(3);

		Collections.shuffle(lstIndexes);
		for(Integer index : lstIndexes) {
			switch(index) {
			case 1:
				bleu=random.nextDouble(reste-1E-15, Math.min(1.0, reste/0.11));
				reste-=bleu*0.11;
				break;
			case 2: 	
				rouge=random.nextDouble(reste-1E-15, Math.min(1.0, reste/0.3));
				reste-=rouge*0.3;
				break;
			case 3: 
				vert=random.nextDouble(reste-1E-15, Math.min(1.0, reste/0.59));
				reste-=vert*0.59; 
				break;
			}
		}

		couleur=new Color(rouge, vert, bleu, 1);	
	}
}
