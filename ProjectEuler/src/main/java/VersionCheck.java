/**
 * Designed to catch older Java installations by using new Java features.
 *
 * @author CS 272 Software Development (University of San Francisco)
 * @version Fall 2021
 */
public class VersionCheck {

	/**
	 * A simple Person record. Feature available from Java 16+.
	 *
	 * Javadoc warning bug already reported at:
	 * <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=572367">
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=572367</a>
	 *
	 * @param name the name of the person
	 */
	record Person(String name) { }

	/**
	 * Method called on run.
	 *
	 * @param args unused
	 */
	public static void main(String[] args) {
		// Switch Expressions, available from Java 14+.
		String name = switch (args.length) {
			case 0:
				yield "anonymous";
			default:
				yield args[1];
		};

		System.out.println("Hello, " + name + "!");

		// Multi-line String, available from Java 15+.
		String hello = """

				Hello,
				World!
				""";

		System.out.println(hello);

		// Record types, available from Java 16+.
		Person person = new Person(name);

		System.out.println("Hello, " + person.name() + "!");
	}
}
