package com.empresa.cadastro_Instrumento.business;

import com.empresa.cadastro_Instrumento.infrastructure.entitys.Instrumento;
import com.empresa.cadastro_Instrumento.infrastructure.repository.InstrumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentoService {

    private final InstrumentoRepository repository;

    public InstrumentoService(InstrumentoRepository repository) {
        this.repository = repository;
    }

    public void salvarInstrumento(Instrumento instrumento) {
        repository.saveAndFlush(instrumento);
    }

    public List<Instrumento> listarTodos() {
        return repository.findAll();
    }

    public Instrumento buscarInstrumentoPorNumSerie(String numSerie) {
        return repository.findByNumSerie(numSerie).orElseThrow(
                () -> new RuntimeException("Instrumento não encontrado!")
        );
    }

    public void deletarInstrumentoPorNumSerie(String numSerie) {
        repository.deleteByNumSerie(numSerie);
    }

    public void atualizarInstrumentoPorNumSerie(String numSerie, Integer id, Instrumento instrumento) {
        Instrumento instrumentoEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Instrumento não encontrado!"));

        Instrumento instrumentoAtualizado = Instrumento.builder()
                .id(instrumentoEntity.getId())
                .numSerie(instrumento.getNumSerie() != null ? instrumento.getNumSerie() : instrumentoEntity.getNumSerie())
                .nome(instrumento.getNome() != null ? instrumento.getNome() : instrumentoEntity.getNome())
                .marca(instrumento.getMarca() != null ? instrumento.getMarca() : instrumentoEntity.getMarca())
                .familia(instrumento.getFamilia() != null ? instrumento.getFamilia() : instrumentoEntity.getFamilia())
                .preco(instrumento.getPreco() != null ? instrumento.getPreco() : instrumentoEntity.getPreco())
                .build();

        repository.saveAndFlush(instrumentoAtualizado);
    }
}