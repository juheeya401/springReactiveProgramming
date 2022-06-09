package kr.re.kitri.webfluxdemo.repository;

import kr.re.kitri.webfluxdemo.model.Employee;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Repository
public class EmployeeRepository {

    private Flux<Employee> dataSource = Flux.just(
            new Employee(1L, "홍길동1"),
            new Employee(2L, "홍길동2"),
            new Employee(3L, "홍길동3"),
            new Employee(4L, "홍길동4"),
            new Employee(5L, "홍길동5"),
            new Employee(6L, "홍길동6")
    );

    public Mono<Employee> findEmployeeById(Long id) {
        Mono<Employee> last = dataSource
                .filter(e -> Objects.equals(e.getId(), id))
                .last();
        return last;
    }

    public Flux<Employee> findAllEmployees() {
        return dataSource;
    }

    public Mono<Employee> updateEmployee(Employee employee) {
        Mono<Employee> last = dataSource
                .filter(e -> Objects.equals(e.getId(), employee.getId()))
                .map(e -> {
                    e.setName(employee.getName());
                    return e;
                })
                .last();
        return last;
    }

    public Mono<Employee> updateMonoEmployee(Employee employee) {
        Mono<Employee> findEmployee = findEmployeeById(1L);
        return findEmployee
                .map(e -> {
                    e.setName(employee.getName());
                    return e;
                });
    }
}
