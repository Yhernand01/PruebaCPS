package com.yelsyn.backendcotizador.Config;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.*;

public class Conexion {
    private Connection conn = null;

    private void abrir() throws SQLServerException, SQLException, ClassNotFoundException {
        String host = "localhost\\development:1433;";
        String db = "database=cotizador;";
        String user = "cpsusr";
        String passwd = "CpsUsr21";

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection("jdbc:sqlserver://" + host + db,user,passwd);
    }

    public ResultSet ejecutarQuery(String sql) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        ResultSet rs = null;
        abrir();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        return rs;
    }

    public void cerrar() throws SQLException {
        if(conn != null) conn.close();
    }
}
