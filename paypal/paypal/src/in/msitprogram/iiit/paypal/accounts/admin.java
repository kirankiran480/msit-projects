package in.msitprogram.iiit.paypal.accounts;

import in.msitprogram.iiit.paypal.persistance.DataStore;
import in.msitprogram.iiit.paypal.utils.PPToolkit;

import java.util.ArrayList; 
import java.util.Scanner;
import java.util.Vector;
import java.io.*;

public class admin implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4119844388928217150L;
	private String userName;
	private String password;
    public admin()
	{
		
	}
	public void activeAccounts()
       {
            Vector<PPAccount> v=new Vector<PPAccount>();
            PPAccount p1 = new PPAccount();
            int total=0;
            try
            {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Accounts.txt"));
                    v=(Vector<PPAccount>)ois.readObject();
                    ois.close();
            }
            catch(Exception e)
            {}
            for(int i=0;i<v.size();i++)
            {
                    p1=(PPAccount)v.elementAt(i);
                    if(p1.isActivated())
                    {
                    total=total+1;
                    }
            }
            System.out.println("Total number of active accounts : "+total);
       }
       
        public void totalmoney()
        {
            Vector<PPAccount> v1 = new Vector<>();
            PPAccount p2 = new PPAccount();
            float total =0;
            try
            {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Accounts.txt"))) {
                    v1=(Vector<PPAccount>)ois.readObject();
                }
            }
            catch(IOException | ClassNotFoundException e)
            {}
            for(int j=0;j<v1.size();j++)
            {
                p2=(PPAccount)v1.elementAt(j);
                total =  (total+p2.accountBal);
            }
            System.out.println("total amount in account is "+total);
            
        }
        
	
      }
