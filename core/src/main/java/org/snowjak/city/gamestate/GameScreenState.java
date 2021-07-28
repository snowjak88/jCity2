/**
 * 
 */
package org.snowjak.city.gamestate;

import org.snowjak.city.CityGame;
import org.snowjak.city.GameData;

import com.badlogic.gdx.ai.fsm.State;

/**
 * Base interface for all states the {@link CityGame} can be in.
 * <p>
 * A GameScreenState represents one possible state for the game-screen
 * (CityGame). The GameScreenState must handle calling
 * {@link CityGame#setScreen(com.badlogic.gdx.Screen)} when its
 * {@link #enter(CityGame) enter()} method is called.
 * </p>
 * <p>
 * The GameScreenState may update its Screen's state when its own
 * {@link #update(CityGame)} method is called, but it must not perform any
 * rendering-tasks. As {@link #update(CityGame) update()} is called from the
 * main (rendering) thread, GameScreenState implementations should perform all
 * heavy processing in another thread.
 * </p>
 * 
 * @author snowjak88
 *
 */
public abstract class GameScreenState implements State<CityGame> {
	
	private final GameData gameData;
	
	public GameScreenState(GameData gameData) {
		
		this.gameData = gameData;
	}
	
	public GameData getGameData() {
		
		return gameData;
	}
}
