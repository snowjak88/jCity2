/**
 * 
 */
package org.snowjak.city.screens;

import org.snowjak.city.GameData;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.I18NBundle;
import com.kotcrab.vis.ui.widget.VisTextButton;

/**
 * @author snowjak88
 *
 */
public class OptionsSetupScreen extends ScreenAdapter {
	
	public static final String I18N_BUTTON_BACK = "options.buttons.back";
	public static final String I18N_BUTTON_PLAY = "options.buttons.play";
	
	private final GameData gameData;
	
	private final Stage stage;
	private final VerticalGroup root;
	
	public OptionsSetupScreen(GameData gameData, Runnable backButtonAction) {
		
		this.gameData = gameData;
		
		final I18NBundle uiText = gameData.assetManager.get(GameData.BUNDLE_UI, I18NBundle.class);
		
		stage = new Stage();
		root = new VerticalGroup();
		
		final VisTextButton playButton = new VisTextButton(uiText.get(I18N_BUTTON_PLAY));
		playButton.pad(32f);
		root.addActor(playButton);
		
		final VisTextButton backButton = new VisTextButton(uiText.get(I18N_BUTTON_BACK));
		backButton.pad(32f);
		backButton.addListener(new ClickListener() {
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
				backButtonAction.run();
			}
		});
		root.addActor(backButton);
		
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
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
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
