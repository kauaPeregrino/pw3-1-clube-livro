package com.cublelivro.backend.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity

public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String dono;
    private String status;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
}
