package com.jira.instance.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class JiraHandler {
    public Mono<ServerResponse> hello(ServerRequest request) {
        System.out.print("Hello world!");

        return ServerResponse.ok().build();
               // .body(BodyInserters.fromObject("Hello, Spring Webflux Example!"));
    }

    public Mono<ServerResponse> receive(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).syncBody("Got it!");
    }
}