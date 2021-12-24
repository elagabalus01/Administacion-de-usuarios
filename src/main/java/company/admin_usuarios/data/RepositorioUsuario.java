package company.admin_usuarios.data;

import org.springframework.stereotype.Component;

import company.admin_usuarios.modelos.Usuario;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class RepositorioUsuario{

    private List<Usuario> users = new ArrayList<>();
    private int incrementador_id=0;

    // public RepositorioUsuario(){
    //     users.addAll(Arrays.asList(
    //         new Usuario(1,"Usuario 1","ejemplo1@compañia.com.mx"),
    //         new Usuario(2,"Usuario 2","ejemplo2@compañia.com.mx"),
    //         new Usuario(3,"Usuario 3","ejemplo3@compañia.com.mx"),
    //         new Usuario(4,"Usuario 4","ejemplo4@compañia.com.mx")
    //         )
    //     );
    //     this.incrementador_id=4;
    // }

    public List<Usuario> todosLosUsuarios(){
        return this.users;
    }

    public Usuario buscarPorId(int id){
        Usuario usuario_encontrado=null;
        for(Usuario usuario:users){
            if(usuario.getId()==id){
                usuario_encontrado=usuario;
            }
        }
        return usuario_encontrado;
    }

    private void _agergarUsuario(Usuario nuevo_usuario){
        users.add(nuevo_usuario);
    }

    public void agergarUsuario(String nombre,String correo){
        this.incrementador_id+=1;
        Usuario nuevo_usuario=new Usuario(this.incrementador_id,nombre,correo);
        users.add(nuevo_usuario);
    }

    public void eliminarUsuario(Usuario usuario_remover){
        this.users.remove(usuario_remover);
    }
}
