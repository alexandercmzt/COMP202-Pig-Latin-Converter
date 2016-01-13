import java.util.Arrays;

public class LongestSubsequence
{
	public static void main (String[] args)
	{
		int[] array = {300, 60, 50, 22, 9, 3, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 22};
		
		System.out.println("Longest Forward:");
		longestForward(array);
		System.out.println("Longest Backward:");
		longestBackward(array);		

	}

	public static void longestForward(int[] forwardArray)
	{
		int lics=1;
		int temp=1;

		for (int i=1; i<forwardArray.length; i++)                       // this loop checks how long the lics array is going to be/ what the lics is 
		{
			if (forwardArray[i] > forwardArray[i-1])
			{
				temp +=1;
			}
			else
			{
				if (temp>lics)                                     //this updates the program with the most recent lics if it is longer than one of the previous ones
				{
					lics=temp;
				}
				temp=1;
			}
		}
		if (temp>lics)                         //accounting for possibility of final array entry being part of the lics
		{
			lics=temp;
		}
		System.out.println(lics);

		int[] finalArray = new int[lics];
		int slot=0;

		for (int i=1; i<forwardArray.length; i++)                     // this loop puts numbers in the lics into slots of the final array
		{
			if (forwardArray[i] > forwardArray[i-1])
			{
				temp +=1;
				finalArray[slot]=forwardArray[i-1];
				slot +=1;
				if (slot == finalArray.length-1)
				{	
					finalArray[slot]=forwardArray[i];                 // loop breaks when final array is totally filled
					break;
				}
			}
			else
			{
				slot=0;
			}
		}
		System.out.println(Arrays.toString(finalArray));
	}

	public static void longestBackward(int[] backwardArray)
	{
		int lics=1;
		int temp=1;

		for (int i=backwardArray.length-2; i >= 0; i--)               // this loop checks how long the lics array is going to be/ what the lics is 
		{
			if (backwardArray[i+1] < backwardArray[i])
			{
				temp +=1;
			}
			else
			{
				if (temp>lics)                             //this updates the program with the most recent lics if it is longer than one of the previous ones
				{
					lics=temp;
				}
				temp=1;
			}
		}
		if (temp>lics)
		{
			lics=temp;
		}
		System.out.println(lics);

		int[] finalArray = new int[lics];
		int slot=0;

		for (int i=backwardArray.length-2; i>=0; i--)                             // this loop puts numbers in the lics into slots of the final array
		{
			if (backwardArray[i+1] < backwardArray[i])
			{
				temp +=1;
				finalArray[slot]=backwardArray[i+1];
				slot +=1;
				if (slot == finalArray.length-1)
				{	
					finalArray[slot]=backwardArray[i];                        // loop breaks when final array is totally filled
					break;
				}
			}
			else
			{
				slot=0;
			}
		}
		System.out.println(Arrays.toString(finalArray));
	}
}