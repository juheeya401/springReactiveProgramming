package kr.re.kitri.webfluxdemo.service;

import kr.re.kitri.webfluxdemo.model.Todo;
import kr.re.kitri.webfluxdemo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public Flux<Todo> getAllTodos() {
        return todoRepository.retrieveTodos();
    }

    public Mono<Todo> getTodoById(Long id) {
        return todoRepository.retrieveTodoById(id);
    }
}
