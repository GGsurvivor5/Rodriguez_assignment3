/* 
 * The program will generate numbers with a SecureRandom object
 * The program will ask the student to solve a multiplication problem
 * 		A multiplication problem shall contain two numbers sampled from a uniform random distribution in the range of 0 to 9 (inclusive)
 * The program shall terminate when a correct response is provided by the student
 * The program shall continue to ask the student to solve the original multiplication problem until the student provides the correct answer
 * Create a main method that runs your program by calling the "quiz" method	
 * 		Create a method called "quiz" that contains the program logic
 * 			Create a method called "askQuestion" that prints the problem to the screen
 * 			Create a method called "readResponse" that reads the answer from the student
 * 			Create a method called "isAnswerCorrect" that checks to see if the student's answer matches the correct answer to the problem
 * 			Create a method called "displayCorrectResponse" that prints out the response when a student enters a correct answer
 * 				The program will display a random positive response if the student provides a correct response
 * 			Create a method called "displayIncorrectResponse" that prints out the response when a student enters an incorrect answer
 * 				The program will display a random negative response if the student provides an incorrect response
 */

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {

	private int multiplicand=0;
	private int multiplier=0;
	private int product=0;
	private int answer=0;
	
	public static final Scanner userInput=new Scanner(System.in);
	
	public int readResponse() {
		answer=userInput.nextInt();
		return answer;
	}
	
	public void askQuestion() {
		System.out.printf("What is %d times %d?\n", multiplicand, multiplier);
	}
	
	public void displayCorrectResponse() {
		SecureRandom rand = new SecureRandom();
		int randomNumber=Math.abs(rand.nextInt()%4);
		switch(randomNumber) {
			case 0 :
				System.out.println("Very good!");
				break;
			case 1 :
				System.out.println("Excellent!");
				break;
			case 2 :
				System.out.println("Nice work!");
				break;
			case 3 :
				System.out.println("Keep up the good work!");
				break;
			default :
				System.out.println("Invalid number, something went wrong :(");
		}
	}
	
	public void displayIncorrectResponse() {
		SecureRandom rand = new SecureRandom();
		int randomNumber=Math.abs(rand.nextInt()%4);
		switch(randomNumber) {
			case 0 :
				System.out.println("No. Please try again.");
				break;
			case 1 :
				System.out.println("Wrong. Try once more.");
				break;
			case 2 :
				System.out.println("Don't give up!");
				break;
			case 3 :
				System.out.println("No. Keep trying.");
				break;
			default :
				System.out.println("Invalid number, something went wrong :(");
		}
	}
	
	public boolean isAnswerCorrect() {
		
		if(answer==product) {
			displayCorrectResponse();
			return true;
		}
		else {
			displayIncorrectResponse();
			return false;
		}
	}
	
	public void quiz() {

		SecureRandom rand = new SecureRandom();
		multiplicand=Math.abs(rand.nextInt()%10);
		multiplier=Math.abs(rand.nextInt()%10);
		
		product=multiplier*multiplicand;
		
		do {
			askQuestion();
			readResponse();
		}
		while(isAnswerCorrect() != true);
		
	}
	
	public static void main(String[] args) {
		CAI2 cai= new CAI2();
		cai.quiz();

	}

}
