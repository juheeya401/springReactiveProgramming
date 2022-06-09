package kr.re.kitri.reactive.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class RxJava002 {
    public static void main(String[] args) {
        Observable<String> stringObservable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon'");

        // 어떤 subscriber를 사용할 지 지정
        stringObservable.subscribe(new MyObserver());
    }
}

class MyObserver implements Observer<String> {

    /**
     * 데이터 구독자로 등록
     */
    @Override
    public void onSubscribe(@NonNull Disposable d) {
        System.out.println("onSubscribe callback..");
    }

    /**
     * 데이터 받기 콜백 함수
     * 콜백함수를 호출하면서 데이터는 파라미터로 전달해준다.
     */
    @Override
    public void onNext(@NonNull String s) {
        System.out.println("onNext callback.. " + s);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        System.out.println("onError..");
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete callback..");
    }
}