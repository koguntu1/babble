package edu.westga.cs.babble.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the Test Tile Constructor class
 * @author Keith Oguntuwase
 * @version 2.0
 *
 */
public class TestTileConstructor {
    
    /**
     * Test for non letter tile
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowNonLetters() {
        new Tile('0');        
    }
    
    /**
     * Check for one point tile 
     */
    @Test
    public void shouldCreateOnePointTiles() {
        assertEquals(new Tile('e').getPointValue(), 1);
        assertEquals(new Tile('E').getPointValue(), 1);
    }
    
    /**
     * Check for two point tile
     */
    @Test
    public void shouldCreateTwoPointTiles() {
        assertEquals(new Tile('d').getPointValue(), 2);
        assertEquals(new Tile('D').getPointValue(), 2);
    }
    
    /**
     * Check for three point tile
     */
    @Test
    public void shouldCreateThreePointTiles() {
        assertEquals(new Tile('m').getPointValue(), 3);
        assertEquals(new Tile('M').getPointValue(), 3);
    }
    
    /**
     * Check for four point tile
     */
    @Test
    public void shouldCreateFourPointTiles() {
        assertEquals(new Tile('w').getPointValue(), 4);
        assertEquals(new Tile('W').getPointValue(), 4);
    }
    
    /**
     * Check for five point tile
     */
    @Test
    public void shouldCreateFivePointTiles() {
        assertEquals(new Tile('k').getPointValue(), 5);
        assertEquals(new Tile('K').getPointValue(), 5);
    }
    
    /**
     * Check for eight point tile
     */
    @Test
    public void shouldCreateEightPointTiles() {
        assertEquals(new Tile('x').getPointValue(), 8);
        assertEquals(new Tile('X').getPointValue(), 8);
    }
    
    /**
     * Check for ten point tile
     */
    @Test
    public void shouldCreateTenPointTiles() {
        assertEquals(new Tile('q').getPointValue(), 10);
        assertEquals(new Tile('Q').getPointValue(), 10);
    }
}
