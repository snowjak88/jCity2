/**
 * 
 */
package org.snowjak.city.gamestate;

import org.snowjak.city.CityGame;
import org.snowjak.city.GameData;
import org.snowjak.city.screens.MainMenuScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.msg.Telegram;

/**
 * @author snowjak88
 *
 */
public class MainMenuScreenState extends GameState {
	
	private MainMenuScreen mainMenuScreen;
	
	public MainMenuScreenState(GameData gameData) {
		
		super(gameData);
	}
	
	@Override
	public void enter(CityGame entity) {
		
		Gdx.app.log("STATE", "Entering [MainMenuState]");
		
		mainMenuScreen = new MainMenuScreen(getGameData(),
				() -> entity.getStateMachine().changeState(new OptionsSetupState(getGameData())), () -> Gdx.app.exit());
		
		entity.setScreen(mainMenuScreen);
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
		Gdx.app.log("STATE", "Exiting [MainMenuState]");
	}
	
	@Override
	public boolean onMessage(CityGame entity, Telegram telegram) {
		
		return false;
	}
	
}
