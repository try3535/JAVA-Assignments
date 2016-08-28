//sample file for question 1 of difficult questions section
//special case if after removing c and ad resultant string contains c or ad then
//remove it, that is, your final string should be free from c and ad

package Teaching;

class removeString {
	//private utility fundtion for checking whether the position is required or not
	private boolean position_required(int index)
	{
		if(str[index]=='c')return false;
		if(str[index]=='a' && index < length-1 && str[index+1] == 'd')
		{
			str[index]=str[index+1]='c';
			return false;
		}
		return true;
	}

	//your code for declaring variables
	char str[];
	int length;
	removeString(String str)
	{
		this.str=new char[str.length()];
		this.str=str.toCharArray();
		this.length=str.length();
	}
	public String display() {
		//your code for removing substring c and ad
		int not_required=0,next_required=-1;
		char temp;

		while(next_required<length && not_required<length) {
			while (not_required<length && position_required(not_required)) not_required++;
			//searching for next required element
			next_required = not_required;
			while (next_required<length && !position_required(next_required)) next_required++;

			if(next_required<length && not_required<length){
				temp = str[next_required];
				str[next_required] = str[not_required];
				str[not_required] = temp;
			}

		}
		not_required=0;
		next_required=-1;
		//removing the special cases

		while(next_required<length && not_required<length) {
			while (not_required<length && position_required(not_required)) not_required++;
			//searching for next required element
			next_required = not_required;
			while (next_required<length && !position_required(next_required)) next_required++;

			if(next_required<length && not_required<length){
				temp = str[next_required];
				str[next_required] = str[not_required];
				str[not_required] = temp;
			}

		}
		//return the resultant string
		return new String (str).substring(0,not_required);

	}
}

public class Remove_SubString {
	
	public static void main(String[] args) {
		//your code for declaring objects and accessing classes
		removeString obj = new removeString("zyacccccdkp");
		System.out.print(obj.display());
	}

}
