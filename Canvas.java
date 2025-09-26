import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Canvas extends JComponent{
	private final int WIDTH;
	private final int HEIGHT;
	private final Image target;
	private int x;
	private int y;
	private Timer t;
	private int score;
	private int ticks;
	private boolean gameOver;
	private static final int MAX_TICKS = 10;


	public Canvas(int width, int height, String image){
		super();
		//You can create listeners inside of the component classes and add them to the "this" object
		WIDTH = width;
		HEIGHT = height;
		target = new ImageIcon(image).getImage();
		moveTarget();
		score = 0;
		ticks = 0;
		gameOver = false;
		class CanvasMouseListener implements MouseListener{
			//only triggers after released and if the mouse did not move
			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				if (!gameOver)
					canvasClicked(e.getX(), e.getY());
			}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		}
		this.addMouseListener( new CanvasMouseListener());

		class TimerListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				moveTarget();
				ticks++;
				if (ticks > MAX_TICKS){
					t.stop();
					gameOver = true;
				}
			}
		}
		t = new Timer(1000, new TimerListener());
		t.start();

		class CanvasKeyListener implements KeyListener{
			public void keyTyped(KeyEvent e){
				if (e.getKeyChar() == 'r')
					reset();
			}
			public void keyPressed(KeyEvent e){}
			public void keyReleased(KeyEvent e){}
		}
		this.addKeyListener(new CanvasKeyListener());
		this.setFocusable(true);
		this.requestFocus();
	}

	public void reset(){
		moveTarget();
		score = 0;
		ticks = 0;
		gameOver = false;
		t.start();
	}

	public void canvasClicked(int clickX, int clickY){
		if (clickX >= x && clickX <= x + target.getWidth(this) && clickY >= y && clickY <= y + target.getHeight(this)){
			score++;
			moveTarget();
		}
	}

	public void moveTarget(){
		x = (int) (Math.random() * (WIDTH - target.getWidth(this)) );
		y = (int) (Math.random() * (HEIGHT - target.getHeight(this)) );
		repaint();
	}

	public void paintComponent(Graphics gr){
		Graphics2D g = (Graphics2D) gr;
		g.drawImage(target,x,y,this);
		g.drawString("Score: " + score, 5, 15);
	}

}
