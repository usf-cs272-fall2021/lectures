import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.text.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ReverseServer {
	public static final int PORT = 8080;
	public static Logger log = LogManager.getLogger();

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);

		ServletHandler handler = new ServletHandler();
		handler.addServletWithMapping(ReverseServlet.class, ""); // TODO

		server.setHandler(handler);
		server.start();

		log.info("Server: {} with {} threads", server.getState(), server.getThreadPool().getThreads());
		server.join();
	}

	public static class ReverseServlet extends HttpServlet {
		private static final long serialVersionUID = 202140;
		private static final String TITLE = "Reverse";

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			log.info("{} handling request: {}", Thread.currentThread().getName(), request.getRequestURI());

			String html = """
					<!DOCTYPE html>
					<html lang="en">

					<head>
					  <meta charset="utf-8">
					  <title>%1$s</title>
					</head>

					<body>
					<h1>%1$s</h1>

					<form method="TODO" action="TODO">
					  <p>
					    <input type="text" name="TODO" size="50"></input>
					  </p>

					  <p>
					    <button>Reverse</button>
					  </p>
					</form>

					<pre>
					%2$s
					</pre>

					</body>
					</html>
					""";

			String reversed = ""; // TODO
			log.info("{}", reversed);

			if (reversed == null || reversed.isBlank()) {
				reversed = "";
			}
			else {
				reversed = new StringBuilder(reversed).reverse().toString();
				reversed = StringEscapeUtils.escapeHtml4(reversed);
			}

			PrintWriter out = response.getWriter();
			out.printf(html, TITLE, reversed, Thread.currentThread().getName());

			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);
		}
	}
}
