package com.nitnelave.CreeperHeal.utils;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import org.bukkit.Location;
import org.bukkit.World;

import com.nitnelave.CreeperHeal.config.CreeperConfig;

/**
 * Implementation of the NeighborFinder for DateLoc
 * 
 * @author nitnelave
 * 
 */
public class NeighborDateLoc extends NeighborFinder<DateLoc> {

    /*
     * (non-Javadoc)
     * @see
     * com.nitnelave.CreeperHeal.utils.NeighborFinder#hasNeighbor(org.bukkit
     * .Location, java.util.LinkedList)
     */
    @Override
    protected boolean hasNeighbor (Location loc, LinkedList<DateLoc> list) {
        if (list != null)
        {
            World w = loc.getWorld ();
            for (DateLoc dl : list)
                if (dl.getWorld () == w && loc.distance (dl.getLocation ()) < 10)
                    return true;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * @see com.nitnelave.CreeperHeal.utils.NeighborFinder#clean()
     */
    @Override
    public void clean () {
        Iterator<LinkedList<DateLoc>> iter = map.values ().iterator ();
        Date delay = new Date (new Date ().getTime () - 200 * CreeperConfig.blockPerBlockInterval);
        while (iter.hasNext ())
        {
            LinkedList<DateLoc> list = iter.next ();
            Iterator<DateLoc> it = list.iterator ();
            while (it.hasNext ())
            {
                Date date = it.next ().getTime ();
                if (date.before (delay))
                    it.remove ();
                else
                    break;
            }
            if (list.isEmpty ())
                iter.remove ();
        }
    }

}
