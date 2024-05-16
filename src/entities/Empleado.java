package entities;

public class Empleado {
    public String nombre;
    public String apellido;
    public int documento;
    public int diasTrabajados;
    public boolean subsidioTransporte;

    public Empleado(String nombre, String apellido, int documento, int diasTrabajados, boolean subsidioTransporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.diasTrabajados = diasTrabajados;
        this.subsidioTransporte = subsidioTransporte;
    }

    public double calcularTotalBruto() {
        double salarioBasico = 1300000; // Ejemplo de salario básico
        double totalBruto = salarioBasico * (diasTrabajados / 21.0); // Se asume el trabajo en un mes de 21 días
        if (subsidioTransporte) {
            totalBruto += 160000; // Valor del subsidio de transporte para 2024
        }
        return totalBruto;
    }

    public double calcularDescuentos() {
        double salud = calcularTotalBruto() * 0.04; // 4% para salud
        double pension = calcularTotalBruto() * 0.04; // 4% para pensión
        return salud + pension;
    }

    public double calcularDevengos() {
        double salarioBasico = 1300000; // Ejemplo de salario básico
        double devengos = salarioBasico * (diasTrabajados / 21.0); // Se asume el trabajo en un mes de 21 días
        if (subsidioTransporte) {
            devengos += 160000; // Valor del subsidio de transporte para 2024
        }
        return devengos;
    }

    public double calcularNetoAPagar() {
        return calcularDevengos() - calcularDescuentos();
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", documento=" + documento +
                ", días trabajados=" + diasTrabajados +
                ", subsidioTransporte=" + subsidioTransporte +
                '}';
    }
}
