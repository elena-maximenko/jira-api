package com.jira.instance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.BodySpec;

import reactor.core.publisher.Mono ;

@WebFluxTest
@Import({ThymeleafAutoConfiguration.class})
class InstanceApplicationTests {
    @Autowired
    private WebTestClient webClient;

    @Test
    void get() {
        webClient.get().uri("/example")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void post() {
        BodySpec<String, ?> body = webClient.post().uri("/example")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just("Some string"), String.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class);

        body.consumeWith(b -> Assertions.assertEquals("Mono response", b.getResponseBody()));
    }
}