package modelos;

//INCUIMOS LIBRERIAS DE LOCALDATE Y LOCALTIME
import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Publicacion {
	
	//ATRIBUTOS
	protected int idPublicacion;
	protected LocalDate fechaPublicacion;
	protected LocalTime hora;
	protected Usuario creador;
	
	//CONSTRUCTOR
	public Publicacion(int idPublicacion, LocalDate fechaPublicacion, LocalTime hora, Usuario creador) {
		super();
		this.idPublicacion = idPublicacion;
		this.fechaPublicacion = fechaPublicacion;
		this.hora = hora;
		this.creador = creador;
	}
	
	//GETTERS Y SETTERS
	public int getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(int idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	//EQUALS
	public boolean equals(Publicacion publi) {
		// TODO Auto-generated method stub
		return (this.idPublicacion == publi.getIdPublicacion() && this.fechaPublicacion.equals(publi.getFechaPublicacion()) 
				&& this.hora.equals(publi.getHora()) && this.creador.equals(publi.getCreador()));
	}
	
	//METODO ABSTRACTO
	abstract boolean contieneTexto (String buscar);
	
	
}
