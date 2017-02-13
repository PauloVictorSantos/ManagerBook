package br.com.book.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.book.model.Livro;
import br.gov.book.utils.HibernateUtil;

public class LivroDaoImp implements LivroDao {
	public void save(Livro livro) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(livro);
		t.commit();
	}

	public Livro getLivro(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Livro) session.load(Livro.class, id);
	}
	public List<Livro> getEditora(Livro editora){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Livro where editora=:editora").setParameter("editora",editora.getEditora()).list();
		t.commit();
		return lista;
	}

	public List<Livro> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Livro").list();
		t.commit();
		return lista;
	}
	
	public List<String> listEditora(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("select distinct editora from Livro").list();
		t.commit();
		return lista;
	}

	public void remove(Livro livro) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(livro);
		t.commit();
	}

	public void update(Livro livro) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(livro);
		t.commit();
	}
}