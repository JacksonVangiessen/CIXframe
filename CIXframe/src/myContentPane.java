import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.UIManager;

public class myContentPane extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	protected Dimension screensize;
	protected int margin, corners, frameControlsHeight;
	
	protected myContentPane(Dimension screensize, int margin, int corners, int frameControlsHeight) {
		// Load Panel
		this.screensize = screensize;
		this.margin = margin;
		this.corners = corners;
		this.frameControlsHeight = frameControlsHeight;
		super.setBackground(new Color(0,0,0,0));
		super.setPreferredSize(new Dimension(screensize.width-margin, screensize.height-frameControlsHeight));
		setScreensize(new Dimension(screensize.width, screensize.height-frameControlsHeight));
		super.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		// No Color Change on Buttons
		UIManager.put("Button.select", new Color(0,0,0,0));
		
		// Final
		super.setVisible(true);
		super.setOpaque(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
        // Setup
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        // Frame Polygon        
        int xPoly[] = {screensize.width-margin, screensize.width-margin,
        		screensize.width-margin-corners, margin+corners, margin,
        		margin, margin+corners};
        int yPoly[] = {0, screensize.height-corners-margin,
        		screensize.height-margin, screensize.height-margin,
        		screensize.height-corners-margin,corners,
        		0};
        g2.setColor(new Color(0,0,0,200));
        g2.fillPolygon(xPoly, yPoly, xPoly.length);
    };
	
	public Dimension getScreensize() {
		return screensize;
	}
	
	public void setScreensize(Dimension d) {
		screensize = d;
	}

}
