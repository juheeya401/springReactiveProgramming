package kr.re.kitri.webfluxdemo.repository;

import kr.re.kitri.webfluxdemo.model.Todo;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class TodoRepository {

    private WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com");

    public Flux<Todo> retrieveTodos() {
        // 소감. 와... 개 편하네 개 심플
        Flux<Todo> todoFlux = webClient.get()
                .uri("/todos")
                .retrieve()
                .bodyToFlux(Todo.class);

        return todoFlux;
    }

    public Mono<Todo> retrieveTodoById(Long id) {
        return webClient.get()
                .uri("/todos/" + id)
                .retrieve()
                .bodyToMono(Todo.class);
    }

    public void insertTodo(Mono<Todo> todoMono) {
        todoMono.subscribe(e -> System.out.println(e.toString())); // 찍힌다.
    }
}