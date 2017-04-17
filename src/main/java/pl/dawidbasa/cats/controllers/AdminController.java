package pl.dawidbasa.cats.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.dawidbasa.cats.model.Cat;
import pl.dawidbasa.cats.model.CatPhoto;
import pl.dawidbasa.cats.model.FileBucket;
import pl.dawidbasa.cats.services.CatPhotoService;
import pl.dawidbasa.cats.services.CatService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private CatService catService;

	@Autowired
	private CatPhotoService catPhotoService;

	public void setCatService(CatService catService) {
		this.catService = catService;
	}
	@RequestMapping(method = RequestMethod.GET)
	public String showAdminPage(Model model) {
		model.addAttribute("cat", new Cat());
		return "admin";
	}
	@RequestMapping(value = "/dbManagment", method = RequestMethod.GET)
	public String showDbManagmentPage(Model model) {
		model.addAttribute("cat", new Cat());
		List<Cat> listCats = catService.listCats();
		model.addAttribute("listCats", listCats);
		return "dbManagment";
	}
	@RequestMapping(value = "/dbManagment/addCat", method = RequestMethod.POST)
	public String addCat(@Valid @ModelAttribute("cat") Cat cat, BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<Cat> listCats = catService.listCats();
			model.addAttribute("listCats", listCats);
			return "dbManagment";
		}
		if (cat.getId() == 0) {
			// new cat, add it
			this.catService.addCat(cat);
		} else {
			// existing cat, call update
			this.catService.updateCat(cat);
		}
		return "redirect:/admin/dbManagment";
	}
	@RequestMapping(value = "/dbManagment/editCat/{id}")
	public String editCat(@PathVariable("id") long id, Model model) {
		model.addAttribute("cat", this.catService.getCatById(id));
		model.addAttribute("listCats", this.catService.listCats());
		return "dbManagment";
	}
	@RequestMapping(value = "/dbManagment/deleteCat/{id}")
	public String deleteCat(@PathVariable("id") long id) {
		this.catService.removeCat(id);
		return "redirect:/admin/dbManagment";
	}
	@RequestMapping(value = { "dbManagment/addPhoto/{catId}" }, method = RequestMethod.GET)
	public String addDocuments(@PathVariable long catId, ModelMap model, HttpServletResponse response) {

		Cat cat = catService.getCatById(catId);
		model.addAttribute("cat", cat);
		FileBucket fileModel = new FileBucket();
		model.addAttribute("fileBucket", fileModel);
		List<CatPhoto> catPhotos = catPhotoService.findAllByUserId(catId);
		model.addAttribute("catPhotos", catPhotos);
		return "Photo";
	}
	@RequestMapping(value = "dbManagment/addPhoto/{catId}", method = RequestMethod.POST)
	public String uploadCatPhoto(@PathVariable("catId") Long catId, FileBucket fileBucket, ModelMap model) {

		CatPhoto catPhoto = new CatPhoto();
		Cat cat = catService.getCatById(catId);
		model.addAttribute("cat", cat);
		try {
			catPhotoService.save(catPhoto, fileBucket, cat);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/admin/dbManagment/addPhoto/" + catId;
	}
	@RequestMapping(value = "dbManagment/addPhoto/{catId}/delete/{catPhotoId}")
	public String deleteCatPhoto(@PathVariable("catPhotoId") long catPhotoId, @PathVariable("catId") long catId) {
		this.catPhotoService.deleteCatPhoto(catPhotoId);
		return "redirect:/admin/dbManagment/addPhoto/" + catId;
	}
}
