package edu.westga.cs.babble.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Played Word Get Score class
 * @author Keith Oguntuwase
 * @version 2.0
 *
 */
public class TestPlayedWordGetScore {
    
    private PlayedWord word;
    
    /**
     * set Up class
     */
    @Before
    public void setUp() {
        word = new PlayedWord();
    }
    
    /**
     * Test Empty Word Should Have Score Of Zero
     */
    @Test
    public void emptyWordShouldHaveScoreOfZero() {
        assertEquals(0, word.getScore());    
    }
    
    /**
     * Test Score A One Tile Word
     */
    @Test
    public void scoreAOneTileWord() {
        word.append(new Tile('A'));
        assertEquals(1, word.getScore());    
    }
    
    /**
     * Test Score A Word With Multiple Differing Tiles
     */
    @Test
    public void scoreAWordWithMultipleDifferingTiles() {
        word.append(new Tile('A'));
        word.append(new Tile('D'));
        assertEquals(3, word.getScore());    
    }
    
    /**
     * Test Score A Word Containing Duplicate Tiles
     */
    @Test
    public void scoreAWordContainingDuplicateTiles() {
        word.append(new Tile('A'));
        word.append(new Tile('A'));
        assertEquals(2, word.getScore());    
    }
}
