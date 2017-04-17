package pl.dawidbasa.cats.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.dawidbasa.cats.model.CatPhoto;
import pl.dawidbasa.cats.services.CatPhotoService;

@Controller
public class TopTenController {

	@Resource(name = "catPhotoService")
	private CatPhotoService catPhotoService;

	@RequestMapping(method = RequestMethod.GET, value = "/top10" )
	public String showTop10Page(Model model) throws IOException {
		model.addAttribute("catPhoto", new CatPhoto());
		model.addAttribute("catPhotos", this.catPhotoService.findAllByBestRate());
		return "/topTen";
	}
	@RequestMapping(value = "**/loadImage/{id}" )
	public void getUserImage(HttpServletResponse response, @PathVariable("id") long id) throws IOException {
		response.setContentType("image/jpeg");
		byte[] buffer = catPhotoService.getCatPhotoById(id).getContent();
		InputStream in1 = new ByteArrayInputStream(buffer);
		IOUtils.copy(in1, response.getOutputStream());
		in1.close();
	}
	@RequestMapping(value = "/top10/update" )
	public String editPhoto(@PathVariable("id") long id, Model model) {
		model.addAttribute("catPhoto", this.catPhotoService.getCatPhotoById(id));
		return "/topTen";
	}
	@RequestMapping(value = "/top10/update", method = RequestMethod.POST )
	public String addCat(@ModelAttribute("catPhoto") CatPhoto catPhoto, @RequestParam("rate") double rate, 
			@RequestParam("id") long id) { 
		this.catPhotoService.updateRating(rate, id);
		return "redirect:/top10";
	}
}
