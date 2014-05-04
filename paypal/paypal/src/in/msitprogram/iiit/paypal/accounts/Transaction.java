package in.msitprogram.iiit.paypal.accounts;

import in.msitprogram.iiit.paypal.persistance.DataStore;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Vector;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Transaction implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String tTime;
	String tDate;
	String narration;
	String reference;
	String status;
	float amount;
	String fromEmail;
	String toEmail;
	
	public String toString()
	{
		
		return null;
	}
	public float getAmount() 
	{
	   return amount;
	}

	public String getFromEmail()
	{
		return fromEmail;
	}

	public String getNarration()
	{
		return narration;
	}

	public void recTrans(String from, String to, float amt, String type, String ref)
	{
		DateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
		tTime = dateformat.format(date);
		DateFormat dateformat1 = new SimpleDateFormat("yyyy/MM/dd");
		tDate = dateformat1.format(date);
		fromEmail = from;
		toEmail = to;
		amount = amt;
		narration = type;
		reference= ref;
		if(narration.equals("Request"))
			status = "Pending";
		else
			status = "Complete";
	}
	
	public static String showtrans(String email) throws IOException
	{
		System.out.println("Last five transactions: ");
		Vector<Transaction> transList = DataStore.readtransc(email);
		for (int i=0; i<transList.size(); i++)
		{
			Transaction t = transList.get(i);
			if( t.narration.equals("Credit"))
			{
				
				System.out.println("Transaction num"+(i+1));
				
				System.out.println("Time       : "+ t.tDate+ " "+t.tTime);
				System.out.println("Payee      : "+ t.toEmail);
				System.out.println("Beneficiary: "+ t.fromEmail);
				System.out.println("Ammount    : "+ t.amount);
				System.out.println("Transaction Type : "+ t.narration);
				System.out.println("Reference  : "+ t.reference);
				System.out.println("Status     : "+ t.status);
				System.out.println("===================================");
			}
			else if(t.narration.equals("Money Request"))
			{
				
				System.out.println("Transaction num "+(i+1));
				System.out.println("Time: "+ t.tDate+ " "+t.tTime);
				System.out.println("From : "+ t.fromEmail);
				System.out.println("To   : "+ t.toEmail);
				System.out.println("Ammount : "+ t.amount);
				System.out.println("Transaction Type : "+ t.narration);
				System.out.println("Reference : "+ t.reference);
				System.out.println("Status    : "+ t.status);
				System.out.println("======================================");
			}
			else if(t.narration.equals("Money Requested"))
			{
				System.out.println("Transaction num"+(i+1));
			    System.out.println("Time: "+ t.tDate+ " "+t.tTime);
				System.out.println("From : "+ t.toEmail);
		        System.out.println("To   : "+ t.fromEmail);
				System.out.println("Ammount : "+ t.amount);
				System.out.println("Transaction Type : "+ t.narration);
				System.out.println("Reference: "+ t.reference);
				System.out.println("Status: "+ t.status);
				System.out.println("==========================================");
			}
			else
			{
				
				System.out.println("Transaction num"+(i+1));
				System.out.println("Date & Time : "+ t.tDate+ " "+t.tTime);
				System.out.println("Payee       : "+ t.fromEmail);
				System.out.println("Beneficiary : "+ t.toEmail);
				System.out.println("Ammount     : "+ t.amount);
				System.out.println("Transaction Type : "+ t.narration);
				System.out.println("Reference   : "+ t.reference);
				System.out.println("Status      : "+ t.status);
				System.out.println("====================================");
			}

		}
		
		return null;
	}	
}
