package guru.springframework.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = UserController.class)
class UserControllerTest {

    /*@Autowired
    ApplicationContext applicationContext;

    WebTestClient webTestClient;*/

    MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(UserController.class).build();
       // webTestClient = WebTestClient.bindToApplicationContext(applicationContext).build();
    }

    @Test
    void index() throws Exception {
       /* webTestClient.get().uri("/")
                .exchange()
                .expectStatus().isOk();*/

        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    void forPost() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("limit", "3");

        /*/webTestClient.post().uri("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromFormData(map))
                .exchange()
                .expectStatus().isOk();*/
    }
}