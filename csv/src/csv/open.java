package csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class open {
	
	    
	    //iterate through the list
	    
	public static void main(String [] args) throws IOException
	{
		String csvFile = "data.csv";
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
	    System.out.println(rownum);
		 br.close();
	    
	    BufferedReader br1 = new BufferedReader(new FileReader(csvFile));
	    ArrayList<ArrayList<String>> group = new ArrayList<ArrayList<String>>() ;
	 
	    
	
	  
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
        System.out.println(group2.size()+"number of records");
        System.out.println(group2);
	}	 
}
