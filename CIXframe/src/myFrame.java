import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;


public class myFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	int pX, pY;

	public static void main(String[] args) {
		// Set Frame Size
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		if (screensize.height >= 1080 && screensize.width >= 1920) {
			screensize.height /= 2;
			screensize.width /= 2;
		}else if(screensize.height >= 540 && screensize.width >= 960){
			screensize = new Dimension(960, 540);
		} else {
			System.exit(1);
		}
		new myFrame(new Dimension(screensize.width, screensize.height-20));
	}
	
	protected myFrame(Dimension d) {
		// Load Frame
		super.setUndecorated(true);
		super.setResizable(false);
		super.setSize(d);
		super.setBackground(new Color(0,0,0,0));

		// Fade in Frame
		FadeUtilityClass.fade(myFrame.this, true, false, false);
		
		// Load GUI
		myPanel panel = new myPanel(d);
		panel.frameControls.setTitle("CIX 0.8");
		
		// Drag 'M' to move Frame
		panel.frameControls.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me) {
                // Get x,y and store them
                pX=me.getX();
                pY=me.getY();
            }
        });
		panel.frameControls.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent me) {
                // Set new Location
            	setLocation(getLocation().x+me.getX()-pX,getLocation().y+me.getY()-pY);
            }
        });
		
		// Click 'X' to exit
		panel.frameControls.bt_exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FadeUtilityClass.fade(myFrame.this, false, true, false);
			}
			
		});
		
		// Click 'I' to icoify
		panel.frameControls.bt_iconify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FadeUtilityClass.fade(myFrame.this, false, false, true);
			}
			
		});
		
		// Click 'C' to change Color
		panel.frameControls.bt_color.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(panel.bg_color.equals(panel.greyT) || panel.bg_color.equals(panel.greyS)) {
					// Blue
					if(!System.getProperty("os.name").equals("Windows 10")) {
						panel.bg_color = panel.blueS;
					}else {
						panel.bg_color = panel.blueT;
					}
					panel.repaint();
				}else if(panel.bg_color.equals(panel.blueT) || panel.bg_color.equals(panel.blueS)) {
					// Red
					if(!System.getProperty("os.name").equals("Windows 10")) {
						panel.bg_color = panel.redS;
					}else {
						panel.bg_color = panel.redT;
					}
					panel.repaint();
				}else if(panel.bg_color.equals(panel.redT) || panel.bg_color.equals(panel.redS)){
					// Purple
					if(!System.getProperty("os.name").equals("Windows 10")) {
						panel.bg_color = panel.purpleS;
					}else {
						panel.bg_color = panel.purpleT;
					}
					panel.repaint();
				}else {
					// Grey
					if(!System.getProperty("os.name").equals("Windows 10")) {
						panel.bg_color = panel.greyS;
					}else {
						panel.bg_color = panel.greyT;
					}
					panel.repaint();
				}
			}
			
		});
		
		// Final
		super.add(panel);
		super.pack();
		super.setLocationRelativeTo(null);
		super.setVisible(true);
	}

}
