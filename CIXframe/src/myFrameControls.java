import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class myFrameControls extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	protected Dimension screensize;
	protected JButton bt_exit, bt_iconify, bt_color;
	protected int frameControlsHeight;
	
	protected myFrameControls(Dimension screensize, int frameControlsHeight) {
		// Load Panel
		this.screensize = screensize;
		this.frameControlsHeight = frameControlsHeight;
		super.setBackground(new Color(0,0,0,0));
		super.setPreferredSize(new Dimension(screensize.width, frameControlsHeight));
		super.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		// No Color Change on Buttons
		UIManager.put("Button.select", new Color(0,0,0,0));
		
		// Exit Button
		bt_exit = new JButton("X");
		bt_exit.setBorderPainted(false);
		bt_exit.setFocusPainted(false);
		bt_exit.setForeground(Color.RED);
		bt_exit.setOpaque(false);
		bt_exit.setBackground(new Color(0,0,0,0));
		bt_exit.setVisible(true);
		
		// Iconify Button
		bt_iconify = new JButton("I");
		bt_iconify.setBorderPainted(false);
		bt_iconify.setFocusPainted(false);
		bt_iconify.setForeground(Color.WHITE);
		bt_iconify.setOpaque(false);
		bt_iconify.setBackground(new Color(0,0,0,0));
		bt_iconify.setVisible(true);
		
		// Iconify Button
		bt_color = new JButton("C");
		bt_color.setBorderPainted(false);
		bt_color.setFocusPainted(false);
		bt_color.setForeground(Color.WHITE);
		bt_color.setOpaque(false);
		bt_color.setBackground(new Color(0,0,0,0));
		bt_color.setVisible(true);
		
		// Final
		super.add(bt_color);
		super.add(bt_iconify);
		super.add(bt_exit);
		super.setOpaque(false);
		super.setVisible(true);
	}
	
	public Dimension getScreensize() {
		return screensize;
	}
	
	public void setScreensize(Dimension d) {
		screensize = d;
	}

}
