package edu.westga.cs.babble.model;

/**
 * A candidate word made up of tiles and their points
 * @author lewisb
 * @version 1.0
 *
 */
public class PlayedWord extends TileGroup {

	/** creates a new empty word
	 * 
	 */
	public PlayedWord() {
		
	}
	
	/**
	 * Gets the total points of all Tiles in this Word.
	 * 
	 * @return the total tile points for this work; zero if no Tiles in the word
	 */
	public int getScore() {
		int score = 0;
		for (Tile tile : super.tiles()) {
			score += tile.getPointValue();
		}
		return score;
	}
	
	/**
	 * Check to see if this word's tiles can make the candidate text. Order matters.
	 * @param text the candidate text
	 * @return true if this word has the needed letters, false otherwise
	 */
	public boolean matches(String text) {
		if (text == null) {
			throw new IllegalArgumentException();
		}
		
		if (text.isEmpty()) {
			return false;
		}
		
		return text.equals(super.getHand());
	}

	/**
	 * Clears all tiles, emptying out the word
	 */
	public void clear() {
		super.tiles().clear();
	}
}
