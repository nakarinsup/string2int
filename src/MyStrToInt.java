
/**
 * This class has function to convert from string that contains mix characters into integer<br>
 * 
 * The function always return positive integer, all minus sign in string would be discard.<br>
 *
 * @author nakarin_sup
 *
 */
public class MyStrToInt {

	/** with this char array, we can map with the corresponding index directly. */
	private final char[] charNumberList = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	/**
	 * map character to digit as integer
	 * 
	 * @param character
	 * @return digit number
	 */
	private int getNumber(char character) {

		for (int i = 0; i < charNumberList.length; ++i) {
			if (character == charNumberList[i]) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * a^b , implement myself instead of using Math.pow(a,b) from library
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	private double pow(int a, int b) {

		double result = 1;

		int powNumber = b > 0 ? b : -b;

		for (int i = 0; i < powNumber; ++i) {
			result *= a;
		}

		if (b < 0) {
			return 1 / result;
		}

		return result;
	}

	/**
	 * Convert String to integer, ignore any letter found, including minus sign<br>
	 * Thus, the function always return positive integer, all minus sign in string would be discard. 
	 * 
	 * @param strInput
	 * @return
	 */
	public int strToInt(String strInput) {

		int output = 0;

		for (int i = strInput.length() - 1, j = 0; i > -1; --i) {

			int number = getNumber(strInput.charAt(i));

			if (number == -1) {
				continue;
			}

			output += number * pow(10, j);
			++j;
		}

		return output;
	}

	

	public static void main(String[] args) {

		MyStrToInt inst = new MyStrToInt();

		int testValue = inst.strToInt("a1b2cc3d45");
		System.out.println( testValue);
		
		testValue = inst.strToInt("abc12345");
		System.out.println( testValue);
		
		testValue = inst.strToInt("12345abc");
		System.out.println(testValue);
	}

}
