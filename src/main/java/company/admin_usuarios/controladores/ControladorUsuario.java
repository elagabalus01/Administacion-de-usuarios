package company.admin_usuarios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    public Usuario usuarioEncontrado(@PathVariable(value="id") int id){
        Usuario usuario_encontrado=null;
        for(Usuario usuario:users){
            if(usuario.getId()==id){
                usuario_encontrado=usuario;
            }
        }

        return usuario_encontrado;
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

}
