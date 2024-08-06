package modelos;

//INCLUIMOS LIBRERIA DE LOCALDATE
import java.time.LocalDate;

public class Usuario {
	
	//ATRIBUTOS
	private int idUsuario;
	private String nombreUsuario;
	private LocalDate fechaAlta;
	
	//CONSTRUCTOR
	public Usuario(int idUsuario, String nombreUsuario, LocalDate fechaAlta) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.fechaAlta = fechaAlta;
	}
	
	//GETTERS Y SETTERS
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	//EQUALS
	public boolean equals(Usuario usuario) {
		// TODO Auto-generated method stub
		return (this.idUsuario == usuario.getIdUsuario() && this.nombreUsuario.equals(usuario.getNombreUsuario())
				&& this.fechaAlta.equals(usuario.getFechaAlta()));
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("\nDatos del Usuario ---> Id: %d --- Nombre: %s --- Fecha Alta: %s ---\n", 
				this.idUsuario, this.nombreUsuario, this.fechaAlta);
	}
}
