import java.net.URISyntaxException;

public class EmailParserTest {

	// TODO

	public class SimpleTest {
		private EmailParser parser;
		private String email;
		private String local;
		private String domain;
		private String tld;

		public void setupTest(String email, String local, String domain, String tld) throws URISyntaxException {
			this.email = email;
			this.local = local;
			this.domain = domain;
			this.tld = tld;

			this.parser = new EmailParser(this.email);
		}

		// TODO
	}


//		@ValueSource(strings = {
//				"email@example.com",
//				"email@subdomain.example.com",
//				"first.last@example.org",
//				"first-last@example.net",
//				"first+last@example.net",
//				"1234567890@example.com",
//				"a@example.com",
//				"email@localhost"
//		})

//		@ValueSource(strings = {
//				"",
//				"hello",
//				"example.com",
//				"@example.com",
//				"example@",
//				"a@b@c",
//				"@"
//		})
}
