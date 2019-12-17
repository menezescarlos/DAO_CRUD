package br.com.apicarlosoliveira.jdbc.teste;

import java.util.Calendar;

import br.com.apicarlosoliveira.jdbc.dao.ContatoDao;
import br.com.apicarlosoliveira.jdbc.modelo.Contato;

public class TestaRemove {

	public static void main(String[] args) {
		//Objeto contato
		Contato contato = new Contato();
		contato.setId((long) 1);
		
		//Abro a conexão com o DAO
		ContatoDao dao = new ContatoDao();
		
		//Adciona o contato
		dao.remove(contato);
		
		System.out.println("Contato Removido com Sucesso!!!!");


	}

}
