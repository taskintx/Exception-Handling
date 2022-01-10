package exceptionhandling;






//create sample class Account for testing as specified in the question
public class Account {
	//balance variable of type double
	private double balance;
	
	//method for adding balance
	public void addBalance(double balance) {
		this.balance = balance;
	}
	
	//withdrawBalance method for withdrawing balance
	//this method may throw our created exception so add throws InSufficientBalanceException to this method declaration
	//so when this method is called that person will handle this exception if thrown
	public double withdrawBalance(double balance) throws InSufficentBalanceException {
		//using compare methods of double because double variable may have precisions
		//if withdrawal request balance is more than the current account balance
		if(Double.compare(this.balance,balance) < 0) {
			//throw our created exception that is InSufficentBalanceException
			throw new InSufficentBalanceException("Insufficient account balance");
		}
		//if Account have sufficient balance
		else {
			//deduct the balance
			this.balance -= balance;
			//and return current balance
			return this.balance;
		}
	}
	//showBalance method for showing current balance
	public void showBalance() {
		System.out.println("Current balance is $"+this.balance);
	}
	//testing 
	public static void main(String[] args) {
		Account acc = new Account();
		//adding 600 $ into account
		acc.addBalance(600);
		
		//display balance
		acc.showBalance();
		
		//as this method shows our created exception 
		//so we need to handle this 
		try {
			
			double balance = acc.withdrawBalance(100);
			System.out.println("Transaction Successfull");
			System.out.println("Current balance is : $"+balance);
		}
		//catch it with our exception
		catch(InSufficentBalanceException exc) {
			//showing exception message
			System.out.println("Something went wrong\n");
			System.out.println("Error occured : "+exc.getMessage());
		}
		
		System.out.println("Withdrawing balance ");
		//now withdraw again with balance more than current balance
		try {
			//this should throw exception
			double balance = acc.withdrawBalance(600);
			System.out.println("Transaction Successfull");
			System.out.println("Current balance is : $"+balance);
		}//catch it with our exception
		catch(InSufficentBalanceException exc) {
			//showing exception message
			System.out.println("Something went wrong");
			System.out.println("Error occured : "+exc);
		}
		
		
	}
	
}
