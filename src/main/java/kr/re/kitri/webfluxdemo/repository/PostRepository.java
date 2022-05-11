package kr.re.kitri.webfluxdemo.repository;

import kr.re.kitri.webfluxdemo.model.Post;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Repository
public class PostRepository {

    public Mono<List<Post>> selectAllPosts() {
        // DB 에서 글 데이터 조회 (DB 에서도 리액티브로 가져올 수 있기 떄문에)

        // 방법1 Mono<List> : 데이터가 좀 많아도 제한된 데이타가 들어올 때는 보통 Mono 를 이용
        List postList = Arrays.asList(
                new Post(1, 1, "제목: 요래요래요래1", "1인생이 내 뜻대로 되지 않는구나"),
                new Post(2, 3, "제목: 요래요래요래2", "2인생이 내 뜻대로 되지 않는구나"),
                new Post(3, 3, "제목: 요래요래요래3", "3인생이 내 뜻대로 되지 않는구나"),
                new Post(4, 4, "제목: 요래요래요래4", "4인생이 내 뜻대로 되지 않는구나"),
                new Post(5, 5, "제목: 요래요래요래5", "5인생이 내 뜻대로 되지 않는구나")
        );
        Mono<List<Post>> postMono = Mono.just(postList);

        // 방법2 Flux<Post> : 데이터가 계속 들어올 때, 시간이 흐르면서 계속 들어올 때 Flux 를 사용.
        /*Flux<Post> postFlux = Flux.just(
                new Post(1, 1, "제목: 요래요래요래1", "1인생이 내 뜻대로 되지 않는구나"),
                new Post(2, 3, "제목: 요래요래요래2", "2인생이 내 뜻대로 되지 않는구나"),
                new Post(3, 3, "제목: 요래요래요래3", "3인생이 내 뜻대로 되지 않는구나"),
                new Post(4, 4, "제목: 요래요래요래4", "4인생이 내 뜻대로 되지 않는구나"),
                new Post(5, 5, "제목: 요래요래요래5", "5인생이 내 뜻대로 되지 않는구나")
        );*/

        return postMono;
    }
}
