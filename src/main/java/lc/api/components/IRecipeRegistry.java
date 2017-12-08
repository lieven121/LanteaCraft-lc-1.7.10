/**
 * This file is part of the official LanteaCraft API. Please see the usage guide and
 * restrictions on use in the package-info file.
 */
package lc.api.components;

import lc.api.defs.IRecipeDefinition;

/**
 * Recipe registry interface. Stores all declared recipes at runtime.
 *
 * @author AfterLifeLochie
 *
 */
public interface IRecipeRegistry {

	/**
	 * Add a new recipe definition to the registry
	 *
	 * @param definition
	 *            The recipe definition
	 */
	public void addRecipe(IRecipeDefinition definition);

	/**
	 * Get a named recipe definition from the registry
	 *
	 * @param name
	 *            The name of the definition
	 * @return The definition or null if it does not exist.
	 */
	public IRecipeDefinition getRecipe(String name);

}
