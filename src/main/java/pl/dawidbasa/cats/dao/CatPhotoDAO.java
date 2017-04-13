package pl.dawidbasa.cats.dao;

import java.util.List;

import pl.dawidbasa.cats.model.CatPhoto;

public interface CatPhotoDAO {

	void save(CatPhoto catPhoto);
	void update(CatPhoto catPhoto);
	void updateRating(CatPhoto catPhoto);
	public CatPhoto getCatPhotoById(long id);
	public List<CatPhoto> findAllByCatId(long catId);
	public List<CatPhoto> findAll();
	public List<CatPhoto> findAllByBestRate();
	void deleteCatPhoto(long catPhotoId);
}

