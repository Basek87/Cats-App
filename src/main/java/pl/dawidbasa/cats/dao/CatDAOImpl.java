package pl.dawidbasa.cats.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import pl.dawidbasa.cats.model.Cat;

@Repository
public class CatDAOImpl implements CatDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	public void addCat(Cat cat) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(cat);
	}
	public void updateCat(Cat cat) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(cat);
	}
	public List<Cat> listCats() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Cat> listCats = session.createQuery("from Cat", Cat.class).getResultList();
		return listCats;
	}
	public Cat getCatById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cat catById = (Cat) session.createQuery("SELECT c FROM Cat c WHERE c.id=:id").setParameter("id", id)
				.getSingleResult();
		return catById;
	}
	public void removeCat(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cat c = (Cat) session.createQuery("SELECT c FROM Cat c WHERE c.id =" + id).getSingleResult();
		session.delete(c);
	}
}