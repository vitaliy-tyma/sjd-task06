package info.sjd;

import java.util.Locale;

public class AppRunner {

/**
 * WORKING WITH STRINGS
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
	
	/** INITIAL VALUES FOR CONSTRUCTING THE OUTPUT.*/
	final static StringBuilder UNDERSCORE_SIGN = new StringBuilder("_");
	final static String SPACEBAR_SIGN = " ";
	
	
	/** Method for calculation of the output sequence.*/
	public static void Task06Print(int NUM1, int NUM2) {
		final int NUM_RES = NUM1*NUM2;
		
		
		final String NUM1_STRING = Integer.toString(NUM1);
		final String NUM2_STRING = Integer.toString(NUM2);
		final String NUM_RES_STRING = Integer.toString(NUM_RES);

		final int NUM2_LEN = NUM2_STRING.length();
		final int NUM_RES_LEN = NUM_RES_STRING.length();
		
		
		final int COLS_COUNT = NUM_RES_LEN;
		int shift = 0;	

		/*Printing rows one by one.*/
		//Print row 1 = NUM1
		PrintRow(NUM1_STRING, COLS_COUNT, shift); 
		
		//Print row 2 = NUM2
		PrintRow(NUM2_STRING, COLS_COUNT, shift); 
		
	
		
		//Check for boundary condition: if the divisor has 1 digit
		if (NUM2_LEN > 1) {
			//Print row 3 = ____
			PrintRow(GetUnderScore(NUM1_STRING).toString(), COLS_COUNT, 0);
			
			//Print rows 4, etc... Starting with shift=0.
			for ( ; shift < NUM2_LEN; shift++) {		  
				PrintRow(Integer.toString(
						NUM1*Character.digit(NUM2_STRING.charAt(NUM2_LEN-shift-1),10)),
						COLS_COUNT, shift);
			}
		}
		
		//Print row PreLAST = ______
		PrintRow(GetUnderScore(NUM_RES_STRING).toString(), COLS_COUNT, shift);

		//Print row LAST = NUM_RES
		PrintRow(NUM_RES_STRING, COLS_COUNT, shift); 	

		
	}
	
	
	
	
	/** From input string get StringBuilder of UNDERSORES with the same length.*/
	public static StringBuilder GetUnderScore(String NUM_STRING) {
		StringBuilder str = new StringBuilder("");
	
		for (int j = 0; j < NUM_STRING.length(); j++) {
			str.append(UNDERSCORE_SIGN);
		}
		return str;
	}
	
	
	
	
	/** Print to console some number of SPACEBARS and finish with NUM_STRING.*/
	public static void PrintRow(String NUM_STRING, int COLS_COUNT, int shift_left) {
		for (int i = shift_left; i < COLS_COUNT - NUM_STRING.length(); i++) {
			System.out.print(SPACEBAR_SIGN);
		}
		System.out.print(NUM_STRING+"\n");
	}
	
	
	
	
/*MAIN****************************************************/	
	public static void main(String[] args) {
		//INITIAL VALUES
		final int NUM1 = 1234;
		final int NUM2 = 123;
		//
		
		Task06Print(NUM1, NUM2);
	}

}
