/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.torneodelpodermodel.dao;

import cl.inacap.torneodelpodermodel.dto.Universo;
import cl.inacap.torneodelpodermodel.utils.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sarayar
 */
public class UniversoService extends Conexion{
    
    
    public List<Universo> obtenerUniversos(){
        List<Universo> universos = new ArrayList<Universo>();
        try{
            this.conectar();
            String sql = "SELECT iduniversos, nombre, nivel_poder FROM universos";
            PreparedStatement st = this.getConexion().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Universo universo = new Universo();
                universo.setId(rs.getInt(1));
                universo.setNombre(rs.getString(2));
                universo.setNivelPoder(rs.getInt(3));
                universos.add(universo);
            }
            rs.close();
            
        }catch(Exception ex){
            universos = null;
        }finally{
            this.desconectar();
        }
        return universos;
    }
    
    public boolean eliminarUniverso(int id){
        try{
            this.conectar();
            String sql = "DELETE FROM universos WHERE iduniversos=?";
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
    
    public boolean ingresarUniverso(Universo universo){
        boolean ingresado = false;
        try{
            this.conectar();
            String sql = "INSERT INTO universos(nombre, nivel_poder)"
                    + " VALUES(?,?)";
            PreparedStatement st = this.getConexion().prepareStatement(sql);
            st.setString(1, universo.getNombre());
            st.setInt(2, universo.getNivelPoder());
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
