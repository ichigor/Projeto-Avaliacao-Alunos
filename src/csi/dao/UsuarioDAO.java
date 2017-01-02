package csi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import csi.modelo.Aluno;
import csi.modelo.Professor;
import csi.modelo.Usuario;
import csi.util.ConectaPostGres;

public class UsuarioDAO {

	
	public static void main(String args[]){
		ConectaPostGres.conexao();
	}
	
	public Aluno autenticado(Usuario user)throws Exception{
		
 
			//pega conexao
			Connection con = ConectaPostGres.conexao();			
			//cria declaracao
			//Statement stmt = con.createStatement();		
			String sql ="select * from Aluno"
						+ " where usuario =? and "
						+ "senha = ?";
			PreparedStatement preStmt = con.prepareStatement(sql);
			preStmt.setString(1, user.getUser());
			preStmt.setString(2, user.getSenha());					
			System.out.println("SQL: "+sql);
			//executa sql
			ResultSet rs = preStmt.executeQuery();									
			/*if(rs.next()){
				return true;
			}*/			
			while(rs.next()){								 			
				System.out.println("ID: " +rs.getInt("id") );
				System.out.println("nome: " +rs.getString("nome") );
				System.out.println("senha: " +rs.getString("senha") );
				return new AlunoDAO().getAluno(rs.getInt("id"));
			}			
			//manipula resultado						
		 		
		return null;			
	}
	
	public Professor autenticadoP(Usuario user)throws Exception{
		
		 
		//pega conexao
		Connection con = ConectaPostGres.conexao();			
		//cria declaracao
		//Statement stmt = con.createStatement();		
		String sql ="select * from professor"
					+ " where usuario =? and "
					+ "senha = ?";
		PreparedStatement preStmt = con.prepareStatement(sql);
		preStmt.setString(1, user.getUser());
		preStmt.setString(2, user.getSenha());					
		System.out.println("SQL: "+sql);
		//executa sql
		ResultSet rs = preStmt.executeQuery();									
		/*if(rs.next()){
			return true;
		}*/			
		while(rs.next()){								 			
			System.out.println("ID: " +rs.getInt("id") );
			System.out.println("nome: " +rs.getString("nome") );
			System.out.println("senha: " +rs.getString("senha") );
			return new ProfessorDAO().getProfessor(rs.getInt("id"));
		}			
		//manipula resultado						
	 		
	return null;			
}
	
	
}
