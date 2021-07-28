/**
 * 
 */
package org.snowjak.city;

import org.snowjak.city.util.DelegatingFileHandleResolver;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.LocalFileHandleResolver;

/**
 * Encapsulates the game's current state (as in data).
 * 
 * @author snowjak88
 *
 */
public class GameData {
	
	/**
	 * I18N bundles are expected to be in this assets-directory.
	 */
	private static final String BUNDLE = "i18n/";
	
	/**
	 * I18N bundle containing strings for UI elements.
	 */
	public static final String BUNDLE_UI = BUNDLE + "ui";
	
	/**
	 * Provides asset-loading functionality. Configured to look first at the
	 * {@link LocalFileHandleResolver local}, then at the
	 * {@link InternalFileHandleResolver internal} file-structures when resolving
	 * assets.
	 */
	public final AssetManager assetManager = new AssetManager(
			new DelegatingFileHandleResolver(new LocalFileHandleResolver(), new InternalFileHandleResolver()));
}
