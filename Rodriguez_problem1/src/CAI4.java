/* 
 * The program will generate numbers with a SecureRandom object
 * The program will ask the student to solve a multiplication problem
 * 		A multiplication problem shall contain two numbers sampled from a uniform random distribution in the range of 0 to 9 (inclusive)
 * The program shall terminate when a correct response is provided by the student
 * The program shall continue to ask the student to solve problems until the student has answered 10 problems
 * Create a main method that runs your program by calling the "quiz" method	
 * 		Create a method called "quiz" that contains the program logic
 * 			Create a method called "askQuestion" that prints the problem to the screen
 * 			Create a method called "readResponse" that reads the answer from the student
 * 			Create a method called "isAnswerCorrect" that checks to see if the student's answer matches the correct answer to the problem
 * 			Create a method called "displayCorrectResponse" that prints out the response when a student enters a correct answer
 * 				The program will display a random positive response if the student provides a correct response
 * 			Create a method called "displayIncorrectResponse" that prints out the response when a student enters an incorrect answer
 * 				The program will display a random negative response if the student provides an incorrect response
 * 			Create a method called "displayCompletionMessage" to display the score and the appropriate score response
 * 				The program shall display the student's score after the student has attempted to solve 10 problems
 * 				The student's score shall be the percentage of problems correctly solved
 * 				The program shall display the message "Please ask your teacher for extra help." if the student's score is less than 75%
 * 				The program shall display the message "Congratulations, you are ready to go to the next level!" if the student's score is 
 * 				greater than or equal to 75%
 * The program shall ask the student if they want to solve a new problem set after the score message has been displayed
 * The program shall restart when the student agrees to solve a new problem set
 * The program shall terminate when the student declines to solve another problem set
 * Create a function called "readDifficulty" that reads the difficulty level from the student
 * 		The program shall ask the student to enter a difficulty level of 1, 2, 3, or 4
 * Create a function called "generateQuestionArgument" that uses the difficulty level to generate a random number		
 * 		A difficulty level of 1 shall limit random numbers to the range of 0-9, inclusive
 * 		A difficulty level of 2 shall limit random numbers to the range of 0-99, inclusive
 * 		A difficulty level of 3 shall limit random numbers to the range of 0-999, inclusive
 * 		A difficulty level of 4 shall limit random numbers to the range of 0-9999, inclusive
 */

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {

	private int multiplicand=0;
	private int multiplier=0;
	private int product=0;
	private int answer=0;
	private int score=0;
	
	public static final Scanner userInput=new Scanner(System.in);
	public static SecureRandom rand = new SecureRandom();
	
	public int readDifficulty() {
		int difficulty=userInput.nextInt();
		return difficulty;
	}
	
	public void generateQuestionArgument() {
		switch(readDifficulty()) {
			case 1:
				for(int i=0; i<10; i++) {
					multiplicand=Math.abs(rand.nextInt()%10);
					multiplier=Math.abs(rand.nextInt()%10);
					
					product=multiplier*multiplicand;
					
					askQuestion();
					readResponse();
					if(isAnswerCorrect()==1) {
						score++;
					}
				}
				break;
			case 2:
				for(int i=0; i<10; i++) {
					multiplicand=Math.abs(rand.nextInt()%100);
					multiplier=Math.abs(rand.nextInt()%100);
					
					product=multiplier*multiplicand;
					
					askQuestion();
					readResponse();
					if(isAnswerCorrect()==1) {
						score++;
					}
				}
				break;
			case 3:
				for(int i=0; i<10; i++) {
					multiplicand=Math.abs(rand.nextInt()%1000);
					multiplier=Math.abs(rand.nextInt()%1000);
					
					product=multiplier*multiplicand;
					
					askQuestion();
					readResponse();
					if(isAnswerCorrect()==1) {
						score++;
					}
				}
				break;
			case 4 : 
				for(int i=0; i<10; i++) {
					multiplicand=Math.abs(rand.nextInt()%10000);
					multiplier=Math.abs(rand.nextInt()%10000);
					
					product=multiplier*multiplicand;
					
					askQuestion();
					readResponse();
					if(isAnswerCorrect()==1) {
						score++;
					}
				}
				break;
			default :
				System.out.println("Invalid number");
				System.exit(0);
		}
	}
	
	public void displayCompletionMessage() {
		System.out.println("Your score is: "+score*10+"%");
		if(score<=7) {
			System.out.println("Please ask your teacher for extra help.");
		}
		else {
			System.out.println("Congratulations, you are ready to go to the next level!");
		}
	}
	
	public int readResponse() {
		answer=userInput.nextInt();
		return answer;
	}
	
	public void askQuestion() {
		System.out.printf("What is %d times %d?\n", multiplicand, multiplier);
	}
	
	public void displayCorrectResponse() {
		
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
	
	public int isAnswerCorrect() {
		
		if(answer==product) {
			displayCorrectResponse();
			return 1;
		}
		else {
			displayIncorrectResponse();
			return 0;
		}
	}
	
	public void quiz() {
		String string;
		do {
			System.out.println("Please enter 1, 2, 3, or 4 to select the question difficulty (4 is highest difficulty).");
			generateQuestionArgument();
			displayCompletionMessage();
			score=0;
			System.out.println("Please type 'continue' to continue, or type 'exit' to quit the program.");
			string=userInput.next();
			if(string.equalsIgnoreCase("exit")) {
				break;
			}
			
		}
		while(string.equalsIgnoreCase("continue"));
		
	}
	
	public static void main(String[] args) {
		CAI4 cai= new CAI4();
		cai.quiz();
			
	}

}
