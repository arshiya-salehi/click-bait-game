import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;

	public static void main(String[] args){
		JFrame frame = new JFrame("Click Bait");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Canvas canvas = new Canvas(WIDTH, HEIGHT, "rick astley.jpg");
		//you can create a mouse listener here and add it onto the canvas
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.add(canvas);
		frame.pack();

		frame.setVisible(true);
	}
}
