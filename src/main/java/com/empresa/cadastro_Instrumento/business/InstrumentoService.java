package com.empresa.cadastro_Instrumento.business;

import com.empresa.cadastro_Instrumento.infrastructure.entitys.Instrumento;
import com.empresa.cadastro_Instrumento.infrastructure.repository.InstrumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentoService {

    private final InstrumentoRepository instrumentoRepository;

    public InstrumentoService(InstrumentoRepository instrumentoRepository) {
        this.instrumentoRepository = instrumentoRepository;
    }

    public List<Instrumento> listarTodos() {
        return instrumentoRepository.findAll();
    }

    public Instrumento salvar(Instrumento instrumento) {
        return instrumentoRepository.save(instrumento);
    }

    public Instrumento atualizar(Integer id, Instrumento dadosNovos) {
        Instrumento existente = instrumentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instrumento não encontrado com o ID: " + id));

        if (dadosNovos.getNome() != null) existente.setNome(dadosNovos.getNome());
        if (dadosNovos.getFamilia() != null) existente.setFamilia(dadosNovos.getFamilia());
        if (dadosNovos.getMarca() != null) existente.setMarca(dadosNovos.getMarca());
        if (dadosNovos.getPreco() != null && dadosNovos.getPreco() > 0) existente.setPreco(dadosNovos.getPreco());

        return instrumentoRepository.save(existente);
    }

    public void deletar(Integer id) {
        if (!instrumentoRepository.existsById(id)) {
            throw new RuntimeException("Instrumento não encontrado com o ID: " + id);
        }
        instrumentoRepository.deleteById(id);
    }
}