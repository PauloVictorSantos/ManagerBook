package br.gov.book.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import br.com.book.dao.LivroDao;
import br.com.book.dao.LivroDaoImp;
import br.com.book.model.Livro;

@ManagedBean
@RequestScoped
public class LivroController {

	private Livro livro;
	private DataModel listaLivros;
	private List<String> editoras;
	
	public LivroController(){
		this.livro= new Livro();
	}
	
	
	public List<String> getEditoras() {
		return editoras;
	}

	public void setEditoras(List<String> editoras) {
		this.editoras = editoras;
	}

	public DataModel getListarLivros() {
		List<Livro> lista = new LivroDaoImp().list();
		listaLivros = new ListDataModel(lista);
		return listaLivros;
	}
	
	public DataModel getlivrosEdit(){ 
		List<Livro> lista= new  LivroDaoImp().getEditora(livro);
		listaLivros= new ListDataModel(lista);
		return  listaLivros;
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String prepararAdicionarLivro() {
		livro = new Livro();
		return "gerenciarLivro";
	}

	public String prepararAlterarLivro() {
		livro = (Livro) (listaLivros.getRowData());
		return "gerenciarLivro";
	}
	
	public String prepararListarEdit(){
		LivroDao dao = new LivroDaoImp();
		dao.getEditora(livro);
		return "view";
	}
	
	public String excluirLivro() {
		Livro livroTemp = (Livro) (listaLivros.getRowData());
		LivroDao dao = new LivroDaoImp();
		dao.remove(livroTemp);
		return "index";
	}
	
	public String adicionarLivro() {
		LivroDao dao = new LivroDaoImp();
		dao.save(livro);
		return "index";
	}

	public String alterarLivro() {
		LivroDao dao = new LivroDaoImp();
		dao.update(livro);
		return "index";
	}
	
	
	@PostConstruct
	public void init(){
		List<String> listaedit= new LivroDaoImp().listEditora();
		editoras=listaedit;
	}
}