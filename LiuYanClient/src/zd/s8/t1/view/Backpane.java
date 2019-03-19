package zd.s8.t1.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Backpane extends JPanel{
	private ImageIcon icon=new ImageIcon("image\\dsBuffer.jpg");
	private Image ximage=icon.getImage();
	public Backpane() {
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ximage, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
