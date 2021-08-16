package br.com.basis.sgt3;

import br.com.basis.sgt3.domain.Tarefa;
import br.com.basis.sgt3.repository.TarefaRepository;
import br.com.basis.sgt3.service.dto.TarefaDTO;
import br.com.basis.sgt3.service.mapper.TarefaMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
public class TarefaResourceIT {

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);

    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private Long id_inexistente;

    @BeforeEach
    public void setUp() {
        id_inexistente = 1000000000L;
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                /*.apply(SecurityMockMvcConfigurers.springSecurity())*/.build();
    }

    @Autowired
    public void setWebApplicationContext(WebApplicationContext pWebApplicationContext) {
        webApplicationContext = pWebApplicationContext;
    }

    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    public static byte[] convertObjectToJsonBytes(Object object)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        JavaTimeModule module = new JavaTimeModule();
        mapper.registerModule(module);

        return mapper.writeValueAsBytes(object);
    }

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private TarefaMapper tarefaMapper;

    @BeforeEach
    private void limparBanco() {
        tarefaRepository.deleteAll();
    }

    private Long salvarTarefa(TarefaDTO tarefaDTO) {
        Tarefa save = tarefaRepository.save(tarefaMapper.toEntity(tarefaDTO));
        return save.getId();
    }

    @Test
    public void criarTarefa() throws Exception {
        TarefaDTO tarefaDTO = getTarefaDTO();

        getMockMvc().perform(
                post("/api/tarefas")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(convertObjectToJsonBytes(tarefaDTO))
        ).andExpect(status().isOk());
    }

    @Test
    public void obterPorIdComSucesso() throws Exception {
        Long idTarefa = salvarTarefa(getTarefaDTO());

        getMockMvc().perform(
                get("/api/tarefas/" + idTarefa)
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk());
    }

    @Test
    public void obterPorIdComError() throws Exception {
        salvarTarefa(getTarefaDTO());
        getMockMvc().perform(
                get("/api/tarefas/" + Long.MAX_VALUE)
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isNotFound());
    }

    @Test
    public void obterTodosComTitulo() throws Exception {
        salvarTarefa(getTarefaDTO());
        getMockMvc().perform(
                get("/api/tarefas/?titulo=teste")
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk());
    }

    @Test
    public void obterTodosSemTitulo() throws Exception {
        salvarTarefa(getTarefaDTO());
        getMockMvc().perform(
                get("/api/tarefas/")
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk());
    }

    @Test
    public void deletarPorIdComSucesso() throws Exception {
        Long idTarefa = salvarTarefa(getTarefaDTO());

        getMockMvc().perform(
                delete("/api/tarefas/" + idTarefa)
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk());
    }

    private TarefaDTO getTarefaDTO() {
        TarefaDTO tarefaDTO = new TarefaDTO();
        tarefaDTO.setTitulo("Título 1");
        tarefaDTO.setDescricao("descr");
        tarefaDTO.setComentarios(new ArrayList<>());
        return tarefaDTO;
    }
}