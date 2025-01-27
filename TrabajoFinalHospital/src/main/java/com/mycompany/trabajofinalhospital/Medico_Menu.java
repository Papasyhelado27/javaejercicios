package com.mycompany.trabajofinalhospital;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Medico_Menu {
//Clase Madre
    static class Persona {

        private String identificacion;
        private String nombre;
        private String apellido;
        private String direccion;
        private String telefono;

        public Persona(String identificacion, String nombre, String apellido, String direccion, String telefono) {
            this.identificacion = identificacion;
            this.nombre = nombre;
            this.apellido = apellido;
            this.direccion = direccion;
            this.telefono = telefono;
        }
//Metodos getter y setter corespondiente a los atributos 
        public String getIdentificacion() {
            return identificacion;
        }

        public void setIdentificacion(String identificacion) {
            this.identificacion = identificacion;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public String getDireccion() {
            return direccion;
        }

        public String getTelefono() {
            return telefono;
        }
    }

    static class Medico extends Persona {

        private int edad;
        private String sexo;
        private String especialidad;
        private LocalDate fechaObtencionTitulo;
        private int horasTrabajadas;

        public Medico(String identificacion, String nombre, String apellido, String direccion, String telefono,
                int edad, String sexo, String especialidad, LocalDate fechaObtencionTitulo, int horasTrabajadas) {
            super(identificacion, nombre, apellido, direccion, telefono);
            this.edad = edad;
            this.sexo = sexo;
            this.especialidad = especialidad;
            this.fechaObtencionTitulo = fechaObtencionTitulo;
            this.horasTrabajadas = horasTrabajadas;
        }
//Metodos getter y setter corespondiente a los atributos 

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public void setSexo(String sexo) {
            this.sexo = sexo;
        }

        public void setEspecialidad(String especialidad) {
            this.especialidad = especialidad;
        }

        public void setFechaObtencionTitulo(LocalDate fechaObtencionTitulo) {
            this.fechaObtencionTitulo = fechaObtencionTitulo;
        }

        public void setHorasTrabajadas(int horasTrabajadas) {
            this.horasTrabajadas = horasTrabajadas;
        }
        
        public int getEdad() {
            return edad;
        }

        public String getSexo() {
            return sexo;
        }

        public String getEspecialidad() {
            return especialidad;
        }

        public LocalDate getFechaTitulo() {
            return fechaObtencionTitulo;
        }

        public int getHorasTrabajadas() {
            return horasTrabajadas;
        }
    }

    private static ArrayList<Medico> listaMedicos = new ArrayList<>();
    private static Scanner leer = new Scanner(System.in);
//metodo Principal (main)
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leer.nextInt();
           

            switch (opcion) {
                case 1 ->
                    ingresarNuevoMedico();
                case 2 ->
                    mostrarListaMedicos();
                case 3 ->
                    calcularYMostrarSalario();
                case 4 ->
                    mostrarMedicoConMasExperiencia();
                case 5 ->
                    mostrarCantidadMedicosPorSexo();
                case 6 ->
                    System.out.println("Saliendo...");

                default ->
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }
// Metodo mostrar menu con las diferentes opciones
    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Ingresar nuevo médico");
        System.out.println("2. Mostrar lista de todos los médicos almacenados");
        System.out.println("3. Calcular y mostrar salario de cada médico");
        System.out.println("4. Mostrar el médico con más experiencia");
        System.out.println("5. Mostrar cantidad de médicos por sexo");
        System.out.println("6. Salir");
       
        System.out.print("Seleccione una opción: ");
    }
//Ingresar nuevo medico a la lista
    private static void ingresarNuevoMedico() {
        System.out.print("Introduce la identificación: ");
        String identificacion = leer.nextLine();
// Se verifica que la Identificacion no este repetida
        for (Medico medico : listaMedicos) {
            if (medico.getIdentificacion().equals(identificacion)) {
                System.out.println("El médico ya existe. Introduzca otra identificación.");
                return;
            }
        }
// Se asignan los atributos para crear un objeto medico
        System.out.print("Introduce el nombre: ");
        String nombre = leer.nextLine();
        System.out.print("Introduce el apellido: ");
        String apellido = leer.nextLine();
        System.out.print("Introduce la dirección: ");
        String direccion = leer.nextLine();
        System.out.print("Introduce el teléfono: ");
        String telefono = leer.nextLine();
        System.out.print("Introduce la edad: ");
        int edad = leer.nextInt();
        leer.nextLine();  // Limpiar el buffer
        System.out.print("Introduce el sexo (M/F): ");
        String sexo = leer.nextLine();
        System.out.print("Introduce la especialidad: ");
        String especialidad = leer.nextLine();
        System.out.print("Introduce la fecha de obtención del título (dd/MM/yyyy): ");
        String fechaTituloStr = leer.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaObtencionTitulo = LocalDate.parse(fechaTituloStr, formatter);
        System.out.print("Introduce el número de horas trabajadas por semana: ");
        int horasTrabajadas = leer.nextInt();

// Se crea Objeto y se agrega a la lista 
        Medico nuevoMedico = new Medico(identificacion, nombre, apellido, direccion, telefono, edad, sexo, especialidad, fechaObtencionTitulo, horasTrabajadas);
        listaMedicos.add(nuevoMedico);

        System.out.println("Médico añadido exitosamente.");
    }
// se muestra los objetos tipo medicos agregados a la lista
    private static void mostrarListaMedicos() {
        
        // Condicion en caso que no hayan medicos almacenados en la lista
        if (listaMedicos.isEmpty()) {
            System.out.println("No hay médicos almacenados.");
        } else {
            for (Medico medico : listaMedicos) {
                // Calculamos la experiencia en base a la fecha de obttencion del titulo con respecto a la fecha actual
                long experiencia = ChronoUnit.YEARS.between(medico.getFechaTitulo(), LocalDate.now());
                System.out.println("Identificación: " + medico.getIdentificacion()
                        + ", Nombre: " + medico.getNombre() + " " + medico.getApellido()
                        + ", Especialidad: " + medico.getEspecialidad()
                        + ", Experiencia: " + experiencia + " años");
            }
        }
    }
//El método calcularYMostrarSalario solicita el salario por hora según la especialidad 
    //y calcula el salario semanal de cada médico."
    private static void calcularYMostrarSalario() {
        System.out.print("Introduce el salario por hora para Cardiología: ");
        double salarioCardiologia = leer.nextDouble();
        System.out.print("Introduce el salario por hora para Pediatría: ");
        double salarioPediatria = leer.nextDouble();
        System.out.print("Introduce el salario por hora para Dermatología: ");
        double salarioDermatologia = leer.nextDouble();
        System.out.print("Introduce el salario por hora para Neurología: ");
        double salarioNeurologia = leer.nextDouble();
        leer.nextLine();  // Limpiar el buffer

        for (Medico medico : listaMedicos) {
            double salarioPorHora;
            switch (medico.getEspecialidad().toLowerCase()) {
                case "cardiología" ->
                    salarioPorHora = salarioCardiologia;
                case "pediatría" ->
                    salarioPorHora = salarioPediatria;
                case "dermatología" ->
                    salarioPorHora = salarioDermatologia;
                case "neurología" ->
                    salarioPorHora = salarioNeurologia;
                default ->
                    salarioPorHora = 0;
            }
            double salarioSemanal = medico.getHorasTrabajadas() * salarioPorHora;
            System.out.println("Médico: " + medico.getNombre() + " " + medico.getApellido() + " - Salario semanal: $" + salarioSemanal);
        }
    }
//encuentra al médico con la fecha de obtención del título más antigua usando Collections.min
    private static void mostrarMedicoConMasExperiencia() {
        if (listaMedicos.isEmpty()) {
            System.out.println("No hay médicos almacenados.");
            return;
        }
//Este método encuentra el elemento mínimo en una colección.
        Medico medicoConMasExperiencia = Collections.min(listaMedicos, Comparator.comparing(Medico::getFechaTitulo));

        System.out.println("El médico con más experiencia es: " + medicoConMasExperiencia.getNombre() + " " + medicoConMasExperiencia.getApellido());
    }
 // código para contar y mostrar la cantidad de médicos por sexo 
    private static void mostrarCantidadMedicosPorSexo() {
        int masculino = 0;
        int femenino = 0;

        for (Medico medico : listaMedicos) {
            if (medico.getSexo().equalsIgnoreCase("M")) {
                masculino++;
            } else if (medico.getSexo().equalsIgnoreCase("F")) {
                femenino++;
            }
        }

        System.out.println("Cantidad de médicos masculinos: " + masculino);
        System.out.println("Cantidad de médicos femeninos: " + femenino);
    }

}
