package PlatformGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JPanel;

public class MainMenu extends Canvas{

	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(200, 200, 200, 200);
	}
	
	public Boolean Start()
	{
		return true;
		
	}
}
