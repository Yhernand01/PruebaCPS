package com.yelsyn.backendcotizador.Controllers;


import com.yelsyn.backendcotizador.Dao.ClienteDao;
import com.yelsyn.backendcotizador.Entities.Cliente;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api")
public class ClienteController {
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/cliente/{codigo}")
    public Cliente buscarCliente(@PathVariable String codigo) throws SQLException, ClassNotFoundException {
        ClienteDao cliente = new ClienteDao();
        return cliente.buscarCliente(codigo);
    }
}
