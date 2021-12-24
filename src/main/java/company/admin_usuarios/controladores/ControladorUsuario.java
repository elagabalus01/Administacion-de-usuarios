package company.admin_usuarios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PatchMapping;

import company.admin_usuarios.modelos.Usuario;
import company.admin_usuarios.data.RepositorioUsuario;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

@RestController
public class ControladorUsuario{

    @Autowired
    private RepositorioUsuario repositorio_usuarios;

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

    @PostMapping("/usuario/nuevo")
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

        repositorio_usuarios.agergarUsuario(nombre,correo);

        response.put("data","Hecho");
        response.put("error","");
        return response;
    }

    @DeleteMapping("/usuario/{id}")
    public HashMap<String,String> removerUsuario(@PathVariable(value="id") int id){
        HashMap<String,String> response=new HashMap<String,String>();
        Usuario usuario_remover=null;
        usuario_remover=repositorio_usuarios.buscarPorId(id);
        if(usuario_remover==null){
            response.put("data","");
            response.put("error","No existe el usario con el id "+String.valueOf(id));
            return response;
        }
        repositorio_usuarios.eliminarUsuario(usuario_remover);
        response.put("data","Usuario eliminado exitosamente");
        response.put("error","");
        return response;
    }

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

}
