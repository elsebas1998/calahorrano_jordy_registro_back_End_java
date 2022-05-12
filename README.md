# Prueba de BackEnd

Creamos esta prueba para conocer sobre sus conocimientos y habilidades en lenguaje Java, programación orientada a objetos y buenas prácticas de programación. 

La prueba consiste en construir una aplicación Java capaz de recuperar información de un archivo XML y un archivo JSON, conservar un registro en una base de datos en memoria o de archivo, y listar los registros en una interfaz simple. 

## Propuesta 

¡El "nuevo" sistema de registro de clientes de la empresa XYZ_CH desde la plataforma web necesita una nueva propuesta!  

El departamento de marketing, ha decidido que por motivos del lanzamiento de la nueva plataforma web, premiará a los primeros clientes en registrarse y participar en beneficios durante todo el año.  En el momento de inscribirse, el cliente deberá escoger a que grupo quiere pertenecer para participar de los beneficios. Por esta razón, se ha creado dos listas separadas diferenciadas por sus formatos: “sk_formato” y “th_formato” 

El reto es desarrollar un sistema Java capaz de: 

Permitir el registro de clientes escogiendo al grupo que quiere pertenecer para participar en los beneficios de los contenidos en los enlaces de referencia sk_formato.json y th_formato.xml 

Enviar un registro que contenga el nombre, el correo electrónico y el número de teléfono del cliente (los campos obligatorios son el nombre y correo electrónico) 

Conservar la información registrada en una base de datos en memoria, como HSQLDB o un archivo 

Obtener, en cualquier momento, la lista de todos los clientes registrados con su respectivo grupo y el beneficio que se le otorgó. 

Validar el uso del mismo nombre como clave para diferentes usuarios (a menos que el nombre sea para listas de formatos diferentes) 

Debe leer la información de los beneficios de los archivos compartidos  

 

## Arquitectura de referencia 

![] (https://github.com/SistemasComoHogar/ClientesBack/blob/main/Referencias/Arquitectura.png)

## Enlaces a archivos de referencia 

https://github.com/SistemasComoHogar/ClientesBack/blob/main/Referencias/sk_formato.json  

https://github.com/SistemasComoHogar/ClientesBack/blob/main/Referencias/th_formato.xml 

## Casos de uso 

- Registro exitoso: 

El usuario “José” registra su nombre, correo electrónico y número de teléfono, y elige la lista sk_formato.json 

El sistema recibe el registro y comprueba los nombres de código disponibles en la lista sk_formato.json 

El sistema encuentra un beneficio libre y lo elige 

El sistema conserva el nombre, el e-mail, el teléfono, beneficio y el archivo de referencia en una base de datos o en un archivo. 

El sistema informa que el usuario se ha registrado correctamente y muestra una advertencia de éxito. 

Lista escogida no tiene beneficios disponibles 

El usuario “Gabriel” registra su nombre, correo electrónico y número de teléfono, y elige la lista th_formato.xml 

El sistema recibe el registro y comprueba los beneficios disponibles en la lista th_formato.xml 

El sistema no encuentra un beneficio libre 

El sistema le informa que esa lista ya no tiene beneficios disponibles 

Informe de usuarios registrados: 

El usuario “Monica” lista los clientes en “Listar Clientes” 

El sistema consulta la base de datos en memoria o en archivo 

El sistema presenta a todos los usuarios registrados. Cada línea tiene la información: nombre, correo electrónico, teléfono, beneficio y archivo de referencia 

## Instrucciones 

 

El código generado no está ni bien ni mal. Solo queremos saber más sobre sus conocimientos en el lenguaje Java, como el uso de bibliotecas públicas, y también su cuidado por el código fuente, teniendo en cuenta la claridad de las ideas, la organización del código, la documentación y las pruebas. 

Clone este proyecto, cree un nuevo proyecto en su propio GitHub y siga los siguientes pasos: 

Clonar el sdfgsdfgsdfg 

Crea un nuevo proyecto dentro de tu GitHub (https://github.com) 

Desarrollar un sistema que cumpla con los casos de uso presentados 

Para montar el sistema, tenga en cuenta la arquitectura de referencia dentro de la carpeta de referencia 

Crear una interfaz HTML que contenga un formulario para recibir el nombre, el correo electrónico y el teléfono 

Cree una interfaz HTML que enumere a los clientes registrados por nombre, correo electrónico, teléfono, beneficio y lista de referencias 

Cree una o más clases que realicen una solicitud HTTP para el archivo de referencia "th_formato " en: sdgsdfg.xml 

Cree una o más clases que realicen una solicitud HTTP para el archivo de referencia "sk:formato" en: sdgs.json 

Crear una o más clases que contengan las reglas para conservar y recuperar los registros de los clientes 

Documente cómo se debe iniciar el proyecto para que podamos ejecutar su aplicación 

Envía tu propuesta para el proyecto que creaste en GitHub. Ejemplo: https://github.com/nombre_apellido 

Envíanos el enlace de GitHub de tu proyecto para que podamos descargarlo. Ejemplo: https://github.com/nombre_apellido/registro-backEnd-Java.git 

Espere a que RRHH se ponga en contacto con usted. 

## Reglas 

Puede utilizar Java en cualquier versión :) 

Puede utilizar frameworks de lenguaje Java, de preferencia Spring y hibernate :) 

Para conservar la información, puede utilizar una base de datos en memoria que administre o utilizar una base de datos, como HSQLDB. 

También puede elegir escribir en el archivo. 

Detalles de la creación de pruebas unitarias, la ordenación de la lista registrada o el filtrado de la lista son opcionales. ¡Pero si lo haces te lo agradeceremos! =) 

## Lo que apreciamos 

Organización 

Simplicidad 

Objetividad 

Reutilización del código 

Pruebas unitarias 

Estandarización del código 

Patrones de diseño 

## A quién buscamos 

Queremos una persona a la que le guste lo que hace, trabaje en equipo y quiera innovar, buscando siempre soluciones actualizadas e innovadoras. 

Si te has identificado, ¡forma parte de nuestro equipo! 

 
