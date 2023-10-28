package modelo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Provincias {

    private ArrayList<String> provincias = new ArrayList<>(Arrays.asList(
            "Buenos Aires",
            "Catamarca",
            "Chaco",
            "Chubut",
            "Córdoba",
            "Corrientes",
            "Entre Ríos",
            "Formosa",
            "Jujuy",
            "La Pampa",
            "La Rioja",
            "Mendoza",
            "Misiones",
            "Neuquén",
            "Río Negro",
            "Salta",
            "San Juan",
            "San Luis",
            "Santa Cruz",
            "Santa Fe",
            "Santiago del Estero",
            "Tierra del Fuego",
            "Tucumán"
    ));

    public String getProvincias() {
        boolean salida = false;
        int conteo = 0;
        while (!salida) {
            
            String[] provinciasArray = provincias.toArray(new String[0]);
            conteo++; 
            String localizacion = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una provincia:",
                    "Selección de Provincia",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    provinciasArray,
                    provinciasArray[0]
            );
            
            if (localizacion == null || localizacion.isEmpty()){
                if (conteo == 3) {
                    JOptionPane.showMessageDialog(null, "Volvemos al Menu");
                    salida = true;
                    return null;
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR: Debe seleccionar una Provincia. Intentos restantes: " + (3-conteo));
                }
            } else {
                // TODO: toLowerCase(Locale.ROOT) convierte a minuscula
                salida = true;
                return localizacion.toLowerCase();
            }
        }
        return null;
    }
}
