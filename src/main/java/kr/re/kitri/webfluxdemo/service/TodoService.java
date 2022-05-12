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

    // fake server 에서 데이터 가져와서 DB에 insert 하고 요청자에게 전달
    public Mono<Todo> getTodoById(Long id) {
        Mono<Todo> todoMono = todoRepository.retrieveTodoById(id);

        todoRepository.insertTodo(todoMono);

        return todoMono;
    }
}
