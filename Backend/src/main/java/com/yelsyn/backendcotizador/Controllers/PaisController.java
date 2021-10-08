package com.yelsyn.backendcotizador.Controllers;

import com.yelsyn.backendcotizador.Dao.PaisDao;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api")
public class PaisController {
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping ("/paises")
    public List obtenerPaises() throws SQLException, ClassNotFoundException {
        PaisDao pais = new PaisDao();
        return pais.obtenerPaises();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/tarifa/{idRegion}")
    public Map<Object,Object> obtenerTarifa(@PathVariable Integer idRegion) throws SQLException, ClassNotFoundException {
        PaisDao pais = new PaisDao();
        return pais.obtenerTarifa(idRegion);
    }
}
