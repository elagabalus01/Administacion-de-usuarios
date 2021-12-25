package company.admin_usuarios.data;

import org.springframework.stereotype.Component;

import company.admin_usuarios.modelos.Usuario;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
* Almacena los datos de los usuarios de la aplicación, además de porpcionar
* métodos para agregar, modificar y buscar usuario
*/

@Component // Se define como un java bean para que spring boot pueda inyectar la dependencia
public class RepositorioUsuario{


    private List<Usuario> users = new ArrayList<>();
    // Lleva el conteo de los identificadores asignados
    // cuando se agregar un nuevo usuario se asigna el siguiente de este valor
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
    /**
    * @return La lista de todos los usuarios de la aplicación
    */
    public List<Usuario> todosLosUsuarios(){
        return this.users;
    }

    /**
    * @param id el identificador del usuario a recuperar
    * @return El objeto tipo Usuario que representa a un cliente si se encuentra
    * o null si el usuairo no es encontrado en la lista de usuarios
    */
    public Usuario buscarPorId(int id){
        Usuario usuario_encontrado=null;
        for(Usuario usuario:users){
            if(usuario.getId()==id){
                usuario_encontrado=usuario;
            }
        }
        return usuario_encontrado;
    }

    /**
    * @param nuevo_usuario el objeto tipo Usuario a agregar a la lista de usuarios
    */
    private void _agergarUsuario(Usuario nuevo_usuario){
        users.add(nuevo_usuario);
    }

    /**
    * @param nombre el nombre completo del usaurio a agregar
    * @param correo el correo electrónico del usuario a agregar
    * @return una referencia al nuevo usuario agregado
    */
    public Usuario agregarUsuario(String nombre,String correo){
        this.incrementador_id+=1;
        Usuario nuevo_usuario=new Usuario(this.incrementador_id,nombre,correo);
        users.add(nuevo_usuario);
        return nuevo_usuario;
    }

    /**
    * @param usuario_remover el objeto tipo Usuario que se removerá de la lista de usuarios
    */
    public void eliminarUsuario(Usuario usuario_remover){
        this.users.remove(usuario_remover);
    }
}
