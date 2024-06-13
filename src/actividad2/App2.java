package actividad2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class App2 {
    
    public static void main(String[] args) {

        readFile("src\\actividad2\\files\\input\\examplito.txt");
    }   

    public static void readFile(String filePath){
        
        try(BufferedInputStream buffersito = new BufferedInputStream(new FileInputStream(filePath))) {
            
            int firstChar = buffersito.read(); // guarda el primer byte del archivo en un int
            while (firstChar != -1) { // mientras sea nulo
                System.out.print(Character.toString(firstChar) + "_" + firstChar); // caracter en asci y el codigo
                firstChar = buffersito.read();  
                if (firstChar == -1) {
                    System.out.println(".");  // punto final
                    
                }
                System.out.print(", "); // separador de caracteres
            }
            buffersito.close();
            
            
        } catch (IOException e) {
            System.out.println("Execpcion I/O");
        } 
        
    }
}
