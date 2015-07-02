package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.ConnectionFactory;

public class JDBCInsere {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
			Connection con = null;
		try{
			con = new ConnectionFactory().getConnection();

			String sql = "insert into contatos" +
					" (nome,email,endereco,dataNascimento)" +
					" values (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "Caelum");
			stmt.setString(2, "ingrund.ferrari@gmail.com");
			stmt.setString(3, "Prudente de Moraes, 857");
			stmt.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));

			stmt.execute();
			stmt.close();

			System.out.println("Gravado!");
		}catch(SQLException e){
			System.out.println(e);
		} finally {
			con.close();
		}

	}


}
