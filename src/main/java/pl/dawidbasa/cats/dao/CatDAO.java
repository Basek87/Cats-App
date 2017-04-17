package pl.dawidbasa.cats.dao;

import java.util.List;

import pl.dawidbasa.cats.model.Cat;

public interface CatDAO {

	public void addCat(Cat cat);
	public void updateCat(Cat cat);
	public List<Cat> listCats();
	public Cat getCatById(long id);
	public void removeCat(long id);

}
