import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.text.StringSubstitutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieVisitServlet extends HttpServlet {
	private static final long serialVersionUID = 202140;
	private static final Logger log = LogManager.getLogger();
	private static final String TITLE = "Cookies!";

	private static final String COOKIES_OK = "Cookies";
	private static final String VISIT_DATE = "Visited";
	private static final String VISIT_COUNT = "Count";

	private static final String DATE_FORMAT = "hh:mm a 'on' EEEE, MMMM dd yyyy";
	private static final Path TEMPLATE_PATH = Path.of("src", "main", "resources", "cookie_visits.html");

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("GET " + request.getRequestURL().toString());

		if (request.getRequestURI().endsWith("favicon.ico")) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		Map<String, String> values = new HashMap<>();

		values.put("title", TITLE);
		values.put("url", request.getRequestURL().toString());
		values.put("path", request.getRequestURI());
		values.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		values.put("thread", Thread.currentThread().getName());

		// TODO
		values.put("method", "TODO");
		values.put("action", "TODO");

		values.put("visit_count", "<em>unknown</em>");
		values.put("visit_date", "<em>unknown</em>");
		values.put("enable_on", "");
		values.put("disable_on", "");

		Map<String, Cookie> cookies = getCookieMap(request);

		// TODO

		if (cookies.containsKey(COOKIES_OK)) {
			// TODO
		}
		else {
			log.info("Cookies are disabled.");
			values.put("disable_on", "disabled");
		}

		String template = Files.readString(TEMPLATE_PATH, StandardCharsets.UTF_8);
		StringSubstitutor replacer = new StringSubstitutor(values);

		PrintWriter out = response.getWriter();
		out.write(replacer.replace(template));

		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.flushBuffer();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("POST " + request.getRequestURL().toString());

		if (request.getParameter("ok_cookies") != null) {
			log.info("Saving cookie approval...");
			// TODO
		}

		if (request.getParameter("no_cookies") != null) {
			log.info("Clearing cookies...");
			clearCookies(request, response);
		}

		response.sendRedirect(request.getRequestURI());
	}

	public static Map<String, Cookie> getCookieMap(HttpServletRequest request) {
		HashMap<String, Cookie> map = new HashMap<>();
		// TODO
		return map;
	}

	public static void clearCookies(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				// TODO
			}
		}
	}
}
