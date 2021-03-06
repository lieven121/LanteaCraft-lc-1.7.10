package lc.structure;

import lc.LCRuntime;
import lc.api.rendering.IBlockSkinnable;
import lc.common.LCLog;
import lc.common.base.LCBlock;
import lc.common.base.LCTile;
import lc.common.util.game.BlockFilter;
import lc.common.util.game.BlockFilterWithRot;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class StructureAbydosPyramid {
	//yzx
	static int[][][] getStructure(int part){
		switch (part) {
			case 0:
				int size = width;
				int[][][] structure = new int[size/2+1][size][size];
				for (int y = 0;y <structure.length;y++) {
					for (int z = 0;z <size;z++){
						for (int x = 0; x < size; x++)
							if ((z >= y && z < size-y) && (x >= y && x < size-y))
								if (((z >= y+1 && z < size-y-1) && (x >= y+1 && x < size-y-1)) && y > 0 && y != 6 && y != 15 || y == structure.length-0)//add floor on level 0(basement), level 6 (gndlvl) and level 15(ceiling) 
									structure[y][z][x] = 0;
								else {
									structure[y][z][x] = 1;
									if  (y >= structure.length-5)
									structure[y][z][x] = 4;
								}
							else
								structure[y][z][x] = -1;
					}
				}
				return structure;
			case 1:
				int[][][] structure2 = {{
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,9,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						},{
					{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
					{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,1,0,0,0,1,1,1,1,1,1,1,0,0,0,1,0,0},
					{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,2,2,0,0,1,1,1,1,1,1,1,0,0,2,2,0,0},
					{0,0,2,2,7,0,1,3,3,3,3,3,1,0,7,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,2,2,0,0,0,0,0,5,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,7,0,0,0,0,0,0,0,0,0,7,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,7,0,0,0,0,0,0,0,0,0,7,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
						},{
					{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
					{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
						},{
					{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
					{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
						},{
					{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
					{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
						},{
					{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
					{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
						},{
					{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
					{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
					{0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0},
						},{
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,-1},
					{-1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,-1},
					{-1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,-1},
					{-1,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,-1},
					{-1,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,-1},
					{-1,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,-1},
					{-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
					{-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
					{-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
					{-1,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,-1},
					{-1,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,-1},
					{-1,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,-1},
					{-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
					{-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
					{-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
					{-1,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,-1},
					{-1,0,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,0,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
						},{
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,1,2,0,0,0,0,0,0,0,0,0,0,0,2,1,-1,-1},
					{-1,-1,1,2,0,0,0,0,0,0,0,0,0,0,0,2,1,-1,-1},
					{-1,-1,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,-1,-1},
					{-1,-1,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,-1,-1},
					{-1,-1,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,-1,-1},
					{-1,-1,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,-1,-1},
					{-1,-1,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,-1,-1},
					{-1,-1,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,-1,-1},
					{-1,-1,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,-1,-1},
					{-1,-1,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,-1,-1},
					{-1,-1,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,-1,-1},
					{-1,-1,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,-1,-1},
					{-1,-1,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,-1,-1},
					{-1,-1,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,-1,-1},
					{-1,-1,2,2,0,0,0,0,0,0,0,0,0,0,0,2,2,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					}};
				return structure2;
			case 2:
				int[][][] structure3 = {{
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				},{
					{1,1,1,1,1,1,1,6,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				},{
					{1,1,0,0,0,0,0,0,0,0,0,0,0,1,1},
					{1,1,0,0,0,0,0,0,0,0,0,0,0,1,1},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				},{
					{1,1,0,0,0,0,0,0,0,0,0,0,0,1,1},
					{1,1,0,0,0,0,0,0,0,0,0,0,0,1,1},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				},{
					{1,1,0,0,0,0,0,0,0,0,0,0,0,1,1},
					{1,1,0,0,0,0,0,0,0,0,0,0,0,1,1},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				},{
					{1,1,0,0,0,0,0,0,0,0,0,0,0,1,1},
					{1,1,0,0,0,0,0,0,0,0,0,0,0,1,1},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				},{
					{1,1,0,0,0,0,0,0,0,0,0,0,0,1,1},
					{1,1,0,0,0,0,0,0,0,0,0,0,0,1,1},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{2,1,0,0,0,0,0,0,0,0,0,0,0,1,2},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				},{
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				}};
				return structure3;
		}
		return null;
	}
	static BlockFilterWithRot[] getBlocks() {
			BlockFilterWithRot[] blocks = { new BlockFilterWithRot(Blocks.air) , //0
											new BlockFilterWithRot(Blocks.sandstone,0) , //1 //sandstone 0
											new BlockFilterWithRot(Blocks.sandstone,2), //2
											new BlockFilterWithRot(Blocks.stone_slab,1), //3
											new BlockFilterWithRot(LCRuntime.runtime.blocks().lanteaDecorBlock.getBlock(),3), //4
											new BlockFilterWithRot(LCRuntime.runtime.blocks().stargateDHDBlock.getBlock()),
											new BlockFilterWithRot(Blocks.chest),
											new BlockFilterWithRot(LCRuntime.runtime.blocks().lanteaBrazier.getBlock()),
											new BlockFilterWithRot(LCRuntime.runtime.blocks().lanteaObelisk.getBlock()),//8
											new BlockFilterWithRot(Blocks.glowstone)};
			
		return blocks;
	}
	
	 static int height = getStructure(0).length;
	 static int width = 45;
	 static int length = width; //TODO 

	 public static int getHeigth() { //y
		 return height;
	 }
	 public static int getWidth() { //z
		 return width;
	 }
	 public static int getLength() { //x
		 return length;
	 }
	 
	 public static int[] getStargatePos(int worldX, int worldY, int worldZ, ForgeDirection rotation) { //x
		 int[] pos = {worldX,worldY,worldZ};
			switch (rotation) {
			case NORTH:
				pos[2] = worldZ-6;
				break;
			case SOUTH:
				pos[2] = worldZ+6;
				break;
			case WEST:
				pos[0] = worldX-6;
				break;
			case EAST:
				pos[0] = worldX+6;
				break;
			default:
				break;
			}
		 return pos;
	 }
	 
	 public static int[] getEntrancePos(int worldX, int worldY, int worldZ, ForgeDirection rotation) { //x
		 int[] pos = {worldX,worldY,worldZ};
		 int width = 15;
		 int length = 21;
			switch (rotation) {
			case NORTH:
				pos[2] = worldZ+9+length;
				pos[0] = worldX+width/2;
				break;
			case SOUTH:
				pos[2] = worldZ-9-length;
				pos[0] = worldX-width/2;
				break;
			case WEST:
				pos[0] = worldX+9-length;
				pos[2] = worldZ+width/2;
				break;
			case EAST:
				pos[0] = worldX-9-length;
				pos[2] = worldZ-width/2;
				break;
			default:
				break;
			}
		 return pos;
	 }

	/*	public static boolean generateStructure(World world, int worldX,int worldY, int worldZ, ForgeDirection rotation) {
			StructureDefault struct = new StructureDefault(getStructure(0), getBlocks());
			struct.placeStructure(world, worldX , worldY, worldZ, rotation);
			return true;			
		}*/
		
		
		public static boolean generateStructureCenter(World world, int worldX,int worldY, int worldZ, ForgeDirection rotation) {
			StructureDefault struct = new StructureDefault(getStructure(0), getBlocks());
			StructureDefault struct2 = new StructureDefault(getStructure(1), getBlocks());
			StructureDefault struct3 = new StructureDefault(getStructure(2), getBlocks());
			
			if (!rotation.equals(ForgeDirection.EAST) & !rotation.equals(ForgeDirection.WEST) ) {
				struct.placeStructure(world, worldX - length/2 , worldY, worldZ - width/2, rotation);
				struct2.placeStructure(world, worldX - 19/2 , worldY+6, worldZ - 19/2, rotation);
				
			}else {
				struct.placeStructure(world, worldX - width/2 , worldY, worldZ - length/2, rotation);
				struct2.placeStructure(world, worldX - 19/2 , worldY+5, worldZ - 19/2, rotation);
			}
			
			//Place Gate
			int[] pos = getStargatePos(worldX, worldY, worldZ, rotation);
			StructureStargate.generateStructureCenter(world, pos[0], pos[1]+7, pos[2], rotation);
			int[] pos2 = getEntrancePos(worldX, worldY, worldZ, rotation);
			struct3.placeStructure(world, pos2[0], pos2[1]+5, pos2[2], rotation);
			//StructureStargate.generateStructureCenter(world, pos[0], pos[1]+7, pos[2], rotation);
			//paint gate bottom
			for (int x = -19/2; x<19/2; x++) {
				for (int z = -19/2; z<19/2; z++) {
					LCTile te = (LCTile) world.getTileEntity(worldX+x, worldY+7, worldZ+z);
					if (te instanceof IBlockSkinnable) {
						IBlockSkinnable skinnable = (IBlockSkinnable) te;
						skinnable.setSkinBlock(Blocks.sandstone, 0);
					}
				}
			}
			
			//add paiting
			return true;			
		}
	
}
