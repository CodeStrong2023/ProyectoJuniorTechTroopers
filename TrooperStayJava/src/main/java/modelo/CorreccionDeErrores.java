package modelo;

import database.ObtenerInformacion;
import javax.swing.JOptionPane;

public class CorreccionDeErrores {

    ObtenerInformacion ObtenerInformacion = new ObtenerInformacion();

    public String correccionString(String dato) {
        int conteo = 0;

        while (conteo < 3) {
            String texto = JOptionPane.showInputDialog(dato);
            conteo++;
            if (conteo != 3) {
                if (texto == null || texto.isEmpty() && conteo < 3) {
                    // Si el texto es nulo o está vacío, pedir al usuario que ingrese un texto no nulo.
                    JOptionPane.showMessageDialog(null, "ERROR: No puede estar vacío. Intentos restantes: " + (3 - conteo));
                } else if (texto.length() < 6 || texto.length() > 8 && conteo < 3) {
                    // Si el texto tiene menos de 6 o más de 8 caracteres, pedir al usuario que ingrese un texto con la longitud adecuada.
                    JOptionPane.showMessageDialog(null, "ERROR: Debe tener entre 6 y 8 caracteres. Intentos restantes: " + (3 - conteo));
                } else {
                    // Si el texto cumple con los requisitos, simplemente lo devolvemos sin cambios.
                    return texto;
                }
            }
        }

        JOptionPane.showMessageDialog(
                null, "Volvemos al menú principal");

        return null; // Retorna null para indicar que no se pudo obtener un valor válido después de tres intentos.
    }

    public String correccionNombreApellido(String dato) {
        int conteo = 0;

        while (conteo < 3) {
            String texto = JOptionPane.showInputDialog(dato);
            conteo++;
            if (texto == null || texto.isEmpty() && conteo < 3) {
                    // Si el texto es nulo o está vacío, pedir al usuario que ingrese un texto no nulo.
                    JOptionPane.showMessageDialog(null, "ERROR: No puede estar vacío. Intentos restantes: " + (3 - conteo));
                } else {
                    // Si el texto cumple con los requisitos, simplemente lo devolvemos sin cambios.
                    return texto;
                }
        }

        JOptionPane.showMessageDialog(
                null, "Volvemos al Menu");

        return null; // Retorna null para indicar que no se pudo obtener un valor válido después de tres intentos.
    }

    public Integer correccionInt(String mensaje) {
        int numero = 0;
        int conteo = 0;
        String input = JOptionPane.showInputDialog(mensaje);
        try {
            numero = Integer.parseInt(input);
            if (numero >= 18) {
                return numero;
            }
        } catch (NumberFormatException e) {
            // Error al convertir a entero
        }
        JOptionPane.showMessageDialog(null, "ERROR: Debe ser mayor de 18 años");
        JOptionPane.showMessageDialog(null, "Volvemos al Menu");
        return 0;
    }
    
   public double correccionPrecio(String mensaje) {
    int conteo = 0;
    
    while (conteo < 3) {
        String input = JOptionPane.showInputDialog(mensaje);
        
        if (input == null || input.isEmpty()){
            input = "0.0";
        }
            
        
        try {
            double numero = Double.parseDouble(input);

            if (numero > 0.0) {
                return numero;
            }
        } catch (NumberFormatException e) {
            // Error al convertir a número decimal
        }

        if (conteo < 2) {
            JOptionPane.showMessageDialog(null, "ERROR: Debe ser un número mayor a cero. Intentos restantes: " + (3 - conteo));
        } else {
            JOptionPane.showMessageDialog(null, "Volvemos al Menú");
        }
        
        conteo++;
    }
    
    return 0.0; // Devolvemos 0.0 si el usuario no ingresa un número válido en tres intentos.
}


    public Integer correccionInt2(String mensaje) {
        int conteo = 0;

        while (conteo < 3) {

            String input = JOptionPane.showInputDialog(mensaje);
            conteo++;
            if (conteo != 3) {
                try {
                    int numero = Integer.parseInt(input);

                    if (numero > 0 && numero < 30) {
                        return numero;
                    }
                } catch (NumberFormatException e) {
                    // Error al convertir a entero
                }

                JOptionPane.showMessageDialog(null, "ERROR: Debe ser un número mayor a cero y menor a 30. Intentos restantes: " + (3 - conteo));
                

            }
        }
        JOptionPane.showMessageDialog(null, "Volvemos al Manu");
        return 0; // Devolvemos null si el usuario no ingresa un número válido en tres intentos.
    }

    public String correccionCorreo(String dato) {
        int conteo = 0;

        while (conteo < 3) {
            String texto = JOptionPane.showInputDialog(dato);
            conteo++;
            if (conteo != 3) {
                if (texto == null || texto.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ERROR: el correo no puede estar vacío. Intentos restantes: " + (3 - conteo));
                } else if (!texto.contains("@") || !texto.contains(".com")) {
                    JOptionPane.showMessageDialog(null, "ERROR: Correo electrónico incorrecto. Intentos restantes: " + (3 - conteo));

                } else {
                    return texto;
                }
            }

        }

        // Si después de 3 intentos no se proporciona un correo válido, puedes manejar el flujo de tu programa como lo desees, por ejemplo, lanzando una excepción o devolviendo un valor predeterminado.
        return "Correo no válido"; // O puedes lanzar una excepción aquí.
    }

    public String correccionUsuario(String dato) {
        int conteo = 0;

        while (conteo < 3) {
            String texto = JOptionPane.showInputDialog(dato);
            conteo += 1;
            if (conteo != 3) {
                if (texto == null || texto.isEmpty()) {
                    // Si el texto es nulo o está vacío, pedir al usuario que ingrese un texto no nulo.
                    JOptionPane.showMessageDialog(null, "El usuario no puede estar vacío. Intentos restantes: " + (3 - conteo));
                } else if (ObtenerInformacion.verificarUsuario(texto)) {
                    // Si el usuario ya existe, mostrar un mensaje de error.
                    JOptionPane.showMessageDialog(null, "El usuario ya existe. Intentos restantes: " + (3 - conteo));
                    conteo += 1;
                } else if (texto.length() < 6 || texto.length() > 8) {
                    // Si el texto tiene menos de 6 o más de 8 caracteres, pedir al usuario que ingrese un texto con la longitud adecuada.
                    JOptionPane.showMessageDialog(null, "El usuario debe tener entre 6 y 8 caracteres. Intentos restantes: " + (3 - conteo));
                } else {
                    return texto;
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Volvemos al Menu ");
        return null; // Retorna null para indicar que no se pudo obtener un valor válido después de tres intentos.
    }

}