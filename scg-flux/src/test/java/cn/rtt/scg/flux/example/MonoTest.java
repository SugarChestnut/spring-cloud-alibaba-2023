package cn.rtt.scg.flux.example;

import reactor.core.publisher.Mono;
import reactor.util.context.ContextView;

/**
 * @author rtt
 * @date 2025/7/1 15:30
 */
public class MonoTest {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        get().onErrorResume(e -> Mono.just("rtt")).flatMap(s -> {
            System.out.println(s.length());
            return Mono.empty();
        }).subscribe(System.out::println);
    }

    public static Mono<String> get() {
        return Mono.empty();
    }

}
