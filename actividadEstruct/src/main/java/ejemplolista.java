
import javax.swing.JOptionPane;

public class ejemplolista {

    public static void main(String[] args) {

        bolsa l = new bolsa();
        while (true) {
            String opcion = JOptionPane.showInputDialog(""
                    + "1. Introducir un objeto  a la bolsa \n"
                    + "2. buscar un objeto en el bolso \n"
                    + "3. Mostrar todos los objetos \n"
                    + "4. Salir  \n"
                    );

            int opc = Integer.parseInt(opcion);

            if ((opc >= 5) || (opc == 0)) {
                JOptionPane.showMessageDialog(null, "el numero ingresado no se encuentra en el rango del menu");
            }

              
            switch (opc) {
                case 1:
                    String Dato = JOptionPane.showInputDialog("Igrese nuevo objeto en la bolsa ");
                    int datolista = Integer.parseInt(Dato);
                    l.insertarcabeza(datolista);
                    break;
                case 2:
                    String Busc = JOptionPane.showInputDialog("que dato desea buscar ");
                    int bus = Integer.parseInt(Busc);
                      nodo n = l.buscar(bus);
                    System.out.println(" este es el numero buscado " + n.dato);
                    break;

                case 3:
                    l.visualizar();
                    System.out.println(" ");
                    break;

                case 4:
                    
                    System.exit(0);
                    break;

               
            }
        }
    }
}