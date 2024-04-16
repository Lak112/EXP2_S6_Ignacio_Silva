/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package teatromoro;

/**
 *
 * @author ignac
 */
import java.util.Scanner;

public class TeatroMoro {
    
    static int totalIngresos = 0;
    static int totalEntradasVendidas = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenido al Teatro Moro");
        
        
        int opcion;
        do {
            // Mostrar menu 
            System.out.println("\nMenu:");
            System.out.println("1. Comprar entradas");
            System.out.println("2. Imprimir boleta");
            System.out.println("3. Promociones");
            System.out.println("4. Ver entradas vendidas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = input.nextInt();
            input.nextLine(); 
            
            switch (opcion) {
                case 1:
                    comprarEntradas(input);
                    break;
                case 2:
                    imprimirBoleta();
                    break;
                case 3:
                    mostrarPromociones();
                    break;
                case 4:
                    verEntradasVendidas();
                    break;
                case 5:
                    System.out.println("Gracias por utilizar nuestro servicio.");
                    break;
                default:
                    System.out.println("Opcion no valida. Seleccione una opcion valida.");
                    break;
            }
        } while (opcion != 5);

        input.close();
    }

    public static void comprarEntradas(Scanner input) {
        System.out.println("Seleccion de Entradas:");
        System.out.println("Por favor, seleccione el tipo de entrada (VIP, Platea Baja, Platea Alta, Palcos):");
        String tipoEntrada = input.nextLine().toLowerCase();

        int precioBase = 0;
      
        precioBase = condicionEntrada(tipoEntrada);
        if (precioBase == 0) {
            System.out.println("Tipo de entrada no valida.");
            return;
        }
        
        // Preguntar el tipo de persona
        String tipoPersona;
        do {
            System.out.println("Es usted estudiante, adulto mayor o publico general?");
            tipoPersona = input.nextLine().toLowerCase();
        } while (!tipoPersona.equals("estudiante") && !tipoPersona.equals("publico general") && !tipoPersona.equals("adulto mayor"));

        // Aplicar descuentos correspondientes
        if (tipoPersona.equals("estudiante")) {
            precioBase *= 0.9; // Descuento del 10% para estudiantes
        } else if (tipoPersona.equals("adulto mayor")) {
            precioBase *= 0.85; // Descuento del 15% para adulto mayor
        }

        // Registrar la entrada vendida
        totalEntradasVendidas++;
        totalIngresos += precioBase;

        // Muestra informacion de la entrada vendida
        System.out.println("Compra realizada exitosamente:");
        System.out.println("Tipo de entrada: " + tipoEntrada);
        System.out.println("Tipo de persona: " + tipoPersona);
        System.out.println("El valor a pagar es: $" + precioBase);
    }

    public static void imprimirBoleta() {
        System.out.println("\nBoleta:");
        System.out.println("Cantidad de entradas vendidas: " + totalEntradasVendidas);
        System.out.println("Total de ingresos: $" + totalIngresos);
    }

    public static void mostrarPromociones() {
        System.out.println("\nPromociones disponibles:");
        System.out.println("- Descuento del 10% para estudiantes.");
        System.out.println("- Descuento del 15% para adultos mayores.");
    }

    public static void verEntradasVendidas() {
        System.out.println("\nEntradas vendidas:" + totalEntradasVendidas);
        System.out.println("Ingresos: " + totalIngresos);
        
    }
    public static int condicionEntrada (String tipoEntrada){
        int precioBase = 0;
        if (tipoEntrada.equals("vip")) {
            precioBase = 25000;
        } else if (tipoEntrada.equals("platea baja")) {
            precioBase = 19000;
        } else if (tipoEntrada.equals("platea alta")) {
            precioBase = 11000;
        } else if (tipoEntrada.equals("palcos")) {
            precioBase = 7200;
        }
        return precioBase;
    }
}