package kr.re.kitri.webfluxdemo.service;

import kr.re.kitri.webfluxdemo.model.Post;
import kr.re.kitri.webfluxdemo.repository.PostRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Flux<Post> getAllPosts() {
        return postRepository.selectAllPosts();
    }

    public Mono<Post> getPostById(Integer id) {
        return postRepository.getPostById(id);
    }

    public Mono<Post> setPost(Mono<Post> responsePost) {
        Mono<Post> postMono = postRepository.setPost(responsePost);
        return postMono;
    }
}