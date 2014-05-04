package in.msitprogram.iiit.paypal.accounts;

import in.msitprogram.iiit.paypal.persistance.DataStore;
import in.msitprogram.iiit.paypal.utils.PPToolkit;

import java.util.ArrayList; 
import java.util.Scanner;
import java.io.*;

public class PPAccount implements Serializable
{
	/**
	 * 
	 */
	private Profile profile;
	public String email;
	public float accountBal;
	private boolean isActivated;
	@SuppressWarnings("unused")
	private String activationCode;
	private ArrayList<Transaction> transactions;
	
	public PPAccount(Profile profile) 
	{
		this.profile = profile;
		this.isActivated=false;
		this.accountBal =0;
		// TODO Auto-generated constructor stub
	}

	public PPAccount() {
		// TODO Auto-generated constructor stub
	}

	public String toString()
	{
		
		String str =     "\n===========  Account details =======" + profile+ "\n balance of the account is : "+ this.accountBal;
		// implement this function to return a beautiful looking string
		// to display the summary of the account
		return str;
	}

	public void activate(String activationCode) 
	{
		
		//code1 = account.setActivationCode(code3);
		//System.out.println(code3);
		int i=3;
		Scanner scan4= new Scanner(System.in);
		do{
		System.out.println("Enter the code for verification");
		String code2= scan4.next();
		i--;
		if(code2.equals(activationCode))
		{
			isActivated = true;
			System.out.println("Your account is activated. Log in again!");
			break;
			//PPAccountActivationScreen.show();
		}
		else
		{
			
			System.out.println("Account activation failed.number of trials left= "+i);
		     if(i==0)
		    	 System.out.println("your account is suspended");
		}
	}while(!isActivated && i!=0);
		// TODO Auto-generated method stub
		
	}
	
	public void suspend() 
	{
		isActivated =false;
		// TODO Auto-generated method stub
	}


	public boolean withdraw(float withdrawAmount) 
	{
		accountBal= accountBal-withdrawAmount;
		return true;
	}


	public boolean addFunds(float creditAmount) 
	{
		accountBal= accountBal+creditAmount;
		System.out.println(accountBal);
		return true;
	}
	
	public boolean sendMoney(float creditAmount,String bemail) throws Exception 
	{
		if(accountBal>creditAmount)
		{
		accountBal=  accountBal - creditAmount;
		System.out.println(accountBal);
		System.out.println("money sent successfully");
		PPAccount beneficiary  = DataStore.lookupAccount(bemail);
		beneficiary.addFunds(creditAmount);
		DataStore.updateAccount(beneficiary, bemail);
		System.out.println("money transfered to beneficiary successfully");
		return true;
		}
		else 
		{ 
			System.out.println("ENTERED EMAIL IS NOT ASSOCIATED TO ANY ACCOUNT");
			return false;
		}
	    }
	
	public boolean requestMoney(float creditAmount,String remail) throws Exception 
	{
		PPAccount reqacc = DataStore.lookupAccount(remail);
		if(reqacc==null)
		{
		System.out.println("you have entered invalid account");
	    System.out.println("transfer unsuccessfull");
		return false;
		}
		else 
		{
			if(reqacc.accountBal>=creditAmount)
			{
				boolean wid =reqacc.withdraw(creditAmount);
				if(wid==true)
					DataStore.updateAccount(reqacc, remail);
				return true;
			}
		     else
		         return false;
	   }
	}
	
	public void setActivationCode(String actcode)
	{
		activationCode = actcode;
		//return activationCode;
	}
	public boolean isActivated()
    {
    	return isActivated;
    }
	public String getEmail()
	{
		// TODO Auto-generated method stub
	      return profile.getEmail();
	}
	
}
