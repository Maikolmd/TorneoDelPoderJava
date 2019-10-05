/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.torneodelpodermodel.dao;

import cl.inacap.torneodelpodermodel.dto.Guerrero;
import cl.inacap.torneodelpodermodel.utils.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sarayar
 */
public class GuerreroService extends Conexion{
    
    
    public List<Guerrero> obtenerGuerreros(){
        List<Guerrero> guerreros = new ArrayList<Guerrero>();
        try{
            this.conectar();
            String sql = "SELECT idguerreros, nombre, raza,poder_de_pelea"
                    + ",planeta_origen FROM guerreros";
            PreparedStatement st = this.getConexion().prepareStatement(sql);
            ResultSet rs =  st.executeQuery();
            while(rs.next()){
                //Obtener los valores de la fila
                Guerrero guerrero = new Guerrero();
                guerrero.setId(rs.getInt(1));
                guerrero.setNombre(rs.getString(2));
                guerrero.setRaza(rs.getString(3));
                guerrero.setPoderDePelea(rs.getInt(4));
                guerrero.setPlanetaOrigen(rs.getString(5));
                //agregar la lista
                guerreros.add(guerrero);
            }
            
            rs.close();
           
        }catch(Exception ex){
            guerreros = null;
        } finally{
            this.desconectar();
        }
        return guerreros;
    }
    
    public boolean actualizarGuerrero(Guerrero guerrero){
      
        try{
            this.conectar();
            String sql = "UPDATE guerreros"
                    + " SET nombre=?"
                    + ", poder_de_pelea=?"
                    + ", raza=?"
                    + ", planeta_origen=?"
                    + " WHERE idguerreros=?";
            PreparedStatement st = this.getConexion().prepareStatement(sql);
            st.setString(1, guerrero.getNombre());
            st.setInt(2, guerrero.getPoderDePelea());
            st.setString(3, guerrero.getRaza());
            st.setString(4, guerrero.getPlanetaOrigen());
            st.setInt(5, guerrero.getId());
            
            st.executeUpdate();
            
            return true;
        }catch(Exception ex){
            return false;
        }finally{
            this.desconectar();
        }
        
    }
    
    public boolean eliminarGuerrero(int id){
        
        try{
            this.conectar();
            String sql = "DELETE FROM guerreros WHERE idguerreros=?";
            PreparedStatement st = this.getConexion().prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        }catch(Exception ex){
            return false;
        }finally{
            this.desconectar();
        }
        
    }
    
    
    /**
     * Se encarga de ingresar en la base de datos un Guerrero
     * @param guerrero instancia de Guerrero
     * @return true cuando ingrese correctamente un Guerrero, falso en caso contrario
     */
    public boolean ingresarGuerrero(Guerrero guerrero){
        boolean ingresado = false;
        try{
            //1. Crear el SQL para Ingresar (INSERT)
            String sql = "INSERT INTO guerreros(nombre, planeta_origen, raza, poder_de_pelea)"
                    + " VALUES (?,?,?,?)";
            //2. Obtener la conexión a la base de datos
            this.conectar();
            PreparedStatement st = this.getConexion().prepareStatement(sql);
            //3. Darle los valores del guerrero a insertar
            st.setString(1, guerrero.getNombre());
            st.setString(2, guerrero.getPlanetaOrigen());
            st.setString(3, guerrero.getRaza());
            st.setInt(4, guerrero.getPoderDePelea());
            //4. Efectuar ingreso
            st.executeUpdate();
            ingresado = true;
            
        }catch(Exception ex){
            ingresado = false;
            
        }finally{
            this.desconectar();
        }
        return ingresado;
    }
   
}









