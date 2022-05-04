//BONUS this enhancement may beyond the scope of the challenge ^^".

/**  
 * This class handles the possibility of negative value, 
 * such as "-200", "abc-200", "abc-200-defg", would be converted as -200 int value
 * while,  "--200", "abc----200, is 200 (even number of adjacent minus signs before number)
 * "---200",  "-----200" == -200	(odd number of adjacent minus signs before number)
 * "-abc-200" == -200  (only consider adjacent minus sign before number)
 * "-+-200" == 200,  the plus sign is discard and the minus sign is concat --200 == 200
 * 
 * @author nakarin_sup
 * 
 */
public class MyStrToIntSupportNegative extends MyStrToInt2 {

	/**
	 * if the minus sign is a character before the first digit, then consider as follows : <br>
	 * - if one minus sign is found, return true <br>
	 * - if multiply minus signs appear adjacently, count the minus sign and return true if count is odd <br>
	 * <p>
	 * example: <br>
	 * "-245" return true  <br>
	 * "-d245" return false //there is a letter between minus sign and number, discard the sign, return false  <br>
	 * "d-245" return true <br>
	 * "d--245" return false //--245 can be consider as -(-245) = 245  <br>
	 * "-d-245" return true //two minus sign are not adjacent each other, discard the early minus sign found <br>
	 * "d-+-+-245--d" return true as ---245 = -245 <br> 
	 * "d2-+-+-45--d"	return true as 245, as the function return at the first digit found and no minus sign before 2
	 * 
	 * @param strInput
	 * @return
	 */
	private boolean scanForNegative(String strInput) {

		int countAdjacentMinus = 0;

		boolean firstTime = true;

		for (int i = 1; i < strInput.length(); ++i) { // yes, i intend to start with index 1, not 0

			if (strInput.charAt(i - 1) == '-' || strInput.charAt(i - 1) == '+') {

				if (firstTime && strInput.charAt(i - 1) == '-' ) {
					++countAdjacentMinus;
					firstTime = false;
				}

				char charNextMinus = strInput.charAt(i);

				if (isNumber(charNextMinus)) {
					return !(countAdjacentMinus % 2 == 0);
				} else if (charNextMinus == '-') {
					++countAdjacentMinus;					
					if(firstTime == true) {
						firstTime = false;
					}
				} else if (charNextMinus == '+') {
					continue; // plus sign mean nothing here
				} else {
					//found letter or another special character
					
					// reset the counter and firstTime met with minus sign flag
					countAdjacentMinus = 0;
					firstTime = true;
				}
			}
		}

		return false;
	}

	private boolean isNumber(char character) {
		if (getNumber(character) > -1) {
			return true;
		}

		return false;
	}

	/**
	 * This variance also support negative value by checking if minus sign adjacent to digit. 
	 * Multiple minus sign found also multiply each other to check if the value actually negative.
	 */
	@Override
	public int strToInt(String strInput) {
		int output = super.strToInt(strInput);

		if (scanForNegative(strInput)) {
			output *= -1;
		}

		return output;
	}

}
