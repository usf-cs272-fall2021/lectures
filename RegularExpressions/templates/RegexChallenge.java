public class RegexChallenge extends RegexHelper {
	public static void main(String[] args) {
		String text = null;
		String regex = null;

		console.println(text);
		console.println(regex);

		text = "hubbub";
		// printMatches(text, "h.*b");
		// printMatches(text, "h.*?b");
		// printMatches(text, "h.*bb*");
		// printMatches(text, "h.*bb+");
		// printMatches(text, "h.*bb?");
		// printMatches(text, "h.*?bb?");

		console.println();

		text = "ant ape bat bee bug cat cow dog";
		// printMatches(text, "\\w*a\\w*");
		// printMatches(text, "\\w+a\\w+");
		// printMatches(text, "\\w+t\\b");
		// printMatches(text, "\\w*[^e]e\\b");

		console.println();

		text = "dragonfly";
		regex = "(drag(on))(fly)";

		// TODO
	}
}
