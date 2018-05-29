package test;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Gris {

	public ArrayList<Color> listGris=new ArrayList();

	Gris(int num){
		for (int i=1; i<=num; i++) {
				listGris.add(Color.rgb(255/num, 255/num, 255/num));
		}
	}
}
