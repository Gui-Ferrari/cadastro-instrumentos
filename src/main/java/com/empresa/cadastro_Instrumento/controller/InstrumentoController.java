package com.empresa.cadastro_Instrumento.controller;

import com.empresa.cadastro_Instrumento.business.InstrumentoService;
import com.empresa.cadastro_Instrumento.infrastructure.entitys.Instrumento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrumento")
public class InstrumentoController {

    private final InstrumentoService instrumentoService;

    public InstrumentoController(InstrumentoService instrumentoService) {
        this.instrumentoService = instrumentoService;
    }

    @GetMapping
    public ResponseEntity<List<Instrumento>> listar() {
        return ResponseEntity.ok(instrumentoService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Instrumento> salvar(@RequestBody Instrumento instrumento) {
        return ResponseEntity.ok(instrumentoService.salvar(instrumento));
    }

    // Suporta PUT localhost:8080/instrumento?id=1
    @PutMapping
    public ResponseEntity<Instrumento> atualizar(@RequestParam Integer id, @RequestBody Instrumento instrumento) {
        Instrumento atualizado = instrumentoService.atualizar(id, instrumento);
        return ResponseEntity.ok(atualizado);
    }

    // Suporta DELETE localhost:8080/instrumento?id=1
    @DeleteMapping
    public ResponseEntity<Void> deletar(@RequestParam Integer id) {
        instrumentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}