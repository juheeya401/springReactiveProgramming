package kr.re.kitri.webfluxdemo.repository;

import kr.re.kitri.webfluxdemo.model.Post;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PostR2DBCRepository extends ReactiveCrudRepository<Post, Integer> {

    @Query("select id, user_id, title, body " +
            "from posts " +
            "where title like concat('%', :like, '%')")
    Flux<Post> findPostsByTitleLike(String like);
}
