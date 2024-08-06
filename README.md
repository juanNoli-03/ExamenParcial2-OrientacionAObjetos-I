<div id="user-content-toc">
  <ul align="center">
    <summary><h1 style="display: inline-block">Resolución del segundo examen parcial - Orientación a Objetos 1 - Año 2023</h1>
    <h1 style="display: inline-block">"Sistema de Redes Sociales"</h1>
    </summary>
  </ul>
</div>

---

**1- Diagrama de Clases:**

![image](https://github.com/user-attachments/assets/dd948ad7-3b40-48cb-97e3-308f93843510)


**2- Consigna:**

---

**Nota:** El examen acredita puntos por la resolución del modelo y test de cada CU.

**Casos de Uso:**

**1.** + traerUsuario(String nombreUsuario): Usuario

**2.** + agregarUsuario(String nombreUsuario, LocalDate fechaAlta): boolean

***Lanzar excepción si ya existe un usuario con el mismo nombreUsuario en la lista. El id se calcula de forma autoincremental, teniendo en cuenta que la lista puede tener altas y bajas de objetos.***

**3.** + traerPublicacion(String nombreUsuario, LocalDate fecha, LocalTime hora): Publicacion

**4.** + agregarPosteo(LocalDate feccha, LocalTime hora, Usuario creador, String texto, boolean publico): boolean

***Lanzar excepción si ya existe una Publicación con el mismo creador, fecha y hora. El id se calcula de forma autoincremental, teniendo en cuenta que la lista puede tener altas y bajas de objetos.***

**5.** + agregarAvisoGeneral(LocalDate feccha, LocalTime hora, Usuario creador, String titulo, String cuerpo): boolean

***Lanzar excepción si ya existe una Publicación con el mismo creador, fecha y hora. El id se calcula de forma autoincremental, teniendo en cuenta que la lista puede tener altas y bajas de objetos.***

**6.** + (abstract) contieneTexto(String buscar): boolean

***Devolverá verdero si el texto a buscar existe en el titulo o en el cuerpo de un AvisoGeneral o en el texto de un Posteo. Help: Se puede utilizar el método .indexOf desde un String que devuelve el indice de la aparición o -1 si no se encontró.***

**7.** + agregarComentario(int identificacion, Publicacion publicacion, Usuario usuario, String texto): boolean

***No lanza excepción ni revisa si el comentario ya existe. El id se calcula de forma autoincremental, teniendo en cuenta que la lista puede tener altas y bajas de objetos.***

**8.** + traerPublicacionesPublicas(LocalDate fechaDesde, LocalDate fechaHasta): List <Publicacion>

***El método retorna una lista de todas las publicaciones publicas que se encuentren entre la fechaDesde y la fechaHasta (incluyendo extremos). Se consideran públicas aquellas publicaciones que sean del tipo AvisoGeneral o del tipo Posteo con el atributo "publico" en TRUE***

**9.** + traerComentariosEnPosteosPorUsuario(Usuario usuario): List <Comentario>

***El método retorna una lista de todos los comentarios del usuario pasado como parametro que se hayan realizado en publicaciones del tipo Posteo.***

**10.** + traerPublicacionesQueContenganTexto(String texto): List <Publicacion>

***El método retorna una lista de todas las publicaciones que contengan el texto pasado como parametro.***


**3- Test:**

---

**Nota:** Al comenzar cada test indicar el numero de CU a resolver ej: ***System.out.println("1)");*** y luego la implementación del mismo.

**1-** Agregar los siguientes Usuarios e imprimir la lista de Usuarios:

***Usuario [nombreUsuario= "usuarioCreador1", fechaAlta= 2023-09-01]***

***Usuario [nombreUsuario= "usuarioCreador2", fechaAlta= 2023-09-02]***

***Usuario [nombreUsuario= "usuarioCreador3", fechaAlta= 2023-09-03]***

***Usuario [nombreUsuario= "usuarioCreador4", fechaAlta= 2023-09-04]***

***Usuario [nombreUsuario= "usuarioCreador5", fechaAlta= 2023-09-05]***

***Usuario [nombreUsuario= "usuarioLector1", fechaAlta= 2023-09-06]***

***Usuario [nombreUsuario= "usuarioLector2", fechaAlta= 2023-09-07]***

***Usuario [nombreUsuario= "usuarioLector3", fechaAlta= 2023-09-08]***

**2-** Agregar las siguientes Publicaciones e imprimir la lista de Publicaciones:

***Posteo [fecha= 2023-10-5, hora= 12:00, creador= Usuario [nombreUsuario= "usuarioCreador1", fechaAlta= 2023-09-01], texto= "Alguien sabe programar en Python?", publico= true]***

***Posteo [fecha= 2023-10-10, hora= 13:00, creador= Usuario [nombreUsuario= "usuarioCreador2", fechaAlta= 2023-09-02], texto= "Cuando es el proximo Feriado?", publico= true]***

***Posteo [fecha= 2023-10-15, hora= 14:00, creador= Usuario [nombreUsuario= "usuarioCreador3", fechaAlta= 2023-09-03], texto= "Al fin salio el sol!", publico= false]***

***AvisoGeneral [fecha= 2023-10-20, hora= 15:00, creador= Usuario [nombreUsuario= "usuarioCreador4", fechaAlta= 2023-09-04], titulo= "Proximas elecciones presidenciales", cuerpo= "El 22 de octubre se realizaran las elecciones presidenciales"]***

***AvisoGeneral [fecha= 2023-10-25, hora= 16:00, creador= Usuario [nombreUsuario= "usuarioCreador5", fechaAlta= 2023-09-05], titulo= "Expo carreras en la UNLa", cuerpo= "Del 2 al 4 de octubre se realizara la Expo Careras en la UNLa"]***

**3-** Agregar los siguientes Comentarios e imprimir la lista de Comentarios:

***Comentario [identificacion= 111, publicacion= Posteo [fecha= 2023-10-10, hora= 13:00, creador= Usuario [nombreUsuario= "usuarioCreador2", fechaAlta= 2023-09-02], texto= "Cuando es el proximo Feriado?", publico= true], usuario= Usuario [nombreUsuario= "usuarioLector2", fechaAlta= 2023-09-07], texto= "Ni idea"]***

***Comentario [identificacion= 222, publicacion= Posteo [fecha= 2023-10-10, hora= 13:00, creador= Usuario [nombreUsuario= "usuarioCreador2", fechaAlta= 2023-09-02], texto= "Cuando es el proximo Feriado?", publico= true], usuario= Usuario [nombreUsuario= "usuarioLector1", fechaAlta= 2023-09-06], texto= "El viernes 13/10"]***

***Comentario [identificacion= 333, publicacion= Posteo [fecha= 2023-10-5, hora= 12:00, creador= Usuario [nombreUsuario= "usuarioCreador1", fechaAlta= 2023-09-01], texto= "Alguien sabe programar en Python?", publico= true], usuario= Usuario [nombreUsuario= "usuarioLector1", fechaAlta= 2023-09-06], texto= "Si, yo. Que necesitas?"]***

***Comentario [identificacion= 444, publicacion= Posteo [fecha= 2023-10-5, hora= 12:00, creador= Usuario [nombreUsuario= "usuarioCreador1", fechaAlta= 2023-09-01], texto= "Alguien sabe programar en Python?", publico= true], usuario= Usuario [nombreUsuario= "usuarioLector3", fechaAlta= 2023-09-08], texto= "Yo tambien"]***

**4-** Traer e imprimir todas las publicaciones públicas entre las fechas 2023-10-10 y 2023-10-22

**5-** Traer e imprimir todos los comentarios del usuario "usuarioLector1" en Posteos

**6-** Traer e iprimir todas las Publicaciones que contengan el texto "en"

**7-** Intentar agregar nuevamente al siguiente Usuario:

***Usuario [nombreUsuario= "usuarioCreador2", fechaAlta= 2023-09-02]***

**8-** Intentar agregar la siguiente Publicacion:

***Posteo [fecha= 2023-10-15, hora= 14:00, creador= Usuario [nombreUsuario= "usuarioCreador3", fechaAlta= 2023-09-03], texto= "Al fin salio el sol!", publico= false]***
