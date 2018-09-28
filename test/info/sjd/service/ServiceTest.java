package info.sjd.service;

import static org.junit.jupiter.api.Assertions.*;




import org.junit.jupiter.api.Test;

import info.sjd.service.Service;

class ServiceTest {


	

	
	
	@Test
	void testGetUnderScore() {
		String getUnderScore = Service.GetUnderScore("12345");
		String underscored5 = new String("_____");
		assertEquals( underscored5, getUnderScore);
		
		assertEquals( "_____", Service.GetUnderScore("12345"));
		assertEquals( "_", Service.GetUnderScore("1"));
	}



	
	@Test
	void testPrintRow() {
		
	    assertEquals("  1234\n", Service.PrintRow("1234", 6, 0));
	    assertEquals(" 1234\n", Service.PrintRow("1234", 6, 1));
	    assertEquals("1234\n", Service.PrintRow("1234", 6, 2));
	}
	
	@Test
	void testTask06Print() {
		
	    assertEquals(
	    		"  1234\n" + 
	    		"   123\n" + 
	    		"  ____\n" + 
	    		"  3702\n" + 
	    		" 2468\n" + 
	    		"1234\n" + 
	    		"______\n" + 
	    		"151782\n",
	    		Service.Task06Print(1234, 123));
	    
	    assertEquals(
	    		"1234\n" + 
	    		"   1\n" + 
	    		"____\n" + 
	    		"1234\n", 
	    		Service.Task06Print(1234, 1));
	}
	

	

}
