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
		new myFrame(screensize);
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
				if(panel.bg_color.equals(new Color(50,50,50,200)) || panel.bg_color.equals(new Color(50,50,50))) {
					// Red
					if(!System.getProperty("os.name").equals("Windows 10")) {
						FadeUtilityClass.fade(myFrame.this, true, false, false);
						panel.bg_color = new Color(75,50,50);
					}else {
						panel.bg_color = new Color(75,50,50,200);
					}
					panel.repaint();
				}else if(panel.bg_color.equals(new Color(75,50,50,200)) || panel.bg_color.equals(new Color(75,50,50))) {
					// Green
					if(!System.getProperty("os.name").equals("Windows 10")) {
						FadeUtilityClass.fade(myFrame.this, true, false, false);
						panel.bg_color = new Color(50,75,50);
					}else {
						panel.bg_color = new Color(50,75,50,200);
					}
					panel.repaint();
				}else if(panel.bg_color.equals(new Color(50,75,50,200)) || panel.bg_color.equals(new Color(50,75,50))) {
					// Blue
					if(!System.getProperty("os.name").equals("Windows 10")) {
						FadeUtilityClass.fade(myFrame.this, true, false, false);
						panel.bg_color = new Color(50,50,75);
					}else {
						panel.bg_color = new Color(50,50,75,200);
					}
					panel.repaint();
				}else {
					// Grey
					if(!System.getProperty("os.name").equals("Windows 10")) {
						FadeUtilityClass.fade(myFrame.this, true, false, false);
						panel.bg_color = new Color(50,50,50);
					}else {
						panel.bg_color = new Color(50,50,50,200);
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
