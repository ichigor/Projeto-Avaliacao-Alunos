package csi.util;

import java.util.ArrayList;

import csi.dao.AlunoDAO;
import csi.dao.AvaliacaoDAO;
import csi.modelo.Aluno;

public class Teste {

	public static void main(String args[]){
		ArrayList<Aluno> lista = new AlunoDAO().getAlunos();
		
		for(Aluno a: lista){
			System.out.println("Id: "+a.getId()+" nome: "+a.getNome());
		}
		
		//AvaliacaoDAO avDao = new AvaliacaoDAO();
		//Aluno a = new Aluno();
		//a.setId(7);
		//System.out.println("média: "+avDao.media(7));
		
	}
	
}
