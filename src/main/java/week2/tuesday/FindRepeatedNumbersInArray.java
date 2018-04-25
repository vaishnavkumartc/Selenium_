package week2.tuesday;

import java.util.HashSet;

public class FindRepeatedNumbersInArray {


	public static void main(String[] args) {


		int arr[] = {1,21,12,33,43,12,43,55};

		for (int i = 0; i < arr.length-1; i++)
		{
			for (int j = i+1; j < arr.length; j++)
			{
				if ((arr[i] == arr[j]) && (i != j))
				{
					System.out.print(" Duplicate Element : "+arr[j]);
				}
			}
		}
	}
}


/* String[] strArray = {"1", "21", "12", "33", "43", "12", "43"};

     HashSet<String> set = new HashSet<String>();

     for (String arrayElement : strArray)
     {
         if(!set.add(arrayElement))
         {
             System.out.println("Duplicate Element is : "+arrayElement);
         }
     }

		}*/




