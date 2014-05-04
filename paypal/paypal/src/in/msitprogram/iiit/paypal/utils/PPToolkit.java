/**
 * 
 */
package in.msitprogram.iiit.paypal.utils;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * @author pg
 *
 */
public class PPToolkit {

	

	public static void sendActivationCode(String phone) 
	{
		System.out.println("a23j5h");
		
	}
	public static boolean validateEmail(String email)
	{
		Pattern p=Pattern.compile("[a-zA-Z]*[0-9]*.*@[a-zA-Z]*.[a-zA-Z]*");
		//Pattern p=Pattern.compile("[abc]");
		java.util.regex.Matcher m=p.matcher(email);
		boolean b=((java.util.regex.Matcher) m).matches();
		if(b==true)
			return true;
		else
			return false;
	}
	public static boolean validateAlphabets(String str)
	{
		Pattern p=Pattern.compile("[a-z A-Z]*");
		Matcher m=p.matcher(str);
		boolean b=m.matches();
		if(b==true)
			return true;
		else
			return false;
	}
	public static boolean isValidCC(String number)
	{

		final int[][] sumTable = {{0,1,2,3,4,5,6,7,8,9},{0,2,4,6,8,1,3,5,7,9}};
		int sum = 0, flip = 0;

		for (int i = number.length() - 1; i >= 0; i--) {
			sum += sumTable[flip++ & 0x1][Character.digit(number.charAt(i), 10)];
		}
		return sum % 10 == 0;
	}

	public static String generateActivationCode()
	{
		 //include lower case alpha(a-z) and numbers(0-9)
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        int numberOfCodes = 0;//controls the length of alpha numberic string
        String code = "";
        while (numberOfCodes < 6) 
        {
            char c = chars.charAt((int) (Math.random() * chars.length()));
            code += c;
            numberOfCodes++;
        }
        System.out.println("Code is :" + code);
        return code;

		
	}

	
}

	


