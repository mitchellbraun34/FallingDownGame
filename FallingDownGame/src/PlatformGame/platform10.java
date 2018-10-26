package PlatformGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class platform10 extends GameObject{
	
	private int counter = 0;
	public platform10(int x, int y, ID id) {
		super(x, y, id);
		velY = 1;
	}
	
	public void tick() {

		y-=velY;
		counter++;
		// if(y<= 0 || y>=Game.HEIGHT - 32) velY = 0;
		if(counter == 90)
		{
			x = 150;
			y=480;
		}
		if(counter>=400)
		{
			if(y<=0)
			{
				x=150;
				y=480;
			}
		}
	}

	
	public void render(Graphics g) {

		if(id == ID.platform10)
		{ 
			g.setColor(Color.white);
			g.fillRect(x,y,490,10);
		}
	}

	
	public Rectangle getBounds() {
		return new Rectangle(x,y,490,10);
	}

	
	
}
