package se.lexicon.amin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HangManTest
{
    private HangMan testGame;

    @Before
    public void setup() {
       testGame = new HangMan();
    }

    @Test
    public void testNewGuessTrue() {
        //Arrange
        //Act
        //Assert
        assertTrue(testGame.isNewGuess('A'));
    }

    @Test
    public void testNewGuessFalse() {
        //Arrange
        testGame.addGuessToAllGuesses('A');
        //Act
        //Assert
        assertFalse(testGame.isNewGuess('A'));
    }

    @Test
    public void testIsCorrectGuessTrue() {
        //Arrange
        //Act
        //Assert
        assertTrue(testGame.isCorrectGuess('L'));
    }

    @Test
    public void testIsCorrectGuessFalse() {
        //Arrange
        //Act
        //Assert
        assertFalse(testGame.isCorrectGuess('B'));
    }

    @Test
    public void testIsGuessesLeftTrue() {
        //Arrange
        //Act
        //Assert
        assertTrue(testGame.isGuessesLeft(3));
    }

    @Test
    public void testIsGuessesLeftFalse() {
        //Arrange
        //Act
        //Assert
        assertFalse(testGame.isGuessesLeft(8));
    }

    @Test
    public void testAllGuessesMadeString() {
        //Arrange
        //Act
        testGame.addGuessToAllGuesses('A');
        testGame.addGuessToAllGuesses('B');
        String actualString = testGame.getAllGuesses().toString();
        String expectedString = "AB";
        //Assert
        assertTrue(actualString.equals(expectedString));
    }

    @Test
    public void testGetIndexOfCorrectGuess() {
        //Arrange
        //Act
        int actualResult = testGame.getIndexOfCorrectGuess('X');
        int expedtedResult = 2;
        //Assert
        assertEquals(expedtedResult, actualResult, 0);
    }


}
