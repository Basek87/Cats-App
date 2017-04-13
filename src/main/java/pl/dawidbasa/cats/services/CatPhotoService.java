package pl.dawidbasa.cats.services;

import java.io.IOException;
import java.util.List;

import pl.dawidbasa.cats.model.Cat;
import pl.dawidbasa.cats.model.CatPhoto;
import pl.dawidbasa.cats.model.FileBucket;

public interface CatPhotoService {

	public void save(CatPhoto catPhoto, FileBucket fileBucket, Cat cat) throws IOException;
	void update(CatPhoto catPhoto);
	void updateRating(double rate, long id);
	void deleteCatPhoto(long catPhotoId);
	public CatPhoto getCatPhotoById(long id);
	public List<CatPhoto> findAllByUserId(long id);
	public List<CatPhoto> findAll();
	public List<CatPhoto> findAllByBestRate();
	
}
