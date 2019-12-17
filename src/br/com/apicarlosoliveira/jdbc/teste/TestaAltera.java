package br.com.apicarlosoliveira.jdbc.teste;

import java.util.Calendar;

import br.com.apicarlosoliveira.jdbc.dao.ContatoDao;
import br.com.apicarlosoliveira.jdbc.modelo.Contato;

public class TestaAltera {

	public static void main(String[] args) {
		//Objeto contato
		Contato contato = new Contato();
		contato.setNome("Andre Campos");
		contato.setEmail("menezesoliveira40@hotmail.com");
		contato.setEndereco("Rua das Barramas, 135");
		contato.setDataNascimento(Calendar.getInstance());
		contato.setId((long) 1);
		
		//Abro a conexão com o DAO
		ContatoDao dao = new ContatoDao();
		
		//Adciona o contato
		dao.alterar(contato);
		
		System.out.println("Contato Alterado com Sucesso!!!!");

	}

}
