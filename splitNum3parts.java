class GfG 
{ 

	// Function to print the two parts 
	static void threeParts(long  number) 
	{ 
		long a = number % 10000;
        long b = ( number / 10000) % 10000;
        long c = ( number / 10000)/10000;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
	} 

	// Driver code 
	public static void main(String []args) 
	{ 
		long  number = 133;
        long  numberb =14115415;
		twoParts(number); 
        twoParts(numberb); 
	} 
} 
