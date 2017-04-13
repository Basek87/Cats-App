/*package pl.dawidbasa.cats.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.dawidbasa.cats.model.Cat;
import pl.dawidbasa.cats.services.CatService;


@Controller
public class CatController {

	
	@Autowired
	private CatService catService;

	public void setCatService(CatService catService) {
		this.catService = catService;
	}


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listCats(Model model) {
		List<Cat> listCats = catService.listCats();
		model.addAttribute("cat", new Cat());
		model.addAttribute("listCats", listCats);
		return "index";
		return "cat";
	}

	// @ModelAttribute bind the request parameters or form fields to an model
	// object

	@RequestMapping(value = "/addCat", method = RequestMethod.POST)
	public String addCat(@ModelAttribute("cat") Cat c) {

		if(c.getId() == 0){
			//new cat, add it
			this.catService.addCat(c);
		}else{
			//existing cat, call update
			this.catService.updateCat(c);
		}
		
		return "redirect:/";
	}

	// @PathVariable used for accessing the values from the URI template("id",
	// {id}).

	@RequestMapping(value = "/deleteCat/{id}")
	public String deleteCat(@PathVariable("id") long id) {
		this.catService.removeCat(id);
		return "redirect:/";
	}

	// @PathVariable used for accessing the values from the URI template("id",
	// {id}).
	@RequestMapping("/editCat/{id}")
	public String editCat(@PathVariable("id") long id, Model model) {
		model.addAttribute("cat", this.catService.getCatById(id));
		model.addAttribute("listCats", this.catService.listCats());
		return "index";
		return "cat";
	}

}*/