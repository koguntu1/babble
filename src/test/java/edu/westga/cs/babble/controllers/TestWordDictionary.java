package edu.westga.cs.babble.controllers;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * This is test word dictionary class
 * @author Keith Oguntuwase
 * @version 1.0
 *
 */
public class TestWordDictionary {

	private WordDictionary dictionary;
	
	/**
	 * Test set up 
	 * @throws Exception 
	 */
	@Before
	public void setUp() throws Exception {
		this.dictionary = new WordDictionary();
	}

	
	/**
	 * Test string valid
	 */
	@Test
	public void stringExpandShouldBeValid() {
		assertTrue(this.dictionary.isValidWord("Expand"));
	}
	
	/**
	 * Test string not valid
	 */
	@Test
	public void stringBugblatShouldNotBeValid() {
		assertFalse(this.dictionary.isValidWord("Bugblat"));
	}
	
	/**
	 * Test empry string
	 */
	@Test
	public void emptyStringShouldNotBeValid() {
		assertFalse(this.dictionary.isValidWord(""));
	}

	/**
	 * Test shouldNotAcceptNull
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAcceptNull() {
		this.dictionary.isValidWord(null);
	}
}
