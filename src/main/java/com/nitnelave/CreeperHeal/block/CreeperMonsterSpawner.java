package com.nitnelave.CreeperHeal.block;

import org.bukkit.block.CreatureSpawner;

/**
 * MonsterSpawner implementation of CreeperBlock, to save the type of monster.
 * 
 * @author nitnelave
 * 
 */
public class CreeperMonsterSpawner extends CreeperBlock{

    /*
     * Constructor.
     */
    protected CreeperMonsterSpawner (CreatureSpawner blockState) {
        super(blockState);
    }

    /*
     * (non-Javadoc)
     * @see com.nitnelave.CreeperHeal.block.CreeperBlock#update(boolean)
     */
    @Override
    public void update () {
        blockState.update (true);
        ((CreatureSpawner) getBlock ().getState ()).setCreatureTypeByName (((CreatureSpawner) blockState).getCreatureTypeName ());
    }
}
