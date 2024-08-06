package modelos;

//IMPORTAMOS LIBRERIAS DE LISTAS
import java.util.List;
import java.util.ArrayList;

//IMPORTAMOS LIBRERIAS DE LOCALDATE Y LOCALTIME
import java.time.LocalDate;
import java.time.LocalTime;

public class Sistema {
	
	//ATRIBUTOS
	private List <Usuario> lstUsuarios;
	private List <Publicacion> lstPublicaciones;
	private List <Comentario> lstComentarios;
	
	//CONSTRUCTOR
	public Sistema() {
		super();
		this.lstUsuarios = new ArrayList <Usuario> ();
		this.lstPublicaciones = new ArrayList <Publicacion> ();
		this.lstComentarios = new ArrayList <Comentario> ();
	}
	
	//GETTERS Y SETTERS
	public List<Usuario> getLstUsuarios() {
		return lstUsuarios;
	}
	
	public void setLstUsuarios(List<Usuario> lstUsuarios) {
		this.lstUsuarios = lstUsuarios;
	}

	public List<Publicacion> getLstPublicaciones() {
		return lstPublicaciones;
	}

	public void setLstPublicaciones(List<Publicacion> lstPublicaciones) {
		this.lstPublicaciones = lstPublicaciones;
	}

	public List<Comentario> getLstComentarios() {
		return lstComentarios;
	}

	public void setLstComentarios(List<Comentario> lstComentarios) {
		this.lstComentarios = lstComentarios;
	}
	
	//TO STRING
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("\n---DATOS DEL SISTEMA---\n" + "\n---LISTA DE USUARIOS---\n" + this.lstUsuarios + 
				"\n---LISTA DE PUBLICACIONES---\n" + this.lstPublicaciones + "\n---LISTA DE COMENTARIOS---\n" + this.lstComentarios
				+ "\n---------------------------------------------\n");
	}
	
	//METODOS PROPIOS
	//--------------------------------------------------------------------
	
	//1- METODOS DE USUARIOS
	//--------------------------------------------------------------------
	public Usuario traerUsuario (String nombreUsuario) {
		
		Usuario usuario = null;
		
		int i = 0;
		
		while (i < this.lstUsuarios.size() && usuario == null) {
			
			if (nombreUsuario.equals(this.lstUsuarios.get(i).getNombreUsuario())) {
				
				usuario = this.lstUsuarios.get(i);
			}
			
			i ++;
		}
		
		return usuario;
	}
	
	public boolean agregarUsuario (String nombreUsuario, LocalDate fechaAlta) throws Exception {
		
		//EXCEPCION
		if (traerUsuario (nombreUsuario) != null) {
			
			throw new Exception ("\nError! El usuario que deseas agregar ya existe en tu lista.");
		}
		//---------------------------------
		
		Usuario usuario = new Usuario (generarIdUsuario (), nombreUsuario, fechaAlta);
		
		return this.lstUsuarios.add(usuario);
	}
	
	private int generarIdUsuario () {
		
		int id = 1;
		
		if (this.lstUsuarios.size () > 0) {
		  
			id = this.lstUsuarios.get(this.lstUsuarios.size () - 1).getIdUsuario() + 1;
		}
	
		return id;
	}
	//--------------------------------------------------------------------
	
	//2- METODOS DE PUBLICACION
	//--------------------------------------------------------------------
	public Publicacion traerPublicacion (String nombreUsuario, LocalDate fecha, LocalTime hora) {
		
		Publicacion publicacion = null;
			
		int i = 0;
			
		while (i < this.lstPublicaciones.size() && publicacion == null) {
			
			if (nombreUsuario.equals(this.lstPublicaciones.get(i).getCreador().getNombreUsuario()) && 
					fecha.equals(this.lstPublicaciones.get(i).getFechaPublicacion()) && hora.equals(this.lstPublicaciones.get(i).getHora())) {
				
				publicacion = this.lstPublicaciones.get(i);
			}
			
			i ++;
		}
			
		return publicacion;
	}
		
	public boolean agregarPosteo (LocalDate fecha, LocalTime hora, Usuario creador, String texto, boolean publico) throws Exception {
			
		//EXCEPCION
		if (traerPublicacion (creador.getNombreUsuario(), fecha, hora) != null) {
				
			throw new Exception ("\nError! La publicacion que deseas agregar ya existe en tu lista.");
		}
		//---------------------------------
			
		Posteo posteo = new Posteo (generarIdPublicacion (), fecha, hora, creador, texto, publico);
			
		return this.lstPublicaciones.add(posteo);
	}
	
	public boolean agregarAvisoGeneral (LocalDate fecha, LocalTime hora, Usuario creador, String titulo, String cuerpo) throws Exception {
		
		//EXCEPCION
		if (traerPublicacion (creador.getNombreUsuario(), fecha, hora) != null) {
				
			throw new Exception ("\nError! La publicacion que deseas agregar ya existe en tu lista.");
		}
		//---------------------------------
			
		AvisoGeneral aviso = new AvisoGeneral (generarIdPublicacion (), fecha, hora, creador, titulo, cuerpo);
			
		return this.lstPublicaciones.add(aviso);
	}
	
	public List <Publicacion> traerPublicacionesPublicas (LocalDate fechaDesde, LocalDate fechaHasta) {
		
		List <Publicacion> lstAux = new ArrayList <Publicacion> ();
		
		for (Publicacion publicacion : this.lstPublicaciones) {
			
			if (publicacion instanceof Posteo) {
				
				Posteo posteo = (Posteo) publicacion;
				
				if (posteo.isPublico() == true && Funciones.fechaEntre(posteo.getFechaPublicacion(), fechaDesde, fechaHasta)) {
					
					lstAux.add(posteo);
				}
			
			} else {
				
				AvisoGeneral aviso = (AvisoGeneral) publicacion;
				
				if (Funciones.fechaEntre(aviso.getFechaPublicacion(), fechaDesde, fechaHasta)) {
					
					lstAux.add(aviso);
				}
			}
		}
		
		return lstAux;
	}
		
	private int generarIdPublicacion () {
			
		int id = 1;
			
		if (this.lstPublicaciones.size () > 0) {
			  
			id = this.lstPublicaciones.get(this.lstPublicaciones.size () - 1).getIdPublicacion() + 1;
		}
		
		return id;
	}
	
	public List <Publicacion> traerPublicacionesQueContenganTexto (String texto) {
		
		List <Publicacion> lstAux = new ArrayList <Publicacion> ();
		
		for (Publicacion publicacion : this.lstPublicaciones) {
			
			if (publicacion instanceof Posteo) {
				
				if (((Posteo) publicacion).contieneTexto(texto)) {
					
					lstAux.add(publicacion);
				}
			
			} else {
				
				if (((AvisoGeneral) publicacion).contieneTexto(texto)) {
					
					lstAux.add(publicacion);
				}
			}
		}
		
		return lstAux;
	}
	//--------------------------------------------------------------------
	
	//3- METODOS DE COMENTARIO
	//--------------------------------------------------------------------
	public boolean agregarComentario (int identificacion, Publicacion publicacion, Usuario usuario, String texto) {
		
		Comentario comentario = new Comentario (generarIdComentario (), identificacion, publicacion, usuario, texto);
		
		return this.lstComentarios.add(comentario);
		
	}
	
	
	public List <Comentario> traerComentariosEnPosteoPorUsuario (Usuario usuario) {
		
		List <Comentario> lstAux = new ArrayList <Comentario> ();
		
		for (Comentario comentario : this.lstComentarios) {
			
			if (usuario.equals(comentario.getUsuario()) && comentario.getPublicacion() instanceof Posteo) {
				
				lstAux.add(comentario);
			}
		}
		
		return lstAux;
	}
	
	private int generarIdComentario () {
		
		int id = 1;
		
		if (this.lstComentarios.size() > 0) {
			
			id = this.lstComentarios.get(this.lstComentarios.size() - 1).getIdComentario() + 1;
		}
		
		return id;
	}
	//--------------------------------------------------------------------

	
	
	//--------------------------------------------------------------------

	
	
	
	
}
