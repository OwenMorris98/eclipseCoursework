
/*
 * COSC 310-001   Assignment 5
 * Prog5.java
 *
 * This class uses a recursive method to 
 * 
 * @author  Owen Morris
 */
import java.util.*;

public class Prog6 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Base number: ");
		int base = Integer.parseInt(in.nextLine());
		System.out.print("Exponent: ");
		int exp = Integer.parseInt(in.nextLine());

		int result = getPower(base, exp);
		System.out.print(base + "^" + exp + " is = " + result);
	}

	/*
	 * Recursive method that calculates the power of a number
	 * @return base
	 *
	 */
	public static int getPower(int base, int n) {
		if (n == 0)
			return 1;
		else {
			return (base * getPower(base, n - 1));
		}
	}
}