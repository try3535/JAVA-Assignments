//sample file for question 2 of difficult questions section

package Teaching;

class findPaths {
	int row,column;
	public String matrix[][][];
	public findPaths()
	{
		row=-1;
		column=-1;
	}
	public void set_size(int row,int column)
	{
		this.row=row;
		this.column=column;
		matrix=new String[row+1][column+1][];
		return;
	}
	private String number_at_index(int i,int j)
	{
		return Integer.toString((i-1)*column+j);

	}
	public void find_all_paths()
	{
		if(row==-1 || column==-1){System.out.println("Size not specified");return;}
		matrix[row][column]=new String[1];
		matrix[row][column][0]=number_at_index(row,column);

		for(int i=row-1;i>0;i--)
		{
			matrix[i][column]=new String[1];
			matrix[i][column][0]=number_at_index(i,column)+"-"+matrix[i+1][column][0];
		}
		for(int i=column-1;i>0;i--)
		{
			matrix[row][i]=new String[1];
			matrix[row][i][0]=number_at_index(row,i)+"-"+matrix[row][i+1][0];
		}
		for(int i=row-1;i>0;i--)
			for(int j=column-1;j>0;j--)
			{
				matrix[i][j]=new String[matrix[i+1][j].length+matrix[i][j+1].length];
				for(int k=0;k<matrix[i][j].length;k++)
				{
					if(k<matrix[i+1][j].length)
						matrix[i][j][k]=number_at_index(i,j)+"-"+matrix[i+1][j][k];
					else
						matrix[i][j][k]=number_at_index(i,j)+"-"+matrix[i][j+1][k-matrix[i+1][j].length];
				}
			}
		//printing all paths
		System.out.println("Total number of paths are : "+matrix[1][1].length);
		for(int i=0;i<matrix[1][1].length;i++)
			System.out.println(matrix[1][1][i]);
		return;
	}

}
public class Print_All_Paths {

	public static void main(String[] args) {
		findPaths obj = new findPaths();
		obj.set_size(4,2);
		obj.find_all_paths();
	}

}
