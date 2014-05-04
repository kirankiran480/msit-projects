package in.msitprogram.iiit.paypal.console;

import in.msitprogram.iiit.paypal.accounts.PPAccount;
import in.msitprogram.iiit.paypal.persistance.DataStore;
import in.msitprogram.iiit.paypal.utils.PPToolkit;
import in.msitprogram.iiit.paypal.*;
import java.io.IOException;
import java.util.Scanner;

public class PPAccountActivationScreen 
{
	
	public static void show() throws Exception
	{
		
		//String email = ""; //change to get console input
		
		/*
		 * TODO
		 * fetchnn the account object using email address
		 * check if the account is suspended
		 * if suspended then activate it
		 * if activation code invalid, retry for 2 more attempts
		 * on successful activation show main menu
		 * on failure show the error message and continue to main menu
		 */				
		
		//PPAccount account = DataStore.lookupAccount(email);
		
		//check if account is active. if yes then ask for suspending it
		
		// if yes suspend it if not go back to main menu
		
		// accept activation code, check if valid, if not give 2 more attempts
		
		//proceed to main menu
		MainMenu.show();
	
	}

}