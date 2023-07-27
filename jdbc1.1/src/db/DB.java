package db;


import java.sql.Connection; // presta atenção nessa parte 
import java.sql.DriverManager;// presta atenção nessa parte 
import java.sql.SQLException;

public class DB {
	
	public static Connection conn= null;
	
	private static String  url="jdbc:mysql://localhost:3306/coursejdbc";
	private static String  user="developer";
	private static String  password="batman.007";
	
	//conectar com banco de dados
	public static Connection getConnection() {
		if(conn == null) {
			try {
				conn= DriverManager.getConnection(url, user, password);
				System.out.println("Conectado ao banco de dados!");
				
			}
			catch(SQLException e) {
				System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
			}
		}
		return conn;
	}
	
	//desconectar com banco de dados 
	public static void claseConnection() {
		if(conn != null) {
			try {
				conn.close();
				 System.out.println("Desconectado do banco de dados!");
			}
			catch(SQLException e) {
				System.out.println("Erro ao desconectar do banco de dados: " + e.getMessage());
			}
		}
	}
	
}
