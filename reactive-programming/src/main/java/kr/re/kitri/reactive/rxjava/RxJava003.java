package kr.re.kitri.reactive.rxjava;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class RxJava003 {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a", "b", "c", "d");

        Observable<String> stringObservable = Observable.fromIterable(myList);
        
    }
}
