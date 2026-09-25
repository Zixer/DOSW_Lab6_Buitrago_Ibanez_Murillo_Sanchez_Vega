package edu.eci.dosw.oficioya.controller;

import edu.eci.dosw.oficioya.model.Trabajador;
import edu.eci.dosw.oficioya.service.TrabajadorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabajadores")
@Tag(name = "Trabajadores",description = "Operaciones relacionadas con la gestión de trabajadores")
public class TrabajadorController {

    private final TrabajadorService trabajadorService;

    public TrabajadorController(TrabajadorService trabajadorService) {
        this.trabajadorService = trabajadorService;
    }

    @GetMapping
    @Operation(summary = "Listar trabajadores",description = "Devuelve la lista de trabajadores registrados")
    public ResponseEntity<List<Trabajador>> listar() {
        return ResponseEntity.ok(trabajadorService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener trabajador por ID",description = "Busca y devuelve un trabajador utilizando su identificador")
    public ResponseEntity<Trabajador> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(trabajadorService.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear trabajador",description = "Registra un nuevo trabajador en el sistema")
    public ResponseEntity<Trabajador> crear( @RequestBody Trabajador trabajador) {

        Trabajador creado =trabajadorService.crear(trabajador);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar trabajador",description = "Modifica la información de un trabajador existente")
    public ResponseEntity<Trabajador> actualizar(@PathVariable Long id, @RequestBody Trabajador trabajador) {
        return ResponseEntity.ok(trabajadorService.actualizar(id, trabajador));
    }

    @PatchMapping("/{id}/inactivar")
    @Operation( summary = "Inactivar trabajador", description = "Inactiva un trabajador sin eliminarlo del sistema")
    public ResponseEntity<Trabajador> inactivar(@PathVariable Long id) {
        return ResponseEntity.ok(trabajadorService.desactivar(id));
    }
}