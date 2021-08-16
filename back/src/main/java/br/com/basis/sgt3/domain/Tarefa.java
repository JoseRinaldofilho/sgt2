package br.com.basis.sgt3.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tarefa")
@Getter
@Setter
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status")
    private String status;
//
    @Column(name = "data_inicio")
    private LocalDate dtInicio;

    @Column(name = "data_termino_previsto")
    private LocalDate dtTerminoPrevisto;

    @Column(name = "data_termino_efetivo")
    private LocalDate dtTerminoEfetivo;

    @JoinColumn(name = "id_tipo")
    @ManyToOne
    private TipoTarefa tipoTarefa;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tarefa")
    List<Comentario> comentarios;

}