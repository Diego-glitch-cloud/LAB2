import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean salir = false; // Variable para controlar el ciclo del menú
        String menu = """
                Seleccione el número de la opción que desea realizar:
                1. Agregar contenedor
                2. Eliminar contenedor
                3. Mover Contenedor
                4. Mostrar información de los contenedores en una sección.
                5. Salir
                """; // En la opción 4 también se muestra el peso
        String secciones = """
                    Secciones:
                    1. Productos electrónicos
                    2. Ropa
                    3. Alimentos
                    4. Maquinaria
                """;
        int id = 0;
        int opcion_seccion; // se utiliza para que el usuario ingrese la sección que desea manipular
        String producto;

        // Creación de secciones
        Seccion electronicos = new Seccion(1);
        Seccion ropa = new Seccion(2);
        Seccion alimentos = new Seccion(3);
        Seccion maquinaria = new Seccion(4);

        while (!salir) {
            System.out.println(secciones);
            System.out.print("Escoja la sección que desea manipular: ");
            opcion_seccion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            Seccion seccion;
            switch (opcion_seccion) {
                case 1:
                    seccion = electronicos;
                    break;
                case 2:
                    seccion = ropa;
                    break;
                case 3:
                    seccion = alimentos;
                    break;
                case 4:
                    seccion = maquinaria;
                    break;
                default:
                    seccion = electronicos;
                    break;

            }

            System.out.println(menu);
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                // Agregar un contenedor a una sección
                case 1:
                    System.out.print("¿Cuál es el producto que almacena este contenedor?");
                    producto = scanner.nextLine();
                    id += 1;
                    seccion.agregarContenedor(new Contenedor(id, producto, opcion_seccion));
                    break;

                // Eliminar Contenedor
                case 2:
                    System.out.println("""
                                1. Eliminar por medio de ID
                                2. Eliminar último contenedor
                            """);
                    System.out.print("Escoja la opción que desee: ");
                    int opcion_eliminar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:
                    System.out.println("Saliendo...");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

    }
}