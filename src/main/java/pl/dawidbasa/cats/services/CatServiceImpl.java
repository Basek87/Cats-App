package pl.dawidbasa.cats.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.dawidbasa.cats.dao.CatDAO;
import pl.dawidbasa.cats.model.Cat;

@Service
public class CatServiceImpl implements CatService {

	private CatDAO catDAO;

	public void setCatDAO(CatDAO catDAO) {
		this.catDAO = catDAO;
	}

	@Transactional
	public void addCat(Cat cat) {
		this.catDAO.addCat(cat);
	}

	@Transactional
	public void updateCat(Cat cat) {
		this.catDAO.updateCat(cat);
	}

	@Transactional
	public List<Cat> listCats() {
		return this.catDAO.listCats();
	}

	@Transactional
	public Cat getCatById(long id) {
		return this.catDAO.getCatById(id);
	}

	@Transactional
	public void removeCat(long id) {
		this.catDAO.removeCat(id);
	}

}
