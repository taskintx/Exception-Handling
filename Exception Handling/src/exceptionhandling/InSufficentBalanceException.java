package exceptionhandling;

public class InSufficentBalanceException extends Exception {

	//set constructor with message argument of String type
	public InSufficentBalanceException(String message) {
		//call super constructor with our argument
		super(message);
	}
	//make default construct as well because sometime we may not pass any message in the constructor
	public InSufficentBalanceException() {}
}
