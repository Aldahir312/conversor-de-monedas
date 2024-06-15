import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("""
                    ****************************************
                    Bienvenid@ al conversor de monedas!

                    1) Dolar ==> Peso Mexicano
                    2) Peso Mexicano ==> Dolar
                    3) Dolar ==> Peso Argentino
                    4) Peso Argentino ==> Dolar
                    5) Dolar ==> Peso Colombiano
                    6) Peso Colombiano ==> Dolar
                    7) Salir
                    Elija una opción valida:
                    ****************************************""");
            ConsultaConversiones consulta = new ConsultaConversiones();
            try {
                var opcion = Integer.parseInt(lectura.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el valor en dólares a convertir a pesos mexicanos:");
                        double dolarPesoMex = Double.parseDouble(lectura.nextLine());
                        consulta.tasaConversion("USD", "MXN", dolarPesoMex);
                        break;
                    case 2:
                        System.out.println("Ingrese el valor en pesos mexicanos a convertir a dólares:");
                        double pesoMexDolar = Double.parseDouble(lectura.nextLine());
                        consulta.tasaConversion("MXN", "USD", pesoMexDolar);
                        break;
                    case 3:
                        System.out.println("Ingrese el valor en dólares a convertir a pesos argentinos:");
                        double dolarPesoArg = Double.parseDouble(lectura.nextLine());
                        consulta.tasaConversion("USD", "MXN", dolarPesoArg);
                        break;
                    case 4:
                        System.out.println("Ingrese el valor en pesos argentinos a convertir a dólares:");
                        double pesoArgDolar = Double.parseDouble(lectura.nextLine());
                        consulta.tasaConversion("MXN", "USD", pesoArgDolar);
                        break;
                    case 5:
                        System.out.println("Ingrese el valor en dólares a convertir a pesos colombianos:");
                        double dolarPesoCol = Double.parseDouble(lectura.nextLine());
                        consulta.tasaConversion("USD", "MXN", dolarPesoCol);
                        break;
                    case 6:
                        System.out.println("Ingrese el valor en pesos colombianos a convertir a dólares:");
                        double pesoColDolar = Double.parseDouble(lectura.nextLine());
                        consulta.tasaConversion("MXN", "USD", pesoColDolar);
                        break;
                    case 7:
                        System.out.println("Gracias por usar el conversor de monedas.");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                        break;

                }
            } catch (NumberFormatException e) {
                System.out.println("La entrada no es valida, ingrese un numero por favor!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando");
            }
        }
    }
}