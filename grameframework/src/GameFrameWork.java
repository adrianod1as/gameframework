import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.text.Collator;

public class GameFrameWork extends Applet implements Runnable, KeyListener
{
	Thread t =  new Thread(this);
	Thread t2 =  new Thread(this);
	
	
	boolean UP_pressed = false;
	boolean DN_pressed = false;
	boolean LT_pressed = false;
	boolean RT_pressed = false;
	boolean ER_pressed = false;
	
	AArRect r1 = new AArRect(10, 10, 100, 100, "Rect");
	AArRect r2 = new AArRect(r1.x+50, -11, 10, 10, "Oval");
	

	public void init()
	{
		addKeyListener(this);
		requestFocus();
		//t.run();
		t.start();
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{	
			
			if (UP_pressed) r1.moveBy(0, -5);
			if (DN_pressed) r1.moveBy(0, 5);
			if (LT_pressed) r1.moveBy(-5, 0);
			if (RT_pressed) r1.moveBy(5, 0);
			if (ER_pressed) { 
				if(r2.y<-10) r2 = null;
				if(r2 == null) r2 = new AArRect(r1.x+20, r1.y, 5, 5, "Oval");
					
					
			}
			
			if(r2 != null)r2.moveBy(0, -10);
				
			
			repaint();
			try {
				t.sleep(16);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void paint(Graphics g){
		
		
		//g.setColor(Color.blue);
		//g.fillRect(r1.x, r1.y, r1.w, r1.h);
		r1.draw(g);
		if(r2 != null) {
			g.setColor(Color.red);
			g.fillOval(r2.x, r2.y, r2.w, r2.h);
			r2.draw(g);
		}
	//	g.drawOval(r1.x, r1.y, r1.w, r1.h);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		if (code == e.VK_UP)	UP_pressed = true;
		if (code == e.VK_DOWN) 	DN_pressed = true;
		if (code == e.VK_LEFT) 	LT_pressed = true;
		if (code == e.VK_RIGHT) RT_pressed = true;
		if (code == e.VK_ENTER) ER_pressed = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		if (code == e.VK_UP)	UP_pressed = false;
		if (code == e.VK_DOWN) 	DN_pressed = false;
		if (code == e.VK_LEFT) 	LT_pressed = false;
		if (code == e.VK_RIGHT) RT_pressed = false;
		if (code == e.VK_ENTER) {
			ER_pressed = false;
		}

		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
