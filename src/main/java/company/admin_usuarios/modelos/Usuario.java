package company.admin_usuarios.modelos;

public class Usuario{

    int id=0;
    String nombre=null;
    String email=null;
    /**
    *   @param id El id del usuario
    *   @param nombre El nombre completo del usuario
    *   @param email El correo electrónico del usuario
    */
    public Usuario(int id,String nombre,String email){
        this.id=id;
        this.nombre=nombre;
        this.email=email;
    }

    public void setId(int id){
        this.id=id;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public int getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getEmail(){
        return this.email;
    }




}
