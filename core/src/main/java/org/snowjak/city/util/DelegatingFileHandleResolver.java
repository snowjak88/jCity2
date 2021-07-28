/**
 * 
 */
package org.snowjak.city.util;

import java.util.LinkedList;

import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;

/**
 * Delegates {@link FileHandle} resolutions to one or more
 * {@link FileHandleResolver}s in priority order, with each successive
 * FileHandleResolver used as a fallback to its predecessor.
 * 
 * @author snowjak88
 *
 */
public class DelegatingFileHandleResolver implements FileHandleResolver {
	
	private final LinkedList<FileHandleResolver> resolvers = new LinkedList<>();
	
	/**
	 * Construct a new {@link DelegatingFileHandleResolver}, using the given
	 * prioritized list of {@link FileHandleResolver}s.
	 * 
	 * @param resolvers
	 */
	public DelegatingFileHandleResolver(FileHandleResolver... resolvers) {
		
		for (FileHandleResolver resolver : resolvers)
			this.resolvers.addLast(resolver);
	}
	
	@Override
	public FileHandle resolve(String fileName) {
		
		for (FileHandleResolver resolver : resolvers) {
			final FileHandle result = resolver.resolve(fileName);
			if (result != null)
				return result;
		}
		
		return null;
	}
	
}
