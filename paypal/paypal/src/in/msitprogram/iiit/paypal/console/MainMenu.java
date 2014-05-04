/**
 * 
 */
package in.msitprogram.iiit.paypal.console;

import java.util.Scanner;
import java.io.*;
import in.msitprogram.iiit.paypal.accounts.PPAccount;
import in.msitprogram.iiit.paypal.accounts.Profile;
import in.msitprogram.iiit.paypal.persistance.DataStore;
import in.msitprogram.iiit.paypal.utils.PPToolkit;
import in.msitprogram.iiit.paypal.accounts.*;
/**
 * @author pg
 *
 */
public class MainMenu
{
	private static String email;
	private static Scanner scan;
	private static PPNewAccountScreen newaccount;

	    public static void show() throws Exception
	    {
               
		//show the welcome message with the main menu options
                while(true)
                {
		System.out.println("========================*WELCOME TO PAYPAL*==================");
		System.out.println("\n\t\t\tWhat do you want to do??? \t\t\t\t\n");
		System.out.println("\n\t\t\t1.login");
		System.out.println("\n\t\t\t2.signup");
		System.out.println("\n\t\t\t3.admin login\n");
		System.out.println("\n\t\t\t4.exit\n");
		scan = new Scanner(System.in);
		int ch= scan.nextInt();
		
		//System.out.println(email);
		switch(ch)
		{
		case 1:
			
			System.out.println("\n\t\t\tenter your email-id please\n");
			email= scan.next();
			if(PPToolkit.validateEmail(email))
			{ 
				 PPAccount acc = DataStore.lookupAccount(email);
				 if(acc!=null)
				 {
					 System.out.println("login here");
					 PPAccountScreen Accs1 = new PPAccountScreen(email);
					Accs1.show1();
					 //((PPAccountScreen) Accs).PPAccountScreen(email);
				 }
				 else 
				 {
					 System.out.println("doesnot exists");
				     show();
					 
				 }
				
			}
			break;
		case 2:
			
			System.out.println("\n\t\t\tenter your email-id please\n");
			email= scan.next();
			if(PPToolkit.validateEmail(email))
			{
				Profile p = DataStore.lookupProfile(email);
				
				if(p==null)
			   {
					newaccount = new PPNewAccountScreen(email);
					newaccount.show();
			    }
	            else
					System.out.println("already exists");
			}
			else
				System.out.println("Invalid Email");
			break;
		case 3:
                {
                    System.out.println("enter username");
                    Scanner sc1= new Scanner(System.in);
                    String username = sc1.next();
                    System.out.println("enter password");
                    String password  = sc1.next();
                    
                    if("123456".equals(password) && "kiran".equals(username))
                    {
                        System.out.println("welcome admin");
                        admin adm = new admin();
                        while(true)
                        {
                        System.out.println("what do u want to do???");
                        System.out.println("\n1.Total money \n2.total number of accounts\n3.exit");
                        Scanner sc= new Scanner(System.in);
                        int ch3= sc.nextInt();
                        switch(ch3)
                        {
                            case 1:
                                adm.totalmoney();
                                break;
                            case 2:
                                adm.activeAccounts();
                                break;
                            case 3:
                                System.exit(3);
                                break;
                            case 4:
                                 MainMenu.show();
                        }
                     }
                    }
                    else
                    {
                        System.out.println("you have entered wrong password");
                    }
                    }  
                case 4:
                   System.exit(1);
                    break;
                }
}
            }
}

		
		//take the menu option as input from the console
		
		//take email address as input from the console
		
		//based on the given menu option instantiate the respective screens


