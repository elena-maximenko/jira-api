package com.jira.instance.router;

import com.jira.instance.handler.JiraHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.Rendering;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Configuration
public class JiraRouter {

    @Controller
    static class JiraController {

        @GetMapping("/example")
        Rendering hello() {
            return Rendering.view("hello.html")
                    .build();
        }
    }

    @Bean
    public RouterFunction<ServerResponse> route(JiraHandler jiraHandler) {
        return RouterFunctions
                .route(GET("/example"), request -> ok().render(
                        "hello.html",
                        Rendering.view("hello.html").build()))
                .andRoute(POST("/example").and(accept(MediaType.APPLICATION_JSON)), jiraHandler::receive);
    }
}