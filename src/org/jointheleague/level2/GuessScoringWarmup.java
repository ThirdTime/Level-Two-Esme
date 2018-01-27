package org.jointheleague.level2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GuessScoringWarmup {
	public static void main(String[] args) {
		// test
		String answer = "toad";
		String guess = "frog";
		GuessScoringWarmup thisClass = new GuessScoringWarmup();
		ArrayList <String> log = new ArrayList<String>();
		log.add("boy");
		log.add("toadies");
		log.add("toad");
		
		
		System.out.println(thisClass.scoreAllGuesses(log, answer));
		
		/*
		System.out.println("answer is " + answer + " and the guess is " + guess
				+ ", it should return 0, actually returns " + thisClass.scoreSoloGuess(guess, answer));

		guess = "toads";
		System.out.println("answer is " + answer + " and the guess is " + guess
				+ ", it should return 1, actually returns " + thisClass.scoreSoloGuess(guess, answer));

		guess = "TOADS";
		System.out.println("answer is " + answer + " and the guess is " + guess
				+ ", it should return 1, actually returns " + thisClass.scoreSoloGuess(guess, answer));

		guess = "Toad";
		System.out.println("answer is " + answer + " and the guess is " + guess
				+ ", it should return 2, actually returns " + thisClass.scoreSoloGuess(guess, answer));

		guess = "toad";
		System.out.println("answer is " + answer + " and the guess is " + guess
				+ ", it should return 2, actually returns " + thisClass.scoreSoloGuess(guess, answer));
		// end of test
		 */

	}

	public int scoreSoloGuess(String guess, String answer) {
		String guessAllLowercase = guess.toLowerCase();
		String answerAllLowercase = answer.toLowerCase();

		if (guess.equalsIgnoreCase(answer)) {
			return 2;
		} else if (guessAllLowercase.contains(answerAllLowercase)) {
			return 1;
		} else {
			return 0;
		}
	}

	public int scoreAllGuesses(ArrayList<String> listOfGuesses, String answer) {
		int totalScore = 0;
		for(int i = 0; i < listOfGuesses.size(); i++){
			totalScore = totalScore +scoreSoloGuess(listOfGuesses.get(i), answer);
		}
		return totalScore;	
	}

}
