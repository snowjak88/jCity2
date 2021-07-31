package org.snowjak.city.lwjgl3;

import org.snowjak.city.CityGame;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

/** Launches the desktop (LWJGL3) application. */
public class Lwjgl3Launcher {
	
	public static void main(String[] args) {
		
		createApplication();
	}
	
	private static Lwjgl3Application createApplication() {
		
		return new Lwjgl3Application(new CityGame(), getDefaultConfiguration());
	}
	
	private static Lwjgl3ApplicationConfiguration getDefaultConfiguration() {
		
		Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
		configuration.setTitle("jCity2");
		configuration.setWindowedMode(800, 600);
		configuration.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png");
		return configuration;
	}
}