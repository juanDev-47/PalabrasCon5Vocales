/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


El asunto en el email debe ser: tercer examen lógica II [NOMBRE DEL ESTUDIANTE]
Todos los programas deben aceptar como entrada un texto leído desde un archivo tipo txt, o darle al usuario la posibilidad de teclear el texto a ser procesado. Si lo hace desde un archivo tipo txt que el usuario pueda entrar el nombre del archivo a leer.
El texto a procesar puede tener toda clase de símbolos: letras, números, signos de puntuación, caracteres especiales etc.
Lo que no tiene es ni tildes, ni diéresis, ni mayúsculas.

00. Elabore programa de computador independiente de la representación que cuente y muestre cuántas veces está cada palabra 
     que tenga las cinco vocales en un texto dado. Elabore todo método que invoque. Ejemplos: ecuación, adulterio, universitario.

Juan Pablo Arenas Velez C.C:1037633965
 */
package Clases;

import static Clases.Metodos.lectura;
import static Clases.Metodos.lecturaString;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author JUAN
 */
public class Principal {
    public static Scanner lectura = null; 
    public static JFileChooser archivoseleccion = new JFileChooser("."); 
    public static String Linea;
    public static StringTokenizer cantidad;
    public static int cantF = 0;
    public static String[] Vpalabras;
    
    
    public static void main(String[] args) {
       boolean salir = false;
       int opcion; //Guardaremos la opcion del usuario

        JOptionPane.showMessageDialog(null, "Este programa lee un archivo txt\nó texto como entrada por teclado\nLuego cuenta y muestra cuantas palabras tienen las 5 vocales");
      
           do{
               try{
           opcion =  Integer.parseInt(JOptionPane.showInputDialog("        Escribe una de las opciones\n\n"
                                                                + "1. Buscar archivo .txt y mostrar el resultado\n"
                                                                + "2. Ingresar manualmente un texto para procesarlo.\n"
                                                                + "3. salir.\n"
                                                                 ));
            

        switch(opcion){
               case 1:
                   lectura();
                   break;
                   
               case 2:                  
                   String s = (JOptionPane.showInputDialog("Ingrese una frase para procesarla"));
                   lecturaString(s);
                   
//                    System.out.println(s);
                   
                   break; 
                    
                case 3:
                    salir=true;
                    
                    break;
                    
                default:
                   JOptionPane.showMessageDialog(null, "Solo opciones entre 1 y 4");
           }
               }
               catch(NumberFormatException e){
          JOptionPane.showMessageDialog(null, "Presiono cancelar ó aceptar\n sin seleccionar opcion validad", "Presiono cancelar ó aceptar sin seleccionar opcion validad", JOptionPane.ERROR_MESSAGE);
      }     
   
       }while(!salir);
      
    
    }
    
    
}
