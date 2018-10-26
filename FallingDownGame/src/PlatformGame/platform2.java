package PlatformGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class platform2 extends GameObject {

	public platform2(int x, int y, ID id) {
		super(x, y, id);
		velY = 1;
	}

	
	public void tick() {

		y-=velY;
		
		// if(y<= 0 || y>=Game.HEIGHT - 32) velY = 0;
		if(y <= 0)
		{
			x = 400;
			y=480;
		}
	}

	
	public void render(Graphics g) {

		if(id == ID.platform2)
		{
			g.setColor(Color.white);
			g.fillRect(x,y,350,10);
		}
	}

	
	public Rectangle getBounds() {
		return new Rectangle(x,y,350,10);
	}

}
