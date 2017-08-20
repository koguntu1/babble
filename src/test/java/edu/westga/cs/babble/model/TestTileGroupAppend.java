package edu.westga.cs.babble.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test tile group append
 * @author Keith Oguntuwase
 * @version 2.0
 *
 */
public class TestTileGroupAppend {
    
    /**
     * Test should not allow null
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowNull() {
        Tile tile = null;
        new TestTileGroup().append(tile);

    }
    
    /**
     * Test empty group should be empty
     */
    @Test
    public void emptyGroupShouldBeEmpty() {
        TestTileGroup testTileGroup = new TestTileGroup();
        assertEquals(0, testTileGroup.tiles().size());
    }
    
    /**
     * Test should have one tile in tile group
     */
    @Test
    public void shouldHaveOneTileInTileGroup() {
        TestTileGroup testTileGroup = new TestTileGroup();
        testTileGroup.append(new Tile('A'));
        assertEquals(1, testTileGroup.tiles().size());
    }
    
    /**
     * Test should have many tile in tile group
     */
    @Test
    public void shouldHaveManyTilesInTileGroup() {
        TestTileGroup testTileGroup = new TestTileGroup();
        testTileGroup.append(new Tile('A'));
        testTileGroup.append(new Tile('B'));
        assertEquals(2, testTileGroup.tiles().size());
    }
    
    /**
     * Test should have many duplicate tile in tile group
     */
    @Test
    public void shouldHaveManyTilesIncludingDuplicatesInTileGroup() {
        TestTileGroup testTileGroup = new TestTileGroup();
        testTileGroup.append(new Tile('A'));
        testTileGroup.append(new Tile('B'));
        testTileGroup.append(new Tile('B'));
        assertEquals(3, testTileGroup.tiles().size());
    }
    
    /**
     * Test cannot add same tile twice
     */
    @Test(expected = IllegalArgumentException.class)
    public void canNotAddSameTileTwice() {
        TestTileGroup testTileGroup = new TestTileGroup();
        testTileGroup.append(new Tile('A'));
        Tile tileB = new Tile('B');
        testTileGroup.append(tileB);
        testTileGroup.append(tileB);
    }
}
