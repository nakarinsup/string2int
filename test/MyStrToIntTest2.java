import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for MyStrToIntTest class
 * 
 * @author nakarin_sup
 *
 */
class MyStrToIntTest2 {

	private MyStrToInt2 inst;
	
	@BeforeEach
	void setUp() throws Exception {
		inst = new MyStrToInt2();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testStrToInt_pureDigits() {
		assertEquals(6587421, inst.strToInt("6587421"));	
	}
	
	@Test
	void testStrToInt_pureLetters() {
		assertEquals(0, inst.strToInt("asdilfuoewr"));	
	}
	
	@Test
	void testStrToInt_pureSpecialChars() {
		assertEquals(0, inst.strToInt("@#!$%^&*()_+"));	
	}
	
	@Test
	void testStrToInt_mixSpecialCharsAndDigits() {
		assertEquals(6587421, inst.strToInt("!@!@6\\/|}[p]#$%5^&8#$74%$#2!@1"));
	}
	
	@Test
	void testStrToInt_mixLettersAndSpecialCharsAndDigits() {
		assertEquals(6587421, inst.strToInt("6ee5a8ttt74%$#2!@1"));
	}
	
	
	@Test
	void testStrToInt_mixString_startWithLetter_endWithLetter() {
		assertEquals(6587421, inst.strToInt("Ee6ppe5#$%wq8xcx7ere421eredf"));
	}
	
	@Test
	void testStrToInt_mixString_startWithDigit_endWithLetter() {
		assertEquals(6587421, inst.strToInt("6ppe5eREwq8xcx7e#$421eredf"));
	}
	
	@Test
	void testStrToInt_mixString_startWithLetter_endWithDigit() {
		assertEquals(6587421, inst.strToInt("ee6ppe5eREWq8x*(7ere421"));
	}
	
	@Test
	void testStrToInt_mixString_startWithDigit_endWithDigit() {
		assertEquals(6587421, inst.strToInt("6pp$%5eREWq8xcx7ere42REEW1"));
	}
	
	@Test
	void testStrToInt_mixString_startWithSpecialChar_endWithSpecialChar() {
		assertEquals(6587421, inst.strToInt("#$#6pp$%5eREWq8xcx7ere42REEW1**"));
	}
		
	
	@Test
	void testStrToInt_mixString_startWithNotDigit_endWithDigit() {
		assertEquals(6587421, inst.strToInt("ONETWOTREE#$#6587421"));
	}
	
	@Test
	void testStrToInt_mixString_startDigit_endWithNotDigit() {
		assertEquals(6587421, inst.strToInt("6587421*FOUR*FIVE"));
	}

}
