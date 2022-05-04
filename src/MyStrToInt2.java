
public class MyStrToInt2 {
	
	
	protected int getNumber(char character) {
		
		char zero = '0';
		char nine = '9'; 
		
		if(character < zero || character > nine) {
			return -1;
		}
		
		return character - zero ;
		
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
		int tenPow = 1;

		for (int i = strInput.length() - 1; i > -1; --i) {

			int number = getNumber(strInput.charAt(i));

			if (number == -1) {
				continue;
			}

			output += number * tenPow;
			tenPow *= 10;
		}

		return output;
	}
	
	public static void main(String[] arg) {
		
		MyStrToInt2 inst = new MyStrToInt2();
		
		int testValue = inst.strToInt("a1b2cc3d45");
		System.out.println( testValue);
		
		testValue = inst.strToInt("abc12345");
		System.out.println( testValue);
		
		testValue = inst.strToInt("12345abc");
		System.out.println(testValue);
	}

}
