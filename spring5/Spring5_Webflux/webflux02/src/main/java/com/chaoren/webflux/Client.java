package com.chaoren.webflux;

import com.chaoren.webflux.bean.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class Client {
    public static void main(String[] args) {
        //调用服务器地址
        WebClient webClient = WebClient.create("http://127.0.0.1:9997");//填写服务器端口
        //根据 id 查询
        String id = "1";
        User userResult = webClient.get().uri("/users/{id}", id)
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(User.class)
                .block();
        assert userResult != null;
        System.out.println(userResult.getName());
        //查询所有
        Flux<User> results = webClient.get().uri("/users")
                .accept(MediaType.APPLICATION_JSON).retrieve()
                .bodyToFlux(User.class);
        results.map(User::getName)
                .buffer().doOnNext(System.out::println).blockFirst();
    }
}
