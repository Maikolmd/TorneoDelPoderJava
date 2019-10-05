/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.torneodelpodermodel.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Dedicada a proveer mecanismos de conexión y desconexión a la base de datos
 * @author sarayar
 */
public class Conexion {
    //final permite que el atributo no se pueda modificar
    private final String nombreDB = "torneo_del_poder";
    private final String usuario = "root";
    private final String servidor = "localhost";
    private final String password = "";
    private Connection conexion;

    public Connection getConexion() {
        return conexion;
    }
    
    
    
    public boolean conectar(){
        boolean conectado = false;
        try{
            //1. Importar la Clase MySQL Driver
            Class.forName("com.mysql.jdbc.Driver");
            //2. Obtener una conexión con el administrador de conexiones
            String url = "jdbc:mysql://" +servidor + ":3306/" + nombreDB;
            this.conexion = DriverManager.getConnection(url,usuario, password);
            conectado = true;
        }catch(Exception ex){
            conectado = false;
        }
        return conectado;
    }
    
    
    
    public void desconectar(){
        try{
            this.conexion.close();
        }catch(Exception ex){
            
        }
    }
    
}



