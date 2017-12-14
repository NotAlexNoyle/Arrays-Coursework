// Import GUI for user input prompting
import javax.swing.JOptionPane;

// Declare class
public class ArraysHomework {
	
	// init main
	public static void main(String[] args) {
		
	      // 1. Instantiate the given array to hold 10 Strings.
			String[] myArray = new String[10];
					
	      // 2. Add your name to the Array at index 0 and a friend's name to the Array at index 4
			myArray[0] = "Alex";
			myArray[4] = "Rachel";
	            
	      // 3. Move your friend's name to index 0 in the array and "delete" their name from index 4
			myArray[0] = myArray[4];
			myArray[4] = null;
			
	      // 4. Fill up all of the remaining indexes in the array with more names
			myArray[1] = "Brian";
			myArray[2] = "Jo";
			myArray[3] = "Elizabeth";
			myArray[4] = "Bill";
			myArray[5] = "Ron";
			myArray[6] = "Casey";
			myArray[7] = "Andrew";
			myArray[8] = "Trevor";
			myArray[9] = "Kayla";
	      
	      // 5. Swap the values at index 5 and index 1
			String temp5 = myArray[5];
			String temp1 = myArray[1];
			
			myArray[5] = temp1;
			myArray[1] = temp5;
	      
	      // 6. Print the array from beginning to end.
			String formatHelper = new String();
			
			for(int i = 0; i < myArray.length; i++) {
				
				// Add contents of array to string for mutability during formatting
				formatHelper += myArray[i] + ", ";
				
			}
			
			// Dissect string for nicer formatting
			formatHelper = formatHelper.substring(0, formatHelper.length() - 2) + ".";
			
			System.out.println(formatHelper);
	      
		  // 7. Shuffle the array of strings
			int[] workerArray = new int[myArray.length];

			// Fill temporary array with contents of main array
			for(int i = 0; i < myArray.length; i++) {
				
				workerArray[i] = i;
			   
			}
			
			// Declare worker array to hold values during swap
			String[] placeholder = new String[myArray.length];

			// Psuedo-random shuffling loop
			for(int i = 0; i < myArray.length; i++) {
				
			   int randomNumberGenerator = (int) (Math.random() * myArray.length);
			   
			   int workerInt = workerArray[i];
			   
			   workerArray[i] = workerArray[randomNumberGenerator];
			   
			   workerArray[randomNumberGenerator] = workerInt;
			   
			   placeholder[i] = myArray[i];
				
			   myArray[i] = "";
			   
			}
			
			// Re-populate main array with shuffled values from placeholder array
			for(int i = 0; i < myArray.length; i++) {

				myArray[i] += placeholder[workerArray[i]];
				
			}
			
			// Garbage collect placeholder arrays
			placeholder = null;
			workerArray = null;
			
	      // 8. Find and print the longest and shortest Strings in the array
			// Declare array to hold length of respective strings
			int[] lengthContainer = new int[myArray.length];

			// Populate lengthContainer
			for(int i = 0; i < myArray.length; i++) {

				lengthContainer[i] = myArray[i].length();
				
			}
			
			// Loop (mostly) sorts array from longest to shortest
			for(int i = lengthContainer.length - 1; i > 1; i--) {
				
				for(int j = 0; j < i; j++) {
					
					if(lengthContainer[j] > lengthContainer[j + 1]) {
						
						int elementSwapHelper = lengthContainer[j];
						
						lengthContainer[j] = lengthContainer[j + 1];
						
						lengthContainer[j + 1] = elementSwapHelper;
						
					}
					
				}
				
			}
			
			// Finishes the job of the previous loop
			if(lengthContainer[0] > lengthContainer[1]) {
				
				int tempForSwap = lengthContainer[1];
				
				lengthContainer[1] = lengthContainer[0];
				
				lengthContainer[0] = tempForSwap;
				
			}
			
			// Declare variables to store results
			String longestString = new String();
			String shortestString = new String();
			
			// Pull corresponding longest and shortest strings from array based on length
			for(int i = 0; i < myArray.length; i++) {
				
				if(myArray[i].length() == lengthContainer[lengthContainer.length - 1]) {
					
					longestString = myArray[i];
					
				}
				
				if(myArray[i].length() == lengthContainer[0]) {
					
					shortestString = myArray[i];
					
				}
				
			}
			
			// Present result to user
			System.out.println("Longest String: " + longestString);
			System.out.println("Shortest String: " + shortestString);
			
	      // 9. Add up the total number of characters in all of the strings in the array and print the answer
			int addContainer = 0;
			for(int i = 0; i < myArray.length; i++) {
				
				addContainer += myArray[i].length();
				
			}
			
			System.out.println("Total # of Characters: " + addContainer);
	   
	      // 10. Prompt the user for a String and then perform a linear search of the array to see if that string is or is not in the array. Print if it is or is not found.
			String stringToFind = JOptionPane.showInputDialog(null, "Enter the String you would like to search for:");
				
			// Keeps track of whether or not the user input is blank
			boolean hasCharacters = false;
			// Runs while user input is blank
			while(hasCharacters == false) {
				
				// Checks individual characters to see if they are comprised of only whitespace
				for(int i = 0; i < stringToFind.length(); i++) {
					
					//  If a non-whitespace character is found, the loop will stop next time
					if(Character.isWhitespace(stringToFind.charAt(i)) == false) {
						
						// Breaks out of loops when user input contains non-whitespace characters
						hasCharacters = true;
						
					}
					
				}
				
				// Runs if user input is whitespace
				if(hasCharacters == false) {
					
					// Asks user to re-enter their input so that it is not blank. Passes the value to original input string for re-evaluation
					stringToFind = JOptionPane.showInputDialog(null, "You left the search field blank, please try again:");
					
				}

			}

			// Makes first character uppercase (adhere to standard convention for names of people)
			if(Character.isLowerCase(stringToFind.charAt(0))) {

				stringToFind = Character.toUpperCase(stringToFind.charAt(0)) + stringToFind.substring(1, stringToFind.length());

			}
			
			// Split up characters to correct their individual cases (makes search more adaptable)
			char[] stringBuilder = new char[stringToFind.length()];
			for(int i = 0; i < stringToFind.length(); i++) {
				
				stringBuilder[i] = stringToFind.charAt(i);
				
			}
			
			// Changes every letter but the first of the name to lowercase for search and output
			for(int i = 1; i < stringToFind.length(); i++) {
			
				if(Character.isUpperCase(stringToFind.charAt(i))) {
					
					stringBuilder[i] = Character.toLowerCase(stringBuilder[i]);
					
				}
				
			}
			
			// Nullifies String in preparation for re-population
			stringToFind = "";
			
			// Re-populates String using case-corrected characters
			for(int i = 0; i < stringBuilder.length; i++) {
				
				stringToFind += stringBuilder[i];
				
			}
			
			// Iterates through array to find string user searched for
			boolean wasStringFound = false;
			for(int i = 0; i < myArray.length; i++) {
				
				if(myArray[i].equalsIgnoreCase(stringToFind)) {
					
					wasStringFound = true;
					
					// Presents positive (if applicable) result of search to user
					System.out.println("The String \"" + stringToFind + "\" was found, at index " + i + " in the array.");
					
				}
				
			}
			
			// Presents negative (if applicable) result of search to user
			if(wasStringFound == false) {

				System.out.println("The String \"" + stringToFind + "\" was not found");

			}
			
			// Garbage collection of worker array
			stringBuilder = null;
			
	      // 11. Remove the item at index 4 of the array by shifting everything after it one spot to the left. This means your array should have one empty index at the end after the shift (delete the duplicate item at the end).			
			for(int i = 5; i < myArray.length; i++) {
				
				myArray[i - 1] = myArray[i];
				
			}
			
			// Nullifies extra element post-shift
			myArray[myArray.length - 1] = "";
	      
	      // 12. Create a new array that is twice as big as the current array and copy all of the items to the new array. When complete, swap references so our old array gets garbage collected and the new array is pointed to by your array variable myData.
			// Creates array twice as big as current (fixing blank space left over from step 11 in the process)
			String[] myData = new String[myArray.length * 2];
			
			for(int i = 0; i < myArray.length; i++) {
				// Copies all of the items to the new array
				myData[i] = myArray[i];
				
			}
			
			// Causes contents of old array to be garbage collected. New array is now pointed to by "myData" variable.
			myArray = null;

			// The following loops and array operations correct the length of array so that all the "nulls" from doubling the size of the array don't get in the way of future operations
			int offset = 0;
			for(int i = 0; i < myData.length; i++) {
				
				if(myData[i] == null) {
					
					offset = i - 1;
					break;
					
				}
				
			}
			
			String[] swapper = new String[offset];
			for(int i = 0; i < swapper.length; i++) {
				
				swapper[i] = myData[i];
				
			}
			
			myData = swapper;
			
			// Garbage collects swapper
			swapper = null;
			
	      // 13. Prompt the user to enter 2 numbers within the range of the array's length. If the first is larger than the second print backwards from that index to the first. If the second is larger than the first, print forward in the array from the first index to the second.
			String userInput = JOptionPane.showInputDialog(null, "Please enter in two numbers within the range of 1 and " + myData.length + ".");
			
			// Fetches raw values from user input
			String firstNumberParser = String.valueOf(userInput.charAt(0));
			String secondNumberParser = String.valueOf(userInput.charAt(userInput.length() - 1));
			
			// Input validation
			boolean integersValid = false;
			while(integersValid == false) {
				
				try {
					
					// Attempts to convert fetched values to integers
					Integer.valueOf(firstNumberParser);
					Integer.valueOf(secondNumberParser);
					
					// Runs if no error is caught, and stops the loop
					integersValid = true;
					
				}
				// Handles errors: prompts user again and updates values until no error is encountered
				catch(NumberFormatException workerException) {
					
					userInput = JOptionPane.showInputDialog(null, "Numbers could not be parsed. Please try again. Enter in two numbers within the range of 1 and " + myData.length + ".");
					
					firstNumberParser = String.valueOf(userInput.charAt(0));
					secondNumberParser = String.valueOf(userInput.charAt(userInput.length() - 1));
					
				}

			}
			
			// Runs if the first number is greater than the second number
			if(Integer.valueOf(firstNumberParser) > Integer.valueOf(secondNumberParser)) {
				
				// Fix for instruction logic. User is supposed to enter in a number within range of the array's length (1-9) but that is said without the context of a zero index.
				if(Integer.valueOf(firstNumberParser) == 9) {
					
					firstNumberParser = "8";
					
				}
				
				// Fancy formatting
				String formatHelperEnd1 = new String();

				// Prints range that step instructs
				for(int i = Integer.valueOf(firstNumberParser); i > Integer.valueOf(secondNumberParser) - 1; i--) {
					
					formatHelperEnd1 += myData[i] + ", ";
					
				}
				
				// More dissection for formatting
				formatHelperEnd1 = formatHelperEnd1.substring(0, formatHelperEnd1.length() - 2) + ".";
				
				System.out.println(formatHelperEnd1);
				
			}
			// Runs if second number is bigger than first number
			else if(Integer.valueOf(secondNumberParser) > Integer.valueOf(firstNumberParser)) {
				
				// Fix for instruction logic. User is supposed to enter in a number within range of the array's length (1-9) but that is said without the context of a zero index.
				if(Integer.valueOf(secondNumberParser) == 9) {
					
					secondNumberParser = "8";
					
				}
				
				// More fancy formatting
				String formatHelperEnd2 = new String();

				// Prints range that step instructs
				for(int i = Integer.valueOf(firstNumberParser); i < Integer.valueOf(secondNumberParser) + 1; i++) {
					
					formatHelperEnd2 += myData[i] + ", ";
					
				}
				
				// Even more dissection for formatting
				formatHelperEnd2 = formatHelperEnd2.substring(0, formatHelperEnd2.length() - 2) + ".";
				
				System.out.println(formatHelperEnd2);
				
			}
			// Never should run if user entered in values that comply with the nature of the assignment
			else {
				
				System.out.println("It's a tie. Real nice job going out of bounds of the assignment's logic. Sad pupper: https://i.imgur.com/K0m8oXD.jpg");

			}
			
	}

}
