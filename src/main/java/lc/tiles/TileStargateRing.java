package lc.tiles;

import lc.api.components.IntegrationType;
import lc.api.jit.DeviceDrivers.DriverCandidate;
import lc.api.rendering.IBlockSkinnable;
import lc.api.rendering.ITileRenderInfo;
import lc.common.base.multiblock.LCMultiblockTile;
import lc.common.base.multiblock.StructureConfiguration;
import lc.common.configuration.xml.ComponentConfig;
import lc.common.network.LCNetworkException;
import lc.common.network.LCPacket;
import lc.common.network.packets.LCTileSync;
import lc.common.util.data.ImmutablePair;
import lc.common.util.game.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.relauncher.Side;

/**
 * Stargate Ring tile implementation.
 *
 * @author AfterLifeLochie
 *
 */
@DriverCandidate(types = { IntegrationType.POWER })
public class TileStargateRing extends LCMultiblockTile implements IBlockSkinnable {

	private Block clientSkinBlock;
	private int clientSkinBlockMetadata;

	/** Default constructor */
	public TileStargateRing() {
		setSlave(true);
	}

	@Override
	public void configure(ComponentConfig c) {
		// TODO Auto-generated method stub

	}

	@Override
	public StructureConfiguration getConfiguration() {
		return null;
	}

	@Override
	public void thinkMultiblock() {
		// TODO Auto-generated method stub

	}

	@Override
	public IInventory getInventory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void thinkClient() {
		// TODO Auto-generated method stub
	}

	@Override
	public void thinkServer() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean shouldRender() {
		return false;
	}

	@Override
	public void thinkPacket(LCPacket packet, EntityPlayer player) throws LCNetworkException {
		super.thinkPacket(packet, player);
		if (packet instanceof LCTileSync)
			if (getWorldObj().isRemote) {
				boolean flag = false;
				if (compound != null && compound.hasKey("skin-block")) {
					ImmutablePair<Block, Integer> data = BlockHelper.loadBlock(compound.getString("skin-block"));
					if (data.getA() != null) {
						clientSkinBlock = data.getA();
						clientSkinBlockMetadata = data.getB();
						flag = true;
					}
				}
				if (!flag) {
					clientSkinBlock = null;
					clientSkinBlockMetadata = 0;
				}
			}
	}

	@Override
	public String[] debug(Side side) {
		return new String[] {
				String.format("Multiblock: %s", getState()),
				String.format("Ghost block: %s", (clientSkinBlock != null) ? clientSkinBlock.getUnlocalizedName()
						: "null"), String.format("Ghost metadata: %s", clientSkinBlockMetadata) };
	}

	@Override
	public ITileRenderInfo renderInfoTile() {
		return null;
	}

	@Override
	public Block getSkinBlock() {
		return clientSkinBlock;
	}

	@Override
	public int getSkinBlockMetadata() {
		return clientSkinBlockMetadata;
	}

	@Override
	public void setSkinBlock(Block block, int metadata) {
		if (block == null) {
			if (compound != null && compound.hasKey("skin-block")) {
				compound.removeTag("skin-block");
				markNbtDirty();
			}
		} else {
			if (compound == null)
				compound = new NBTTagCompound();
			compound.setString("skin-block", BlockHelper.saveBlock(block, metadata));
			markNbtDirty();
		}
	}

}
