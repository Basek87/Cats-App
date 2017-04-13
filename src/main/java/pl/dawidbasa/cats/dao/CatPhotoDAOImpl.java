package pl.dawidbasa.cats.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import pl.dawidbasa.cats.model.Cat;
import pl.dawidbasa.cats.model.CatPhoto;

@Repository
public class CatPhotoDAOImpl implements CatPhotoDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void save(CatPhoto catPhoto) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(catPhoto);
	}

	public void update(CatPhoto catPhoto) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(catPhoto);
	}

	public void deleteCatPhoto(long catPhotoId) {
		Session session = this.sessionFactory.getCurrentSession();
		CatPhoto catPhoto = (CatPhoto) session.load(CatPhoto.class, new Long(catPhotoId));
		catPhoto.getCat().getCatPhotos().clear();
		if (catPhoto != null) {
			session.delete(catPhoto);
		}
	}

	public void updateRating(CatPhoto catPhoto) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate("rate", catPhoto);
	}

	public CatPhoto getCatPhotoById(long id) {
		Session session = this.sessionFactory.openSession();
		CatPhoto catPhoto = (CatPhoto) session.createQuery("SELECT cp FROM CatPhoto cp WHERE cp.id=:id")
				.setParameter("id", id).getSingleResult();
		session.close();
		return catPhoto;
	}

	public List<CatPhoto> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<CatPhoto> catPhotos = session.createQuery("from CatPhoto", CatPhoto.class).getResultList();
		return catPhotos;
	}

	public List<CatPhoto> findAllByCatId(long catId) {
		Session session = this.sessionFactory.openSession();
		List<CatPhoto> catPhotosByCatId = session
				.createQuery("SELECT cp FROM CatPhoto cp JOIN FETCH cp.cat c WHERE c.id=:catId ", CatPhoto.class)
				.setParameter("catId", catId).getResultList();
		session.close();
		return catPhotosByCatId;
	}

	public List<CatPhoto> findAllByBestRate() {
		Session session = this.sessionFactory.openSession();
		List<CatPhoto> catPhotosByRate = session.createQuery("FROM CatPhoto cp ORDER BY cp.rate DESC", CatPhoto.class)
				.getResultList();
		session.close();
		return catPhotosByRate;
	}
}
