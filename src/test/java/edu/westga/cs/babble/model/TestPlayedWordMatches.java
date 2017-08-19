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
public class TestPlayedWordMatches {
    
    private PlayedWord word;
    
    /**
     * set Up class
     */
    @Before
    public void setUp() {
        word = new PlayedWord();
    }
    
    /**
     * Test Tiles For A Multiple Letter Word
     */
    @Test
    public void hasTilesForAMultipleLetterWord() {
        word.append(new Tile('H'));
        word.append(new Tile('E'));
        assertTrue(word.matches("HE"));
    }
    
    /**
     * Test Tiles For A Single Letter Word
     */
    @Test
    public void hasTilesForASingleLetterWord() {
        word.append(new Tile('H'));
        assertTrue(word.matches("H"));
    }
    
    /**
     * Test Cannot Match Word When Tiles Are Scrambled
     */
    @Test
    public void cannotMatchWordWhenTilesAreScrambled() {
        word.append(new Tile('H'));
        assertFalse(word.matches("A"));
    }
    
    /**
     * Test Cannot Match Word If Insufficient Tiles
     */
    @Test
    public void cannotMatchWordIfInsufficientTiles() {
        word.append(new Tile('H'));
        word.append(new Tile('I'));
        assertFalse(word.matches("HIS"));
    }
    
    /**
     * Test Can Match Word With Duplicate Letters
     */
    @Test
    public void canMatchWordWithDuplicateLetters() {
        word.append(new Tile('J'));
        word.append(new Tile('A'));
        word.append(new Tile('V'));
        word.append(new Tile('A'));
        assertTrue(word.matches("JAVA"));
    }
    
    /**
     * Test Non Empty Word Should Not Match Empty Text
     */
    @Test
    public void nonEmptyWordShoudlNotMatchEmptyText() {
        assertFalse(word.matches("JAVA"));
    }
    
    /**
     * Test Empty Word Should Not Match Empty Text
     */
    @Test
    public void emptyWordShouldNotMatchEmptyText() {
        word.append(new Tile('J'));
        word.append(new Tile('A'));
        word.append(new Tile('V'));
        word.append(new Tile('A'));
        assertFalse(word.matches(""));
    }
    
    /**
     * Test Empty Word Should Not Match Empty Text
     */
    @Test(expected = IllegalArgumentException.class) 
    public void shouldNotAllowNull() {
        word.matches(null);
    }    
}
