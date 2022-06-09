package kr.re.kitri.reactive.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Reactor005 {
    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.range(1, 10);
        Mono<Integer> reduce = integerFlux.reduce((a, b) -> a + b);  // 문제 : 1부터 100까지의 수를 모두 더한 값 구하기
        Mono<Integer> reduce1 = integerFlux.reduce(1, (a, b) -> a * b); // 곱하기 // reduce() 초기값 지정 가능. initial 값
        //reduce.subscribe(System.out::println);
        reduce1.subscribe(System.out::println);

        // Flux 데이터를 List 컬렉션으로 바꾸려면: 먼저 Mono<List<Integer>>로 바꾼 후 꺼내 쓴다
        Mono<List<Integer>> listMono = integerFlux.collectList();

        Flux<Integer> integerFlux2 = Flux.range(11, 10);
    }
}
