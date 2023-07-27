package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	/* conectar com banco de dados jdbc
	 * é instancia um objeto do Connection 
	 */
	private static Connection conn= null;
	
	//carregar as infoçoes da db.properties
	private static Properties loadProperties() {
		try(FileInputStream fs= new FileInputStream("db.properties")){ //chando o arquivo db.properties
			Properties props= new Properties();
			props.load(fs); // ler o arquivo db.properties
			return props;
		}
		catch(IOException e) { // caso tenha erro de leitura ou sei la 
			throw new DbException(e.getMessage());
		}
	}
	
	
	//conetear com banco de dados
	public static Connection getConnection() {
		if(conn == null) {
			try {
			Properties props= loadProperties(); //metodo de cima, para pegar informaçoes
			String url= props.getProperty("dburl");
			conn= DriverManager.getConnection(url, props); // estabelecer conexão
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	//desconetar com banco de dados 
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	//desconetar o Statement
	public static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			}
			catch(SQLException e ) {
				throw new DbException(e.getMessage());
			}
		}
	}


	//desconetar o ResultSet
	public static void closeResultSet(ResultSet rs) {
		while(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
}
