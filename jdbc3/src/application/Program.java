package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		Connection conn= null; 
		PreparedStatement st= null;
		
		try {
			conn= DB.getConnection();// conectar ao banco de dados 
			
			
			st= conn.prepareStatement(
						"INSERT INTO seller "
						+"(Name, Email, BirthDate, BaseSalary, DepartmentId) "
						+"VALUES "
						+"(?, ?, ?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS);
			
			/* st vai informar onde sera alterado no banco de dados
			 * entre os parestes() esta comandos sql para fazer inserção de dados 
			 * "INSERT INTO seller ": inserir no tabela seller
			 * (Name, Email, BirthDate, BaseSalary, DepartmentId): campos que teram inserção na tabela
			 * O CAMPO ID TEM INSERÇÃO AUTOMATICAMENTE
			 * "VALUES"= vao receber os valores 
			 * "(?, ?, ?, ?, ?)"= valores. Cada ? significa um campo. Mas o ? significa que sera inserido depois
			 * Statement.RETURN_GENERATED_KEYS= seve para possibilar reucperar Id da nova inserção */
			
			//trocando os ? por valores
			st.setString(1, "Carl Purple"); //A primeira ? sera trocado por esse nome 
			st.setString(2, "carl@gmail.com");  //A segunda ? sera trocado por esse email
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime())); //A terceira ? sera trocado por esse BirthDate
			st.setDouble(4, 3000.0); //o quarto ? sera trocado por esse BaseSalary
			st.setInt(5, 4); //o quinto ? sera trocado por esse BaseSalary
			
			int rowsAffected= st.executeUpdate();
			/*st.executeUpdate()= serve para alteração no banco de daldos
			 * int rowsAffected= st.executeUpdate()= vai informa quanta linha foram alterada*/
			
			System.out.println("Done! Rows affected: "+ rowsAffected);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.claseConnection();
		}
		
	}

}
