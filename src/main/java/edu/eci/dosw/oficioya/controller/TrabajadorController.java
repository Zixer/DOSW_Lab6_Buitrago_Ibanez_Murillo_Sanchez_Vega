package edu.eci.dosw.oficioya.controller;

import edu.eci.dosw.oficioya.model.Trabajador;
import edu.eci.dosw.oficioya.service.TrabajadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabajadores")
public class TrabajadorController {

    private final TrabajadorService trabajadorService;

    public TrabajadorController(TrabajadorService trabajadorService) {
        this.trabajadorService = trabajadorService;
    }

    @GetMapping
    public ResponseEntity<List<Trabajador>> listar() {
        return ResponseEntity.ok(trabajadorService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabajador> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(trabajadorService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Trabajador> crear(@RequestBody Trabajador trabajador) {
        Trabajador creado = trabajadorService.crear(trabajador);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trabajador> actualizar(@PathVariable Long id, @RequestBody Trabajador trabajador) {
        return ResponseEntity.ok(trabajadorService.actualizar(id, trabajador));
    }

    @PatchMapping("/{id}/inactivar")
    public ResponseEntity<Trabajador> inactivar(@PathVariable Long id) {
        return ResponseEntity.ok(trabajadorService.desactivar(id));
    }
}
