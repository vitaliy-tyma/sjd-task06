package info.sjd;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;




class AppRunnerTest<outContent> {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
	
	
	@Test
	void testGetUnderScore() {
//		AppRunner ar = new AppRunner();
		StringBuilder getUnderScore = AppRunner.GetUnderScore("12345");
		StringBuilder underscored5 = new StringBuilder("_____");
		assertEquals( underscored5, getUnderScore);
	}



	
	@Test
	void testPrintRow() {
//		AppRunner ar = new AppRunner();
		AppRunner.PrintRow("1234", 6, 0);
	    assertEquals("  1234", outContent.toString());
	}
	
	
	
	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}

}
