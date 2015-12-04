package drachenkurve;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Dies ist die Zeichenklasse des Projekts Drachenkurve, welche die Kurve graphisch darstellt.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class DrachenkurveGUI {
	
	/**Programmfenster*/
	private JFrame frame1 = new JFrame("Drachenkurve");
	/**Laenge der Linien*/
	private int linelength = 3;
	/**Objekt der Drachenkurveklasse*/
	private Drachenkurve k;
	/**Floatwert fuer die HSV-Farbe*/
	private float c = 0f, n = 0.002f;
	/**JPanel, auf welchem die Kurve dargestellt wird*/
	private JPanel painter = new JPanel() {
		@Override
	    public void paintComponent(Graphics g) {
			int x = frame1.getWidth()/2;
			int y = 300;//frame1.getHeight()/2;
			for(char c:k.getDirections()) {
				g.setColor(getColor());
				switch(c) {
				case 'o':
					g.drawLine(x, y, x-=linelength, y);
					break;
				case 'n':
					g.drawLine(x, y, x, y-=linelength);
					break;
				case 'w':
					g.drawLine(x, y, x+=linelength, y);
					break;
				case 's':
					g.drawLine(x, y, x, y+=linelength);
					break;
				}
			}
	    }
	};
	
	public DrachenkurveGUI() {
		k = new Drachenkurve(15);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame1.setResizable(true);
		
		Container cp = frame1.getContentPane();
		cp.setLayout(new GridLayout(1,1));
		cp.add(painter);
		
		frame1.pack();
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
	}
	
	/**
	 * Diese Methode gibt die aktuelle Farbe zurueck.
	 * @return Gibt Farbe aus.
	 */
	private Color getColor() {
		if(c==(1-n)) {
			c=-n;
		}
		Color color = new Color(Color.HSBtoRGB(c+=n,1f,1f));
		return color;
	}

	public static void main(String[] args) {
		new DrachenkurveGUI();
	}
}