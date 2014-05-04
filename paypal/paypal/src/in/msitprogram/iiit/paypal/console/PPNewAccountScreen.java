package in.msitprogram.iiit.paypal.console;

import java.io.IOException;
import java.util.Scanner;

import in.msitprogram.iiit.paypal.accounts.PPAccount;
import in.msitprogram.iiit.paypal.accounts.PPBusinessAccount;
import in.msitprogram.iiit.paypal.accounts.PPRestrictedAccount;
import in.msitprogram.iiit.paypal.accounts.Profile;
import in.msitprogram.iiit.paypal.persistance.DataStore;
import in.msitprogram.iiit.paypal.utils.PPToolkit;
import in.msitprogram.iiit.paypal.console.*;
import in.msitprogram.iiit.paypal.console.MainMenu;
public class PPNewAccountScreen 
{
	Profile profile;
	PPAccount account;
	String email;
	Scanner scan;
	private String code1;
	int ch1;
	
	public PPNewAccountScreen(String email) 
	{
		profile = new Profile();
		scan = new Scanner(System.in);
		this.email = email;
	}

	

	public PPNewAccountScreen()
        {
		// TODO Auto-generated constructor stub
	}

	public  void show() throws Exception 
	{
		//check if the account with the given email address exists 
		
		//if not create the user profile
		 
		//show the account types
                while(true)
                {
		System.out.println("\n\t\t\tenter the type of account you want to create");
		System.out.println("\n\t\t\t1.business account\n");
		System.out.println("\n\t\t\t2.student account\n");
		System.out.println("\n\t\t\t3.personal account\n");
                System.out.println("\n\t\t\t4.previous menu\n");
                System.out.println("\n\t\t\t5.exit\n");
	    ch1= scan.nextInt();
		
		switch(ch1)
		{
		case 1:
			 
		  profile= createProfile(email);
		 this.createBusinessAccount();
                 DataStore.writeProfile(profile);
		 this.completeAccountCreation();
		 DataStore.writeAccount(account);
		 System.out.println(account);
		 break;
		case 2:
			 profile= createProfile(email);
			this.createStudentAccount();
			DataStore.writeProfile(profile);
			this.completeAccountCreation();
            DataStore.writeAccount(account);
            System.out.println(account.getEmail());
            break;
		case 3:
			
			
			// this.createPersonalAccount();
			 profile= createProfile(email);
             DataStore.writeProfile(profile);
             this.createPersonalAccount();
             //this.completeAccountCreation(account.getEmail());
             this.completeAccountCreation();
             DataStore.writeAccount(account);
             //System.out.println(account);
             break;
                    
                case 4:
                      MainMenu.show();
                      break;
                case 5:
                      System.exit(2);
                    break;
			  
		
		}
		//based on the given account type selected create the account object
	}
        }
	private Profile createProfile(String email)
	{
		// use this for creating the profile
		    Profile Profile1= new Profile() ;
		    @SuppressWarnings("resource")
			Scanner scan1= new Scanner(System.in);
			System.out.println("enter ur name ");
		    String name = scan1.next();
		    Profile1.setEmail(name);	    
		    System.out.println("enter ur address ");
		    String address = scan1.next();
		    Profile1.setaddress(address);
	        System.out.println("enter phone number");
			String phone = scan1.next();
			Profile1.setphone(phone);
		    Profile1.setEmail(email);
		    Profile1.setType(ch1);
		return Profile1;
	}

	private void createBusinessAccount() throws Exception 
	{
		//use this for creating the business account
		
		 account= new PPBusinessAccount(profile);
	  
	}

	private void createStudentAccount() throws Exception 
	{
		//use this for creating the student account 
		
		Scanner Scan3=new Scanner(System.in);
		String pemail;
		PPAccount temp;
		do{
		System.out.println("enter source account id");
		pemail= Scan3.next();
		temp=DataStore.lookupAccount(pemail);
		profile= createProfile(email);
		}while(temp==null ||!PPToolkit.validateEmail(pemail));		
		
		account = new PPRestrictedAccount(profile,pemail);
	}

	/*
	 * this method create the personal account, saves it to the file system
	 * and redirects the users to the next screen
	 */
	private void createPersonalAccount() throws Exception {
		//use this for creating the personal account
		
		account = new PPAccount(profile);
		//completeAccountCreation();
	}
	
	public void completeAccountCreation() throws Exception
	{
		String code3 = PPToolkit.generateActivationCode();
		account.activate(code3);
		
	//ask & redirect the user to the activation screen or the main menu
	}
	public void createRestrictedAccount(PPBusinessAccount MainAcc) throws Exception 
	{
		// TODO Auto-generated method stub
		
		String empEmail ;
		scan = new Scanner(System.in); 
		System.out.println("Enter the email of the employee: ");
                empEmail=scan.next();
		Profile empProfile = new Profile();
		empProfile=createProfile(empEmail);
		DataStore.writeProfile(empProfile);
		PPRestrictedAccount empAcc = new PPRestrictedAccount( empProfile, (String) MainAcc.getEmail() );		
		empAcc.setActivationCode(PPToolkit.generateActivationCode());//do something else
		MainAcc.addAccountOperator(empAcc);
		DataStore.writeAccount(empAcc);
	}
}
