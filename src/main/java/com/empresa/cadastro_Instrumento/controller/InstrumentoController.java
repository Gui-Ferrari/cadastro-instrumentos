package com.empresa.cadastro_Instrumento.controller;

import com.empresa.cadastro_Instrumento.business.InstrumentoService;
import com.empresa.cadastro_Instrumento.infrastructure.entitys.Instrumento;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrumento")
@RequiredArgsConstructor
public class InstrumentoController {

    private final InstrumentoService instrumentoService;

    @PostMapping
    public ResponseEntity<Void> salvarInstrumento(@RequestBody Instrumento instrumento) {
        instrumentoService.salvarInstrumento(instrumento);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Instrumento>> listarTodos() {
        return ResponseEntity.ok(instrumentoService.listarTodos());
    }

    @GetMapping("/{numSerie}")
    public ResponseEntity<Instrumento> buscarPorNumSerie(@PathVariable String numSerie) {
        return ResponseEntity.ok(instrumentoService.buscarInstrumentoPorNumSerie(numSerie));
    }

    @PutMapping("/{numSerie}/{id}")
    public ResponseEntity<Void> atualizarInstrumento(@PathVariable String numSerie,
                                                     @PathVariable Integer id,
                                                     @RequestBody Instrumento instrumento) {
        instrumentoService.atualizarInstrumentoPorNumSerie(numSerie, id, instrumento);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{numSerie}")
    public ResponseEntity<Void> deletarInstrumento(@PathVariable String numSerie) {
        instrumentoService.deletarInstrumentoPorNumSerie(numSerie);
        return ResponseEntity.ok().build();
    }
}