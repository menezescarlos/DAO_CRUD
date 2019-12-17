package br.com.apicarlosoliveira.jdbc.teste;

import java.util.List;

import br.com.apicarlosoliveira.jdbc.dao.ContatoDao;
import br.com.apicarlosoliveira.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		
		List<Contato> contatos = dao.getLista();
		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data de Nascimento: " + contato.getDataNascimento().getTime() + "\n");
			System.out.println();
			
		}

	}

}
