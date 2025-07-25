package cn.rtt.scg.flux.example;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rtt
 * @date 2025/7/1 15:30
 */
public class FluxTest {

    public static void main(String[] args) {

//        test2();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        String encode = encoder.encode("123456");
        System.out.println(encode);
    }

    public static void test0() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        /*
            Flux    多个处理器
            Mono    单个处理器
         */
        Flux<String> f1 = Flux.fromIterable(list);
        // 映射
        Flux<String> f2 = f1.concatMap(s -> s.equals("x") ? Mono.just("b") : Mono.empty());
        // 获取第一个非空返回
        Mono<String> m1 = f2.next();
        // 如果前面返回为空，就返回 empty
        Mono<String> m2 = m1.switchIfEmpty(Mono.just("empty"));
        // 转换
        Mono<String> m3 = m2.flatMap(s -> Mono.just(s + "xx"));
        // 终结
        m3.subscribe(System.out::println);
    }

    public static void test1() {
        Flux<List<String>> flux = Flux.defer(() -> Mono.justOrEmpty(get())).subscribeOn(Schedulers.boundedElastic());
        flux.subscribe(System.out::println);
        flux.subscribe(System.out::println);
    }

    public static List<String> get() {
        System.out.println("exec");
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        return list;
    }

    public static void test2() {
        Flux.just("xxx")
                .doOnNext(System.out::println).map(s -> {
                    System.out.println(s);
                    return s + "a";
                })
                .doOnNext(System.out::println)
                .then(Mono.just("yyy"))
                .subscribe(System.out::println);
    }
}
