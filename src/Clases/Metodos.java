/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import static Clases.Principal.Linea;
import static Clases.Principal.Vpalabras;
import static Clases.Principal.archivoseleccion;
import static Clases.Principal.cantF;
import static Clases.Principal.cantidad;
import static Clases.Principal.lectura;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;


/**
 *
 * @author JUAN
 */
public class Metodos {
    public static Scanner lectura = null; 
    public static Scanner lecturaString = null; 
    public static JFileChooser archivoseleccion = new JFileChooser("."); 
    public static String Linea;
    public static String Linea2;
    public static StringTokenizer cantidad;
    public static StringTokenizer cantPalabras;
    public static int cantF = 0;
    public static String[] Vpalabras = new String[500];
    public static int cantF2 = 0;
    public static String[] Vpalabras2 = new String[500];
    public static int[] vocales2 = new int[5];
    public static int[] vocales = new int[5];
    public static int conteoF2 = 0;
    public static int conteoF1 = 0;
    public static String caracteres[] = {")","(","]","[","}","{","¬","!","\"","#","$","%","&","/","=","?","¡","¿","'","\\","´","¨","+","*","~","^","`","-","_",".",":",",",";","<",">","1","2","3","4","5","6","7","8","9","0","@","|","°"};    
    public static int inicio = 0;
    public static int inicio2 = 0; // variables para cortar la palabra correctamente con el metodo subString
    public static int final1 = 0;
    public static int final2 = 0;  
    public static String var = null;
    public static String var1 = null;
    public static String var2;
    public static String var3;
    public static int frec1[] = new int[500];
    public static int frec2[] = new int[500];
    
    
    public static void lectura(){
        try{
                    lectura = null;// Para que siempre abra un archivo nuevo
                    archivoseleccion.showOpenDialog(archivoseleccion);  //Ventana  donde se puede seleccionar archivo a leer    
                    String ruta = archivoseleccion.getSelectedFile().getAbsolutePath(); //String que contiene la ruta del fichero seleccionado
                    File f = new File(ruta);    //Obtener la ruta del archivo
                    lectura = new Scanner(f); 
                    cantF = 0;
                    
                    
                    for (int i = 0; i < Vpalabras.length; i++) {
                        Vpalabras[i] = "null";
                    }
                    
                    while (lectura.hasNext()){
                        Linea = lectura.nextLine().trim();
                        cantPalabras = new StringTokenizer(Linea," "); // para sacar las palabras 
                        
                        while(cantPalabras.hasMoreTokens()){ // ciclo para saber cuantas palabras hay 
                            Vpalabras[cantF] = cantPalabras.nextToken();
                            cantF = 1 + cantF;
                            
                        }
                                                                      
                    }
                    System.out.println("La cantidad total de palabras en el texto es: " + cantF +"\n"); // cantidad de palabras en el texto
                    
                    
                    conteoF1 = 0;
                    
                    for (int l = 0; l < Vpalabras2.length; l++) {
                            frec1[l] = 0;                            
                        }
                    
                    for (int k = 0; k < Vpalabras.length; k++) {
                        for (int i = 0; i < Vpalabras.length; i++) {
                            if (Vpalabras[k] == Vpalabras[i]) {
                                frec1[k] +=1;
                            }
                        }
                                          
                    }
                    
                    for (int i = 0; i < Vpalabras.length; i++) { // proceso para saber cuales palabras tienen las 5 vocales                        
                        vocales[0] = 0;
                        vocales[1] = 0;
                        vocales[2] = 0;
                        vocales[3] = 0;
                        vocales[4] = 0;
                        
                            String aux = Vpalabras[i];
                            for (int j = 0; j < aux.length(); j++) { // saber si tiene las 5 vocales
                                if (aux.charAt(j) == 'a'){
                                    vocales[0] += 1;
                                }else if(aux.charAt(j) == 'e'){
                                    vocales[1] += 1;
                                }else if(aux.charAt(j) == 'i'){
                                    vocales[2] += 1;
                                }else if(aux.charAt(j) == 'o'){
                                    vocales[3] += 1;
                                }else if(aux.charAt(j) == 'u'){
                                    vocales[4] += 1;
                                }
                                if(j == aux.length()-1){
                                    int cont2 = 0;
                                    for (int k = 0; k < 5; k++) {

                                        if (vocales[k] >= 1) {
                                            cont2 +=1;
                                        }
                                    }

                                    if(cont2 >= 5){
                                        conteoF1 += 1; // para ir contando las palabras con 5 vocales
                                        var1 = Vpalabras[i];
                                        var = var1;
                                        for (int k = 0; k < 47; k++) {
                                            
                                            var = var.replace(caracteres[k],"");
                                        }
                                        
                                        
                                        
                                        //Vpalabras[i]
                                        System.out.println("la palabra:"+ var.toLowerCase() + " tiene las 5 vocales (a,e,i,o,u) y se repite: " + frec1[i]);
                                    }
                                }                        
                            }
                            
                    }
                        
                      System.out.println("\nLa cantidad de palabras con almenos las 5 vocales diferentes son: " + conteoF1 + "\n");    
                    
                                                                                               
                   }
                    catch(FileNotFoundException e) { //Si no se encuentra el fichero en la ruta seleccionada
                        System.out.println(e.getMessage());
                   }
                    catch (NullPointerException e) {  //En el caso de no haber seleccionado ningún fichero, porque se ha pulsado el botón cancelar o se ha cerrado la ventana directamente
                            System.out.println("No se ha seleccionado ningún fichero");
                    } catch (Exception e) {
                            System.out.println(e.getMessage());
                            
                    } finally {
                        if (lectura != null) {
                           lectura.close();
                        }
                    }
    }
    
    public static void lecturaString(String s){
                    lecturaString = null;// Para que siempre abra un archivo nuevo
                    lecturaString = new Scanner(s);
                    cantF2 = 0;
                    
                    
                    for (int i = 0; i < Vpalabras2.length; i++) {
                        Vpalabras2[i] = "null";
                    }
                    
                    while (lecturaString.hasNext()){
                        Linea2 = lecturaString.nextLine().trim();
                        cantidad = new StringTokenizer(Linea2," "); // para saber cuantas palabras hay 
                        
                        while(cantidad.hasMoreTokens()){ // ciclo para saber cuantas palabras hay 
                            Vpalabras2[cantF2] = cantidad.nextToken();
                            cantF2 = 1 + cantF2;                            
                        }    
                     }
                    
                    System.out.println("La cantidad total de palabras en el texto es: " + cantF2 +"\n"); // cantidad de palabras en el texto
                    conteoF2 = 0;
                    
                    for (int l = 0; l < Vpalabras2.length; l++) {
                            frec2[l] = 0;                            
                        }
                    
                    for (int k = 0; k < Vpalabras2.length; k++) { // proceso para sacar las frecuencias de las palabras
                        for (int l = 0; l < Vpalabras2.length; l++) {
                            if (Vpalabras2[k] == Vpalabras2[l]) {
                                frec2[k] += 1;;
                            }                            
                        }                                            
                    }
                    
                    for (int i = 0; i < Vpalabras2.length; i++) { // proceso para saber cuales palabras tienen las 5 vocales
                        
                        vocales2[0] = 0;
                        vocales2[1] = 0;
                        vocales2[2] = 0;
                        vocales2[3] = 0;
                        vocales2[4] = 0;
                    
                        
                            String aux2 = Vpalabras2[i];

                            for (int j = 0; j < aux2.length(); j++) { // saber si tiene las 5 vocales
                                if (aux2.charAt(j) == 'a'){
                                    vocales2[0] += 1;
                                }else if(aux2.charAt(j) == 'e'){
                                    vocales2[1] += 1;
                                }else if(aux2.charAt(j) == 'i'){
                                    vocales2[2] += 1;
                                }else if(aux2.charAt(j) == 'o'){
                                    vocales2[3] += 1;
                                }else if(aux2.charAt(j) == 'u'){
                                    vocales2[4] += 1;
                                }
                                
                                
                                if(j == aux2.length()-1){
                                    int cont1 = 0;
                                    for (int k = 0; k < 5; k++) {

                                        if (vocales2[k] >= 1) {
                                            cont1 +=1;
                                        }
                                    }

                                    if(cont1 >= 5){
                                        conteoF2 += 1;
                                        var2 = Vpalabras2[i];
                                        var3 = var2;
                                        
                                        for (int k = 0; k < 47; k++) {                                            
                                            var3 = var3.replace(caracteres[k],"");
                                        }
                                                                               
                                        
                                        System.out.println("la palabra: "+ var3.toLowerCase() + " tiene las 5 vocales (a,e,i,o,u) y se repite: " + frec2[i]);
                                    }
                                }
                            }
                        
                        
                }        
                  System.out.println("\nLa cantidad de palabras con almenos las 5 vocales diferentes son: " + conteoF2 + "\n");  

    }
 
    
    
    
}