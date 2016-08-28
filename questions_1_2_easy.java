package Teaching;//sample file for question 1 & 2 of easy questions section

//package Assignment1;

abstract class Palindrome_Anagram {
	//your code for declaring variables
	public String str1,str2;
	public abstract void Check_Number();
	public abstract void set_strings(String...varg);
	
}

class Palindrome extends Palindrome_Anagram {

	@Override
	public void Check_Number() {
		//Code for Checking Palindrome
		StringBuffer rev=new StringBuffer(str1);
		if(str1.equals(rev.reverse().toString()))
			System.out.println("Palindrome");
		else 
			System.out.println("Not a Palindrome");
		return;
	}
	public void set_strings(String... varg)
	{
		str1=new String();
		if(varg.length != 1) throw new RuntimeException("ArgumentMisMatch");
		this.str1=varg[0];
		return;
	}
}

class Anagram extends Palindrome_Anagram {

	@Override
	public void Check_Number() {
		// Code for checking Anagram
		int hash[] = new int[100];
		str1=str1.toLowerCase().trim();
		str2=str2.toLowerCase().trim();
		for(int i=0;i < str1.length();i++)
			hash[str1.charAt(i)-48]++;
		for(int i=0;i<str2.length();i++)
			hash[str2.charAt(i)-48]--;
		for(int i=0;i<hash.length;i++)
		{
			if(hash[i]!=0)
			{
				System.out.println("Not an Anagram");
				return;
			}
		}
		System.out.println("It's an Anagram");
		return;
	}
	public void set_strings(String ... varg)
	{
		str1= new String();
		str2 = new String();
		if(varg.length != 2 )throw new RuntimeException("ArgumentMisMatch");
		this.str1 = varg[0];
		this.str2 = varg[1];
		return;
	}
	
}
public class questions_1_2_easy {

	public static void main(String[] args) {
		//your code for declaring objects and accessing classes
		Palindrome_Anagram obj= new Palindrome();
		obj.set_strings("z1bab1z");
		obj.Check_Number();
		obj = new Anagram();
		obj.set_strings("aabbaa","Aaabab");
		obj.Check_Number();
	}

}
