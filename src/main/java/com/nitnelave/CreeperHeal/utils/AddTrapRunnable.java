package com.nitnelave.CreeperHeal.utils;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;

import com.nitnelave.CreeperHeal.block.CreeperBlock;
import com.nitnelave.CreeperHeal.block.CreeperExplosion;
import com.nitnelave.CreeperHeal.block.Replaceable;

public class AddTrapRunnable implements Runnable{

	private CreeperExplosion cEx;
	private Block block;
	private Material type;
	
	public AddTrapRunnable(CreeperExplosion cEx, Block b, Material t)
	{
		this.cEx = cEx;
		block = b;
		type = t;
	}
	
	@Override
	public void run() {
		BlockState tmp_state = block.getState();

		block.setType(type);                            //set the block to tnt

		List<Replaceable> list = cEx.getBlockList();
		list.add(CreeperBlock.newBlock(block.getState()));                //record it

		tmp_state.update(true);        //set it back to what it was
		
	}

}
