package in.msitprogram.iiit.paypal.accounts;

import java.util.ArrayList;
import java.util.List;

public class PPBusinessAccount extends PPAccount {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList <PPRestrictedAccount> accountOperators;
   
	public PPBusinessAccount(Profile profile) {
		super(profile);
		accountOperators = new ArrayList<PPRestrictedAccount>();
	}
	
	public void addAccountOperator(PPRestrictedAccount accountOperator)
	{
		accountOperators.add(accountOperator);
		//accountOperators.add((<PPRestrictedAccount> accountOperator.size(), accountOperator);
		//add account operators after checking if there are duplicates
	}

}
