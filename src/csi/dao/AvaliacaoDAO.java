package csi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import csi.modelo.Aluno;
import csi.modelo.Avaliacao;
import csi.util.ConectaPostGres;

public class AvaliacaoDAO {

	
	public boolean fezAvalizacao(Aluno avaliador, Avaliacao av){
		//codigo para inserir em fezAvalicao
		System.out.println("vai inserir em FezAvalicao");
		
		
		String sql = "insert into fezAvaliacao (idAlunoAvaliado, idAlunoAvaliador) "
				+ "values(?,?)";
		try{
		
			PreparedStatement pre = 
					ConectaPostGres.conexao().prepareStatement(sql);
			pre.setInt(1, avaliador.getId());
			pre.setInt(2, av.getAlunoAvaliado().getId());					
			pre.execute();
			
			
			inserir(av);
			return true;		
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}							
	}
		
		
		
		
	
	
	private boolean inserir(Avaliacao av){
		String sql = "insert into avaliacao (idAlunoAvaliado, comentario, nota) "
				+ "values(?,?,?)";
		
		//insert into avaliacao (idAlunoAvaliado, comentario, nota) 
		//values (1,'mas q lindeza',30.5);
		
		try{
		
			PreparedStatement pre = 
					ConectaPostGres.conexao().prepareStatement(sql);
			pre.setInt(1, av.getAlunoAvaliado().getId());
			pre.setString(2, av.getComentario());					
			pre.setFloat(3, av.getNota());
			pre.execute();
									
			return true;		
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	
	}
	
	public float media(int id){
		
		float media = 0;
		Connection c = ConectaPostGres.conexao();
		String sql = "SELECT AVG(nota) FROM avaliacao where idalunoavaliado = ?";
		
		try {
						
			PreparedStatement preStmt = c.prepareStatement(sql);		
			preStmt.setInt(1, id);
			ResultSet rs =	preStmt.executeQuery();
			
			while(rs.next()){
				  media = rs.getFloat(1);
				return media;
			}
								
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return media;		
	}
	
	public ArrayList<Avaliacao> getAvaliacoes(Aluno a){
		// vai fazer um select * from aluno
				ArrayList<Avaliacao> avaliacao = new ArrayList<Avaliacao>();
				
				Connection con = ConectaPostGres.conexao();
				String sql = "select * from avaliacao where idalunoavaliado = ?";							
				
				try {
									
					PreparedStatement preStmt = con.prepareStatement(sql);
					preStmt.setInt(1, a.getId());
					ResultSet rs =	preStmt.executeQuery();
					
					while(rs.next()){
						
						int id = rs.getInt("id");
						int idAluno = rs.getInt("idalunoavaliado");
						String comentario = rs.getString("comentario");
						float nota = rs.getFloat("nota");
							System.out.println("notas ... "+nota);							 
						//montar obj da lista
						Avaliacao av = new Avaliacao(a, comentario, nota);
						 
						avaliacao.add(av);				
					}
										
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
				return avaliacao;
	}
	
}
