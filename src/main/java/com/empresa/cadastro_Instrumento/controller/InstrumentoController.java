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

    // GET por número de série (Exemplo: GET http://localhost:8080/instrumento/serie/SN-12345)
    @GetMapping("/serie/{numSerie}")
    public ResponseEntity<Instrumento> buscarPorNumSerie(@PathVariable String numSerie) {
        return ResponseEntity.ok(instrumentoService.buscarPorNumSerie(numSerie));
    }

    @PostMapping
    public ResponseEntity<Instrumento> salvar(@RequestBody Instrumento instrumento) {
        return ResponseEntity.ok(instrumentoService.salvar(instrumento));
    }

    @PutMapping
    public ResponseEntity<Instrumento> atualizar(@RequestParam Integer id, @RequestBody Instrumento instrumento) {
        Instrumento atualizado = instrumentoService.atualizar(id, instrumento);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(@RequestParam Integer id) {
        instrumentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // DELETE por número de série (Exemplo: DELETE http://localhost:8080/instrumento/serie/SN-12345)
    @DeleteMapping("/serie/{numSerie}")
    public ResponseEntity<Void> deletarPorNumSerie(@PathVariable String numSerie) {
        instrumentoService.deletarPorNumSerie(numSerie);
        return ResponseEntity.noContent().build();
    }
}