package modelos;

import java.time.LocalDate;
import java.time.LocalTime;

public class AvisoGeneral extends Publicacion {
	
	//ATRIBUTOS
	private String titulo;
	private String cuerpo;
	
	//CONSTRUCTOR
	public AvisoGeneral(int idPublicacion, LocalDate fechaPublicacion, LocalTime hora, Usuario creador, String titulo,
			String cuerpo) {
		super(idPublicacion, fechaPublicacion, hora, creador);
		this.titulo = titulo;
		this.cuerpo = cuerpo;
	}
	
	//GETTERS Y SETTERS
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	//EQUALS Y TO STRING
	public boolean equals(AvisoGeneral aviso) {
		// TODO Auto-generated method stub
		return (this.idPublicacion == aviso.getIdPublicacion() && this.fechaPublicacion.equals(aviso.getFechaPublicacion())
				&& this.hora.equals(aviso.getHora()) && this.creador.equals(aviso.getCreador()) && this.titulo.equals(aviso.getTitulo())
				&& this.cuerpo.equals(aviso.getCuerpo()));
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("\nDatos del Aviso General ---> Id: %d --- Fecha: %s --- Hora: %s --- Titulo: %s --- Cuerpo: %s ---\n" + 
		"%s", this.idPublicacion, this.fechaPublicacion, this.hora, this.titulo, this.cuerpo, this.creador);
	}
	
	//METODO ABSTRACTO
	@Override
	public boolean contieneTexto(String buscar) {
		// TODO Auto-generated method stub
		return this.titulo.contains(buscar) || this.cuerpo.contains(buscar);
	}
	
	
}
