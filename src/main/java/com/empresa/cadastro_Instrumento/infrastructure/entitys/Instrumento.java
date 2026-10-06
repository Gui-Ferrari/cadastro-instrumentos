package com.empresa.cadastro_Instrumento.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "instrumento")
@Entity
public class Instrumento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "marca")
    private String marca;

    @Column(name = "familia")
    private String familia;

    @Column(name = "num_serie", unique = true)
    private String numSerie;

    @Column(name = "preco")
    private Double preco;
}