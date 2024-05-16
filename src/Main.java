import java.util.ArrayList;
import java.util.Scanner;
import entities.Empleado;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Empleado> empleados = new ArrayList<>();

        int opcion;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Calcular nómina");
            System.out.println("3. Imprimir reporte");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt()

            switch (opcion) {
                case 1:
                    agregarEmpleado(empleados, scanner);
                    break;
                case 2:
                    calcularNomina(empleados);
                    break;
                case 3:
                    imprimirReporte(empleados);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void agregarEmpleado(ArrayList<Empleado> empleados, Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Documento: ");
        int documento = scanner.nextInt();
        System.out.print("Días trabajados: ");
        int diasTrabajados = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt()
        System.out.print("¿Tiene subsidio de transporte? (true/false): ");
        boolean subsidioTransporte = scanner.nextBoolean();
        scanner.nextLine(); // Consumir el salto de línea después de nextBoolean()

        Empleado empleado = new Empleado(nombre, apellido, documento, diasTrabajados, subsidioTransporte);
        empleados.add(empleado);
        System.out.println("Empleado agregado correctamente.");
    }

    private static void calcularNomina(ArrayList<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            System.out.println("\nEmpleado: " + empleado.nombre + " " + empleado.apellido);
            System.out.println("Total Bruto: " + empleado.calcularTotalBruto());
            System.out.println("Descuentos: " + empleado.calcularDescuentos());
            System.out.println("Devengos: " + empleado.calcularDevengos());
            System.out.println("Vlr. Neto a Pagar: " + empleado.calcularNetoAPagar());
        }
    }

    private static void imprimirReporte(ArrayList<Empleado> empleados) {
        System.out.println("=== Reporte de Nómina ===");
        for (Empleado empleado : empleados) {
            System.out.println("\nEmpleado: " + empleado.nombre + " " + empleado.apellido);
            System.out.println("Documento: " + empleado.documento);
            System.out.println("Días trabajados: " + empleado.diasTrabajados);
            System.out.println("Subsidio de transporte: " + (empleado.subsidioTransporte ? "Sí" : "No"));
            System.out.println("Total Bruto: " + empleado.calcularTotalBruto());
            System.out.println("Descuentos: " + empleado.calcularDescuentos());
            System.out.println("Devengos: " + empleado.calcularDevengos());
            System.out.println("Vlr. Neto a Pagar: " + empleado.calcularNetoAPagar());
        }
    }
}
