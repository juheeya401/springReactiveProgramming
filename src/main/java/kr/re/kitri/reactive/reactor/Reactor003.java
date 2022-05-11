package kr.re.kitri.reactive.reactor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class Reactor003 {
    public static void main(String[] args) throws InterruptedException {
        Flux.just("a", "b")
                //.subscribe(new MySubscriber()); 정석대로라면 이렇게 구현체를 직접 넣어야 함. 하지만 아래처럼 필요한 기능만 구현할 수 있또록 미리 파라미터로 선언되어있다
                .subscribe(
                        item -> System.out.println(item),
                        error -> System.out.println(error),
                        () -> System.out.println("the end.")
                        //subscription -> System.out.println("구독 시작") // 이 네번째 파라미터를 쓴다는건 Backpress를 사용한다는 것이다. 따라서 현재는 request()를 선언하지 않았기 때문에 실행 시 아무런 데이터가 들어오지 않는다.
                        , subscription -> {
                            // 1개만 구독받고 구독 중단
                            subscription.request(1); // 그냥 실행하면 complete 이벤트가 발생하지 않았음. 이유=main이 미리 끝났기 떄문.
                            //subscription.request(4); // 2개 이상(데이터 갯수 이상) 달라고 하면 onComplete 이벤트도 발생한다.
                            subscription.cancel();  // complete 이벤트가 발생하지 않음
                        }
                );
    }
}

class MySubscriber implements Subscriber<String> {
    /**
     * 데이터 에밋 전 최초로 연결이 맺어졌을 때 발생하는 이벤트
     * 파라미터 subscription : 나중에 구독을 중단할 때 사용할 수 있다.
     */
    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(5);  // backpressur 와 관련된 함수. 한 번에 몇개씩 받고싶은지 지정. default=Long.MAX_VALUE
    }

    /**
     * 함수형 인터페이스 Consumer<T> 와 동일한 시그니처.
     * 따라서 subscribe() 함수에서 파라미터 1개로 Consumer<T>만 받는 함수는 onNext()를 구현한 것이라고 보면 된다.
     */
    @Override
    public void onNext(String s) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
