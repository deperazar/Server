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

/**
 *
 * @author Estudiante
 */
public class Servidor {
    public static void main(String[] args) throws IOException {
        try{
            ServerSocket serverSocket=new ServerSocket(8000);
            System.out.println("SERVIDOR ESPERANDO");
            java.net.Socket cliente = serverSocket.accept();
            System.out.println("Se ha conectado un cliente");
            
            InputStream flujoEntrada = cliente.getInputStream();
            OutputStream flujoSalida = cliente.getOutputStream();
            
            BufferedReader lectura= new BufferedReader(new InputStreamReader(flujoEntrada));
            PrintWriter escritura= new PrintWriter(flujoSalida,true);
 
            String mensajeleido="";
            while(true){
                mensajeleido=lectura.readLine();
                escritura.println("ECO: "+ mensajeleido);
            }      
        }catch(IOException ex){
            System.out.println("falla");
        }
    }
}
