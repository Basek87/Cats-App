package pl.dawidbasa.cats.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String welcomeHandler() {
		return "index";
	}

	@RequestMapping(value = "/index")
	public String showHomePage() {

		return "index";
	}

	@RequestMapping(value = "/aboutCats")
	public String showAboutCatsPage() {

		return "aboutCats";
	}

	@RequestMapping(value = "/aboutProject")
	public String showAboutProjectPage() {

		return "aboutProject";
	}

}
