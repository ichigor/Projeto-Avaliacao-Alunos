package csi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.org.apache.regexp.internal.recompile;

public class ConectaPostGres {
	private static Connection c;
	
	public static Connection conexao(){
		
		if(c != null){
			return c;
		}else{
			try {
				
				Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql://localhost:5432/votacaodb";
				String user = "postgres";
				String senha = "1234";
				
				c = DriverManager.getConnection(url, user, senha);			
				return c;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(SQLException e){
				
				e.printStackTrace();
			}		
			System.out.println("... conexao realizada ... ");
		}
		
		
		return null;
		
	}
	
}
