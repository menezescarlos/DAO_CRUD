package br.com.apicarlosoliveira.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

		public Connection getConnection() {
			try {
				return DriverManager.getConnection(
						"jdbc:mysql://localhost/conexaojdbc", "root", "xxxxxx00000000"
						);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
}
