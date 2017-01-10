package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeRootController {

	@RequestMapping("/")
	public ModelAndView getPage() {
		System.out.println("in root controller");
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
}
