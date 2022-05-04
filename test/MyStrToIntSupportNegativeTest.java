import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for MyStrToIntSupportNegative class
 * 
 * @author nakarin_sup
 *
 */
public class MyStrToIntSupportNegativeTest {
	
	private MyStrToInt2 inst;
	
	@BeforeEach
	void setUp() throws Exception {
		inst = new MyStrToIntSupportNegative();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	//bonus effort 
	
	@Test
	void testStrToInt_negativeOneString() {
		assertEquals(-1, inst.strToInt("-1"));
	}
	
	@Test
	void testStrToInt_oddNumberOfMinusSign() {
		assertEquals(-1, inst.strToInt("---1"));
	}
	
	@Test
	void testStrToInt_oddNumberOfMinusSign2() {
		assertEquals(-1, inst.strToInt("-----1"));
	}
	
	@Test
	void testStrToInt_evenNumberOfMinusSign() {
		assertEquals(1, inst.strToInt("--1"));
	}
	
	@Test
	void testStrToInt_evenNumberOfMinusSign2() {
		assertEquals(1, inst.strToInt("----1"));
	}
	
	@Test
	void testStrToInt_letterBetweenMutipleMinusSign_expectNagative() {
		assertEquals(-1, inst.strToInt("---d-1"));
	}
	
	@Test
	void testStrToInt_letterBetweenMutipleMinusSign_expectNagative2() {
		assertEquals(-134, inst.strToInt("---d---1R3T4"));
	}
	
	@Test
	void testStrToInt_letterBetweenMutipleMinusSign_expectPositive() {
		assertEquals(1, inst.strToInt("---d--1EEEE"));
	}
	
	@Test
	void testStrToInt_letterBetweenMutipleMinusSign_expectPositive2() {
		assertEquals(123, inst.strToInt("---d----1E2X3"));
	}

	@Test
	void testStrToInt_letterBeforeMutipleMinusSign_expectPositive() {
		assertEquals(1, inst.strToInt("ddd----1"));
	}
	
	@Test
	void testStrToInt_letterBeforeMutipleMinusSign_expectNegative() {
		assertEquals(-1, inst.strToInt("ddd---1"));
	}
	
	
	@Test
	void testStrToInt_mixPlusAndMinusSign_expectNegative() {
		assertEquals(-1, inst.strToInt("ddd-+-++-1"));
	}
	
	@Test
	void testStrToInt_mixPlusAndMinusSign_expectPositive() {
		assertEquals(1, inst.strToInt("ddd+-++-1"));
	}
	
	
	@Test
	void testStrToInt_mixPlusAndMinusSignDigitInBetween() {
		assertEquals(-21, inst.strToInt("+-2++-1"));
	}
	
	@Test
	void testStrToInt_mixPlusAndMinusSignDigitInBetween2() {
		assertEquals(-21, inst.strToInt("+-2+-+-1"));
	}
	
	@Test
	void testStrToInt_mixPlusAndMinusSignDigitInBetween3() {
		assertEquals(-21, inst.strToInt("-+--2+-+-1"));
	}
	
	@Test
	void testStrToInt_mixPlusAndMinusSignDigitInBetween4() {
		assertEquals(21, inst.strToInt("-+-2+-+-1"));
	}
	
}
