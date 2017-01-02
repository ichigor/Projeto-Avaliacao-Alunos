package csi.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import csi.dao.AlunoDAO;
import csi.dao.AvaliacaoDAO;

public class Aluno extends Usuario{

	private int id;
	private String nome;
	private String matricula;
	private Calendar dataNasc;
	private Usuario usuario;
	private float media;
	private ArrayList<Avaliacao> avaliado;		
	 
	public ArrayList<Avaliacao> getAvaliado() {
		return avaliado;
	}

	public void setAvaliado(ArrayList<Avaliacao> avaliado) {
		this.avaliado = avaliado;
	}

	public Aluno(String nome, String m, Calendar d){
		this.nome = nome;
		this.matricula = m;
		this.dataNasc = d;		
	}
	
	public Aluno(String nome, String m, Calendar d, String usuario, String senha, float media){
		this.nome = nome;
		this.matricula = m;
		this.dataNasc = d;
		this.usuario = new Usuario(usuario, senha);		
		this.media = media;
	}
	
	
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public Aluno(){
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Calendar getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public float getMedia(){
		return media;					
	}
	 
	 
}
