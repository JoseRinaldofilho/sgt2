package br.com.basis.sgt3.repository;

import br.com.basis.sgt3.domain.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {

    List<Responsavel> findAllByNome(String nome);

    @Query("FROM Responsavel WHERE nome LIKE %:nome%")
    List<Responsavel> encontarTodosPorNome(@Param("nome") String nome);

}