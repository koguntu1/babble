package edu.westga.cs.babble.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test tile Rack get number of tile needed class
 * @author Keith Oguntuwase
 * @version 2.0
 *
 */
public class TestTileRackGetNumberOfTilesNeeded {
    
    private TileRack tileRack;
    
    /**
     * set Up 
     */
    @Before
    public void setUp() {
        tileRack = new TileRack();
    }
    
    /**
     * Test Empty Tile Rack Should Need Max Size Number Of Tiles 
     */
    @Test
    public void emptyTileRackShouldNeedMaxSizeNumberOfTiles() {
        assertEquals(7, tileRack.getNumberOfTilesNeeded());
        
    }
    
    /**
     * Test Tile Rack With One Tile Should Need Max Size Minus One Tiles 
     */
    @Test
    public void tileRackWithOneTileShouldNeedMaxSizeMinusOneTiles() {
        tileRack.append(new Tile('A'));
        assertEquals(6, tileRack.getNumberOfTilesNeeded());
        
    }
    
    /**
     * Test Tile Rack With Several Tiles Should Need Some Tiles 
     */
    @Test
    public void tileRackWithSeveralTilesShouldNeedSomeTiles() {
        tileRack.append(new Tile('A'));
        tileRack.append(new Tile('B'));
        tileRack.append(new Tile('C'));
        assertEquals(4, tileRack.getNumberOfTilesNeeded());        
    }
    
    /**
     * Test Full Rack Needs Zero Tiles 
     */
    @Test
    public void fullRackNeedsZeroTiles() {
        tileRack.append(new Tile('A'));
        tileRack.append(new Tile('B'));
        tileRack.append(new Tile('C'));
        tileRack.append(new Tile('D'));
        tileRack.append(new Tile('E'));
        tileRack.append(new Tile('F'));
        tileRack.append(new Tile('G'));
        assertEquals(0, tileRack.getNumberOfTilesNeeded());        
    }
}
