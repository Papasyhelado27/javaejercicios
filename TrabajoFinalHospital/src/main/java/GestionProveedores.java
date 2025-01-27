//Programa en Java para gestión de proveedores




import java.util.*;

// Clase para representar a un proveedor
class Proveedor {
    private int identificacion; 
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String tipoProveedor;
    private double valorCompras;

    public Proveedor(int identificacion, String nombre, String apellido, String telefono, String direccion, String tipoProveedor) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipoProveedor = tipoProveedor;
        this.valorCompras = 0;
    }

    // Getters y setters
    public int getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipoProveedor() {
        return tipoProveedor;
    }

    public double getValorCompras() {
        return valorCompras;
    }

    public void aumentarValorCompras(double valor) {
        this.valorCompras += valor;
    }
}

// Clase principal
public class GestionProveedores {

    private static List<Proveedor> proveedores = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    ingresarNuevoProveedor(sc);
                    break;
                case 2:
                    mostrarProveedores();
                    break;
                case 3:
                    mostrarProveedorMayorCompra();
                    break;
                case 4:
                    mostrarListaProveedoresYPago();
                    break;
                case 5:
                    mostrarCantIdentificacionadProveedoresPorTipo();
                    break;
                case 6:
                    mostrarProveedoresOrdenadosPorPago();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 7);
    }

    // Opciones de menú
    private static void mostrarMenu() {
        System.out.println("\n\n**Menú de gestión de proveedores**");
        System.out.println("1. Ingresar nuevo proveedor");
        System.out.println("2. Mostrar todos los proveedores");
        System.out.println("3. Calcular y mostrar proveedor con mayor compra");
        System.out.println("4. Mostrar lista de proveedores y valor a pagar");
        System.out.println("5. Mostrar cantidad de proveedores por tipo");
        System.out.println("6. Mostrar proveedores ordenados por valor a pagar");
        System.out.println("7. Salir");
        System.out.print("Ingrese la opción deseada: ");
    }

    // Métodos para las opciones del menú

    private static void ingresarNuevoProveedor(Scanner sc) {
        System.out.println("\n**Ingreso de nuevo proveedor**");

        System.out.print("Identificacion del proveedor: ");
        int identificacion = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea

        if (existeProveedor(identificacion)) {
            System.out.println("Error: El proveedor con Identificacion " + identificacion + " ya existe. Intente con otro identificacion.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        System.out.print("Dirección: ");
        String direccion = sc.nextLine();

        System.out.print("Tipo de proveedor: ");
        String tipoProveedor = sc.nextLine();

        Proveedor nuevoProveedor = new Proveedor(identificacion, nombre, apellido, telefono, direccion, tipoProveedor);
        proveedores.add(nuevoProveedor);
        System.out.println("Proveedor ingresado exitosamente.");
    }

    private static void mostrarProveedores() {
        if (proveedores.isEmpty()) {
            System.out.println("\nNo hay proveedores registrados.");
            return;
        }

        System.out.println("\n**Lista de proveedores**");
        for (Proveedor proveedor : proveedores) {
            System.out.println("Identificacion: " + proveedor.getIdentificacion());
            System.out.println("Nombre completo: " + proveedor.getNombre() + " " + proveedor.getApellido());
            System.out.println("Teléfono: " + proveedor.getTelefono());
            System.out.println("Dirección: " + proveedor.getDireccion());
            System.out.println("Tipo de proveedor: " + proveedor.getTipoProveedor());
            System.out.println("Valor total de compras: $" + proveedor.getValorCompras());
            System.out.println("------------------------------");
        }
    }

    private static boolean existeProveedor(int identificacion) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getIdentificacion() == identificacion) {
                return true;
            }
        }
        return false;
    }

    private static void mostrarProveedorMayorCompra() {
        if (proveedores.isEmpty()) {
            System.out.println("\nNo hay proveedores registrados.");
            return;
        }

        Proveedor proveedorMayorCompra = null;
        double mayorCompra = 0;

        for (Proveedor proveedor : proveedores) {
            double valorCompraActual = proveedor.getValorCompras();
            if (valorCompraActual > mayorCompra) {
                mayorCompra = valorCompraActual;
                proveedorMayorCompra = proveedor;
            }
        }

        if (proveedorMayorCompra == null) {
            System.out.println("Error: No se pudo identificar al proveedor con mayor compra.");
        } else {
            System.out.println("\n**Proveedor con mayor compra**");
            System.out.println("Identificacion: " + proveedorMayorCompra.getIdentificacion());
            System.out.println("Nombre completo: " + proveedorMayorCompra.getNombre() + " " + proveedorMayorCompra.getApellido());
            System.out.println("Valor total de compras: $" + mayorCompra);
        }
    }

    private static void mostrarListaProveedoresYPago() {
        if (proveedores.isEmpty()) {
            System.out.println("\nNo hay proveedores registrados.");
            return;
        }

        System.out.println("\n**Lista de proveedores y valor a pagar**");
        for (Proveedor proveedor : proveedores) {
            System.out.println("Identificacion: " + proveedor.getIdentificacion());
            System.out.println("Nombre completo: " + proveedor.getNombre() + " " + proveedor.getApellido());
            System.out.println("Valor total de compras: $" + proveedor.getValorCompras());
            System.out.println("------------------------------");
        }
    }

    private static void mostrarCantIdentificacionadProveedoresPorTipo() {
        if (proveedores.isEmpty()) {
            System.out.println("\nNo hay proveedores registrados.");
            return;
        }

        Map<String, Integer> tipoProveedorCount = new HashMap<>();
        for (Proveedor proveedor : proveedores) {
            tipoProveedorCount.put(proveedor.getTipoProveedor(), tipoProveedorCount.getOrDefault(proveedor.getTipoProveedor(), 0) + 1);
        }

        System.out.println("\n**Cantidad de proveedores por tipo**");
        for (Map.Entry<String, Integer> entry : tipoProveedorCount.entrySet()) {
            System.out.println("Tipo de proveedor: " + entry.getKey() + " - Cantidad: " + entry.getValue());
        }
    }

    private static void mostrarProveedoresOrdenadosPorPago() {
        if (proveedores.isEmpty()) {
            System.out.println("\nNo hay proveedores registrados.");
            return;
        }

        List<Proveedor> proveedoresOrdenados = new ArrayList<>(proveedores);
        proveedoresOrdenados.sort((p1, p2) -> Double.compare(p2.getValorCompras(), p1.getValorCompras()));

        System.out.println("\n**Proveedores ordenados por valor a pagar**");
        for (Proveedor proveedor : proveedoresOrdenados) {
            System.out.println("Identificacion: " + proveedor.getIdentificacion());
            System.out.println("Nombre completo: " + proveedor.getNombre() + " " + proveedor.getApellido());
            System.out.println("Valor total de compras: $" + proveedor.getValorCompras());
            System.out.println("------------------------------");
        }
    }
}