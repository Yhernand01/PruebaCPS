package com.yelsyn.backendcotizador.Interfaces;

import com.yelsyn.backendcotizador.Entities.Cliente;

import java.sql.SQLException;

public interface ClienteInterface {
    public Cliente buscarCliente(String codigo) throws SQLException, ClassNotFoundException;
}
