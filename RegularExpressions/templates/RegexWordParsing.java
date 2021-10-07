public class RegexWordParsing extends RegexHelper {
	public static void main(String[] args) {
		String text = RegexHelper.sample;
		String regex = "";

		regex = "s";
		console.println("Regex: " + regex);

		showMatches(text, regex);
		console.println();
	}
}
