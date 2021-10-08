package com.yelsyn.backendcotizador.Dao;

import com.yelsyn.backendcotizador.Config.Conexion;
import com.yelsyn.backendcotizador.Entities.Pais;
import com.yelsyn.backendcotizador.Interfaces.PaisInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaisDao implements PaisInterface {

    @Override
    public List obtenerPaises() throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        List<Pais> lstPaises = new ArrayList<>();
        String sql = "select id_region, nombre[pais] from env.pais";

        Conexion conexion = new Conexion();

        rs = conexion.ejecutarQuery(sql);
        while(rs.next()){
            Pais pais = new Pais();
            pais.setIdRegion(rs.getInt("id_region"));
            pais.setNombrePais(rs.getString("pais"));
            lstPaises.add(pais);
        }

        return lstPaises;
    }

    @Override
    public Map<Object, Object> obtenerTarifa(int idRegion) throws SQLException, ClassNotFoundException {
        Map<Object,Object> map = new HashMap<>();
        ResultSet rs = null;
        String sql = "select tarifa_dolar " +
                     "from env.region where id_region = " + idRegion;
        Conexion conexion = new Conexion();

        rs = conexion.ejecutarQuery(sql);
        if (rs.next()){
            map.put("tarifa",rs.getDouble("tarifa_dolar"));
        }
        else{
            map.put("tarifa",0);
            map.put("error","no se encontró tarifa asociada");
        }

        return map;
    }
}
