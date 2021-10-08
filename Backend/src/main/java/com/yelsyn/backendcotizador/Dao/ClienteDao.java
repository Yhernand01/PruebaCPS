package com.yelsyn.backendcotizador.Dao;

import com.yelsyn.backendcotizador.Config.Conexion;
import com.yelsyn.backendcotizador.Entities.Cliente;
import com.yelsyn.backendcotizador.Interfaces.ClienteInterface;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao implements ClienteInterface {
    @Override
    public Cliente buscarCliente(String codigo) throws SQLException, ClassNotFoundException {
        Cliente cliente = new Cliente();
        ResultSet rs = null;
        String sql = "select p.nombre [pais_origen], c.nombre,valor_descuento " +
                    "from env.cliente c " +
                    " inner join env.pais p on (c.id_pais_origen = p.id_pais)" +
                    "where c.codigo = '" + codigo + "'";
        Conexion conexion = new Conexion();
        rs = conexion.ejecutarQuery(sql);
        if(rs.next()){
            cliente.setPaisOrigen(rs.getString("pais_origen"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setValorDescuento(rs.getDouble("valor_descuento"));
        }
        else{
            cliente.setPaisOrigen("Guatemala");
            cliente.setNombre("Invitado");
            cliente.setValorDescuento(0);
        }

        return cliente;
    }
}
