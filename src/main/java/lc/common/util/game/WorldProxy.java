package lc.common.util.game;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * World proxy class. Allows worlds to behave differently to default (ie, return
 * fake blocks, etc).
 *
 * @author AfterLifeLochie
 */
public class WorldProxy implements IBlockAccess {

	IBlockAccess myWorld;
	int allMeta;
	int allBrightness = -1;

	/**
	 * Create a new world proxy
	 *
	 * @param world
	 *            The IBlockAccess world
	 * @param meta
	 *            The metadata to spoof
	 */
	public WorldProxy(IBlockAccess world, int meta) {
		myWorld = world;
		allMeta = meta;
	}

	/**
	 * Create a new world proxy
	 *
	 * @param world
	 *            The IBlockAccess world
	 * @param meta
	 *            The metadata to spoof
	 * @param brightness
	 *            The block brightness to spoof
	 */
	public WorldProxy(IBlockAccess world, int meta, int brightness) {
		myWorld = world;
		allMeta = meta;
		allBrightness = brightness;
	}

	@Override
	public Block getBlock(int x, int y, int z) {
		return myWorld.getBlock(x, y, z);
	}

	@Override
	public TileEntity getTileEntity(int x, int y, int z) {
		return myWorld.getTileEntity(x, y, z);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getLightBrightnessForSkyBlocks(int var1, int var2, int var3, int var4) {
		return allBrightness != -1 ? allBrightness : myWorld.getLightBrightnessForSkyBlocks(var1, var2, var3, var4);
	}

	@Override
	public int getBlockMetadata(int x, int y, int z) {
		return allMeta;
	}

	@Override
	public boolean isAirBlock(int x, int y, int z) {
		return myWorld.isAirBlock(x, y, z);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public BiomeGenBase getBiomeGenForCoords(int x, int z) {
		return myWorld.getBiomeGenForCoords(x, z);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getHeight() {
		return myWorld.getHeight();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean extendedLevelsInChunkCache() {
		return myWorld.extendedLevelsInChunkCache();
	}

	@Override
	public int isBlockProvidingPowerTo(int var1, int var2, int var3, int var4) {
		return myWorld.isBlockProvidingPowerTo(var1, var2, var3, var4);
	}

	@Override
	public boolean isSideSolid(int x, int y, int z, ForgeDirection side, boolean _default) {
		return myWorld.isSideSolid(x, y, z, side, _default);
	}

}
