package kr.re.kitri.webfluxdemo.service;

import kr.re.kitri.webfluxdemo.model.Post;
import kr.re.kitri.webfluxdemo.repository.PostR2DBCRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostR2DBCRepository postR2DBCRepository;

    public Flux<Post> getAllPosts() {
        return postR2DBCRepository.findAll();
    }

    public Mono<Post> getPostById(Integer id) {
        return postR2DBCRepository
                .findById(id)
                .switchIfEmpty(Mono.just(new Post(0,0,"No data", "No data")));
    }

    // insert는 안되고 update만 된다...?
    public Mono<Post> setPost(Mono<Post> post) {
        // save는 Post 객체 자체를 파라미터로 넣어야 한다.
        //postR2DBCRepository.save(post);

        System.out.println("원본>>" + post);

        // flatMap() 을 쓰면 Mono<Post> 타입을 -> Post 타입으로 변환된다.
        // 변환된 타입을 이용해서 save를 호출한다.
        // 리턴 타입은 저장결과를 리턴한다
        Mono<Post> postMono = post.flatMap(t -> postR2DBCRepository.save(t));

        // 오잉 save()를 쓰니 update는 되는데 insert가 되지 않는다?
        System.out.println("저장 결과>>" + postMono);

        return postMono;
    }

    public Mono<Long> getPostCount() {
        return postR2DBCRepository.count();
    }

    public Mono<Void> deletePostById(Integer id) {
        Mono<Void> voidMono = postR2DBCRepository.deleteById(id);
        return voidMono;
    }

    public Flux<Post> findPostsByTitleLike(String like) {
        return postR2DBCRepository.findPostsByTitleLike(like);
    }
}