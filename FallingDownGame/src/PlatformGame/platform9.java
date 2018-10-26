package PlatformGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class platform9 extends GameObject{

	public platform9(int x, int y, ID id) {
		super(x, y, id);
		velY = 1;
	}

	
	public void tick() {

		y-=velY;
		
		// if(y<= 0 || y>=Game.HEIGHT - 32) velY = 0;
		if(y <= 0)
		{
			x = 0;
			y=480;
		}
	}

	
	public void render(Graphics g) {

		if(id == ID.platform9)
		{ 
			g.setColor(Color.white);
			g.fillRect(x,y,600,10);
		}
	}

	
	public Rectangle getBounds() {
		return new Rectangle(x,y,600,10);
	}

	
	
}
