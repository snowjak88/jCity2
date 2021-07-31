/**
 * 
 */
package org.snowjak.city.screens;

import org.snowjak.city.GameData;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * @author snowjak88
 *
 */
public class GameplayScreen extends ScreenAdapter {
	
	private final GameData gameData;
	
	private Viewport gameViewport;
	private Stage guiStage;
	
	/**
	 * @param gameData
	 */
	public GameplayScreen(GameData gameData) {
		
		this.gameData = gameData;
		
		gameViewport = new ExtendViewport(16f, 16f);
		guiStage = new Stage();
		
		// TODO add game-screen input processor
		Gdx.input.setInputProcessor(new InputMultiplexer(guiStage));
	}
	
	@Override
	public void resize(int width, int height) {
		
		gameViewport.update(width, height);
		guiStage.getViewport().update(width, height, true);
	}
	
	@Override
	public void dispose() {
		
		Gdx.input.setInputProcessor(null);
		guiStage.dispose();
	}
}
