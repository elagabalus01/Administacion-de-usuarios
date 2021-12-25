# Administración de usuario
## Ejemplo de crud simple utilizando el framework de spring boot

### Get
Si no existen usuarios la api envía el mensaje de que no hay usuarios registrados <br><br>
![Screenshot](capturas/get_no_usuarios.png?raw=true "No hay usuarios")
Si no se agrega el id a la ruta se envía una lista con todos los usuarios <br><br>
![Screenshot](capturas/get_usuario.png?raw=true "Lista de usuarios")
Si se agrega el id a la ruta se muestra la información del usuario con ese id <br><br>
![Screenshot](capturas/get_usuario_id.png?raw=true "Informacion de un usuario dado")
### POST
Crea un nuevo usuario (el funcionamiento de este método se puede comprobar en la captura del método get) <br><br>
![Screenshot](capturas/post_crear.png?raw=true "Crea un usuario")

### DELETE
Valida si existe el usuario con el id<br><br>
![Screenshot](capturas/delete_usuario_no_existe.png?raw=true "Elimina un usuario que no existe")
 Elimina el usuario con el id definido <br><br>
![Screenshot](capturas/delete_usuario.png?raw=true "Elimina un usuario")
verificación del método delete <br><br>
![Screenshot](capturas/delete_verificacion.png?raw=true "Verificación de método delete")
### PUT
Actualiza todos los campos de un usuario <br><br>
![Screenshot](capturas/put_usuario_exitente.png?raw=true "Actualiza un usuario")
Verificación del método put <br><br>
![Screenshot](capturas/put_verficación.png?raw=true "Verificación del método put")
Si no existe el usuario lo crea pero con el identificador que corresponde según el incrementador <br><br>
![Screenshot](capturas/put_usuario_nuevo.png?raw=true "Crea un usuario")
### PATCH
Actualiza los campos del usuario definidos en la solicitud  <br><br>
![Screenshot](capturas/patch_nombre.png?raw=true "Actualiza el nombre de un usuario")
Verificación del método patch  <br><br>
![Screenshot](capturas/patch_verificación.png?raw=true "Verificación path")
Si no se envía ningún campo a modificar la api regresa un error <br><br>
![Screenshot](capturas/patch_no_campos.png?raw=true "Regresa error al no enviar ningun campo")
