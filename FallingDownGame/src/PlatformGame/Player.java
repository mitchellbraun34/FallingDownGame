package PlatformGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;





public class Player extends GameObject {
	
	private BufferedImage player_image;
	private Handler handler;


	public Player(int x, int y, ID id, Handler handler) 
	{
		super(x,y,id);
		
		SpriteSheet ss = new SpriteSheet(Game.Smileyface);
		player_image = ss.grabImage(1, 1, 32, 32);
		this.handler = handler;
		
		velY=2;
	}

	public void tick() {
		
		
		
	
		x = Game.clamp(x,0,Game.WIDTH - 40);
		y = Game.clamp(y,0,Game.HEIGHT - 62);
		
      
        x += velX;
        y += velY;
        collision();
        
       
		
	}
	private void collision()
	{
		for(int i = 0; i<handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
					if(tempObject.getId() == ID.platform1|| tempObject.getId() == ID.platform2 
					|| tempObject.getId() == ID.platform3|| tempObject.getId() == ID.platform4 
					|| tempObject.getId() == ID.platform5|| tempObject.getId() == ID.platform6
					|| tempObject.getId() == ID.platform7|| tempObject.getId() == ID.platform8
					|| tempObject.getId() == ID.platform9
					|| tempObject.getId() == ID.platform10|| tempObject.getId() == ID.platform11)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					velY = -1;
					break;
				}
				
				if(getBounds().intersects(new Rectangle(0,0,1000,1)))
					System.exit(0);
				else
					velY = 2;
			}
		}
	}

	public void render(Graphics g) {
		if(id == ID.player)
		g.drawImage(player_image, (int)x, (int)y,null);
			//g.setColor(Color.red);
			//g.fillRect(x,y,32,32);
			
	}
	

	
	public Rectangle getBounds() {
		return new Rectangle(x,y,32,32);
	}
	
}
