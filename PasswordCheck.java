
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter; 
import java.util.ArrayList.* ; 
import java.util.* ; 
import java.io.IOException ; 


	public class PasswordCheck {

		public static boolean isNumeric(final String a)
	{
	for (char c : a.toCharArray())
	{
		if(!Character.isDigit(c))
			return false ; 
	}
	return true ; 
	}
	public static boolean isAlpha(final String a)
	{
		for (char c: a.toCharArray())
			{
				if(!Character.isLetter(c))
				return false ; 
			}
			return true ; 

	}
	public static void writeStuff(ArrayList arr) throws FileNotFoundException
	{
		java.io.File file = new java.io.File("InsecurePasswords.txt") ; 
		java.io.PrintWriter output = new java.io.PrintWriter(file) ; 
		for (int i = 0 ; i< arr.size()-1; i++)
		{
			output.println(arr.get(i)) ; 
			
		}
		output.close() ; 
	}
	
	
	
		public static void main(String [] args) throws FileNotFoundException
		{
		//passwords.txt
		int count = 0 ;  
		ArrayList<String> invalids = new ArrayList<String>() ; 
		ArrayList<String> replacedStuff = new ArrayList<String>() ; 
		

		File file = new File("passwords.txt");
		Scanner input = new Scanner (file) ; 
		while(input.hasNext())
		{
			String user = input.next() ; 
			String pwd = input.next() ; 


			if (pwd.length()<8 || isNumeric(pwd) || isAlpha(pwd))
			{
			count += 1 ; 
			invalids.add(user + " " + pwd) ; 

			replacedStuff.add(user + " " + "******") ; 

			}
			else

			replacedStuff.add(user + " " + pwd) ; 


		
		}
		System.out.println("There are " + count + " invalid passwords: ") ; 
		for (int i = 0 ; i < invalids.size(); i++)
		{
			System.out.println(invalids.get(i)) ; 
		}
		
		writeStuff(replacedStuff) ; 


		

		

}
}