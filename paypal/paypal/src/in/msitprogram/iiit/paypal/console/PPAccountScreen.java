package in.msitprogram.iiit.paypal.console;

import java.io.IOException;
import java.util.Scanner;

import in.msitprogram.iiit.paypal.accounts.PPAccount;
import in.msitprogram.iiit.paypal.accounts.PPBusinessAccount;
import in.msitprogram.iiit.paypal.accounts.PPRestrictedAccount;
import in.msitprogram.iiit.paypal.accounts.Transaction;
import in.msitprogram.iiit.paypal.persistance.DataStore;
import in.msitprogram.iiit.paypal.accounts.Profile;

public class PPAccountScreen 
{
	PPAccount account;
	Scanner scan;
	Profile Prof;
	float creditAmount;
	Transaction trans = new Transaction();
	MainMenu main = new MainMenu();
	PPNewAccountScreen newscr = new PPNewAccountScreen();
	public PPAccountScreen(String email) throws Exception
	{
		scan = new Scanner(System.in);
		account = DataStore.lookupAccount(email);
		Prof = DataStore.lookupProfile(email);
	}

	@SuppressWarnings("resource")
	public void show1() throws Exception 
	{
		int ch1;
		//check if account is active
		if(account.isActivated())
		{
			System.out.println(account);
			System.out.println(Prof.getType());
			switch(Prof.getType())
			{
			case 1:
				do
				{
					System.out.println(" business account");
					System.out.println("1.Add fund");
					System.out.println("2.withdraw fund");
					System.out.println("3.send money");
					System.out.println("4.Request Money");
					System.out.println("5.view balance");
					System.out.println("6.view transactions");
					System.out.println("7.add member");
					System.out.println("8.Log out");
				    System.out.println("Enter a choice:");
					ch1 = scan.nextInt();
					switch(ch1)
					{
					case 1:
						this.addFunds();
						break;
					case 2:
						this.withdrawFunds();
						break;
					case 3:
						this.sendMoney();
						break;
					case 4:
						this.requestMoney();
						break;
					case 5:
					    System.out.println(account.toString());
					    break;
					case 6:
						Transaction.showtrans(account.getEmail());
						break;
					case 7:
						PPNewAccountScreen newAccScreen = new PPNewAccountScreen();			//ADDING new operators for Business type PPAccount					
						newAccScreen.createRestrictedAccount((PPBusinessAccount)account);
						break;
					case 8 :
						MainMenu.show();
						break;
					
					}
				}while(ch1<0 && ch1 > 7);
				break;
			case 2:
				do
				{
					System.out.println("student Account");
					System.out.println("1.Send Money");
					System.out.println("2.view transactions");
					System.out.println("3.Log out");
				        System.out.println("Enter a choice:");
					ch1 = scan.nextInt();
					switch(ch1)
					{
					case 1:
						this.sendMoney();
						break;
					
	                                case 2:
						Transaction.showtrans(account.getEmail());
						break;
					case 3:
						MainMenu.show();
						break;
					}
				}while(ch1<0 && ch1 > 7);
				break;
			case 3:
				do
				{
					System.out.println(" Personal Account");
					System.out.println("1.Add fund");
					System.out.println("2.withdraw fund");
					System.out.println("3.send money");
					System.out.println("4.Request Money");
					System.out.println("5.view balance");
					System.out.println("6.view transactions");
					System.out.println("7.Log out");
				    System.out.println("Enter a choice:");
					ch1 = scan.nextInt();
					switch(ch1)
					{
					case 1:
						this.addFunds();
						break;
					case 2:
						this.withdrawFunds();
						break;
					case 3:
						this.sendMoney();
						break;
					case 4:
						this.requestMoney();
						break;
					case 5:
					    System.out.println(account.toString());
					    break;
					case 6:
						Transaction.showtrans(account.getEmail());
						break;
					case 7 :
						MainMenu.show();
						break;
					}
				}while(ch1<0 && ch1 > 7);
			}
			
		}
		else
		{
			System.out.println("ur account is not yet activated");
			System.out.println("do u wish to activate ur account now,if yes press 1 or else press 2");
			Scanner scan8= new Scanner(System.in);
			int ach= scan8.nextInt();
			if(ach==1)
			{
				newscr.completeAccountCreation();
			}
			else
			{
				account.suspend();
			}
			
		}
		
		System.out.println("successfully logged in ");
	}
		
			
			// print menu and accept menu options
			// for all the paypal account operations
	
	private void withdrawFunds() throws IOException
	{
		// implement the withdraw funds user interface here
		System.out.println("how much do you want to withdraw");
		@SuppressWarnings("resource")
		Scanner scan6= new Scanner(System.in);
		float withdrawamount = scan6.nextFloat();
		if(account.withdraw(withdrawamount))
		{
			DataStore.updateAccount(account,account.getEmail());
		}
		trans.recTrans(account.getEmail(), "Self", withdrawamount, "Fund Withdrawal", "Self");
		DataStore.writetrans(trans);
		
		//use the account object as needed for withdraw funds
	}

	private void requestMoney() throws Exception
	{
		System.out.println("enter the email of the user to whom u want to request");
		Scanner scan8= new Scanner(System.in);
		String remail = scan8.next();
		System.out.println("how much amount do u want to recive from "+remail);       
		float reqmoney = scan8.nextFloat();
		PPAccount acc = DataStore.lookupAccount(remail);
		if(acc!=null)
		{
			if(account.requestMoney(reqmoney,remail))
			{
				@SuppressWarnings("unused")
				boolean af = account.addFunds(reqmoney);
				DataStore.updateAccount(account, account.getEmail());
				trans.recTrans(account.getEmail(), remail, reqmoney, "Money Request", "Self");
				DataStore.writetrans(trans);
				trans.recTrans(remail, account.getEmail(), reqmoney, "Money Requested", "Self");
				DataStore.writetrans(trans);
				System.out.println("Your request for "+reqmoney+" Rs has been sent to "+remail);
			}
		else
			 System.out.println("invalid action");	
	    }    
		// 	implement the request money user interface here
		
		//use the account object as needed for request money funds
	}

	private void sendMoney() throws Exception
	{
		System.out.println("enter the beneficiary email");
		@SuppressWarnings("resource")
		Scanner scan7= new Scanner(System.in);
		String benemail= scan7.next();
		String ref=null;
		System.out.println("how much amount do u want to send to "+benemail);
	    float sentmoney= scan7.nextFloat();
        PPAccount acc = DataStore.lookupAccount(benemail);
		if(acc!=null)
		{
	       if(account.sendMoney(sentmoney, benemail))
	       {
	    	DataStore.updateAccount(account, account.getEmail());
	    	if(Prof.getType()==2)
			{
				PPRestrictedAccount temp = (PPRestrictedAccount) account;
				ref = temp.getParentEmail();
				trans.recTrans(ref, benemail, sentmoney, "Debit", account.getEmail());
				DataStore.writetrans(trans);
			}
			else
			ref = "Self";
			trans.recTrans(account.getEmail(), benemail, sentmoney, "Debit", ref);
			DataStore.writetrans(trans);
			trans.recTrans(benemail, account.getEmail(), sentmoney, "Credit", ref);
			DataStore.writetrans(trans);
	        }
		}
	    
		// implement the send moeny user interface here
		
		//use the account object as needed for send money funds
	}

	private void addFunds() throws IOException 
	{
		// implement the add funds user interface here
		System.out.println("enter the amount to be credited");
		Scanner scan5 = new Scanner(System.in);
		float creditAmount= scan5.nextFloat();
		if(account.addFunds(creditAmount))
		{
			DataStore.updateAccount(account,account.getEmail());
		}
		//use the account object as needed for add funds
		trans.recTrans(account.getEmail(), "Self", creditAmount , "Fund Withdrawal", "Self");
		DataStore.writetrans(trans);
	}
}              