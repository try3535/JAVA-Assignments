//sample file for question 1 & 2 of intermediate questions section

package Teaching;

class infinite {
    //declaring a private utility function
    private int binary_search(int start,int end,int key)
    {
        if(start==end)
        {
            if(arr[start]==key)return start;
            else return -1;
        }
        int mid=(start+end)/2;
        if(arr[mid] == key)return mid;
        if(key < arr[mid])return binary_search(start,mid-1,key);
        else return binary_search(mid+1,end,key);
    }

    //declaring variables
    public int arr[];
    //constructor for declaring an infinite size array
    public infinite()
    {
        this.arr=new int[1000000];
        for(int i=0;i<arr.length;i++)
            arr[i]=i+1;
    }
    public void Find_Element(int key) {
        //your code for implementing first question of section intermediate questions
        int lower=0,higher=1,index;
        while(key>arr[higher])
        {
            if(2*higher <arr.length)//this won't be necessary if the size infinite
            {lower=higher;
            higher*=2;}
        }
        index=binary_search(lower,higher,key);
        if(index == -1)
            System.out.println("Element does not exist in the array");
        else
            System.out.println("Element "+"\""+key+"\""+" is present at index: "+index);
        return;
    }

}

class spiral extends infinite {
    public int row,column;
    public int matrix[][];
    private void create_2d_from_1d()
    {
        int i,j;
        matrix=new int[row][column];
        //converting a 1D array to a 2D array
        for(i=0;i<row;i++)
            for(j=0;j<column;j++)
                matrix[i][j]=arr[column*i+j];
        return;
    }
    public void set_size(int row,int column)
    {
        this.row=row;
        this.column=column;
        create_2d_from_1d();
        return;
    }
    public void Print_Spiral() {
        //your code for displaying matrix in spiral form
        int horizontal=column,vertical=row;
        int x,y,i;
        for(int start=0;start<=Math.min(column%2==0?column/2-1:column/2,row%2==0?row/2-1:row/2);start++)
        {

            x=y=start;
            for(i=0;i<horizontal;i++)
                System.out.print(matrix[x][y++]+" ");
            y=y-1;
            x=x+1;
            for(i=1;i<vertical;i++)
                System.out.print(matrix[x++][y]+" ");
            x=x-1;
            y=y-1;
            for(i=1;i<horizontal;i++)
                System.out.print(matrix[x][y--]+" ");
            y=y+1;
            x=x-1;
            for(i=1;i<vertical-1;i++)
                System.out.print(matrix[x--][y]+" ");
            horizontal=horizontal-2;
            vertical=vertical-2;

        }

    }
}

public class questions_1_2_intermidiate {

    public static void main(String[] args) {
        //your code for declaring objects and accessing Find_Element and Print_Spiral
        infinite obj = new infinite();
        System.out.print("Searching for value 5:-\n");
        obj.Find_Element(5);
        System.out.println("Printing the 2d matrix obtained:");
        spiral new_obj=new spiral();
        new_obj.set_size(4,3);
        new_obj.Print_Spiral();

    }
}
