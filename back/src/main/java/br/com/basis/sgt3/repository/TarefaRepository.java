package br.com.basis.sgt3.repository;

import br.com.basis.sgt3.domain.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findAllByTitulo(String titulo);

    @Query("FROM Tarefa WHERE titulo LIKE %:titulo%")
    List<Tarefa> encontarTodosPorTitulo(@Param("titulo") String titulo);

}