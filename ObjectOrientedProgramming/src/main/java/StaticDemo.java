/**
 * Briefly demonstrates the affect the "static" keyword has on
 * members/variables.
 *
 * @author CS 272 Software Development (University of San Francisco)
 * @version Fall 2021
 */
public class StaticDemo {
	/** Example instance member; belongs to a specific object/instance. */
	private int a;

	/** Example static/class member; shared by all objects/instances */
	private static int b;

	/**
	 * Demonstrates the affect of the "static" keyword.
	 *
	 * @param args unused
	 */
	@SuppressWarnings("static-access") // (Don't do this!)
	public static void main(String[] args) {
		/*
		 * Lets create a StaticDemo object. Remember, a class is like a blueprint. An
		 * object is a specific element, such as a specific house, built from that
		 * blueprint.
		 */

		StaticDemo d1 = new StaticDemo();
		d1.a = 0;
		d1.b = 1;

		System.out.println("d1.a = " + d1.a + ", d1.b = " + d1.b);

		/*
		 * Ignore for the moment that we did not properly initialize our members.
		 */

		StaticDemo d2 = new StaticDemo();
		d2.a = 2;
		d2.b = 3;

		System.out.println("d2.a = " + d2.a + ", d2.b = " + d2.b);
		System.out.println();

		/*
		 * Suppose we create another StaticDemo object. The INSTANCE member (non-static)
		 * is specific to an object, so "d2" will have its own value for "a". However,
		 * CLASS members are shared by all objects (and exist even when there are no
		 * active objects), so "d2" will share the value of "b" with "d1".
		 */

		System.out.println("after initializing d2...");
		System.out.println("d1.a = " + d1.a + ", d1.b = " + d1.b);
		System.out.println();

		/*
		 * Note that I had to suppress warnings in this file. DON'T DO THIS! Since b is
		 * static, we should really be accessing it as below. It makes it more clear
		 * that we are dealing with a class-wide element instead of a per-instance
		 * element.
		 */

		StaticDemo.b = 4;

		System.out.println("after modifying b...");
		System.out.println("d1.a = " + d1.a + ", d1.b = " + d1.b);
		System.out.println("d2.a = " + d2.a + ", d2.b = " + d2.b);
	}
}
