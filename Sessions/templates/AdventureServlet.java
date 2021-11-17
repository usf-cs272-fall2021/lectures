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
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdventureServlet extends HttpServlet {
	private static final long serialVersionUID = 202140;
	private static Logger log = LogManager.getLogger();
	private static final String TITLE = "Adventure!";
	private static final Path TEMPLATE_PATH = Path.of("src", "main", "resources", "adventure.html");

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> values = new HashMap<>();

		values.put("title", TITLE);
		values.put("url", request.getRequestURL().toString());
		values.put("path", request.getRequestURI());
		values.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		values.put("thread", Thread.currentThread().getName());

		HttpSession session = request.getSession(true);

		AdventureRoom room = null;
		Direction direction = null;

		try {
			// TODO
		}
		catch (Exception e) {
			log.debug(e);
		}

		// make sure values are valid
		if (room == null || direction == null) {
			log.info("Starting new game for session {}", session.getId());
			// TODO
		}
		else {
			// TODO
			AdventureRoom old = null;
			log.info("Session {} moved from {} to {}", session.getId(), old, room.ordinal());
		}

		values.put("room", Integer.toString(room.ordinal()));
		values.put("message", room.toString());
		values.put("direction", direction.name());

		// TODO
		values.put("action", "TODO");
		values.put("session", "TODO");

		// TODO

		if (room.done()) {
			log.info("Game finished for session {}", session.getId());
			// TODO

			values.put("west", "disabled");
			values.put("east", "disabled");
			values.put("north", "disabled");
			values.put("south", "disabled");
		}
		else {
			values.put("west", room.canMove(Direction.WEST) ? "" : "disabled");
			values.put("east", room.canMove(Direction.EAST) ? "" : "disabled");
			values.put("north", room.canMove(Direction.NORTH) ? "" : "disabled");
			values.put("south", room.canMove(Direction.SOUTH) ? "" : "disabled");
		}

		String template = Files.readString(TEMPLATE_PATH, StandardCharsets.UTF_8);
		StringSubstitutor replacer = new StringSubstitutor(values);
		String html = replacer.replace(template);

		PrintWriter writer = response.getWriter();
		writer.write(html);

		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.flushBuffer();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
