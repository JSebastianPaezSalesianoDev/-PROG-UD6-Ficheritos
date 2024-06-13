package actividad4;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import actividad4.mesas.Mesa;
import actividad4.mesas.MesaPersistencia;

public class App4 {
    private static final String FILENAME = "src\\actividad4\\files\\output\\mesitas.txt";
    private static MesaPersistencia persistencia = new MesaPersistencia(FILENAME);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Nueva mesa");
            System.out.println("2. Mostrar todas las mesas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    nuevaMesa(scanner);
                    break;
                case 2:
                    mostrarMesas();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void nuevaMesa(Scanner scanner) {
        System.out.print("Ingrese el color de la mesa: ");
        String color = scanner.nextLine();
        System.out.print("Ingrese el número de patas: ");
        int numeroPatas = scanner.nextInt();
        scanner.nextLine();

        Mesa mesa = new Mesa(color, numeroPatas);
        try {
            persistencia.guardarMesa(mesa);
            System.out.println("Mesa guardada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la mesa: " + e.getMessage());
        }
    }

    private static void mostrarMesas() {
        List<Mesa> mesas = persistencia.obtenerMesas();
        if (mesas.isEmpty()) {
            System.out.println("No hay mesas guardadas.");
        } else {
            for (Mesa mesa : mesas) {
                System.out.println(mesa);
            }
        }
    }
}
