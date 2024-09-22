package br.edu.ufage.topicos.estoque.cadastro;

import java.util.List;

import br.edu.ufage.topicos.estoque.basica.Armazem;
import br.edu.ufage.topicos.estoque.cadastro.Exceptions.ArmazemNaoEncontradoException;

public interface InterfaceCadastroArmazem {

    List<Armazem> listarArmazensPorNome(String nome);

    Armazem atualizarArmazem(Long id, Armazem novoArmazem) throws ArmazemNaoEncontradoException;

    Armazem salvarArmazem(Armazem entity);

    List<Armazem> listarArmazens();

    Armazem encontrarArmazemId(Long id);

    void apagarArmazem(Long id);

    void apagarArmazem(Armazem entity);
}
