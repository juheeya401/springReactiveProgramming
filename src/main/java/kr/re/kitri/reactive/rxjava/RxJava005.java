package kr.re.kitri.reactive.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class RxJava005 {
    public static void main(String[] args) {
        Single.just("Only one")
                .subscribe(data -> System.out.println(data),
                        error -> System.out.println(error)); // onSuccess() 또는 onError() 두가지만 구현. (onNext() 는 구현할 필요 없음. 1개의 데이터만 있으니까)

        Observable<String> just = Observable.just("one", "two");

        // first() 의 파라미터 : 만약 Observable 이 비어있을 때 기본값
        Single<String> data = just.first("Nil"); // 그리고 return 타입은 Single 타입을 리턴함
        // Single 타입이다? = 무조건 데이터가 1개는 있단느 말이다. 즉 코드를 명확하게 해주는 것이다.
    }
}
