/*
 * The program contains a class called SavingsAccount
 * 		SavingsAccount will have a class variable called annualInterestRate
 * 		SavingsAccount will have an instance variable called savingsBalance
 * 
 */



public class SavingsAccount {

	private static double annualInterestRate=0; //interest rate for all accounts
	private double savingsBalance=0; //amount saver has on deposit
	
	public SavingsAccount(double newBalance) {
		savingsBalance=newBalance;
	}
	
	
	//this method multiplies the annual interest by the savings balance and divides by 12 to generate a monthly interest
	public double calculateMonthlyInterest() {
		savingsBalance = savingsBalance+((savingsBalance*annualInterestRate)/12);
		return savingsBalance;
	}
	public static void modifyInterestRate(double newInterestRate) {
		annualInterestRate=newInterestRate;
	}
}
