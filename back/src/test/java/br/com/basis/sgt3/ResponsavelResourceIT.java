package br.com.basis.sgt3;

import br.com.basis.sgt3.domain.Responsavel;
import br.com.basis.sgt3.repository.ResponsavelRepository;
import br.com.basis.sgt3.service.dto.ResponsavelDTO;
import br.com.basis.sgt3.service.mapper.ResponsavelMapper;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
public class ResponsavelResourceIT {

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
    private ResponsavelRepository responsavelRepository;

    @Autowired
    private ResponsavelMapper responsavelMapper;

    @BeforeEach
    private void limparBanco() {
        responsavelRepository.deleteAll();
    }

    private Long salvarResponsavel(ResponsavelDTO responsavelDTO) {
        Responsavel save = responsavelRepository.save(responsavelMapper.toEntity(responsavelDTO));
        return save.getId();
    }

    @Test
    public void criarResponsavel() throws Exception {
        ResponsavelDTO responsavelDTO = getResponsavelDTO();

        getMockMvc().perform(
                post("/api/responsaveis")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(convertObjectToJsonBytes(responsavelDTO))
        ).andExpect(status().isOk());
    }

    @Test
    public void obterPorIdComSucesso() throws Exception {
        Long idResponsavel = salvarResponsavel(getResponsavelDTO());

        getMockMvc().perform(
                get("/api/responsaveis/" + idResponsavel)
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk());
    }

    @Test
    public void obterPorIdComError() throws Exception {
        salvarResponsavel(getResponsavelDTO());
        getMockMvc().perform(
                get("/api/responsaveis/" + Long.MAX_VALUE)
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isNotFound());
    }

    @Test
    public void obterTodosComNome() throws Exception {
        salvarResponsavel(getResponsavelDTO());
        getMockMvc().perform(
                get("/api/responsaveis/?nome=teste")
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk());
    }

    @Test
    public void obterTodosSemNome() throws Exception {
        salvarResponsavel(getResponsavelDTO());
        getMockMvc().perform(
                get("/api/responsaveis/")
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk());
    }

    @Test
    public void deletarPorIdComSucesso() throws Exception {
        Long idResponsavel = salvarResponsavel(getResponsavelDTO());

        getMockMvc().perform(
                delete("/api/responsaveis/" + idResponsavel)
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk());
    }

    private ResponsavelDTO getResponsavelDTO() {
        ResponsavelDTO responsavelDTO = new ResponsavelDTO();
        responsavelDTO.setNome("Nome 1");
        responsavelDTO.setEmail("igorpignata@outlook.com");
        responsavelDTO.setCpf(12345678900L);
        return responsavelDTO;
    }
}
