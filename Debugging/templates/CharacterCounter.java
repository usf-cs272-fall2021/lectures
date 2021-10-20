import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class CharacterCounter {
	private static int SIZE = 1000;

	public static int countCharacters(Path file) {
		int count = 0;
		int total = 0;

		char[] buffer = new char[SIZE];

		try (Reader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8);) {
			while (count >= 0) {
				count = reader.read(buffer);
				total += count;
			}
		}
		catch (IOException e) {

		}

		return total;
	}

	public static void main(String[] args) throws IOException {
		Path path1 = Path.of("src");
		Path path2 = Path.of("README.md");

		System.out.println(countCharacters(path1));
		System.out.println(countCharacters(path2));
		System.out.println(Files.size(path2));
	}
}
