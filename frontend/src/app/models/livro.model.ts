export interface Livro {
  id?: number;
  titulo: string;
  dono: string;
  status?: string;
  dataEmprestimo?: string;
  dataDevolucaoPrevista?: string;
}