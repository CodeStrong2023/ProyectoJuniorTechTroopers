package modelo;

public class Usuario {
    public int id;
    public String nombre_de_usuario;
    public String contrasenia;
    public String correo;
    public int edad;
    public String nombre;
    public String apellido;
    public double saldo;

    public Usuario(int id, String nombre_de_usuario, String contrasenia, String correo, int edad, String nombre, String apellido, double saldo) {
        this.id = id;
        this.nombre_de_usuario = nombre_de_usuario;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.saldo = saldo;
    }    
    
}
