package com.empresa.cadastro_Instrumento.infrastructure.repository;

import com.empresa.cadastro_Instrumento.infrastructure.entitys.Instrumento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstrumentoRepository extends JpaRepository<Instrumento, Integer> {

    Optional<Instrumento> findByNumSerie(String numSerie);

    @Transactional
    void deleteByNumSerie(String numSerie);
}