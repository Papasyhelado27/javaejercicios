/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadestruct;

import javax.swing.JOptionPane;

/**
 *
 * @author salaj
 */
public class recursividad {
    
    public static int factorial (int n){
    
    if(n <=1){
        
        
        return 1;
    }
    else{
           System.out.println(n);
     return factorial(n-1);
     

}
  
}
    
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese Un numero"));
        
        System.out.println(factorial(n));
    }
}
