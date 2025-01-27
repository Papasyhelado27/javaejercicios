import java.util.ArrayList;
import java.util.Scanner;

public class Menu_Medico {

    private ArrayList<Medico> medicos = new ArrayList<>();

    public void ingresarMedico(Medico medico){
        for (Medico med : medicos){
            if(med.getIdentificacion().equals(medico.getIdentificacion())){
                System.out.println("El medico ya existe. Ingrese otra identificacion");
                return;
            }
        }
        medicos.add(medico);
    }

    public void mostrarMedicos() {
        for (Medico med : medicos) {
            System.out.println("ID: " + med.getIdentificacion() + ", Nombre: " + med.getNombre() + ", Apellido: " + med.getApellido() + ", Edad: " + med.getEdad() + ", Direccion: " + med.getDireccion() + ", Telefono: " + med.getTelefono() + ", Genero: " + med.getGenero() + ", Especialidad: " + med.getEspecialidad() + ",Fecha de grado: " + med.getFechagrado() + ", Horas trabajadas: " + med.getHorastrabajadas());
        }
    }

    public static void mostrarMenu() {
        
        Scanner scanner = new Scanner(System.in);
        Menu_Medico medico = new Menu_Medico();
    


        while (true) {
            System.out.println("\nMenú de Medico:");
            System.out.println("1. Ingresar un nuevo Medico");
            System.out.println("2. Mostrar todos lo medicos");
            System.out.println("3. Mostrar el salario de cada medico"); //mostrar el salario de cada medico, segun su especialidad
            System.out.println("4. mostrar el nombre y el apellido del médico con más experiencia.");
            System.out.println("5. Mostrar cuántos médicos hay de cada sexo. ");
            System.out.println("6. Volver al menu anterior. ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la identificación: ");
                    String id = scanner.next();
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.next();
                    System.out.print("Ingrese el apellido: ");
                    String apellido = scanner.next();
                    System.out.print("Ingrese la edad: ");
                    int edad = scanner.nextInt();
                    System.out.print("Ingrese la direccion: ");
                    String direccion = scanner.next();
                    System.out.print("Ingrese el telefono: ");
                    String telefono = scanner.next();
                    System.out.print("Ingrese el Genero F o M: ");
                    String genero = scanner.next();
                    System.out.print("Ingrese el cargo: ");
                    System.out.print("\nCargos: ");
                    System.out.println("\nNutricionista");
                    System.out.println("Pediatra");
                    System.out.println("Odontologia"); 
                    System.out.println("Doctor");
                    String especialidad = scanner.next();
                    System.out.println("Ingrese Dia / mes / año de obtencion de grado");
                    String fecha_grado = scanner.next();
                    System.out.println("ingrese la cantidad de horas trabajadas");
                    int horas_trabajadas = scanner.nextInt();

                    Medico nuevoMedico = new Medico(id, nombre, apellido, edad, direccion, telefono, genero, especialidad, fecha_grado, horas_trabajadas);
                    medico.ingresarMedico(nuevoMedico);
                    break;
                case 2:
                    medico.mostrarMedicos();
                    break;
                case 3:
                    //
                    break;
                case 4:
                    //
                    break;
                case 5:
                    //
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }
}
    
