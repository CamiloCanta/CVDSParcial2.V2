## Escuela Colombiana de Ingeniería

### PDSW – Procesos de desarrollo de Software
### Parcial Segundo Tercio


**IMPORTANTE**

* Deseable Trabajar en Linux (para evitar problemas con las instrucciones finales).
* Se puede consultar en la Web: APIs/Documentación de lenguaje y frameworks (Primefaces, Guice, MyBatis, etc), y enunciados de los laboratorios (se pueden revisar los fuentes incluidos con los dichos enunciados).
* No se permite: Usar memorias USB, acceder a redes sociales, clientes de correo, o sistemas de almacenamiento en la nube (Google Drive, DropBox, etc). El uso de éstos implicará anulación.
* Clone el proyecto con GIT, NO lo descargue directamente.
* NO modifique los indicado en consultaPaciente.xhtml.
* El filtrado y ordenamiento de los datos DEBE realizarse en el motor de base de datos, a través del uso de SQL. Consultar todos los datos y filtrarlos en el servidor de aplicaciones -que es supremamente INEFICIENTE- se evaluará como INCORRECTO.


Se le han dado los fuentes de un avance parcial de una plataforma de consultas de pacientes de una IPS en línea. En esta plataforma los médicos podrán registrar y buscar pacientes así como buscar y registrar las consultas.
Adicionalmente, la secretaria de salud puede hacer búsquedas para control epidemiológico.

Para el Sprint en curso, se han seleccionado las siguientes historias de usuario del Backlog de producto:

Recuerde que en el formato XML no se puede utilizar '<' y '>', por ejemplo al realizar comparaciones, 
 utilice '&amp;lt;' o '&amp;gt;' respectivamente. 

## Historia de usuario #1

  -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  > **Como** Usuario de la plataforma de consultas médicas
  >
  > **Quiero** Poder consultar un paciente a partir de su número y tipo de identificación.
  >
  > **Para** Poder hacer una revisión de las consultas realizadas por un paciente cuyo documento ya conozco, y así evitar la búsqueda por el nombre del paciente.
  >
  > **Criterio de aceptación:** Se debe mostrar la fecha de nacimiento del paciente, su nombre, y cada una de las consultas realizadas. Las consultas deben estar organizadas de la más reciente (mostrados arriba) a la más antígua, y deben mostrar la fecha y el resúmen.

## Historia de usuario #2

  -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  > **Como** Usuario de la secretaría de salud de la plataforma
  >
  > **Quiero** Tener un reporte de las consultas de los menores de edad (menóres de 18 años) en las que en el resúmen se encuentren enfermedades contagiosas.
  >
  > **Para** Conocer con rapidez qué pacientes debo revisar y tomar medidas al respecto.
  >
  > **Criterio de aceptación:** El reporte NO debe requerir entrar parámetro alguno. Se considerán como enfermedades contagiosas: 'hepatitis' y 'varicela'. El reporte sólo debe contener el número y tipo de identificación  del paciente y la fecha de nacimiento, ordenados por edad de mayor a menor.
  -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

El modelo de base de datos y de clases asociados a la implementación parcial son los siguientes:

![](./img/Diagram.png)

![](./img/Model.png)

A partir de la aplicación base suministrada, debe realizar lo siguiente:

Dado un número y tipo de identificacion de un paciente, mostrar el paciente y las consultas que ha realizado esde paciente.

Mostrar los pacientes menores de edad que en sus consultas se encuentren las enfermedades: hepatitis o varicela.


1.  (20%) A partir de la especificación hecha en los métodos
    *consultarPacientesPorId* y *consultarMenoresConEnfermedadContagiosa* de la fachada de
    servicios (la parte lógica de la aplicación), implemente sólo una prueba (la que considere más importante para validar las especificaciones y los criterios de aceptación). Siga el esquema usado en ServicesJUnitTest para poblar la base de datos volátil y verificar el comportamiento de las operaciones de la lógica.

2.  (40%) Implemente la historia de usuario #1, agregando todo lo que haga falta en la capa de presentación, lógica y de persistencia. La vista debe implementarse en consultaPaciente.xhtml.

3.  (40%)Implemente la historia de usuario #2, agregando todo lo que haga falta en la capa de presentación, lógica y de persistencia. La vista debe implementarse en consultarMenoresEnfermedadContagiosa.xhtml.


## Entrega

1. Documentar la solución en Readme de Git.

## Solución

1. El primer punto se realizara luego de implementar las pruebas de usuario para lograr implementar correctamente las pruebas unitarias.


### Back-end
2. Para el segundo punto(Implemente la historia de usuario #1) y tercer punto(Implemente la historia de usuario #2) se empezo a construir el codigo a fondo y como primer paso fue realizar dos clases de Beans (componente software que tiene la particularidad de ser reutilizable y así evitar la tediosa tarea de programar los distintos componentes uno a uno. Se puede decir que existen con la finalidad de ahorrarnos tiempo al programar).

![image](https://user-images.githubusercontent.com/108955358/200099221-d8ec9847-541b-4825-a99b-11cb8faeb46e.png)

![image](https://user-images.githubusercontent.com/108955358/200099234-35ce73bb-fb3f-4bcf-a0ea-bed20cceb0fb.png)
![image](https://user-images.githubusercontent.com/108955358/200099245-b9b58d14-bbfa-420a-892b-692dd29766ac.png)

Ademas en el paquete de persistence se complemntan dos paquetes (mybatisimpl y mappers) con clases e interfaces.

*ConsultaMapper*

![image](https://user-images.githubusercontent.com/108955358/200099493-0876acd9-4d4d-42b5-9692-4ddaa766d904.png)

*MyBatisDAOConsulta*

![image](https://user-images.githubusercontent.com/108955358/200099528-bd0c62a6-04d5-4b68-846a-1a898e33bb0c.png)

*DAOConsulta*

![image](https://user-images.githubusercontent.com/108955358/200099540-9b0dec55-7458-4644-b507-08107e5b2f45.png)

Una vez realizado esto, vamos al paquete services y creamos los metodos para realizar las consultas y crearemos una clase main.

![image](https://user-images.githubusercontent.com/108955358/200099949-17ed59db-e3c4-4e59-96a7-838a6cb0092b.png)

### Front-end

En el paquete mappers realizamos las modificaiones para realizar las consultas a la base de datos, en consultaMapper se obtendran los usuarios y en Pacienteapper obtendremos el historial

![image](https://user-images.githubusercontent.com/108955358/200100206-bdca76e7-6b75-4ef2-bf49-ba4bad8ab4ab.png)

![image](https://user-images.githubusercontent.com/108955358/200100213-dd85afb1-7e8d-4ac4-aef6-6da4b4e434bf.png)

Por ultimo nos dirigimos a la carpeta webapp para realizar las modificaciones en los .xhtml, y luego de correr los servicios se logra visualizar así:

*Implemente la historia de usuario #1*

![image](https://user-images.githubusercontent.com/108955358/200121993-c3f10e9d-5856-4f7b-a26c-1bcef8669b80.png)

*Implemente la historia de usuario #2*

![image](https://user-images.githubusercontent.com/108955358/200122129-a99c316a-32b8-4ece-b610-643b18e4c1f2.png)


### Pruebas 

![image](https://user-images.githubusercontent.com/108955358/200122052-64439ccd-08c3-43fe-9976-813d73ea9594.png)

![image](https://user-images.githubusercontent.com/108955358/200122069-3e7e2d42-b1b8-477d-85c3-68a123d1befb.png)





