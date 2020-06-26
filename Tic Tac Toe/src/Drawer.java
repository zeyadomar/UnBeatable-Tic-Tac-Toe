import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Drawer extends JPanel {

	

	public void paint(Graphics g) {
		
		Graphics2D g2= (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		
		g2.drawLine(300, 0, 300, 900);

		g2.drawLine(600, 0, 600, 900);

		g2.drawLine(0, 300, 900, 300);

		g2.drawLine(0, 600, 900, 600);
		
		

	}


	
	
	

}
