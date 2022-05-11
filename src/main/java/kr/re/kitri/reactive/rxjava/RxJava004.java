package kr.re.kitri.reactive.rxjava;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class RxJava004 {
    public static void main(String[] args) throws InterruptedException {

        // interval() : 무한 Observable.
        // 0.5초마다 데이터 에밋
        Observable<Long> interval = Observable.interval(500, TimeUnit.MILLISECONDS);

        interval.subscribe(System.out::println);

        // 실행결과 : 아무것도 안 찍히고, 바로 끝남.
        // 이유 = Observable 은 기본적으로 main과 별도의 쓰레드로 실행됨.
        // 그런데 main 스레드는 명령 실행하고 바로 끝나버리니까
        // 데이터 쓸 애가 사라진 것임
        // 그래서, main 스레드를 sleep 주면 할 수 있음
        Thread.sleep(5000);
    }
}
