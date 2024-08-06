package modelos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Posteo extends Publicacion {
	
	//ATRIBUTOS
	private String texto;
	private boolean publico;
	
	//CONSTRUCTOR
	public Posteo(int idPublicacion, LocalDate fechaPublicacion, LocalTime hora, Usuario creador, String texto,
			boolean publico) {
		super(idPublicacion, fechaPublicacion, hora, creador);
		this.texto = texto;
		this.publico = publico;
	}
	
	//GETTERS Y SETTERS
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}

	//EQUALS Y TO STRING
	public boolean equals(Posteo posteo) {
		// TODO Auto-generated method stub
		return (this.idPublicacion == posteo.getIdPublicacion() && this.fechaPublicacion.equals(posteo.getFechaPublicacion())
				&& this.hora.equals(posteo.getHora()) && this.creador.equals(posteo.getCreador()) && this.texto.equals(posteo.getTexto())
				&& this.publico == posteo.isPublico());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("\nDatos del Posteo ---> Id: %d --- Fecha: %s --- Hora: %s --- Texto: %s --- Publico: %s ---\n" + 
				"%s", this.idPublicacion, this.fechaPublicacion, this.hora, this.texto, this.publico, this.creador);
	}
	
	//METODO ABSTRACTO
	@Override
	public boolean contieneTexto(String buscar) {
		// TODO Auto-generated method stub
		return this.texto.contains(buscar);
	}
}
