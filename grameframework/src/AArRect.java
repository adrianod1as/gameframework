import java.awt.*;

public class AArRect {
	int x;
	int y;
	
	int w;
	int h;
	
	String format;
	int[] x1 = {10, 10, 30, 50, 50, 40, 20};
    int[] y1 = {80, 30, 10, 30, 80, 50, 50};
	public AArRect(int x, int y, int w,int h, String format)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.format = format;
	}
	public void draw(Graphics g)
	{
		
		if(format.equals("Rect")) {
			
		g.setColor(Color.blue);
		g.fillPolygon(x1, y1, 7);
        g.drawPolygon(x1, y1, 7);
       // g.drawOval(x, y, w, h);
		}
			
		if(format.equals("Oval")) g.drawOval(x, y, w, h);
	}
	
	public void moveBy(int dx, int dy)
	{
		x +=dx;
		y +=dy;		
		
		for(int i = 0; i<7; i++){
			x1[i] +=dx;
			y1[i] +=dy;
		}
		
	}
}
