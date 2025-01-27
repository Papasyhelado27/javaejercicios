package com.mycompany.actividadestruct;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        // Crear una lista vacía
        lista miLista = new lista();

        // Agregar algunos nodos a la lista usando el método insertarcabeza
        miLista.insertarcabeza("Juan", 25, 5, "123", 101);
        miLista.insertarcabeza("Maria", 30, 7, "456", 102);
        miLista.insertarcabeza("Luis", 22, 3, "789", 103);

        // Visualizar la lista completa
        System.out.println("Lista completa:");
        miLista.visualizar();  // Debería mostrar los nodos agregados

        // Pedir datos al usuario para insertar un nuevo nodo
        String name = JOptionPane.showInputDialog("Ingresa el nombre:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la edad:"));
        int cantDias = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad de días:"));
        String id = JOptionPane.showInputDialog("Ingresa el ID:");
        int habitacion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de habitación:"));
        
        // Insertar el nuevo nodo en la lista
        miLista.insertarcabeza(name, edad, cantDias, id, habitacion);
        
        // Volver a visualizar la lista después de agregar el nuevo nodo
        System.out.println("\nLista después de insertar un nuevo nodo:");
        miLista.visualizar();
        
        // Buscar un nodo específico en la lista
        Nodo nodoBuscado = miLista.buscar(name, edad, cantDias, id, habitacion);
        if (nodoBuscado != null) {
            System.out.println("\nNodo encontrado: " + nodoBuscado.name + " " + nodoBuscado.Id);
        } else {
            System.out.println("\nNodo no encontrado.");
        }
    }
}