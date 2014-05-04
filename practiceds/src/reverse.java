
public class reverse {

	
	public static void main(String args[])
	{
		String test = "my city is vizag";
		
		String rev = " ";
		String temp =" ";
		int count;
		int k=0;
		for(int i = 0; i<test.length();i++)
		{
			if(test.charAt(i) == ' ')
			{
			
		for(int j=i-1;j>=k;j--)
				{
					//temp = temp + test.charAt(j);
					System.out.println(test.charAt(j));
				
				}
		k = i+1;
			} 
			
		}
		System.out.println(temp);
		
	}
} 
