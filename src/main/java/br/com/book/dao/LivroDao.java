package br.com.book.dao;

import java.util.List;
import br.com.book.model.Livro;

public interface LivroDao {
	public void save(Livro livro);
	public Livro getLivro(long id);
	public List<Livro> list();
	public void remove(Livro livro);
	public void update(Livro livro);
	public List<Livro> getEditora(Livro livro);
}
