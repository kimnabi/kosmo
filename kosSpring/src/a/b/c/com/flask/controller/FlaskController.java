package a.b.c.com.flask.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FlaskController {
	Logger logger = LogManager.getLogger(FlaskController.class);

	@RequestMapping(value="flask_test", method = RequestMethod.GET)
	public String  flask_test(Model m) {
		

		String url = "http://127.0.0.1:5000/tospring";
		String sb = "";
		
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

			String line = null;

			while ((line = br.readLine()) != null) {
				sb = sb + line + "\n";
			}

			logger.info("========br======" + sb.toString());
			if (sb.toString().contains("ok")) {
				logger.info("test");				
			}
			br.close();

			logger.info("" + sb.toString());
		} catch (Exception e) {			
			logger.info("error >>> : " + e.getMessage());
		}

		m.addAttribute("test1", sb.toString()); // 
		m.addAttribute("fail", false);

		return "flask/jsp_flask";
	}
	
	@RequestMapping(value="flask_search", method = RequestMethod.GET)
	public String  flask_ajax(Model m) {
		
		return "flask/flask_search";
	}
	@RequestMapping(value="flask_7", method = RequestMethod.GET)
	public String  flask_ajax_7(Model m) {
		
		return "flask/flask07_1";
	}
	@RequestMapping(value="weather", method = RequestMethod.GET)
	public String  flask_weather(Model m) {
		
		return "kos_weather/weather";
	}
}

