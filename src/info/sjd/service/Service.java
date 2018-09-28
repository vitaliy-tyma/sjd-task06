package info.sjd.service;

public class Service {
	
	/** INITIAL VALUES FOR CONSTRUCTING THE OUTPUT.*/
	static StringBuilder UNDERSCORE_SIGN = new StringBuilder("_");
	static String SPACEBAR_SIGN = " ";
	
	
	/** Method for calculation of the output sequence.*/
	public static String Task06Print(int num1, int num2) {
		int num_res = num1*num2;
		StringBuilder result = new StringBuilder();
		
		
		String num1_string = Integer.toString(num1);
		String num2_string = Integer.toString(num2);
		String num_res_string = Integer.toString(num_res);

		int num2_len = num2_string.length();
		int num_res_len = num_res_string.length();
		
		
		int cols_count = num_res_len;
		int shift = 0;	

		/** Printing rows one by one.*/
		/** Print row 1 = num1*/
		result.append(PrintRow(num1_string, cols_count, shift)); 
		
		/** Print row 2 = num2*/
		result.append(PrintRow(num2_string, cols_count, shift)); 
		
	
		
		/** Check for boundary condition: if the divisor has 1 digit.*/
		if (num2_len > 1) {
			/** Print row 3 = ____*/
			result.append(PrintRow(GetUnderScore(num1_string).toString(), cols_count, 0));
			
			/** Print rows 4, etc... Starting with shift=0.*/
			for ( ; shift < num2_len; shift++) {		  
				result.append(PrintRow(
						Integer.toString(num1*
						Character.digit(num2_string.charAt(num2_len-shift-1),10)),
						cols_count,
						shift));
			}
		}
		
		/** Print row PreLAST = ______*/
		result.append(PrintRow(GetUnderScore(num_res_string).toString(), cols_count, shift));

		/** Print row LAST = num_res*/
		result.append(PrintRow(num_res_string, cols_count, shift)); 	

		return result.toString();
	}
	
	
	
	
	/** From input string get String of UNDERSORES with the same length.*/
	public static String GetUnderScore(String num_string) {
		StringBuilder str = new StringBuilder("");
	
		for (int j = 0; j < num_string.length(); j++) {
			str.append(UNDERSCORE_SIGN);
		}
		return str.toString();
	}
	
	
	
	
	/** Append some number of SPACEBARS and finish with NUM_STRING.*/
	public static String PrintRow(String num_string, int cols_count, int shift_left) {
		StringBuilder result = new StringBuilder();
		
		for (int i = shift_left; i < cols_count - num_string.length(); i++) {
			result.append(SPACEBAR_SIGN);
		}
		result.append(num_string+"\n");
		return result.toString();
	}
	
	
}
