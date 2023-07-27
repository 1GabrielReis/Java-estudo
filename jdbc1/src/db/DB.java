package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection; // presta atenção nessa parte 
import java.sql.DriverManager;// presta atenção nessa parte 
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	
	
	public static Connection conn= null;
	
	//conectar com banco de dados
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Properties props= loadProperties();
				String url= props.getProperty("dburl"); //dburl esta no arquivo db.properties
				conn= DriverManager.getConnection(url, props);
				/* Conectar com banco jdbc  
				 * é igual instancia um objeto do tipo Connection
				 */
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	//desconectar com banco de dados 
	public static void claseConnection() {
		if(conn != null) {
			try {
				conn.close();
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	//Propriedades para o banco de dados
	private static Properties loadProperties() {
		try(FileInputStream fs= new FileInputStream("db.properties")){
			Properties props= new Properties();
			props.load(fs);
			return props;
		}
		catch(IOException e) {
			throw new DbException(e.getMessage());
		}
	}
}
