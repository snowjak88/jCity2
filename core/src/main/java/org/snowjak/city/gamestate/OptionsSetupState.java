/**
 * 
 */
package org.snowjak.city.gamestate;

import org.snowjak.city.CityGame;
import org.snowjak.city.GameData;
import org.snowjak.city.screens.OptionsSetupScreen;

import com.badlogic.gdx.ai.msg.Telegram;

/**
 * @author snowjak88
 *
 */
public class OptionsSetupState extends GameState {
	
	private OptionsSetupScreen optionsSetupScreen;
	
	/**
	 * @param gameData
	 */
	public OptionsSetupState(GameData gameData) {
		
		super(gameData);
	}
	
	@Override
	public void enter(CityGame entity) {
		
		optionsSetupScreen = new OptionsSetupScreen(getGameData(),
				() -> entity.getStateMachine().changeState(new MainMenuScreenState(getGameData())));
		
		entity.setScreen(optionsSetupScreen);
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
	}
	
	@Override
	public boolean onMessage(CityGame entity, Telegram telegram) {
		
		return false;
	}
	
}
