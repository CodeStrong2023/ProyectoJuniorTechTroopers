
package modelo;


public class usuario {
    public int id_usuario;
    public String nombre_de_usuario;
    public String contrasena;
    public String correo;
    public int edad;
    public String nombre;
    public String apellido;
    public double saldo;
    
    
    public usuario(int id_usuario, String nombre_de_usuario,String contrasena,String correo,int edad, String nombre, String apellido, double saldo){
        this.id_usuario = id_usuario;
        this.nombre_de_usuario = nombre_de_usuario;
        this.contrasena = contrasena;
        this.correo = correo;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.saldo = saldo;
    }
}