package drachenkurve;

import java.util.ArrayList;

/**
 * Dies ist die Klasse des Projekts Drachenkurve, welche die Schritte der Kurve fuer eine bestimmte Laenge berechnet.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class Drachenkurve {
	
	/**Liste der Himmelsrichtungen*/
	private ArrayList<Character> directions = new ArrayList<Character>();
	
	public Drachenkurve(int gene) {
		directions.add('o');
		for(int i=0;i<gene;i++) {
			nextGeneration();
		}
	}
	
	/**
	 * Diese Methode macht aus der aktuellen Drachenkurve die naechste Generation einer Drachenkurve.
	 */
	private void nextGeneration() {
		for(int i=0;i<directions.size();i++) {
			switch(directions.get(i)) {
			case 'o':
				directions.set(i, 'o');
				directions.add(i+1,'n');
				break;
			case 'n':
				directions.set(i, 'w');
				directions.add(i+1,'n');
				break;
			case 'w':
				directions.set(i, 'w');
				directions.add(i+1,'s');
				break;
			case 's':
				directions.set(i, 'o');
				directions.add(i+1,'s');
				break;
			}
			i++;
		}
	}

	public ArrayList<Character> getDirections() {
		return directions;
	}
}