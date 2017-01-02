package csi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import csi.modelo.Professor;
import csi.util.ConectaPostGres;

public class ProfessorDAO {

	public Professor getProfessor(int id)throws Exception{
		Connection con = ConectaPostGres.conexao();
		String sql = "Select * from professor where id=?";
		PreparedStatement prt = con.prepareStatement(sql);
		prt.setInt(1, id);
		
		ResultSet rs =	prt.executeQuery();
		
		while(rs.next()){
			 					
			String nome = rs.getString("nome");																										
			String usuario = rs.getString("usuario");
			String senha = rs.getString("senha");

			Professor p = new Professor(nome,usuario, senha);
			p.setId(id);
			return p;
			
		}
		
		return null;
	}
	
}
