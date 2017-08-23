package edu.westga.cs.babble.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Tile Bag Draw Tile class
 * @author Keith Oguntuwase
 * @version 2.0
 *
 */
public class TestTileBagDrawTile {

    private TileBag tileBag;

    /**
     * Test set up 
     */
    @Before
    public void setUp() {
        this.tileBag = new TileBag();
    }

    /**
     * Test can draw all tile
     * @throws EmptyTileBagException 
     */
    @Test
    public void canDrawAllTiles() throws EmptyTileBagException {
        int i = 0;
        for (i = 0; i < 98; i++) {
            this.tileBag.drawTile();
        }        
        assertEquals(98, i);
    }

    /**
     * Test can not draw too many tile
     * @throws EmptyTileBagException 
     */
    @Test
    public void canNotDrawTooManyTiles() throws EmptyTileBagException {
        int i = 0;
        for (i = 0; i < 98; i++) {
            this.tileBag.drawTile();
        }        
        
        assertNotEquals(99, i);
    }

    /**
     * Test proper tile distribution
     * @throws EmptyTileBagException 
     */
    @Test
    public void hasProperTileDistribution() throws EmptyTileBagException {
        int count = 0;
        for (int i = 0; i < 98; i++) {
            if (this.tileBag.drawTile().getLetter() == 'A') {
                count++;
            }                
        }        
        assertEquals(9, count);
    }
}
