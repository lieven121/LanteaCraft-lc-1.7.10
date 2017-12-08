package lc.common.impl.registry;

import java.util.Map;

import lc.api.components.RecipeType;
import lc.api.defs.IDefinitionReference;
import lc.api.defs.IRecipeDefinition;
import lc.common.LCLog;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

/**
 * Recipe proxy helper. Allows IRecipe objects to be wrapped like LC
 * definitions.
 *
 * @author AfterLifeLochie
 *
 */
public class RecipeProxy implements IRecipeDefinition {

	private String name;
	private RecipeType type;

	private Class<? extends IRecipe> recipeClass;
	private IRecipe recipeObject;

	/**
	 * Default constructor
	 *
	 * @param name
	 *            The name of the recipe
	 * @param type
	 *            The type of recipe
	 * @param clazz
	 *            The IRecipe class
	 */
	public RecipeProxy(String name, RecipeType type, Class<? extends IRecipe> clazz) {
		this.name = name;
		this.type = type;
		recipeClass = clazz;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public RecipeType getType() {
		return type;
	}

	@Override
	public void evaluateRecipe() {
		try {
			recipeObject = recipeClass.newInstance();
		} catch (Throwable t) {
			LCLog.fatal("Failed to evaluate nested recipe.", t);
		}
	}

	@Override
	public Map<Integer, ItemStack> getInputStacks() {
		return null;
	}

	@Override
	public Map<Integer, Boolean> getInputConsumption() {
		return null;
	}

	@Override
	public Map<Integer, ItemStack> getOutputStacks() {
		return null;
	}

	@Override
	public IRecipe getParentObject() {
		return recipeObject;
	}

	@Override
	public Class<? extends IRecipe> getParentClass() {
		return recipeClass;
	}

	@Override
	public IDefinitionReference ref() {
		return new DefinitionReference(this);
	}
}
