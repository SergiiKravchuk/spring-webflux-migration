package victor.training.spring.sql;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface PostReactiveRepo extends R2dbcRepository<Post, Long> {

}
