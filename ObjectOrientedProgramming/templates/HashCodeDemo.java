import java.util.ArrayList;
import java.util.Arrays;

public class HashCodeDemo {
	@SuppressWarnings("removal")
	public static void main(String[] args) {
		Integer a = new Integer(0);

		printHash("OUTER BEG", a);
//		testInteger(a);
//		printHash("OUTER END", a);

		System.out.println();
	}

	public static void testInteger(Integer value) {
		printHash("INNER BEG", value);
		// TODO Fill in modification
		printHash("INNER END", value);
	}

	public static void testString(String value) {
		printHash("INNER BEG", value);
		// TODO Fill in modification
		printHash("INNER END", value);
	}

	public static void testBuilder(StringBuilder value) {
		printHash("INNER BEG", value);
		// TODO Fill in modification
		printHash("INNER END", value);
	}

	public static void testArray(String[] value) {
		printHash("INNER BEG", value);
		// TODO Fill in modification
		printHash("INNER END", value);
	}

	public static void testList(ArrayList<String> value) {
		printHash("INNER BEG", value);
		// TODO Fill in modification
		printHash("INNER BEG", value);
	}

	public static void printHash(String label, Object object) {
		Object[] args = { label, System.identityHashCode(object), object };
		System.out.format("%-9s : x%08X : %s %n", args);
	}

	public static void printHash(String label, Object[] object) {
		Object[] args = { label, System.identityHashCode(object), Arrays.toString(object) };
		System.out.format("%-9s : x%08X : %s %n", args);
	}
}
