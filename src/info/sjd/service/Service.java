package info.sjd.service;

public class Service {
	
	/** INITIAL VALUES FOR CONSTRUCTING THE OUTPUT.*/
	static StringBuilder UNDERSCORE_SIGN = new StringBuilder("_");
	static String SPACEBAR_SIGN = " ";
	
	
	/** Method for calculation of the output sequence.*/
	public static String Task06Print(int num1, int num2) {
		int NUM_RES = num1*num2;
		StringBuilder result = new StringBuilder();
		
		
		String NUM1_STRING = Integer.toString(num1);
		String NUM2_STRING = Integer.toString(num2);
		String NUM_RES_STRING = Integer.toString(NUM_RES);

		int NUM2_LEN = NUM2_STRING.length();
		int NUM_RES_LEN = NUM_RES_STRING.length();
		
		
		int COLS_COUNT = NUM_RES_LEN;
		int shift = 0;	

		/** Printing rows one by one.*/
		/** Print row 1 = NUM1*/
		result.append(PrintRow(NUM1_STRING, COLS_COUNT, shift)); 
		
		/** Print row 2 = NUM2*/
		result.append(PrintRow(NUM2_STRING, COLS_COUNT, shift)); 
		
	
		
		/** Check for boundary condition: if the divisor has 1 digit*/
		if (NUM2_LEN > 1) {
			/** Print row 3 = ____*/
			result.append(PrintRow(GetUnderScore(NUM1_STRING).toString(), COLS_COUNT, 0));
			
			/** Print rows 4, etc... Starting with shift=0.*/
			for ( ; shift < NUM2_LEN; shift++) {		  
				result.append(PrintRow(Integer.toString(
						num1*Character.digit(NUM2_STRING.charAt(NUM2_LEN-shift-1),10)),
						COLS_COUNT, shift));
			}
		}
		
		/** Print row PreLAST = ______*/
		result.append(PrintRow(GetUnderScore(NUM_RES_STRING).toString(), COLS_COUNT, shift));

		/** Print row LAST = NUM_RES*/
		result.append(PrintRow(NUM_RES_STRING, COLS_COUNT, shift)); 	

		return result.toString();
	}
	
	
	
	
	/** From input string get StringBuilder of UNDERSORES with the same length.*/
	public static String GetUnderScore(String NUM_STRING) {
		StringBuilder str = new StringBuilder("");
	
		for (int j = 0; j < NUM_STRING.length(); j++) {
			str.append(UNDERSCORE_SIGN);
		}
		return str.toString();
	}
	
	
	
	
	/** Print to console some number of SPACEBARS and finish with NUM_STRING.*/
	public static String PrintRow(String NUM_STRING, int COLS_COUNT, int shift_left) {
		StringBuilder result = new StringBuilder();
		
		for (int i = shift_left; i < COLS_COUNT - NUM_STRING.length(); i++) {
			result.append(SPACEBAR_SIGN);
		}
		result.append(NUM_STRING+"\n");
		return result.toString();
	}
	
	
}
