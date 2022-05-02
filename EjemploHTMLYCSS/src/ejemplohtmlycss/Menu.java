package ejemplohtmlycss;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Menu {
    GuardandoDatos ingresadatos = new GuardandoDatos(); // instancia de la clase
    Scanner ingresar = new Scanner(System.in); //Sirve para leer lo ingresado por el usuario
    public Menu() throws FileNotFoundException {
        mPrincipal(); //accede al metodo
    }
    public void mPrincipal() throws FileNotFoundException{
        try { //captura errores durante la ejecución
            int opcion;                //variable para guardar la opcion a elegir
            do {
                System.out.println("------Menu Principal------\n" //imprime las opciones
                        + "1. Ingresar datos\n"
                        + "2. Imprimir datos\n"
                        + "3. Crear HTML\n"
                        + "4. Salir\n");

                System.out.println("Ingrese una opción:");
                opcion = ingresar.nextInt(); //guarda la opción ingresada por el usuario
                switch (opcion) { //De acuerdo a la opcion ingresada ingresa al caso correspondiente
                    case 1:
                        ingresadatos.ingresando(); //ingresa al metodo para ingresar datos
                        break;
                    case 2:
                        ingresadatos.imprimirDatos(); //ingresa al metodo para imprimir los datos
                        break;
                    case 3:
                        ingresadatos.HTML(); // ingresa al metodo para crear el archivo html y css
                        System.out.println("Se ha creado el archivo correctamente\n");
                        break;
                    case 4:
                        System.exit(0); //sale del programa
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                        break;
                }
            } while (opcion != 4);
        } catch (Exception e) {
            System.out.println("Formato incorrecto");
        }
    }
}