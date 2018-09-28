package info.sjd;

import info.sjd.service.*;

public class AppRunner {

/**
 * WORK WITH STRINGS
Print the product of 2 numbers multiplication. 
Using no Logger.
Print with System.out.print(<your job>)

  1234
   123
  ____
  3702
 2468
1234
______    
151782 

 * */

	
	
/*MAIN****************************************************/	
	public static void main(String[] args) {
		//INITIAL VALUES
		int num1 = 1234;
		int num2 = 123;
		////////////////
		
		String result = Service.Task06Print(num1, num2);
		System.out.print(result);
		
	}

}
