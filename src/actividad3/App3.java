package actividad3;

/* import java.io.BufferedOutputStream; */
import java.io.BufferedWriter;
import java.io.FileInputStream;
/* import java.io.FileOutputStream; */
import java.io.FileWriter;
import java.io.IOException;
/* import java.io.Writer; */

public class App3 {

    public static void main(String[] args) {
        readfile("src\\actividad1\\files\\output\\hola.txt", "src\\actividad2\\files\\examplito.txt");
    }

    public static void readfile(String firstFilePath, String secondFilePath) {
        try (FileInputStream firstFileInputStream = new FileInputStream(firstFilePath); // almacena el primer fichero
                BufferedWriter buffersito = new BufferedWriter(
                        new FileWriter("src\\actividad3\\files\\output\\thirdFile.txt", true));

                FileInputStream secondFileInputStream = new FileInputStream(secondFilePath)) {
            String message1 = "El contenido del primer archivo es: ";
            String message2 = "El contenido del segundo archivo es: ";
            String firmas = "Modificado por Juan y Fran";
            buffersito.write(message1);
            int firstFileread = firstFileInputStream.read();
            while (firstFileread != -1) {

                buffersito.write(firstFileread);
                firstFileread = firstFileInputStream.read();
            }
            buffersito.write('\n');

            buffersito.write(message2);
            int secondFileread = secondFileInputStream.read();
            while (secondFileread != -1) {
                buffersito.write(secondFileread);
                secondFileread = secondFileInputStream.read();
            }
            buffersito.write("\n" + firmas);

        } catch (IOException e) {
            System.out.println("I/O EXCEPTION");
        }
    }
}
