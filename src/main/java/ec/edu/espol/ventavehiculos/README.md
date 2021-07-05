PROYECTO #1 - PRIMER PARCIAL

Venta de Vehículos
El presente proyecto tiene como finalidad crear una aplicación para la compra y venta de vehículos usados. La aplicación permitirá al vendedor ingresar la información del vehículo para que esté disponible para la venta. Los vehículos que se pueden vender son autos, camionetas y motocicletas. El comprador podrá ingresar una oferta por el vehículo para que posteriormente sea contactado por el vendedor del vehículo.
Toda la información que genere el sistema debe guardarse en archivos de texto plano.
Especificaciones
Menú de Opciones
El programa deberá proporcionar un menú de opciones para facilitar el acceso a las diferentes opciones a los usuarios.
Menú de Opciones:
1.	Vendedor
2.	Comprador
3.	Salir
Opciones del Vendedor
En la opción del Vendedor se deben presentar las siguientes opciones:
1.	Registrar un nuevo vendedor
2.	Ingresar un nuevo vehículo
3.	Aceptar oferta
4.	Regresar
Registrar nuevo vendedor
Esta opción permite registrar los datos de un vendedor.
•	Nombres
•	Apellidos
•	Organización
•	Correo Electrónico
•	Clave
Validar que el correo sea único con respecto a los que ya se encuentran registrados en el sistema. En caso de estar registrado, no se debería permitir el registro.
Por seguridad, las contraseñas se deben almacenar con una función hash en el archivo de texto plano.
https://www.geeksforgeeks.org/sha-256-hash-in-java/
Ingresar un nuevo vehículo
Para acceder a esta opción el vendedor debe ingresar su correo electrónico y su clave. Para validar si la clave es correcta se debe calcular el hash de la clave y compararla con la que está almacenada en el archivo.
Esta opción permitirá el ingreso de un nuevo vehículo, el cual debe contar con al menos la siguiente información:
Lo primero que debe ingresar es el tipo de vehículo que va a ingresar y dependiendo del tipo de vehículo se presentará la siguiente información.
•	Placa
•	Marca
•	Modelo
•	tipo de motor
•	Año
•	Recorrido
•	Color
•	Tipo combustible
•	Vidrios (no aplica para motos)
•	Transmisión (no aplica para motos)
•	Tracción (aplica para camionetas)
•	Precio
En caso de que el vendedor ingrese un vehículo con una placa existente en el sistema, no se permitirá el ingreso.
Aceptar oferta
Para acceder a esta opción el vendedor debe ingresar su correo y su clave. Para validar si la clave es correcta se debe calcular el hash de la clave y compararla con la que está almacenada en el archivo.
El vendedor podrá revisar las ofertas de los vehículo ingresando la placa del vehículo. Las ofertas deben presentarse de una manera interactiva al momento de revisar las ofertas. La aplicación presenta una oferta a la vez y debe permitirle al vendedor revisar la siguiente oferta, en su defecto, cuando vaya avanzado entre las ofertas, debe tener la posibilidad de regresar a revisar otra oferta. Ejemplo:
Ingrese la placa: PBA5050
Renault Logan 1.6 Precio: 16000
Se han realizado 3 ofertas
Oferta 1
Correo: jperez@gmail.com
Precio Ofertado: 15500
1.- Siguiente Oferta
2.- Aceptar Oferta

Oferta 2
Correo: mortiz@gmail.com
Precio Ofertado: 15000
1.- Siguiente Oferta
2.- Anterior Oferta
2.- Aceptar Oferta
Cuando el vendedor acepta la oferta, el vehículo debe eliminarse del sistema y enviarle un correo al usuario del cual se aceptó la oferta confirmándole que se ha aceptado su oferta.
https://javaee.github.io/javamail/
https://www.campusmvp.es/recursos/post/como-enviar-correo-electronico-con-java-a-traves-de-gmail.aspx
Opciones del Comprador
En la opción del Comprador se deben presentar las siguientes opciones:
1.	Registrar un nuevo comprador
2.	Ofertar por un vehículo
Registrar nuevo comprador
Esta opción permite registrar los datos de un comprador.
•	Nombres
•	Apellidos
•	Correo Electrónico
•	Organización
•	Correo
•	Clave
Validar que el correo sea único con respecto a los que ya se encuentran registrados en el sistema. En caso de estar registrado, no se debería permitir el registro.
Las contraseñas se deben almacenar con una función hash en el archivo de texto plano.
https://www.geeksforgeeks.org/sha-256-hash-in-java/
Ofertar por un vehículo
Para que un comprador pueda ofertar por un vehículo, primero debe realizar una búsqueda de los vehículos por los siguientes criterios:
•	Tipo de vehículo 
•	Recorrido (Especificado en un rango)
•	Año (Especificado en un rango)
•	Precio (Especificado en un rango)
Para realizar la búsqueda de los vehículos, no es necesario que el comprador ingrese todos los parámetros de búsqueda, en caso de que no ingrese alguno de ellos, se entenderá que está buscando todas las posibilidades de ese parámetro.
Los vehículos deben presentarse de una manera interactiva. La aplicación presenta un vehículo a la vez y debe permitirle al comprador revisar el siguiente vehículo, en su defecto, cuando vaya avanzado entre los vehículos, debe tener la posibilidad de regresar a revisar otro vehículo
Cuando el comprador vaya a realizar una oferta, debe ingresar el precio ofertado y el sistema debe registrar el correo electrónico con la oferta.
Generalidades
En las opciones que se requiera información por parte del usuario se debe realizar validaciones para que el usuario ingrese la información correcta.
Entregables
•	Diagrama de clases. 
•	Proyecto en el repositorio de git.
