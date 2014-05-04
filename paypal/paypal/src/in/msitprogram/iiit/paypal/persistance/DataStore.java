package in.msitprogram.iiit.paypal.persistance;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Vector;

import in.msitprogram.iiit.paypal.accounts.PPAccount;
import in.msitprogram.iiit.paypal.accounts.PPRestrictedAccount;
import in.msitprogram.iiit.paypal.accounts.Profile;
import in.msitprogram.iiit.paypal.accounts.Transaction;
import in.msitprogram.iiit.paypal.accounts.admin;

@SuppressWarnings("unused")
public class DataStore 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static PPAccount lookupAccount(String email) throws Exception 
	{ 
		Vector<PPAccount> v=new Vector<PPAccount>();
		boolean flag=false;
		int i;
		try
		{
		
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Accounts.txt"));
			v=(Vector<PPAccount>)ois.readObject();
			ois.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		for(i=0;i<v.size();i++)
		{
			//System.out.println(v.get(i).getEmail());
			if( v.get(i).getEmail().equalsIgnoreCase(email))
			{
				flag=true;
				break;
			}
		}
		if(flag)
			return v.get(i);
		else
			return null;
	}
	public static int toalact() throws Exception 
	{ 
		Vector<PPAccount> v=new Vector<PPAccount>();
		boolean flag=false;
		int i;
		try
		{
		
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Accounts.txt"));
			v=(Vector<PPAccount>)ois.readObject();
			ois.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return v.size();
			
	}
	
	public static void writeAccount(PPAccount account)
	{
		Vector<PPAccount> v=new Vector<PPAccount>();
		try
		{
		
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Accounts.txt"));
			v=(Vector<PPAccount>)ois.readObject();
			ois.close();
		}
		catch(Exception e)
		{}
			
		v.add(account);
		try
		{
			ObjectOutputStream obj1 = new ObjectOutputStream(new FileOutputStream("Accounts.txt"));
			obj1.writeObject(v);
			obj1.close();
		}
		catch(IOException e)
		{}
		try
		{
		
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Accounts.txt"));
			v=(Vector<PPAccount>)ois.readObject();
			ois.close();
		}
		catch(Exception e)
		{}
			System.out.println(v.size());
	}
	public static void updateAccount(PPAccount account,String email)
	{
		Vector<PPAccount> v=new Vector<PPAccount>();
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
			if(v.get(i).getEmail().equalsIgnoreCase(email))
			{
				v.remove(i);
				v.add(i, account);
				break;
			}
		}	
		try
		{
			ObjectOutputStream obj1 = new ObjectOutputStream(new FileOutputStream("Accounts.txt"));
			obj1.writeObject(v);
			obj1.close();
		}
		catch(IOException e)
		{}
		System.out.println(v.size());
	}
	public static Profile lookupProfile(String email) throws IOException
	{
		Vector<Profile> v=new Vector<Profile>();
		boolean flag=false;
		int i;
		try
		{
		
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Profile.txt"));
			v=(Vector<Profile>)ois.readObject();
			ois.close();
		}
     catch(Exception e)
		{
			System.out.println("enter");
		}
		for(i=0;i<v.size();i++)
		{
			//System.out.println(v.get(i).getEmail());
			if( v.get(i).getEmail().equalsIgnoreCase(email))
			{
				flag=true;
				break;
			}
		}
		if(flag)
			return v.get(i);
		else
			return null;
	}
		
	public static void writeProfile(Profile prof) throws IOException
	 {
		 Vector<Profile> v=new Vector<Profile>();
			try
			{
			
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Profile.txt"));
				v=(Vector<Profile>)ois.readObject();
				ois.close();
			}
			catch(Exception e)
			{}
				
			v.add(prof);
			try
			{
				ObjectOutputStream obj1 = new ObjectOutputStream(new FileOutputStream("Profile.txt"));
				obj1.writeObject(v);
				obj1.close();
			}
			catch(IOException e)
			{}
			try
			{
			
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Profile.txt"));
				v=(Vector<Profile>)ois.readObject();
				ois.close();
			}
			catch(Exception e)
			{}
				//System.out.println(v.size());
		}
	public static void writeadmin(Profile prof) throws IOException
	 {
		 Vector<admin> v=new Vector<admin>();
			try
			{
			    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("admin.txt"));
				v=(Vector<admin>)ois.readObject();
				ois.close();
			}
			catch(Exception e)
			{}
				
			v.addAll((Collection<? extends admin>) prof);
			try
			{
				ObjectOutputStream obj1 = new ObjectOutputStream(new FileOutputStream("admin.txt"));
				obj1.writeObject(v);
				obj1.close();
			}
			catch(IOException e)
			{}
			try
			{
			
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("admin.txt"));
				v=(Vector<admin>)ois.readObject();
				ois.close();
			}
			catch(Exception e)
			{}
				System.out.println(v.size());
		}
	
	public static void writetrans(Transaction trans)
		{
			Vector<Transaction> v=new Vector<Transaction>();
			File file=new File("transaction.txt");
			boolean exists = file.exists();
	        
			if(exists)
			{
				try
				{
	            FileInputStream fis = new FileInputStream("transaction.txt");    
	        	ObjectInputStream ois = new ObjectInputStream(fis);
	            while(fis.available()!=0)
	        		{
	        			Transaction ppa=(Transaction)ois.readObject();
	        			v.add(ppa);
	        			
	        		}
	                v.add(trans);
	                ois.close();
				}
	        catch(Exception e)
	        {}
	        try
	        {
	                ObjectOutputStream obj1 = new ObjectOutputStream(new FileOutputStream("transaction.txt"));
	                
	                for(int i=0;i<v.size();i++)
	                {
	                	obj1.writeObject(v.get(i));
	                }
	                obj1.close();
	                
	        }
	        catch(IOException e)
	        {}
	        
		}//if closing
		else
			{
				try
		        {
		        
					ObjectOutputStream obj1 = new ObjectOutputStream(new FileOutputStream("transaction.txt"));
					
					obj1.writeObject(trans);
					
					obj1.close();
		        	
		        }
				catch(Exception e1)
				{
					System.out.println("******"+e1);
				}
			}
		}//function closing
	
	 public static Vector<Transaction> readtransc(String email1) 
		{
			//PPAccount account = null; //initialize it after reading from file
			// write code to open the files, read
			Vector<Transaction> v=new Vector<Transaction>();
			Vector<Transaction> t=new Vector<Transaction>();
			
			
	        int i,j=0;
	        int count=0;
	        
	        File file=new File("transaction.txt");
			boolean exists = file.exists();
	        
			if(exists)
			{
				try
				{
				FileInputStream fis = new FileInputStream("transaction.txt");
				ObjectInputStream oin = new ObjectInputStream(fis);
				count=0;
				while(fis.available()!=0)
				{
					Transaction rta=(Transaction)oin.readObject();
					//System.out.println("in while");
					//System.out.println("emailid is "+rta.getFromEmail());  
					if(rta.getFromEmail().equalsIgnoreCase(email1))
					{
						v.add(rta);
						count++;
					}
			    }
				oin.close();
		        }
				catch(Exception e)
		        {
					System.out.println(e);
		        }
				System.out.println("size of vector is"+v.size());
				if(count>5)
				{
					j=v.size()-1;
					
					for(i=0;i<=5;i++)
			        {
			            
						 t.add(v.elementAt(j));  
						 j--;
			        }
					return(t);
				}
				else if(count>0)
				{
					for(i=v.size()-1;i>=0;i--)
	                {
	                        t.add(v.elementAt(i));          
	                }
					return(t);
					
				}
				else
				{
					return null;
				}
			}//if closing of file exists
			else
			{
				try
		        {
		        
					ObjectOutputStream obj1 = new ObjectOutputStream(new FileOutputStream("transaction.txt"));
					obj1.close();
		        	//return null;
		        }
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				return null;
			}
		} //readtransc closing
}


