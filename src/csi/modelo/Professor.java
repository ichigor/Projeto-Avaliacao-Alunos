package csi.modelo;



public class Professor {

	private int id;
	private String nome;
	private Usuario usuario;
	
	
	public Professor(String nome, String usuario, String senha){
		this.nome = nome;
		this.usuario = new Usuario(usuario, senha);
	}

	
	public Professor(){
		
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


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
