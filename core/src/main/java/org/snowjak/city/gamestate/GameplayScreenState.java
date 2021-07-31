/**
 * 
 */
package org.snowjak.city.gamestate;

import org.snowjak.city.CityGame;
import org.snowjak.city.GameData;
import org.snowjak.city.screens.GameplayScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.msg.Telegram;

/**
 * @author snowjak88
 *
 */
public class GameplayScreenState extends GameState {
	
	private GameplayScreen gameplayScreen;
	
	public GameplayScreenState(GameData gameData) {
		
		super(gameData);
	}
	
	@Override
	public void enter(CityGame entity) {
		
		Gdx.app.log("STATE", "Entering [GameMapScreenState]");
		
		gameplayScreen = new GameplayScreen(getGameData());
		
		entity.setScreen(gameplayScreen);
	}
	
	@Override
	public void update(CityGame entity) {
		
		//
		// nothing to do
	}
	
	@Override
	public void exit(CityGame entity) {
		
		//
		// nothing to do
		Gdx.app.log("STATE", "Exiting [GameMapScreenState]");
	}
	
	@Override
	public boolean onMessage(CityGame entity, Telegram message) {
		
		return false;
	}
	
}
