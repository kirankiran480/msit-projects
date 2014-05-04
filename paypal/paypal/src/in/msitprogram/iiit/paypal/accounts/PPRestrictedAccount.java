package in.msitprogram.iiit.paypal.accounts;

import in.msitprogram.iiit.paypal.persistance.DataStore;
import java.util.*;
public class PPRestrictedAccount extends PPAccount
{
	
    private static final long serialVersionUID = 1L;
	private String parentEmail;
	private float withdrawLimit;


	
	
	public PPRestrictedAccount(Profile profile, String email)
	{
		// TODO Auto-generated constructor stub
		super(profile);
		// TODO Auto-generated constructor stub
	    @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
	    //String pEmail = null;
		//String pEmail = scan.next();
	    parentEmail = email;
	    System.out.println("enter withdraw limit:");
	   float withdrawLimit = scan.nextFloat();
	}

	public String getParentEmail()
	{
		return parentEmail;
	}
	
	public void setParentEmail(String parentEmail)
	{
		this.parentEmail = parentEmail;
	}
      
    @Override
        public boolean sendMoney(float transferAmount, String bEmail) throws Exception 
	{
		PPAccount parent  = DataStore.lookupAccount(parentEmail);
		if(parent.withdraw(transferAmount))
		{
			PPAccount beneficiary  = DataStore.lookupAccount(bEmail);
			beneficiary.addFunds(transferAmount);
			System.out.println("Amount is successfully Sent to the beneficiary.");
			DataStore.updateAccount(parent,parentEmail);
			return true;
		}
		else
			System.out.println("transfer unsuccessfull!");
		return false;
	}

}
