package com.nitnelave.CreeperHeal.block;

import org.bukkit.block.Sign;

/**
 * Sign implementation of CreeperBlock.
 * 
 * @author nitnelave
 * 
 */
public class CreeperSign extends CreeperBlock {

    /*
     * Constructor.
     */
    protected CreeperSign (Sign sign) {
        super(sign);
    }

    /*
     * (non-Javadoc)
     * @see com.nitnelave.CreeperHeal.block.CreeperBlock#update()
     */
    @Override
    public void update () {
        blockState.update (true);
        Sign state = (Sign)getBlock().getState();
        Sign sign = (Sign) blockState;
        for(int k = 0; k < 4; k++)
            state.setLine(k, sign.getLine(k));

        state.getData().setData(sign.getRawData());
        state.update(true);
    }


}
