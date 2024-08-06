package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelos.Sistema;

public class TestParcial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("\n---SEGUNDO PARCIAL ORIENTACION A OBJETOS (Juan Manuel Noli - 45233126)---\n");
		
		//0- CRAEAMOS AL SISTEMA Y LO INICIALIZAMOS
		//--------------------------------------------------------
		Sistema sistema = new Sistema ();
		//--------------------------------------------------------
		
		//1- AGREGAMOS USUARIOS E IMPRIMIMOS LA LISTA
		//--------------------------------------------------------
		System.out.println("\n---AGREGAMOS USUARIOS E IMPRIMIMOS LA LISTA (1)---");
		
		try {
			System.out.println("\nUsuario agregado de forma exitosa?: " + sistema.agregarUsuario("usuarioCreador1", LocalDate.of(2023, 9, 1)));
			System.out.println("\nUsuario agregado de forma exitosa?: " + sistema.agregarUsuario("usuarioCreador2", LocalDate.of(2023, 9, 2)));
			System.out.println("\nUsuario agregado de forma exitosa?: " + sistema.agregarUsuario("usuarioCreador3", LocalDate.of(2023, 9, 3)));
			System.out.println("\nUsuario agregado de forma exitosa?: " + sistema.agregarUsuario("usuarioCreador4", LocalDate.of(2023, 9, 4)));
			System.out.println("\nUsuario agregado de forma exitosa?: " + sistema.agregarUsuario("usuarioCreador5", LocalDate.of(2023, 9, 5)));
			System.out.println("\nUsuario agregado de forma exitosa?: " + sistema.agregarUsuario("usuarioLector1", LocalDate.of(2023, 9, 6)));
			System.out.println("\nUsuario agregado de forma exitosa?: " + sistema.agregarUsuario("usuarioLector2", LocalDate.of(2023, 9, 7)));
			System.out.println("\nUsuario agregado de forma exitosa?: " + sistema.agregarUsuario("usuarioLector3", LocalDate.of(2023, 9, 8)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(sistema);
		
		System.out.println("--------------------------------------------------------\n");
		//--------------------------------------------------------
		
		//2- AGREGAMOS PUBLICACIONES E IMPRIMIMOS LA LISTA
		//--------------------------------------------------------
		System.out.println("\n---AGREGAMOS PUBLICACIONES E IMPRIMIMOS LA LISTA (2)---");
				
		try {
			System.out.println("\nPosteo agregado de forma exitosa?: " + sistema.agregarPosteo(LocalDate.of(2023, 10, 5), LocalTime.of(12, 0), 
					sistema.traerUsuario("usuarioCreador1"), "Alguien sabe programar en Python?", true));
			System.out.println("\nPosteo agregado de forma exitosa?: " + sistema.agregarPosteo(LocalDate.of(2023, 10, 10), LocalTime.of(13, 0), 
					sistema.traerUsuario("usuarioCreador2"), "Cuando es el proximo Feriado?", true));
			System.out.println("\nPosteo agregado de forma exitosa?: " + sistema.agregarPosteo(LocalDate.of(2023, 10, 15), LocalTime.of(14, 0), 
					sistema.traerUsuario("usuarioCreador3"), "Al fin salio el sol!", false));
			System.out.println("\nAviso agregado de forma exitosa?: " + sistema.agregarAvisoGeneral(LocalDate.of(2023, 10, 20), LocalTime.of(15, 0), 
					sistema.traerUsuario("usuarioCreador4"), "Proximas elecciones presidenciales", "El 22 de octubre se realizaran las elecciones presidenciales"));
			System.out.println("\nAviso agregado de forma exitosa?: " + sistema.agregarAvisoGeneral(LocalDate.of(2023, 10, 25), LocalTime.of(16, 0), 
					sistema.traerUsuario("usuarioCreador5"), "Expo carreras en la UNLa", "Del 2 al 4 de octubre se realizara la Expo Careras en la UNLa"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		System.out.println(sistema);
				
		System.out.println("--------------------------------------------------------\n");
		//--------------------------------------------------------
		
		//3- AGREGAMOS COMENTARIOS E IMPRIMIMOS LA LISTA
		//--------------------------------------------------------
		System.out.println("\n---AGREGAMOS COMENTARIOS E IMPRIMIMOS LA LISTA (3)---");
						
		try {
			System.out.println("\nComentario agregado de forma exitosa?: " + sistema.agregarComentario(111, 
					sistema.traerPublicacion("usuarioCreador2", LocalDate.of(2023, 10, 10), LocalTime.of(13, 0)), sistema.traerUsuario("usuarioLector2"), 
					"Ni idea"));
			System.out.println("\nComentario agregado de forma exitosa?: " + sistema.agregarComentario(222, 
					sistema.traerPublicacion("usuarioCreador2", LocalDate.of(2023, 10, 10), LocalTime.of(13, 0)), sistema.traerUsuario("usuarioLector1"), 
					"El viernes 13/10"));
			System.out.println("\nComentario agregado de forma exitosa?: " + sistema.agregarComentario(333, 
					sistema.traerPublicacion("usuarioCreador1", LocalDate.of(2023, 10, 5), LocalTime.of(12, 0)), sistema.traerUsuario("usuarioLector1"), 
					"Si, yo. Que necesitas?"));
			System.out.println("\nComentario agregado de forma exitosa?: " + sistema.agregarComentario(444, 
					sistema.traerPublicacion("usuarioCreador1", LocalDate.of(2023, 10, 5), LocalTime.of(12, 0)), sistema.traerUsuario("usuarioLector3"), 
					"Yo tambien"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
		System.out.println(sistema);
						
		System.out.println("--------------------------------------------------------\n");
		//--------------------------------------------------------
				
		//4- TRAEMOS E IMPRIMIMOS TODAS LAS PUBLICACIONES PUBLICAS ENTRE LAS FECHAS 2023-10-10 Y 2023-10-22
		//--------------------------------------------------------		
		System.out.println("\n---TRAEMOS E IMPRIMIMOS TODAS LAS PUBLICACIONES PUBLICAS ENTRE LAS FECHAS 2023-10-10 Y 2023-10-22 (4)---");
		System.out.println(sistema.traerPublicacionesPublicas(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 22)));
		System.out.println("--------------------------------------------------------\n");
		//--------------------------------------------------------
		
		//5- TRAEMOS E IMPRIMIMOS TODOS LOS COMENTARIOS DEL USUARIO 'usuarioLector1' EN POSTEOS
		//--------------------------------------------------------		
		System.out.println("\n---TRAEMOS E IMPRIMIMOS TODOS LOS COMENTARIOS DEL USUARIO 'usuarioLector1' EN POSTEOS (5)---");
		System.out.println(sistema.traerComentariosEnPosteoPorUsuario(sistema.traerUsuario("usuarioLector1")));
		System.out.println("--------------------------------------------------------\n");
		//--------------------------------------------------------	
		
		//6- TRAEMOS E IMPRIMIMOS TODAS LAS PUBLICACIONES QUE CONTENGAN EL TEXTO 'en'
		//--------------------------------------------------------		
		System.out.println("\n---TRAEMOS E IMPRIMIMOS TODAS LAS PUBLICACIONES QUE CONTENGAN EL TEXTO 'en' (6)---");
		System.out.println(sistema.traerPublicacionesQueContenganTexto("en"));
		System.out.println("--------------------------------------------------------\n");
		//--------------------------------------------------------	
		
		//7- INTENTAMOS AGREGAR NUEVAMENTE A UN USUARIO
		//--------------------------------------------------------		
		System.out.println("\n---INTENTAMOS AGREGAR NUEVAMENTE A UN USUARIO (7)---");
		try {
			System.out.println("\nUsuario agregado de forma exitosa?: " + sistema.agregarUsuario("usuarioCreador2", LocalDate.of(2023, 9, 2)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("\n--------------------------------------------------------\n");
		//--------------------------------------------------------	
		
		//8- INTENTAMOS AGREGAR NUEVAMENTE UNA PUBLICACION
		//--------------------------------------------------------		
		System.out.println("\n---INTENTAMOS AGREGAR NUEVAMENTE UNA PUBLICACION (8)---");
		try {
			System.out.println("\nPosteo agregado de forma exitosa?: " + sistema.agregarPosteo(LocalDate.of(2023, 10, 15), LocalTime.of(14, 0), 
					sistema.traerUsuario("usuarioCreador3"), "Al fin salio el sol!", false));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("\n--------------------------------------------------------\n");
		//--------------------------------------------------------	


	}

}
