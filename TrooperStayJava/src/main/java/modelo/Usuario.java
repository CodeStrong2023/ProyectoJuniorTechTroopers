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
    public Usuario() {
    }

    public Usuario(int id, String nombre_de_usuario, double saldo) {
        this.id = id;
        this.nombre_de_usuario = nombre_de_usuario;
        this.saldo = saldo;
    }

}

