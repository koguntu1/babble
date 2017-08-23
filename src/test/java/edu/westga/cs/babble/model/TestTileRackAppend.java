package edu.westga.cs.babble.model;

import org.junit.Test;

/**
 * The Tile Rack Test
 * @author Keith Oguntuwase
 * @version 2.0
 *
 */
public class TestTileRackAppend {
    
    /**
     * Test should not append to full rack
     */
    @Test(expected = TileRackFullException.class)
    public void shouldNotAppendToFullRack() {
        TileRack tileRack = new TileRack();
        tileRack.append(new Tile('A'));
        tileRack.append(new Tile('B'));
        tileRack.append(new Tile('C'));
        tileRack.append(new Tile('D'));
        tileRack.append(new Tile('E'));
        tileRack.append(new Tile('F'));
        tileRack.append(new Tile('G'));
        tileRack.append(new Tile('H'));        
    }
}
