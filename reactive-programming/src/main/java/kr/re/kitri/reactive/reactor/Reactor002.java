package kr.re.kitri.reactive.reactor;

import reactor.core.publisher.Flux;

public class Reactor002 {
    public static void main(String[] args) {
        // 1. Flux 생성.. range
        Flux<Integer> integerFlux = Flux.range(2020, 10);// 2020년부터 2029년까지. (10개임)

        // 2. 연산
        // filter - 짝수 연도만 추출
        // map - "년" 문자 붙이기
        Flux<String> stringFlux = integerFlux
                .filter(item -> item % 2 == 0)
                .map(item -> item + "년");

        // 3. 사용
        stringFlux.subscribe(item -> System.out.println(item));
    }
}
