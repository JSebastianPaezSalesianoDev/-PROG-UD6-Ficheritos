package actividad1;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* import java.nio.Buffer;
import java.nio.charset.StandardCharsets; */
import java.util.Scanner;

import actividad1.utility.validLength;

public class App {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        String userOption;

        // pide un texto al usuario, y lo valida para que sea mayor de 30 o igual a +30 caracteres
        //mientras tenga menos de 30 seguira pidiendole al usuario un texto

        do {
            System.out.println("Ingrese un texto mayor o igual a 30 caracteres:");
            userOption = scanner.nextLine();
            validLength.lengthChecker(userOption);
        } while (userOption.length() <= 30);
         
                                            
        // remplaza todos los espacios del userOption con '_'

        String userOptionFormatted = userOption.replace(" ", "_");
        System.out.println("Opción formateada: " + userOptionFormatted);

        String filePath = "src/actividad1/files/output/hola.txt";

        /* byte[] data = userOptionFormatted.getBytes(StandardCharsets.UTF_8); */

        // Crea un Buffer que guardara el FileOutput que contiene el archivo para no cerrar el flujo de datos
        // con un for i itera sobre cada byte/caracter de la cadena formateada y lo guarda con el write en un int con su codificacion 
        // en bytes

        try (BufferedOutputStream buffersito = new BufferedOutputStream(new FileOutputStream(filePath, true))) {
        /* bufferedOutputStream.write(data); */
            for (int i = 0; i < userOptionFormatted.length(); i++) {
                buffersito.write(userOptionFormatted.charAt(i)); // itera cada byte y lo ingresa
            
                
            }
            System.out.println("Opción guardada exitosamente en el archivo: " + filePath);
        } catch (IOException e) {
            System.out.println("ERROR: Error al escribir en el archivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
