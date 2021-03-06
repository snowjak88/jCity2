/**
 * 
 */
package org.snowjak.city.screens;

import org.snowjak.city.GameData;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.utils.Align;
import com.kotcrab.vis.ui.widget.VisProgressBar;

/**
 * Presents a loading-bar that tracks the {@link AssetManager#getProgress()
 * progress} of the game's {@link GameData#assetManager shared AssetManager}.
 * 
 * @author snowjak88
 *
 */
public class LoadingScreen extends ScreenAdapter {
	
	private final GameData gameData;
	
	private final Stage stage;
	private final VerticalGroup root;
	private final VisProgressBar progressBar;
	
	private boolean isFinishedLoading = false;
	
	public LoadingScreen(GameData gameData) {
		
		this.gameData = gameData;
		
		stage = new Stage();
		root = new VerticalGroup();
		progressBar = new VisProgressBar(0f, 1f, 0.1f, false);
		
		root.setFillParent(true);
		root.align(Align.center);
		root.wrap(false);
		root.grow();
		
		stage.addActor(root);
	}
	
	@Override
	public void show() {
		
		Gdx.input.setInputProcessor(stage);
	}
	
	@Override
	public void render(float delta) {
		
		gameData.assetManager.update();
		progressBar.setValue(gameData.assetManager.getProgress());
		
		if (gameData.assetManager.isFinished())
			isFinishedLoading = true;
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
	}
	
	public boolean isFinishedLoading() {
		
		return isFinishedLoading;
	}
	
	@Override
	public void resize(int width, int height) {
		
		stage.getViewport().update(width, height, true);
	}
	
	@Override
	public void dispose() {
		
		Gdx.input.setInputProcessor(null);
		stage.dispose();
	}
}
