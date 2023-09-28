
package modelo;

public class alojamiento_hospedaje {
    public int id_alojamiento;
    public String nombre;
    public String tipo;
    public int capacidad;
    public String localizacion;
    public double precion_por_noche;
    public boolean estado;
    public int id_usuario;
    public int id_inquilino;
    public String estadia; 
    
    public alojamiento_hospedaje(int id_alojamiento, String nombre, String tipo, int capacidad, String localizacion, double precio_por_noche, boolean estado, int id_usuario, int id_inquilino, String estadia){
    
        this.id_alojamiento = id_alojamiento;
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidad = capacidad; 
        this.localizacion = localizacion; 
        this.precion_por_noche = precion_por_noche;
        this.estado = estado; 
        this.id_usuario = id_usuario;
        // this.id_inquilino = id_inquilino;
        this.estadia = estadia;
        
    }
    
}
