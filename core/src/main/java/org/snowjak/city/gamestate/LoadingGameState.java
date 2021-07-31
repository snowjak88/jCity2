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
public class LoadingGameState extends GameState {
	
	private LoadingScreen loadingScreen;
	
	public LoadingGameState(GameData gameData) {
		
		super(gameData);
		
		loadingScreen = new LoadingScreen(gameData);
	}
	
	@Override
	public void enter(CityGame entity) {
		
		Gdx.app.log("STATE", "Entering [LoadingGameState]");
		entity.setScreen(loadingScreen);
	}
	
	@Override
	public void update(CityGame entity) {
		
		//
		// check if loading is complete
		if (loadingScreen.isFinishedLoading())
			entity.getStateMachine().changeState(new MainMenuScreenState(getGameData()));
	}
	
	@Override
	public void exit(CityGame entity) {
		
		//
		// do nothing
		Gdx.app.log("STATE", "Exiting [LoadingGameState]");
	}
	
	@Override
	public boolean onMessage(CityGame entity, Telegram telegram) {
		
		return false;
	}
	
}
