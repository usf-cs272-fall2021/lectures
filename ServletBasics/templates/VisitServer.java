import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VisitServer {
	public static final int PORT = 8080;
	public static Logger log = LogManager.getLogger();

	private static int visits = 0;

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);

		ServletHandler handler = new ServletHandler();
		handler.addServletWithMapping(VisitServlet.class, "/");

		server.setHandler(handler);
		server.start();

		log.info("Server: {} with {} threads", server.getState(), server.getThreadPool().getThreads());
		server.join();
	}

	public static class VisitServlet extends HttpServlet {
		private static final long serialVersionUID = 202140;
		private static final String TITLE = "Visits";

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
					<p>There have been %2$d visits to this page.</p>
					<p>This request was handled by thread %3$s.</p>
					</body>
					</html>
					""";

			// TODO
			System.out.println(TITLE);
			System.out.println(html);
			System.out.println(visits);

			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);
		}
	}
}
