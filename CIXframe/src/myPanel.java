import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class myPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	protected Dimension screensize;
	protected myFrameControls frameControls;
	protected myContentPane contentPane;
	protected JButton bt_move, bt_fullscreen, bt_exit, bt_iconify;
	protected Color bg_color;
	
    protected String title = "New Frame";
    protected int corners = 30,
    		margin = 5,
    		thickness = 2,
    		frameControlsHeight = 35;
	
	protected myPanel(Dimension screensize) {
		// Load Panel
		this.screensize = screensize;
		super.setPreferredSize(screensize);
		super.setBackground(new Color(0,0,0,0));
		
		// Set Layout
		FlowLayout fl = new FlowLayout(FlowLayout.RIGHT);
		fl.setVgap(0);
		super.setLayout(fl);
		
		// Linux disable Transparency
		if(!System.getProperty("os.name").equals("Windows 10")) {
			bg_color = new Color(50,50,50);
		} else {
			bg_color = new Color(50,50,50,200);
		}

		// No Color Change on Buttons
		UIManager.put("Button.select", new Color(0,0,0,0));
		
		// Load Frame Controls
		frameControls = new myFrameControls(title, screensize, frameControlsHeight);
		
		// Load Contnent Pane
		contentPane = new myContentPane(screensize, margin, corners, frameControlsHeight);
		
		// Final
		super.add(frameControls);
		super.add(contentPane);
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
        int yPoly[] = {margin, screensize.height-margin-corners,
        		screensize.height-margin, screensize.height-margin,
        		screensize.height-margin-corners, margin+corners,
        		margin};
        g2.setColor(bg_color);
        g2.fillPolygon(xPoly, yPoly, xPoly.length);
        g2.setStroke(new BasicStroke(thickness));
        g2.setColor(new Color(255,255,255,20));
        g2.drawPolygon(xPoly, yPoly, xPoly.length);
    };
	
	public Dimension getScreensize() {
		return screensize;
	}
	
	public void setScreensize(Dimension d) {
		screensize = d;
	}

}
