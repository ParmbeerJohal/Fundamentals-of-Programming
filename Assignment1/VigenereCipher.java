/*
* Name: Parm Johal
* ID: V00787710
* Date: January 29, 2018
* Filename: VigenereCipher.java
* Details: CSC 115, Assignment 1
*/

/*
* The class VigenereCipher contains methods for
* performing encryptions and decryptions on
* various words given by a certain client class.
* The test for this class occured in the 'main' header at the bottom
* A string was received into the program, encrypted, then decrypted back out
*/

import java.util.*;

public class VigenereCipher {

	private int[] key;

	public VigenereCipher(String key) {

		setKey(key);

	}

	public String decrypt(String ciphertext) {

		int[] sway = stringToIntArray(ciphertext);
		for (int i=0; i<ciphertext.length(); i++) {

			int iGotTheKey = key[i%3];
			sway [i] = (26 + sway [i] - iGotTheKey)%26;

		}//end of for loop

		String inThaNight = intArrayToString(sway);

		return inThaNight;//returns decrypted string
	}

	private void dumpArray(int[] array, String text) {

		System.out.print(text);
		for (int i = 0; i < array.length -1; i++) {

			System.out.print(array[i] + ",");

		}//end of for loop

		System.out.println(array[array.length -1]);

	}

	public String encrypt(String plaintext) {

		//Encrypts a string using a simplified Vigenere cipher.
		int[] sway = stringToIntArray(plaintext);

		for (int i=0; i<plaintext.length(); i++) {

			int iGotTheKey = key[i%3];
			sway [i] = (sway [i] + iGotTheKey)%26; //makes certain that letters don't go past 26 (number of letters)

		}//end of for loop

		String inThaMorning = intArrayToString(sway);
		return inThaMorning;//returns encrypted string

	}

	private String intArrayToString(int[] encodedText) {

		//Converts an array of integers with values in the range 0...25 into a string with characters in the range a...z.
		String aToS = new String();
		int i = encodedText.length;
		int x = 0;

		while (x < i) {

			aToS += (char) (encodedText[x]+97);
			x++;

		}//end of while loop

		return aToS; //returns string

	}

	public void	setKey(String key) {

		//Sets the key for a simplified Vigenere cipher.
		this.key = stringToIntArray(key);

	}

	private int[] stringToIntArray(String text) {

		//Converts a string into an int array where the values are within the range 0...25.
		int[] sToA = new int[text.length()];
		int i=0;

		while (i<text.length()) {

			sToA[i] = (int)(text.charAt(i))-97; //lines up 0 to 'a', 1 to 'b', etc.
			i++;

		}//end of while loop

		return sToA;//returns array

	}

	public static void main(String[] args) {
		//Used for internal testing purposes only.

	}

}
