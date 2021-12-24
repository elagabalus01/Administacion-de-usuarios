package company.admin_usuarios.modelos;

public class Usuario{

    int id=0;
    String nombre=null;
    String correo=null;
    /**
    *   @param id El id del usuario
    *   @param nombre El nombre completo del usuario
    *   @param correo El correo electrónico del usuario
    */
    public Usuario(int id,String nombre,String correo){
        this.id=id;
        this.nombre=nombre;
        this.correo=correo;
    }

    public void setId(int id){
        this.id=id;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setCorreo(String correo){
        this.correo=correo;
    }

    public int getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getCorreo(){
        return this.correo;
    }




}
