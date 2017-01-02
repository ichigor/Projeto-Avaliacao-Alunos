package csi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import csi.modelo.Aluno;
import csi.modelo.Avaliacao;
import csi.util.ConectaPostGres;

public class AlunoDAO {

	// create
	public boolean inserir(Aluno a){
		
		String sql = "insert into Aluno (nome, matricula, datanasc, usuario, senha) "
				+ "values(?,?,?,?,?)";
		try{
		
			PreparedStatement pre = 
					ConectaPostGres.conexao().prepareStatement(sql);
			pre.setString(1, a.getNome());
			pre.setString(2, a.getMatricula());
			pre.setDate(3, new Date( a.getDataNasc().getTimeInMillis()) );
			pre.setString(4, a.getUsuario().getUser());
			pre.setString(5, a.getUsuario().getSenha());
			pre.execute();
			
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}							
	}
	
	public Aluno getAluno(int id)throws Exception{
		Connection con = ConectaPostGres.conexao();
		String sql = "Select * from aluno where id=?";
		PreparedStatement prt = con.prepareStatement(sql);
		prt.setInt(1, id);
		
		ResultSet rs =	prt.executeQuery();
		
		while(rs.next()){
			 					
			String nome = rs.getString("nome");							
			String matricula = rs.getString("matricula");								
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("datanasc"));								
			String usuario = rs.getString("usuario");
			String senha = rs.getString("senha");
			float media = new AvaliacaoDAO().media(id);
			 
			//montar obj aluno
			Aluno a = new Aluno(nome, matricula, data, usuario, senha, media);
			a.setId(id);
			ArrayList<Avaliacao> avaliacao = new AvaliacaoDAO().getAvaliacoes(a);
			a.setAvaliado(avaliacao);
			return a;
			
		}
		
		return null;
	}
	
	//read
	public Aluno getAluno(String nome)throws Exception{
		
		
		return null;
		
	}
	//read all alunos
	public ArrayList<Aluno> getAlunos(){
		// vai fazer um select * from aluno
		ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
		
		Connection con = ConectaPostGres.conexao();
		String sql = "Select * from Aluno";
		
		
		
		try {
			
			
			PreparedStatement preStmt = con.prepareStatement(sql);			
			ResultSet rs =	preStmt.executeQuery();
			
			while(rs.next()){

				
				int id = rs.getInt("id");						
				String nome = rs.getString("nome");							
				String matricula = rs.getString("matricula");								
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datanasc"));								
				String usuario = rs.getString("usuario");
				String senha = rs.getString("senha");
				float media = new AvaliacaoDAO().media(id);
				
				//montar obj aluno
				Aluno a = new Aluno(nome, matricula, data, usuario, senha, media);				
				a.setId(id);
				ArrayList<Avaliacao> avaliacao = new AvaliacaoDAO().getAvaliacoes(a);
				a.setAvaliado(avaliacao);
				listaAlunos.add(a);				
			}
								
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return listaAlunos;
	}
	
	
	//update
	public boolean atualizar(Aluno a) throws Exception{
		Connection c = ConectaPostGres.conexao();
		String sql = "UPDATE aluno"
				+ " set nome=?, matricula=?, datanasc=?, usuario=?, senha=?"
				+ " where id=? ";
				
		
		PreparedStatement pre = c.prepareStatement(sql);
		pre.setString(1, a.getNome());
		pre.setString(2, a.getMatricula());
		pre.setDate(3, new Date( a.getDataNasc().getTimeInMillis()) );
		pre.setString(4, a.getUsuario().getUser());
		pre.setString(5, a.getUsuario().getSenha());
		pre.setInt(6, a.getId());
		pre.execute();
				
		return true;
	}
	
	//delete
	public boolean deletar(Aluno a) throws Exception{
		
		Connection c = ConectaPostGres.conexao();
		String sql = "DELETE FROM aluno where id=?";
		
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setInt(1, a.getId());
		pst.execute();
		return true;
	}
	
	
	public ArrayList<Aluno> getAlunosNaoAvaliados(){
		
		ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
		Connection con = ConectaPostGres.conexao();
		String sql = "select id from aluno where id not in (select idalunoavaliado from avaliacao)";

		try {
			PreparedStatement preStmt = con.prepareStatement(sql);			
			ResultSet rs =	preStmt.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("id");						
				Aluno a = getAluno(id);
				
//				ArrayList<Avaliacao> avaliacao = new AvaliacaoDAO().getAvaliacoes(a);
//				a.setAvaliado(avaliacao);
				listaAlunos.add(a);				
			}
								
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return listaAlunos;
	}
	
}
