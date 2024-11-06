package tpVehiculos.tpVehiculos.microServicioGestionPruebas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tpVehiculos.tpVehiculos.microServicioGestionPruebas.model.Prueba;
import tpVehiculos.tpVehiculos.microServicioGestionPruebas.service.PruebaService;
import java.util.List;

// Controlador para los endpoints de pruebas
@RestController
@RequestMapping("/api/pruebas")
public class PruebaController {
    private final PruebaService pruebaService;

    @Autowired
    public PruebaController(PruebaService pruebaService) {
        this.pruebaService = pruebaService;
    }

    @PostMapping
    public Prueba crearPrueba(@RequestBody Prueba prueba) {
        return pruebaService.crearPrueba(prueba);
    }

    @GetMapping("/en-curso")
    public List<Prueba> listarPruebasEnCurso() {
        return pruebaService.listarPruebasEnCurso();
    }

    @PutMapping("/{id}/finalizar")
    public Prueba finalizarPrueba(@PathVariable Long id, @RequestBody String comentario) {
        return pruebaService.finalizarPrueba(id, comentario);
    }

}
