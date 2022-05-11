package kr.re.kitri.reactive.reactor;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Reactor004 {
    public static void main(String[] args) throws InterruptedException {
        Disposable disposable = Flux.interval(Duration.ofMillis(500))  // 0.5초 간격으로 무한 데이터 에밋
                .subscribe(e -> System.out.println(e));

        Thread.sleep(3000);

        disposable.dispose(); // 무한 스트림을 종료한다

        Thread.sleep(5000);
    }
}
