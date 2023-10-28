package formulario;

import javax.swing.JOptionPane;

public class Menu {

    boolean salir = false;
    Login lo = new Login();
    Registro re = new Registro();


    
   

    public void Menu() {
        while (!salir) {
            //Creamos un arreglo que contenga los elementos del panel de opciones
            String [] arreglo = {"Iniciar Sesión", "Registrarte", "Salir"};
            // usamos el comando de JOptionPane.showOptionDiaglog te permite seleeccional opciones
            int opcion = JOptionPane.showOptionDialog(null, "Elige una opción", "MENU PRINCIPAL", 0, JOptionPane.QUESTION_MESSAGE, null, arreglo, "");
            
            //Por medio de un SWITCH derivamos la opcion seleccionada en base a la posicion del arreglo
            switch (opcion) {
                case 0:
                    // Lógica para iniciar sesión
                    lo.iniciarSesion();
                    break;
                case 1:
                    // Lógica para registrarse
                    re.registrarUsuario();
                    break;
                default:
                    // Cualquier otra opcion sale
                    salir = true;
                    break;
            }
        }
    }

  
}