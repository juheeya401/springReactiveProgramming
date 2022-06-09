package kr.re.kitri.reactive.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableAll;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class HelloRxjava {
    public static void main(String[] args) {
        // Imperative Programming (전통적방식)
        List<String> colors = Arrays.asList("blue", "red", "white", "tan");
        for (String color : colors) {
            if (color.length() >= 4) { // 데이터 필터링
                System.out.println(color.toUpperCase(Locale.ROOT));  // 데이터 가공
            }
        }

        // 선언적 프로그래밍
        Stream.of("blue", "red", "white", "tan") // 스트림 데이터. Stream도 데이터 컬렉션으로 본다.
                .filter(e -> e.length() >= 4)
                .map(e -> e.toUpperCase(Locale.ROOT))
                .forEach(System.out::println);

        // 리액티브 프로그래밍 - RxJava (Reactor)
        // Observable = Data Producer
        // subscribe Subscriber
        Observable
                .just("blue", "red", "white", "tan")  // 3가지 방법 다 데이터는 String. Observable 은 데이터를 감싸고 있는 컬렉션 개념
                .filter(e -> e.length() >= 4)
                .map(e -> e.toUpperCase(Locale.ROOT))
                .subscribe(System.out::println);

    }
}
