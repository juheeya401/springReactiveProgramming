package kr.re.kitri.webfluxdemo.controller;

import kr.re.kitri.webfluxdemo.model.Post;
import kr.re.kitri.webfluxdemo.service.PostService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    /**
     * 전체 글 조회
     */
    @GetMapping("/posts")
    public Flux<Post> viewAllPosts() {
        Flux<Post> allPosts = postService.getAllPosts();
        return allPosts;
    }

    /**
     * 글 1건 조회
     */
    @GetMapping("/posts/{id}")
    public Mono<Post> viewPostById(@PathVariable("id") Integer id) {
        Mono<Post> postById = postService.getPostById(id);
        return postById;
    }

    /**
     * 글 저장
     */
    @PostMapping("/posts")
    public Mono<Void> registPost(@RequestBody Mono<Post> responsePost) {
        Mono<Post> postMono = postService.setPost(responsePost);
        return Mono.empty();
    }

    @GetMapping("/posts/count")
    public Mono<Long> viewCount() {
        Mono<Long> count = postService.getPostCount();
        return count;
    }

    @GetMapping("/posts/title/{like}")
    public Flux<Post> findPostsByTitleLike(@PathVariable("like") String like) {
        return postService.findPostsByTitleLike(like);
    }

    @DeleteMapping("/posts/{id}")
    public Mono<Void> removePost(@PathVariable("id") Integer id) {
        return postService.deletePostById(id);
    }
}
