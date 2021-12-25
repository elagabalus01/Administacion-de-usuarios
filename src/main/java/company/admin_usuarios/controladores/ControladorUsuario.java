package company.admin_usuarios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;

import company.admin_usuarios.modelos.Usuario;
import company.admin_usuarios.data.RepositorioUsuario;

import java.util.Map;
import java.util.HashMap;
import java.util.List;


// Establece a la clase como controlador y define que los resultados devueltos por una
// función serán enviados como respuesta en un formato json
@RestController
public class ControladorUsuario{

    @Autowired // Se utiliza para que spring boot relice la inyección de la dependencia
    private RepositorioUsuario repositorio_usuarios;

    // Muestra los datos de todos los usuarios
    @GetMapping("/usuario")
    public HashMap<String,Object> todos(){
        HashMap<String,Object> response=new HashMap<String,Object>();
        List users=repositorio_usuarios.todosLosUsuarios();
        if(users.size()==0){
            response.put("data","No hay usuarios por mostrar");
            response.put("error","");
            return response;
        }
        response.put("data",users);
        response.put("error","");
        return response;
    }

    // Muestra los datos de un usuario
    @GetMapping("/usuario/{id}")
    public HashMap<String,Object> usuarioEncontrado(@PathVariable(value="id") int id){
        HashMap<String,Object> response=new HashMap<String,Object>();
        Usuario usuario_encontrado=null;
        usuario_encontrado=repositorio_usuarios.buscarPorId(id);
        if(usuario_encontrado==null){
            response.put("data","");
            response.put("error","No se encontró al usuario con el id "+String.valueOf(id));
            return response;
        }
        response.put("data",usuario_encontrado);
        response.put("error","");
        return response;
    }

    // crea un nuevo usuario
    @PostMapping("/usuario")
    public HashMap<String,String> agregarUsuario(@RequestParam Map<String,String> input){
        HashMap<String,String> response=new HashMap<String,String>();
        if(input.get("nombre")==null){
            response.put("data","");
            response.put("error","No se envió el nombre completo del usuario");
            return response;
        }
        if(input.get("correo")==null){
            response.put("data","");
            response.put("error","No se envió el correo electrónico del usuario");
            return response;
        }

        String nombre=input.get("nombre");
        String correo=input.get("correo");

        repositorio_usuarios.agregarUsuario(nombre,correo);

        response.put("data","Hecho");
        response.put("error","");
        return response;
    }

    // Elimina un usuario
    @DeleteMapping("/usuario/{id}")
    public HashMap<String,String> removerUsuario(@PathVariable(value="id") int id){
        HashMap<String,String> response=new HashMap<String,String>();
        Usuario usuario_remover=null;
        usuario_remover=repositorio_usuarios.buscarPorId(id);
        if(usuario_remover==null){
            response.put("data","");
            response.put("error","No existe el usuario con el id "+String.valueOf(id));
            return response;
        }
        repositorio_usuarios.eliminarUsuario(usuario_remover);
        response.put("data","Usuario eliminado exitosamente");
        response.put("error","");
        return response;
    }

    // Actualiza un campo en concreto del usuario
    @PatchMapping("/usuario/{id}")
    public HashMap<String,String> cambiarUsuario(@PathVariable(value="id") int id,
    @RequestParam Map<String,String> input){
        HashMap<String,String> response=new HashMap<String,String>();
        if((input.get("nombre")==null) && (input.get("correo")==null)){
            response.put("data","");
            response.put("error","No se seleccionó ningún campo a actualizar");
            return response;
        }
        Usuario usuario_actualizar=null;
        usuario_actualizar=repositorio_usuarios.buscarPorId(id);
        if(usuario_actualizar==null){
            response.put("data","");
            response.put("error","No existe el usario con el id "+String.valueOf(id));
            return response;
        }
        if(input.get("correo")!=null){
            usuario_actualizar.setCorreo(input.get("correo"));
        }
        if(input.get("nombre")!=null){
            usuario_actualizar.setNombre(input.get("nombre"));
        }
        response.put("data","Usuario actualizado exitosamente");
        response.put("error","");
        return response;
    }

    // Actualiza los datos de un usuario y no existe lo crea con el id que corresponde al siguiente
    // del último asignado no con el parametro del id en la petición
    @PutMapping("/usuario/{id}")
    public HashMap<String,String> cambiarAgregarUsuario(@PathVariable(value="id") int id,
    @RequestParam Map<String,String> input){
        HashMap<String,String> response=new HashMap<String,String>();
        String mensaje;
        if(input.get("nombre")==null){
            response.put("data","");
            response.put("error","No se envió el nombre completo del usuario");
            return response;
        }
        if(input.get("correo")==null){
            response.put("data","");
            response.put("error","No se envió el correo electrónico del usuario");
            return response;
        }
        Usuario usuario_actualizar=null;
        usuario_actualizar=repositorio_usuarios.buscarPorId(id);
        if(usuario_actualizar==null){
            usuario_actualizar=repositorio_usuarios.agregarUsuario(input.get("nombre"),input.get("correo"));
            mensaje="Se creó el usuario exitosamente con el id "+String.valueOf(usuario_actualizar.getId());
        }else{
            usuario_actualizar.setCorreo(input.get("correo"));
            usuario_actualizar.setNombre(input.get("nombre"));
            mensaje="Usuario actualizado exitosamente";
        }
        response.put("data",mensaje);
        response.put("error","");
        return response;
    }

}
