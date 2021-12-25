package company.admin_usuarios.modelos;

/**
* Representa a un usuario o cliente de la aplicación
*/
public class Usuario{

    int id=0;
    String nombre=null;
    String correo=null;
    /**
    * Crea a un usuario con el identificador, el nombre y el correo establecidos
    *   @param id El id del usuario
    *   @param nombre El nombre completo del usuario
    *   @param correo El correo electrónico del usuario
    */
    public Usuario(int id,String nombre,String correo){
        this.id=id;
        this.nombre=nombre;
        this.correo=correo;
    }

    /**
    * Establece el identificador del usuario
    *   @param id El id del usuario
    */
    public void setId(int id){
        this.id=id;
    }

    /**
    * Establece el nombre completo del usuario
    *   @param nombre El nombre completo del usuario
    */
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    /**
    * Establece el correo eléctronico del usuario
    *   @param correo El correo electrónico del usuario
    */
    public void setCorreo(String correo){
        this.correo=correo;
    }

    /**
    *   @return Un entero que representa el id del usuario
    */
    public int getId(){
        return this.id;
    }

    /**
    *   @return Una cadena con el nombre completo del usuario
    */
    public String getNombre(){
        return this.nombre;
    }

    /**
    *   @return Una cadena con el correo eléctronico del usuario
    */
    public String getCorreo(){
        return this.correo;
    }

}
