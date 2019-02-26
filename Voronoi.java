import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.Random;			
import javax.swing.JFrame;
 
public class Voronoi extends JFrame {
	static BufferedImage I;
	static int px[], py[], color[], cells = 1000, size = 1000;
 
	public Voronoi() {
		super("Voronoi Diagram");
		setBounds(0, 0, size, size);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Random rand = new Random();
		I = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
		px = new int[cells];
		py = new int[cells];
		color = new int[cells];
		for (int i = 0; i < cells; i++) {
			px[i] = rand.nextInt(size);
			py[i] = rand.nextInt(size);
			color[i] = rand.nextInt(16777215);
 
		}
		int closest = 0;
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				closest = 0;
				for (int i = 0; i < cells; i++) {
					if (distance(px[i], x, py[i], y) < distance(px[closest], x, py[closest], y)) {
						closest = i;
 
					}
				}
				I.setRGB(x, y, color[closest]);
 
			}
		}
 
		Graphics2D graphics = I.createGraphics();
		graphics.setColor(Color.BLACK);
		for (int i = 0; i < cells; i++) {
			graphics.fill(new Ellipse2D.Double(px[i] - 2.5, py[i] - 2.5, 5, 5));
		}
	}
 
	public void paint(Graphics g) {
		g.drawImage(I, 0, 0, this);
	}
 
	static double distance(int x1, int x2, int y1, int y2) {
		double d;
	    d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)); // Euclidian
	  	return d;
	}
 
	public static void main(String[] args) {
		new Voronoi().setVisible(true);
	}
}