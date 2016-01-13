import java.util.Arrays;

public class randomMethods
{
	public static void main(String[] args) 
	{
	
	String[] fuckyou = {"lalalala", "fuckrobert", "AHEHAEHEAHEH"};

	swap(fuckyou, 1, 2);

	System.out.println(Arrays.toString(fuckyou));

	}

	public static int howManyCopies(int[] arrayWithCopies)
	{
		int slotsWithCopies = 0;
		
		for (int i = 0; i<arrayWithCopies.length;i++ ) 
		{
			
			for (int j = i; j > 0; j--)
			{
				if (arrayWithCopies[i] == arrayWithCopies[j-1])
				{
					slotsWithCopies += 1;
					break;
				}
			}
		}

		return arrayWithCopies.length - slotsWithCopies;			
	}

	public static int[] removeCopies(int[] inputArray)
	{
		int[] noCopies = new int[howManyCopies(inputArray)];

		int slot = 0;
		boolean unique = true;

		for (int i = 0; i<inputArray.length;i++ ) 
		{
			unique=true;

			for (int j = i; j > 0; j--)
			{
				if (inputArray[i] == inputArray[j-1])
				{
					unique=false;
					break;
				}
			}
			
			if (unique == true)
			{
				noCopies[slot]=inputArray[i];
				slot += 1;
			}	
		}
		return noCopies;
	}

	// public static int[] bubbleSort(int[] a)
	// {
	// 	boolean keepScanning=true;
	// 	while(keepScanning==true)
	// 	{
	// 		keepScanning=false;

	// 		for (int i=0; i<a.length-1; i++ )
	// 		{
	// 			if (a[i]>a[i+1])
	// 			{
	// 				swap(a,i,i+1);
	// 				keepScanning=true;
	// 			}
	// 		}
	// 	}
	// 	return a;	
	// }

	public static void swap(String[] a, int b, int c)
	{
		String t = a[b];
		a[b] = a[c];
		a[c] = t;
	}
}

