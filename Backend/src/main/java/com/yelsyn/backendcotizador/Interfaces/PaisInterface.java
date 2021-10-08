package com.yelsyn.backendcotizador.Interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface PaisInterface {
    public List obtenerPaises() throws SQLException, ClassNotFoundException;
    public Map<Object,Object> obtenerTarifa(int idPais) throws SQLException, ClassNotFoundException;
}
