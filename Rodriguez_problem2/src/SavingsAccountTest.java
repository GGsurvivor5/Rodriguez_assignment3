import java.text.DecimalFormat;

public class SavingsAccountTest {

	public static void main(String[] args) {
		DecimalFormat df= new DecimalFormat("#.00");
		SavingsAccount saver1 = new SavingsAccount(2000);
		SavingsAccount saver2 = new SavingsAccount(3000);
		SavingsAccount.modifyInterestRate(0.04);
		System.out.printf("%-10.10s %-10.10s %-10.10s%n","Month", "Saver1", "Saver2");
		for(int i=1; i<=12; i++) {
			System.out.printf("%-10.10s %-10.10s %-10.10s%n",i, 
					df.format(saver1.calculateMonthlyInterest()),
					df.format(saver2.calculateMonthlyInterest()));
		}
		SavingsAccount.modifyInterestRate(0.05);
		System.out.printf("%-10.10s %-10.10s %-10.10s%n","13",
				df.format(saver1.calculateMonthlyInterest()),
				df.format(saver2.calculateMonthlyInterest()));
	}

}
