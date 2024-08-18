package victor.training.spring.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AuthorReactiveRepo extends ReactiveMongoRepository<Author, String> {
}
