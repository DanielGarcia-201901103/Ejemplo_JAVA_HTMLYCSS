package ejemplohtmlycss;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class GuardandoDatos {

    Scanner reader = new Scanner(System.in); //Sirve para leer lo ingresado por el usuario
    Scanner readerNum = new Scanner(System.in); //Sirve para leer lo ingresado por el usuario
    Persona[] almacenar = new Persona[6]; // Objeto de clase persona, es un arreglo de objetos
    static int contador = 0;

    public GuardandoDatos() {
    }

    public void ingresando() {
        //ingesa al if solamente si el contador se mantene en el rango de 0 a 5
        if (contador >= 0 && contador <= 5) {

            System.out.println("*********************************************");
            System.out.println("Por favor ingrese el nombre");
            String IngresaNombre = reader.nextLine(); //lee el texto ingresado

            System.out.println("Por favor ingrese el apellido");
            String IngresaApellido = reader.nextLine();//lee el texto ingresado

            System.out.println("Por favor ingrese su altura");
            String IngresaAltura = readerNum.nextLine();//lee el texto ingresado

            System.out.println("Por favor ingrese su edad");
            String IngresaEdad = readerNum.nextLine();//lee el texto ingresado
            System.out.println("*********************************************\n");

            //almacenando datos
            almacenar[contador] = new Persona(IngresaNombre, IngresaApellido, IngresaAltura, IngresaEdad);
            //enviar.recibiendoDatos();
            contador++;
        }
    }

    public void imprimirDatos() {
        for (int i = 0; i < almacenar.length; i++) {
            if (almacenar[i] != null) {//si el arreglo está vació en una posición no lo imprime
                System.out.println("------------------------------------------");
                System.out.println("Persona" + (i + 1));
                //uso de get para acceder a los datos
                System.out.println("nombre: " + almacenar[i].getNombre()); 
                System.out.println("apellido: " + almacenar[i].getApellido());
                System.out.println("altura: " + almacenar[i].getAltura());
                System.out.println("edad: " + almacenar[i].getEdad());
                System.out.println("------------------------------------------\n");
            }

        }
    }

    public void HTML() throws FileNotFoundException {
        FileOutputStream rep = new FileOutputStream("Reporte 1.html"); //Crea el archivo html
        PrintStream t = new PrintStream(rep); //Permite agregar el contenido del documento
        t.println(
                " <HTML>"
                + "\t<HEAD>\n"
                + "\t <meta charset=\"utf-8\">\n"
                + "\t<TITLE> Ejemplo Personas </TITLE>\n"
                + "\t<LINK REL = StyleSheet HREF = 'style.css'> \n"
                + "\n"
                + "\t</HEAD>\n"
                + "\t<BODY bgcolor =\"DDCCC8\">"
                + "\t<BODY>\n"
                + "\t<CENTER>\n"
                + "\t<h1> <b> Personas </b></h1>\n"
                + "\t<p><h2> A continuación se muestra una tabla con los datos ingresados por el usuario </h2></p>"
                + "\t</CENTER>\n"
        );
        t.println("\t<CENTER>\n"
                + "\t<p>Se tiene los siguientes datos.</p>"
                + "\t<table border=\"1\">"
                + "\t<tr>"
                + "\t<td> Cantidad </td>"
                + "\t<td> Nombre  </td>"
                + "\t<td> Apellido</td>"
                + "\t<td> Edad</td>"
                + "\t<td> Altura</td>"
                + "\t</tr>");
        for (int i = 0; i < almacenar.length; i++) {
            if (almacenar[i] != null) {
                t.println("\t<tr>"
                        + "\t<td>" + (i + 1) + "</td>"
                        + "\t<td>" + almacenar[i].getNombre() + "</td>"
                        + "\t<td>" + almacenar[i].getApellido() + "</td>"
                        + "\t<td>" + almacenar[i].getEdad() + "</td>"
                        + "\t<td>" + almacenar[i].getAltura() + "</td>"
                        + "\t</tr>");
            }
        }

        t.println("\t</table>" + "\t</CENTER>\n"
        );

        t.println("<BODY>"
                + "</HTML>\n");
        t.close(); //CIERRA EL ARCHIVO HTML DESPUES DE ESCRIBIR EN EL MISMO

        FileOutputStream style = new FileOutputStream("Style.CSS"); //Crea el archivo html
        PrintStream t1 = new PrintStream(style); //Permite agregar el contenido del documento
        t1.println(
                " h1{\n"
                + "    font-family: fontRandom;\n"
                + "    color: red\n"
                + "  }");
        t1.println(
                " h2{\n"
                + "    font-family: fontRandom;\n"
                + "    color: black\n"
                + "  }"
        );
        t1.close();//CIERRA EL ARCHIVO CSS DESPUES DE ESCRIBIR EN EL MISMO
    }
}
