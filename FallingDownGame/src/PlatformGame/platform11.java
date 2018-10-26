package PlatformGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class platform11 extends GameObject{
	
	private int counter = 0;
	public platform11(int x, int y, ID id) {
		super(x, y, id);
		velY = 1;
	}
	
	public void tick() {

		y-=velY;
		counter++;
		// if(y<= 0 || y>=Game.HEIGHT - 32) velY = 0;
		if(counter == 90)
		{
			x = 0;
			y=480;
		}
		if(counter>=400)
		{
			if(y<=0)
			{
				x=0;
				y=480;
			}
		}
	}

	
	public void render(Graphics g) {

		if(id == ID.platform11)
		{ 
			g.setColor(Color.white);
			g.fillRect(x,y,100,10);
		}
	}

	
	public Rectangle getBounds() {
		return new Rectangle(x,y,100,10);
	}

	
	
}
