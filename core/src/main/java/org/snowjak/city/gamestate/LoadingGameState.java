/**
 * 
 */
package org.snowjak.city.gamestate;

import org.snowjak.city.CityGame;
import org.snowjak.city.GameData;
import org.snowjak.city.screens.LoadingScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.msg.Telegram;

/**
 * @author snowjak88
 *
 */
public class LoadingGameState extends GameScreenState {
	
	private LoadingScreen loadingScreen;
	
	public LoadingGameState(GameData gameData) {
		
		super(gameData);
		
		loadingScreen = new LoadingScreen(gameData, (v) -> Gdx.app.exit());
	}
	
	@Override
	public void enter(CityGame entity) {
		
		Gdx.app.log("STATE", "Entering [LoadingGameState]");
		entity.setScreen(loadingScreen);
	}
	
	@Override
	public void update(CityGame entity) {
		
		//
		// nothing to do
	}
	
	@Override
	public void exit(CityGame entity) {
		
		//
		// Move to the Main Menu State
		Gdx.app.log("STATE", "Exiting [LoadingGameState]");
		Gdx.app.exit();
	}
	
	@Override
	public boolean onMessage(CityGame entity, Telegram telegram) {
		
		return false;
	}
	
}
