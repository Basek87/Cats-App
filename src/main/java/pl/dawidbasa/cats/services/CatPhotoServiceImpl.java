package pl.dawidbasa.cats.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import pl.dawidbasa.cats.dao.CatPhotoDAO;
import pl.dawidbasa.cats.model.Cat;
import pl.dawidbasa.cats.model.CatPhoto;
import pl.dawidbasa.cats.model.FileBucket;


@Service
public class CatPhotoServiceImpl implements CatPhotoService {

	private CatPhotoDAO catPhotoDAO;
	
	public void setCatPhotoDAO(CatPhotoDAO catPhotoDAO) {
		this.catPhotoDAO = catPhotoDAO;
	}

	@Transactional
	public void save(CatPhoto catPhoto, FileBucket fileBucket, Cat cat) throws IOException {
		MultipartFile multipartFile = fileBucket.getFile();
		catPhoto.setName(multipartFile.getOriginalFilename());
		catPhoto.setDescription(fileBucket.getDescription());
		catPhoto.setType(multipartFile.getContentType());
		catPhoto.setContent(multipartFile.getBytes());
		catPhoto.setCat(cat);
		this.catPhotoDAO.save(catPhoto);
	}

	@Transactional
	public void deleteCatPhoto(long catPhotoId) {
		this.catPhotoDAO.deleteCatPhoto(catPhotoId);
	}
	
	@Transactional
	public CatPhoto getCatPhotoById(long id) {
		return this.catPhotoDAO.getCatPhotoById(id);
	}

	@Transactional
	public List<CatPhoto> findAllByUserId(long catId) {
		return this.catPhotoDAO.findAllByCatId(catId);
	}

	@Transactional
	public List<CatPhoto> findAll() {
		return this.catPhotoDAO.findAll();
	}

	@Transactional
	public void update(CatPhoto catPhoto) {
		this.catPhotoDAO.update(catPhoto);
	}

	@Transactional
	public void updateRating(double rate, long id) {
		CatPhoto catPhoto = this.catPhotoDAO.getCatPhotoById(id);
		double newRate = catPhoto.getRate() + rate;
		int numberOfRates = catPhoto.getNumberOfRates() + 1;
		catPhoto.setRate(newRate);
		catPhoto.setNumberOfRates(numberOfRates);
		catPhoto.setAverageRate(newRate / numberOfRates);
		this.catPhotoDAO.updateRating(catPhoto);
	}

	@Transactional
	public List<CatPhoto> findAllByBestRate() {
		return this.catPhotoDAO.findAllByBestRate();
	}

}
