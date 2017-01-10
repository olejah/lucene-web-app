package controllers;
 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class IndexController { 
	private final static Logger logger = Logger.getLogger(IndexController.class);
 
	@RequestMapping(value = "/index", method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView getPage(@RequestParam(value="q", required = false) String param) {
		String url = "";
		System.out.println("input param = " + param);
//		String url = "http://google.com.ua";
		System.out.println("isUrl -> " + isValidUrl(param));
		if(isValidUrl(param)){
			url = param.trim().toLowerCase();
		}
		System.setProperty("file.log", "D:\\" + LocalDate.now().format(DateTimeFormatter.ISO_DATE) + ".log");
		System.out.println(System.getProperty("file.log"));
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	public boolean isValidUrl(String url){
		String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|.]*[-a-zA-Z0-9+&@#/%=~_|]";
		Pattern pattern = Pattern.compile(regex);
		if (url == null || url.isEmpty()){
			return false;
		}
		
		return Pattern.matches(regex, url.trim().toLowerCase());
	}
} 