import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LivroService } from '../../services/livro.service';
import { Livro } from '../../models/livro.model';

@Component({
  selector: 'app-livro-lista',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './livro-lista.component.html',
  styleUrl: './livro-lista.component.css'
})
export class LivroListaComponent implements OnInit {
  livros: Livro[] = [];

  constructor(private livroService: LivroService) {}

  ngOnInit(): void {
    this.carregarLivros();
  }

  carregarLivros(): void {
    this.livroService.listarTodos().subscribe(dados => {
      this.livros = dados;
    });
  }

  emprestar(id: number): void {
    this.livroService.emprestar(id).subscribe(() => this.carregarLivros());
  }

  devolver(id: number): void {
    this.livroService.devolver(id).subscribe(() => this.carregarLivros());
  }

  deletar(id: number): void {
    this.livroService.deletar(id).subscribe(() => this.carregarLivros());
  }
}
