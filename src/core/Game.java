package core;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

import states.Menu;
import states.Play;

public class Game extends StateBasedGame {

	public static final String gameName = "Beat to Move";
	public static final String version = "0.0.1";
	public static final int fps = 119;
	public static final boolean debugMode = true;
	public static final int menu = 1, play = 2;

	public static TrueTypeFont heading, text, title;

	public static AppGameContainer appgc;

	public Game(String gameName) throws SlickException {
		
		super(gameName);
		this.addState(new Play());
		
		this.addState(new Menu());

	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// fonts
		Font javaFont = new Font("Montserrat Light Italic", Font.BOLD, 65);
		heading = new TrueTypeFont(javaFont, true);

		javaFont = new Font("Montserrat Light", Font.PLAIN, 50);
		text = new TrueTypeFont(javaFont, true);

		javaFont = new Font("Montserrat Medium", Font.BOLD, 50);
		title = new TrueTypeFont(javaFont, true);
		
		
		this.getState(menu).init(appgc, this);


		this.getState(play).init(appgc, this);
		
		this.enterState(menu);

	}

	public static void main(String[] args) {

		try {
			appgc = new AppGameContainer(new Game(gameName + " " + version));
			appgc.setDisplayMode(1920, 1080, true);
			appgc.setDefaultFont(text);
			appgc.setShowFPS(debugMode);
			appgc.setTargetFrameRate(fps);
			appgc.start();

		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}