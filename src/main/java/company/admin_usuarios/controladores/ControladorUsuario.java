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

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class ControladorUsuario{

    private List<Usuario> users = new ArrayList<>();

    public ControladorUsuario(){
        users.addAll(Arrays.asList(
            new Usuario(1,"Usuario 1","ejemplo1@compañia.com.mx"),
            new Usuario(2,"Usuario 2","ejemplo2@compañia.com.mx"),
            new Usuario(3,"Usuario 3","ejemplo3@compañia.com.mx"),
            new Usuario(4,"Usuario 4","ejemplo4@compañia.com.mx")
            )
        );
    }

    @GetMapping("/usuario")
    public Iterable<Usuario> todos(){
        return users;
    }

    @GetMapping("/usuario/{id}")
    public HashMap<String,String> usuarioEncontrado(@PathVariable(value="id") int id){
        HashMap<String,String> response=new HashMap<String,String>();
        Usuario usuario_encontrado=null;
        for(Usuario usuario:users){
            if(usuario.getId()==id){
                usuario_encontrado=usuario;
            }
        }
        if(usuario_encontrado==null){
            response.put("data","");
            response.put("error","No se encontró al usuario con el id "+String.valueOf(id));
            return response;
        }
        response.put("data",usuario_encontrado.toString());
        response.put("error","No se encontró al usuario con el id "+String.valueOf(id));
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

        int id=users.size()+1;
        String nombre=input.get("nombre");
        String correo=input.get("correo");

        Usuario nuevo_usuario=new Usuario(id,nombre,correo);
        users.add(nuevo_usuario);
        response.put("data","Hecho");
        response.put("error","");
        return response;
    }

    @DeleteMapping("/usuario/{id}")
    public HashMap<String,String> removerUsuario(@PathVariable(value="id") int id){
        HashMap<String,String> response=new HashMap<String,String>();
        Usuario usuario_remover=null;
        for(Usuario usuario:users){
            if(usuario.getId()==id){
                usuario_remover=usuario;
            }
        }
        if(usuario_remover==null){
            response.put("data","");
            response.put("error","No existe el usario con el id "+String.valueOf(id));
        }
        users.remove(usuario_remover);
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
        for(Usuario usuario:users){
            if(usuario.getId()==id){
                usuario_actualizar=usuario;
            }
        }
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
