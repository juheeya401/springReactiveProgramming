package kr.re.kitri.reactive.rxjava;

import io.reactivex.rxjava3.core.Observable;

import java.util.Locale;

public class RxJava001 {
    public static void main(String[] args) {
        // Publisher (Producer)
        Observable<String> stringObservable =
                Observable.just("blue", "red", "pink");

        // 연산자 Operator (filter, map ...)
        Observable<String> stringObservable2 = stringObservable
                .filter(e -> e.length() >= 4)
                .map(e -> e.toUpperCase(Locale.ROOT));

        // Subscriber (Cusumer)
        stringObservable2.subscribe(e -> System.out.println(e));
    }
}
