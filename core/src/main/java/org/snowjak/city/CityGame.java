package org.snowjak.city;

import org.snowjak.city.gamestate.GameScreenState;
import org.snowjak.city.gamestate.LoadingGameState;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.ai.fsm.DefaultStateMachine;
import com.badlogic.gdx.ai.fsm.StateMachine;
import com.kotcrab.vis.ui.VisUI;

/**
 * Base game-screen holder.
 * <p>
 * Uses a {@link StateMachine} to manage its {@link GameScreenState
 * screen-states}.
 * </p>
 * 
 * @author snowjak88
 *
 */
public class CityGame extends Game {
	
	private StateMachine<CityGame, GameScreenState> stateMachine;
	private GameData gameData = new GameData();
	
	@Override
	public void create() {
		
		VisUI.load();
		
		stateMachine = new DefaultStateMachine<>(this);
		stateMachine.changeState(new LoadingGameState(gameData));
	}
	
	@Override
	public void render() {
		
		super.render();
		stateMachine.update();
	}
	
	@Override
	public void dispose() {
		
		super.dispose();
		VisUI.dispose();
	}
	
	public StateMachine<CityGame, GameScreenState> getStateMachine() {
		
		return stateMachine;
	}
	
	public GameData getGameData() {
		
		return gameData;
	}
}