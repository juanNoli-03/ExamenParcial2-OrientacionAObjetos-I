package modelos;

public class Comentario {
	
	//ATRIBUTOS
	private int idComentario;
	private int identificacion;
	private Publicacion publicacion;
	private Usuario usuario;
	private String texto;
	
	//CONSTRUCTOR
	public Comentario(int idComentario, int identificacion, Publicacion publicacion, Usuario usuario, String texto) {
		super();
		this.idComentario = idComentario;
		this.identificacion = identificacion;
		this.publicacion = publicacion;
		this.usuario = usuario;
		this.texto = texto;
	}
	
	//GETTERS Y SETTERS
	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	//EQUALS Y TO STRING
	public boolean equals(Comentario comentario) {
		// TODO Auto-generated method stub
		return (this.idComentario == comentario.getIdComentario() && this.identificacion == comentario.getIdentificacion() 
				&& this.publicacion.equals(comentario.getPublicacion()) && this.usuario.equals(comentario.getUsuario())
				&& this.texto.equals(comentario.getTexto()));
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("\nDatos del comentario ---> Id: %d --- Identificacion: %d ---\n" + "%s" + "%s" + "\nTexto: %s\n", 
				this.idComentario, this.identificacion, this.publicacion, this.usuario, this.texto);
	}
	
	
	
	
	
	



}
