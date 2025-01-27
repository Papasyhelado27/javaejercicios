
import java.util.Scanner;
import javax.swing.JOptionPane;


 
public class Arreglos {
    
    public static void main(String[] args) {
         Scanner entrada = new Scanner(System.in);
    int num = 0;
        
          num = Integer.parseInt(JOptionPane.showInputDialog("Igrese cantidad de vaores a Ingresar"));
          
        
        if (num < 2) {
            JOptionPane.showMessageDialog(null, "Ell arreglo debe tener minimo 3 vaores.");
            return;
        }
        
        int [] arrglo = new int[num];
        
        for(int i =0;i<num;i++){
           
            arrglo [i] =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor # "+(i+1)));
            
        }
        
        
        }
    }
    

