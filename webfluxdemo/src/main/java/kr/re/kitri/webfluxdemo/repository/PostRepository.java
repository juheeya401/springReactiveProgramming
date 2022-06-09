package kr.re.kitri.webfluxdemo.repository;

import kr.re.kitri.webfluxdemo.model.Post;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Repository
public class PostRepository {

    private int sequenceId = 5;
    private List<Post> datas = Arrays.asList(
            new Post(1, 1, "제목: 요래요래요래1", "1인생이 내 뜻대로 되지 않는구나"),
            new Post(2, 3, "제목: 요래요래요래2", "2인생이 내 뜻대로 되지 않는구나"),
            new Post(3, 3, "제목: 요래요래요래3", "3인생이 내 뜻대로 되지 않는구나"),
            new Post(4, 4, "제목: 요래요래요래4", "4인생이 내 뜻대로 되지 않는구나"),
            new Post(5, 5, "제목: 요래요래요래5", "5인생이 내 뜻대로 되지 않는구나")
    );

    public int nextSequenceId() {
        return sequenceId++;
    }

    public Flux<Post> selectAllPosts() {
        // DB 에서 글 데이터 조회 (DB 에서도 리액티브로 가져올 수 있기 떄문에)
        return Flux.fromIterable(datas);
    }

    public Mono<Post> getPostById(Integer id) {
        /*datas.stream().filter(e -> e.getId() == id)
                .limit(1);*/
        return Mono.just(
                new Post(1, 1, "제목: 요래요래요래1", "1인생이 내 뜻대로 되지 않는구나")
        );
    }

    public Mono<Post> setPost(Mono<Post> responsePost) {
        return responsePost;
    }
}

