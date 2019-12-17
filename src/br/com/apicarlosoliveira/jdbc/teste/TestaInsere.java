package br.com.apicarlosoliveira.jdbc.teste;

import java.util.Calendar;

import br.com.apicarlosoliveira.jdbc.dao.ContatoDao;
import br.com.apicarlosoliveira.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		//Objeto contato
		Contato contato = new Contato();
		contato.setNome("Carlos Menezes de Oliveira");
		contato.setEmail("menezesoliveira40@hotmail.com");
		contato.setEndereco("Rua das Barramas, 135");
		contato.setDataNascimento(Calendar.getInstance());
		
		//Abro a conexão com o DAO
		ContatoDao dao = new ContatoDao();
		
		//Adciona o contato
		dao.adciona(contato);
		
		System.out.println("Contato Gravado com Sucesso!!!!");

	}

}
