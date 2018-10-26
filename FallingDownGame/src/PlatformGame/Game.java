package PlatformGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

public class Game extends Canvas implements Runnable {
	
	static final int WIDTH = 640; // height is 480

	static final int HEIGHT = WIDTH/ 12 * 9;
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	
	public static BufferedImage Smileyface;
	public static BufferedImage Sadface;
	MainMenu m = new MainMenu();

	
	
	public Game() 
	{

		BufferedImageLoader loader = new BufferedImageLoader();
		Smileyface = loader.loadImage("/racecar.png"); 
		handler = new Handler();

		this.addKeyListener(new KeyInput(handler));
		

		new Window(WIDTH, HEIGHT, "Game", this);
		
		
		
		
		
		
		handler.addObject(new Player(280,10,ID.player, handler));
		handler.addObject(new platform1(0, 480, ID.platform1));
		handler.addObject(new platform2(400, 480, ID.platform2));
		handler.addObject(new platform3(100, 400, ID.platform3));
		handler.addObject(new platform4(500, 400, ID.platform4));
		handler.addObject(new platform5(0, 320, ID.platform5));
		handler.addObject(new platform6(500, 320, ID.platform6));
		handler.addObject(new platform9(0, 240, ID.platform9));
		handler.addObject(new platform7(0, 160, ID.platform7));
		handler.addObject(new platform8(225, 160, ID.platform8));
		handler.addObject(new platform10(0, 1000, ID.platform10));
		handler.addObject(new platform11(225, 1000, ID.platform11));
		
		}
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop()
	{
		try
		{
			thread.join();
			running = false;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta+=(now-lastTime)/ns;
			lastTime = now;
			while(delta>=1)
			{
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer+=1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
		
	}
	
	private void tick()
	{
		handler.tick();
	}
	
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		handler.render(g);
		
		
		
		g.dispose();
		bs.show();
	}
	public static int clamp(int var, int min, int max)
	{
		if(var>= max)
			return var=max;
		else if(var <= min)
			return var = min;
		else 
			return var;
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to game -- move left and right using the arrow keys --"
				+ " go down the holes to increase your score -- hit the top and u will die -- hit enter to continue! ");
		//in.nextLine();
		in.close();
		new Game();
	}


}
