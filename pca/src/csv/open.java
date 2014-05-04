package csv;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;


public class open {
	
	    
	    //iterate through the list
	    
	public static void main(String [] args) throws IOException
	{
		String csvFile = "sample1.csv";
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
	    String line1,line2 = "";
	    int lineNumber = 0; 
	    int colnum =0 ;
	    int rownum =0;
	    while((line1=br.readLine()) !=null)
	    {
	       String [] St1 =  line1.split(",");
		   colnum = St1.length;
		   rownum++;
	    }
	    System.out.println("rows"+rownum);
		 br.close();
	    
	    BufferedReader br1 = new BufferedReader(new FileReader(csvFile));
	    ArrayList<ArrayList<String>> group = new ArrayList<ArrayList<String>>() ;
	 
	    
	/*   line1 = br.readLine();
	   String [] St1 =  line1.split(",");
	   colnum = St1.length;
	   System.out.println(colnum);
	  */
	  
	  ArrayList[] list = new ArrayList[colnum];
	  for(int i=0; i<colnum; i++)
	  {
	      list[i] = new ArrayList<String>();
	  }
	   while((line2=br1.readLine())!=null)
        {
		  String [] st = line2.split(",");
		  
		  int k=0;
		for(int h =0; h < colnum; h++)
		{
		  while(k<st.length)
		  {
			  list[h].add(st[k]);
		      k++;
		      break;
		  }
		  group.add(list[h]);
		  
		  
        }
        }
	   ArrayList<ArrayList<String>> group2 = new ArrayList<ArrayList<String>>() ;
	   
	   
     
        for(int i = 0 ;i< colnum;i++)
        {
        	group2.add(group.get(i));
        }
        int count=0;
    
        System.out.println("size before removing junk"+group2.size());
      //  System.out.println(group2);
        for(int i=0;i<group2.size();i++)
        {
        	//System.out.println("outr loop"+i);
        	count=0;
        	for(int j=0;j<group2.get(i).size();j++)
        	{
        		
        		//checking if the feature is not repeated 
        		//System.out.println(Collections.frequency(group2.get(i), group2.get(i).get(j))+"data"+group.get(i).get(j));
        		if(Collections.frequency(group2.get(i), group2.get(i).get(j))==1)
        		{
        			count=count+1;
        		}
        		
        		//checking for the frequency of features which are equal to the size of the group
        		
        		if(Collections.frequency(group2.get(i), group2.get(i).get(j))==(group2.get(i).size()) )
        		{
        			//System.out.println("jksfkjf");
        			//System.out.println("removing"+group2.get(i));
        			group2.remove(i);
        			break;
        		}
        	}
        }
        System.out.println("size after removing the junk"+group2.size());	
       // System.out.println(group2);
        //checking for duplicate columns
        
        for(int i=0;i<group2.size();i++)
        {
        	for(int j=0;j<group2.size();j++)
        	{
        		if(i!=j)
        		{
        			if(group2.get(i).equals(group2.get(j)))
        			{
        				group2.remove(i);
        			}
        		}
        	}
        	
        }
        System.out.println("size after removing dupliacate columns"+group2.size());	
      //  System.out.println(group2);
     //System.out.println(group2);
        
        
        ArrayList<ArrayList<String>> group3 = new ArrayList<ArrayList<String>>() ;
      	 
    	
    	  ArrayList[] list1 = new ArrayList[rownum];
    	  for(int i=0; i<rownum; i++)
    	  {
    	      list1[i] = new ArrayList<String>();
    	  }
          
  	  for(int i=0;i< group2.size();i++)
  	  {
  		  for(int j=0;j< group2.get(i).size();j++)
  		 {
  			  list1[j].add(group2.get(i).get(j));
  		 }
  		  
  	  }
  	  
  	  	  
    	  for(int i6=0; i6< list1.length ; i6++ )
    	  {
  	  group3.add(list1[i6]);
    	  }
   
    	  System.out.println("size before removing the duplicate rows"+group3.size());
    	  
    	for(int i=0;i<group3.size();i++)
      {
      	for(int j=0;j<group3.size();j++)
      	{
      		if(i!=j)
      		{
      			if(group3.get(i).equals(group3.get(j)))
      			{
      				group3.remove(i);
      				break;
      			}
      		}
      	}
      	
      }
    	System.out.println("after removal of duplicate rows "+group3.size());
  //  System.out.println(group3);
    ArrayList<ArrayList<String>> group4 = new ArrayList<ArrayList<String>>() ;

	  ArrayList[] list2 = new ArrayList[group2.size()];
	  
	  for(int i=0; i< group2.size(); i++)
	  {
	      list2[i] = new ArrayList<String>();
	  }
	  
    for(int j2=0;j2<list2.length;j2++)
    {
    	
    
  	  int j3= 0 ;
    	while(j3<group3.size())
    	{
    		
    		for(int j4=j2 ;j4<group3.get(j4).size();j4++)
    		{
    			
    		   list2[j2].add(group3.get(j3).get(j4));
    		   break;
    		   
    		  
    		}
    		j3++;
    		
    	}
    	
    }
 
    for(int i=0;i<list2.length;i++)
    {
    	group4.add(list2[i]);
    }
    
   
    
    System.out.println("no of col after removal of duplicate rows"+group4.size());
  }
	
}
