package br.com.apicarlosoliveira.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.apicarlosoliveira.jdbc.ConnectionFactory;
import br.com.apicarlosoliveira.jdbc.modelo.Contato;

public class ContatoDao {
	//Estabelecendo uma conexão com o Banco de Dados
	private Connection connection;
	
	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adciona(Contato contato) {
		String sql = "insert into contatos" + 
				"(nome, email, endereco, dataNascimento)" +
				"values (?,?,?,?)";
		
		try {
			//Preparando o Objeto statement para inserir os dados no BD
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			//Momento em que settamos os valores
			stmt.setString(1,contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3,contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			
			//execução
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getLista(){
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement(
					"select * from contatos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				//Criando o objeto Contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				//Formatando a Data atravez do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				//adcionando o objeto a lista
				contatos.add(contato);
			}
			
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void alterar(Contato contato){
		String sql = "update contatos set nome=?, email=?, endereco=?," +
				"dataNascimento=? where id=?";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1,contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3,contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5,contato.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Contato contato){
		try {
			PreparedStatement stmt = this.connection.prepareStatement("delete from contatos where id=?");
			stmt.setLong(1,contato.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
