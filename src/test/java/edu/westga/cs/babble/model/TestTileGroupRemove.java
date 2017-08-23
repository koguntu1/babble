package edu.westga.cs.babble.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test tile group remove
 * @author Keith Oguntuwase
 * @version 2.0
 *
 */
public class TestTileGroupRemove {
    private TestTileGroup tileGroup;

    private Tile tileA = new Tile('A');        
    private Tile tileB = new Tile('B');
    private Tile tileC = new Tile('C');
    private Tile tileD = new Tile('D');

    /**
     * Test set up 
     * @throws Exception 
     */
    @Before
    public void setUp() throws Exception {
        tileGroup = new TestTileGroup();

        tileGroup.append(tileA);
        tileGroup.append(tileB);
        tileGroup.append(tileC);
        tileGroup.append(tileD);
    }

    /**
     * Test should not allow null
     * @throws TileNotInGroupException 
     */
    @Test(expected = TileNotInGroupException.class)
    public void canNotRemoveFromEmptyTileGroup() throws TileNotInGroupException {
        Tile tile = new Tile('A');
        new TestTileGroup().remove(tile);
    }

    /**
     * Test throw tile not in group
     * @throws TileNotInGroupException 
     */
    @Test(expected = TileNotInGroupException.class)
    public void canNotRemoveTileNotInTileGroup() throws TileNotInGroupException {
        tileGroup.remove(new Tile('P'));
    }

    /**
     * Test can remove tile in tile group
     * @throws TileNotInGroupException 
     */
    @Test
    public void canRemoveOnlyTileInTileGroup() throws TileNotInGroupException {
        TestTileGroup testTileGroup = new TestTileGroup();
        testTileGroup.append(tileA);
        testTileGroup.remove(tileA);
        assertEquals(0, testTileGroup.tiles().size());
    }

    /**
     * Test can remove first of many tile in tile group
     * @throws TileNotInGroupException 
     */
    @Test(expected = TileNotInGroupException.class)
    public void canRemoveFirstOfManyTilesFromTileGroup() throws TileNotInGroupException {
        //can remove the tile
        tileGroup.remove(tileA);
        //tile no longer exist to remove
        tileGroup.remove(tileA); 
    }

    /**
     * Test can remove last of many tile in tile group
     * @throws TileNotInGroupException 
     */
    @Test(expected = TileNotInGroupException.class)
    public void canRemoveLastOfManyTilesFromTileGroup() throws TileNotInGroupException {
        //can remove the tile
        tileGroup.remove(tileD);
        //tile no longer exist to remove
        tileGroup.remove(tileD); 
    }

    /**
     * Test can remove middle of many tile in tile group
     * @throws TileNotInGroupException 
     */
    @Test(expected = TileNotInGroupException.class)
    public void canRemoveMiddleOfManyTilesFromTileGroup() throws TileNotInGroupException {
        //can remove the tile
        tileGroup.remove(tileB);
        //tile no longer exist to remove
        tileGroup.remove(tileB); 
    }

    /**
     * Test can remove multiple of many tile in tile group
     * @throws TileNotInGroupException 
     */
    @Test (expected = TileNotInGroupException.class)
    public void canRemoveMultipleTilesFromTileGroup() throws TileNotInGroupException {
        tileGroup.remove(tileB);
        tileGroup.remove(tileC);        
        //tile no longer exist to remove
        tileGroup.remove(tileB);
        tileGroup.remove(tileC);    
    }

    /**
     * Test does not remove duplicate tile in tile group
     * @throws TileNotInGroupException 
     */
    @Test(expected = IllegalArgumentException.class)
    public void doesNotRemoveDuplicateTilesFromTileGroup() throws TileNotInGroupException {
        Tile dupA = new Tile('A');
        tileGroup.append(dupA);
        //can remove the tile
        tileGroup.remove(tileA);
        //duplicate tile still in
        tileGroup.append(dupA);        
    }
}
