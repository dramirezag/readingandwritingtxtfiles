/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadsemana2;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
public class Actividadsemana2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        try {
BufferedReader ent = new BufferedReader(new FileReader("ventas.txt"));
             
PrintWriter sal = new PrintWriter(new FileWriter("importar_ventas.txt")); 
PrintWriter salErr = new PrintWriter(System.err, true);

String nitcliente;
String nombrecliente;
String cedulavendedor;
String nombrevendedor;
String totalventas;
StringTokenizer stt;
String linea = ent.readLine();

while (linea != null) {
// se tokeniza la linea leida del archivo
try {
stt = new StringTokenizer(linea, ",");
// se extrae cada uno de los tokens de la línea
nitcliente = stt.nextToken();
nombrecliente = stt.nextToken();
cedulavendedor = stt.nextToken();
nombrevendedor = stt.nextToken();
totalventas = stt.nextToken();

sal.println("" + nitcliente + ", " + nombrecliente + ", " + totalventas);
}
catch (NoSuchElementException nsee) {
salErr.println("No hay datos completos " + linea + " " + nsee.toString());
JOptionPane.showMessageDialog( null,"no hay datos completos " + linea + " " + nsee.toString() , "error",JOptionPane.ERROR_MESSAGE);
}
linea = ent.readLine();
}
salErr.println("Fin");
JOptionPane.showMessageDialog( null,"se termino de crear el archivo, por favor revise el archivo importar_ventas.txt en la carpeta del proyecto "  , "exito",JOptionPane.INFORMATION_MESSAGE);
ent.close(); 
sal.close();
        }
        catch (FileNotFoundException e){
        JOptionPane.showMessageDialog( null,"Por favor coloque el archivo ventas.txt en la carpeta del proyecto " + e , "error",JOptionPane.ERROR_MESSAGE);
        }
       

    }
    
}
