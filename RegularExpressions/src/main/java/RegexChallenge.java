import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tests how well you combine different regex components.
 *
 * @see RegexHelper
 *
 * @author CS 272 Software Development (University of San Francisco)
 * @version Fall 2021
 */
public class RegexChallenge extends RegexHelper {
	/**
	 * Tests how well you combine different regex components.
	 *
	 * @param args unused
	 */
	public static void main(String[] args) {
		String text = null;
		String regex = null;

		text = "hubbub";
		printMatches(text, "h.*b");    // [hubbub]
		printMatches(text, "h.*?b");   // [hub]
		printMatches(text, "h.*bb*");  // [hubbub]
		printMatches(text, "h.*bb+");  // [hubb]
		printMatches(text, "h.*bb?");  // [hubbub]
		printMatches(text, "h.*?bb?"); // [hubb]

		console.println();

		text = "ant ape bat bee bug cat cow dog";
		printMatches(text, "\\w*a\\w*");    // [ant, ape, bat, cat]
		printMatches(text, "\\w+a\\w+");    // [bat, cat]
		printMatches(text, "\\w+t\\b");     // [ant, bat, cat]
		printMatches(text, "\\w*[^e]e\\b"); // [ape]

		console.println();

		text = "dragonfly";
		regex = "(drag(on))(fly)";

		console.println(regex);

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);

		if (m.matches()) {
			for (int i = 0; i <= m.groupCount(); i++) {
				console.println(i + ": " + m.group(i));
			}
		}

		// 0: dragonfly
		// 1: dragon
		// 2: on
		// 3: fly
	}

}
