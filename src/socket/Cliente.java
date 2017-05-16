/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Estudiante
 */
public class Cliente {
    
    public static void main(String[] args) {
        try{
            Socket cliente= new Socket("localhost",8000);  
            InputStream flujoEntrada = cliente.getInputStream();
            OutputStream flujoSalida = cliente.getOutputStream();
            
            BufferedReader lectura= new BufferedReader(new InputStreamReader(flujoEntrada));
            PrintWriter escritura= new PrintWriter(flujoSalida,true);
            
            BufferedReader lecturaUsuario=new BufferedReader(new InputStreamReader(System.in));
            
            String mensajeleido="";
            String mensajeusuario="";
            
            while(true){
                System.out.println("INGRESE EL MENSAJE");
                mensajeusuario=lecturaUsuario.readLine();
                
                mensajeleido = lectura.readLine();
                System.out.println("Me contestaron");
            }               
        }catch(Exception e){   
        }  
    }
}
