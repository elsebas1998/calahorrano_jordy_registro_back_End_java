# Prueba de BackEnd

Para el funcionamiento del sistema solo se requiere un IDE de desarrollo compatible con Java - Spring Boot. 
Como primer paso se tiene los end point, los cuales dan la funcionalidad al sistema, adicionalmente a esto ya que se trabaja
con una BDD tipo H2 no es necesario levantar ningun sistema de BDD ya que esta integrada en el sistema. 

# Pasos para uso 
Crear usuario:
Desde Postman ingresar la siguiente url en la opcion de Post -> http://localhost:9090/registro
Se debe tener en cuenta ciertos puntos para crear un usuario 
1.- Solo se acepta un unico nombre por grupo, es decir que no pueden existir nombres repetidos en los grupos
2.- El email debe ser uno valido ya que esta validado
3.- El numero de telefono debe empezar por 09 y contener 10 digitos
4.- Los grupos solo pueden ser SK o TH 
5.- Las mimas condiciones riguen para la actualizacion de datos 
Ejemplo de JSON para crear un registro de cliente


      {
        "nombre": "José",
        "email": "jose@example.com",
        "telefono": "0901234567",
        "grupo": "SK"
      }

Para visualizar los datos desde la opcion de get se ingresa la siguiente -> url: http://localhost:9090/mostrar

Para eliminar hacer uso del apartado de eliminar -> http://localhost:9090/eliminar/id

Para buscar por nombre o email es similar a mostra -> http://localhost:9090/buscaEmail/jose@example.com

Nota: Las rutas de los archivos JSON y XML son rutas absolutas asi que estas deben varias en base al equipo que se use
