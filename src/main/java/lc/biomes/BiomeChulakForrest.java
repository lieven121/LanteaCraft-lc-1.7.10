package lc.biomes;

import java.util.Random;

import lc.api.defs.IBiomeDefinition;
import lc.api.defs.IDefinitionReference;
import lc.common.impl.registry.DefinitionReference;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenDesertWells;
import net.minecraft.world.gen.structure.MapGenVillage;


/**
 * Abydos desert biome implementation
 *
 * @author AfterLifeLochie
 *
 */
public class BiomeChulakForrest extends BiomeGenBase implements IBiomeDefinition {

	/**
	 * Default constructor
	 *
	 * @param biomeId
	 *            The biome ID to use
	 */
	public BiomeChulakForrest(int biomeId) {
		super(biomeId, true);
		topBlock = Blocks.grass;
		biomeName = getName();
		fillerBlock = Blocks.dirt;
		theBiomeDecorator.generateLakes = true;
		theBiomeDecorator.treesPerChunk = 5;
		theBiomeDecorator.deadBushPerChunk = 5;
		theBiomeDecorator.reedsPerChunk = -999;
		theBiomeDecorator.cactiPerChunk = -999;
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
		//TODO add jafa
        //TODO add java villeages
        //TODO add grass darker texture
	}

	@Override
	public String getName() {
		return "chulak forrest";
	}

	@Override
	public IDefinitionReference ref() {
		return new DefinitionReference(this);
	}

	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4) {
		super.decorate(par1World, par2Random, par3, par4);
		if (par2Random.nextInt(1000) == 0) {
			int k = par3 + par2Random.nextInt(16) + 8;
			int l = par4 + par2Random.nextInt(16) + 8;
			MapGenVillage mapGenVillage = new MapGenVillage();
			mapGenVillage.generateStructuresInChunk(par1World, par2Random, k, par1World.getHeightValue(k, l) + 1);
			
		}
	}
	   public BiomeGenBase.TempCategory getTempCategory()
	    {
	        return BiomeGenBase.TempCategory.WARM;
	    }

}
