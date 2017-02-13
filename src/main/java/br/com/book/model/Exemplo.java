package br.com.book.model;

import java.util.ArrayList;
import java.util.List;

import br.com.book.dao.LivroDaoImp;

public class Exemplo {

	public static void main(String[] args) {
		LivroDaoImp l = new LivroDaoImp();
		Livro livro=new Livro();
		livro.setEditora("1212");
		List<String> list = new ArrayList();
		list =  l.listEditora();
		for (String a : list) {
			System.out.println(a);
		}
	}

}
