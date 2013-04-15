/**
 * The method longToString(string) converts a provided string
 * into it's equivalent long value. The method uses base 10.
 * 
 * The method works for negative values, and values ending with
 * "L" (used to denote long value).
 * 
 * @author Karan Goel (karanmatic@gmail.com)
 *
 */

public class StringToLong {

	public static void main(String[] args) {
		long l = stringToLong("9223372036854775807");
		if (l == 9223372036854775807L) {
			System.out.println("Success...");
		} else {
			System.out.println("Failure");
		}
	}

	private static long stringToLong(String string) {
		int length = string.length();
		boolean neg = string.startsWith("-");
		boolean endsWithL = Character.toLowerCase(string.charAt(length - 1)) == 'l';
		
		int start = neg ? 1 : 0;
		int end = endsWithL ? length - 1 : length;
		
		long result = 0;
		
		for (int i = start; i < end; i++) {
			char c = string.charAt(i);
			result = result * 10 + Character.digit(c, 10);
		}
		
		return neg ? -result : result;
	}

}
