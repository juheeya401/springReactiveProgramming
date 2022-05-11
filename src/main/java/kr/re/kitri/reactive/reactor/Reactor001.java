package kr.re.kitri.reactive.reactor;

import reactor.core.publisher.Flux;

import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;

public class Reactor001 {
    public static void main(String[] args) {
        // Publisher
        Flux<String> just = Flux.just("blue", "pink", "red", "green");

        // 연산자 - 순서대로. 원본변경 X 복사본을 가공. 각 연산작업의 결과를 다음 작업의 데이터로 전달됨. 각 연산자는 각각의 복사본으로 작업(독립적)
        just
                .filter(new MyInterface())
                .filter(data -> data.length() >= 4)  // 독립된 복사본으로 작업
                .map(new MyFunction())
                .map(e -> e.toUpperCase(Locale.ROOT));  // 또다른 독립된 복사본으로 작업

        // Subscriber
        just.subscribe(data -> System.out.println(data));
    }
}

class MyFunction implements Function<String, String> {
    @Override
    public String apply(String s) {
        return s.toUpperCase(Locale.ROOT);
    }
}

class MyInterface implements Predicate<String> {
    @Override
    public boolean test(String data) {
        return data.length() >= 4;
    }
}