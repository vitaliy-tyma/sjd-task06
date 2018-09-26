package info.sjd;

public class AppRunner {
/**
 * РАБОТА СО СТРОКАМИ
Имея два числа вывести их умножение в столбик. Только в этом задании не используем Logger.
Выводим через System.out.print(<ваша реализация>)

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
	
	
	/** Method for calculating of the output sequence.*/
	public static void Task06Print(int NUM1, int NUM2) {
		final int NUM_RES = NUM1*NUM2;
		
		
		final String NUM1_STRING = Integer.toString(NUM1);
		final String NUM2_STRING = Integer.toString(NUM2);
		final String NUM_RES_STRING = Integer.toString(NUM_RES);

		final int NUM2_LEN = NUM2_STRING.length();
		final int NUM_RES_LEN = NUM_RES_STRING.length();
		
		
		final int COLS_COUNT = NUM_RES_LEN;
		

		/*Printing rows one by one.*/
		PrintRow(NUM1_STRING, COLS_COUNT, 0); //Print row 1 = NUM1
		PrintRow(NUM2_STRING, COLS_COUNT, 0); //Print row 2 = NUM2
		
											  //Print row 3 = ____
		PrintRow(GetUnderScore(NUM1_STRING).toString(), COLS_COUNT, 0);
		
		
		int k = 0;
		for ( ; k < NUM2_LEN; k++) {		  //Print rows 4, etc...
			PrintRow(Integer.toString(
					NUM1*Character.digit(NUM2_STRING.charAt(NUM2_LEN-k-1),10)),
					COLS_COUNT, k);
		}
		
											  //Print row PreLAST = ______
		PrintRow(GetUnderScore(NUM_RES_STRING).toString(), COLS_COUNT, k);
		
		PrintRow(NUM_RES_STRING, COLS_COUNT, k); //Print row LAST = NUM_RES	

		
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
