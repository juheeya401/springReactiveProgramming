package kr.re.kitri.webfluxdemo.controller;

import kr.re.kitri.webfluxdemo.model.Todo;
import kr.re.kitri.webfluxdemo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;

    /**
     * 다른 서버에서 데이터 조회(DB조회 아님)
     * webClient 이용
     */
    @GetMapping("/todos")
    public Flux<Todo> viewAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/todos/{id}")
    public Mono<Todo> viewTodoById(@PathVariable("id") Long id) {
        return todoService.getTodoById(id);
    }
}

